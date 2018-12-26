package com.tt.controller.zhuge;

import com.tt.common.utils.HttpClientUtils;
import com.tt.common.utils.ProxyUtils;
import com.tt.dao.ZhugeCommunityDealMapper;
import com.tt.dao.ZhugeCommunityMapper;
import com.tt.entity.ZhugeCommunity;
import com.tt.entity.ZhugeCommunityDeal;
import com.tt.entity.ZhugeCommunityExample;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/5 18:25
 * @Description:
 */
@RestController
public class ParseDeal {

    @Autowired
    private ZhugeCommunityMapper zhugeCommunityMapper;

    @Autowired
    private ZhugeCommunityDealMapper zhugeCommunityDealMapper;

    @Autowired
    @Qualifier("ipPoolProxy")
    //@Qualifier("moguProxy")
    private IDownLoadPage downLoadPage;



    @RequestMapping("/parseZhugeDeal")
    public void parseDEal() throws InterruptedException {
        Map<String,String> header=new HashMap<>();
        //header.put("Host","sh.house.zhuge.com");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("If-None-Match","W/125e-8pYtdxwALKZH7kOMgUjllg");
        header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        header.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");

        int num =6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        ZhugeCommunityExample zhugeCommunityExample = new ZhugeCommunityExample();
        ZhugeCommunityExample.Criteria criteria = zhugeCommunityExample.createCriteria();
        criteria.andStatusIsNull();
        List<ZhugeCommunity> zhugeCommunities = zhugeCommunityMapper.selectByExample(zhugeCommunityExample);
        if(zhugeCommunities!=null && zhugeCommunities.size()!=0){
            for (ZhugeCommunity zhugeCommunity : zhugeCommunities) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String detailUrl = zhugeCommunity.getDetailUrl();
                            String titleId = zhugeCommunity.getTitleId();
                            String jiaoyiNum = zhugeCommunity.getJiaoyiNum();
                            if(StringUtils.isNotBlank(titleId) && StringUtils.isNotBlank(jiaoyiNum)){
                                int pageNum = Integer.parseInt(jiaoyiNum);
                                Integer pageCount= pageNum%10==0 ? pageNum/10: (pageNum/10)+1;

                                for (int i = 0; i < pageCount; i++) {
                                    ZhugeCommunityDeal zhugeCommunityDealParam = new ZhugeCommunityDeal();
                                    zhugeCommunityDealParam.setId(UUID.randomUUID().toString());
                                    zhugeCommunityDealParam.setTitleId(titleId);
                                    zhugeCommunityDealParam.setDetailUrl(detailUrl);

                                    String pageUrl=detailUrl.replace(titleId+".html","jiaoyi/"+titleId+"/"+i);
                                    System.out.println(pageUrl);
                                    //Document document = downLoadPage.downLoadPageByGet(pageUrl, header);
                                    //List<ZhugeCommunityDeal> zhugeCommunityDeals = parseJiaoyi(document);
                                    HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                                    String html = HttpClientUtils.get(pageUrl, "UTF-8", header, iPoolProxy);
                                    if(StringUtils.isBlank(html) || !(html.contains("<tr>"))){
                                        for (int j = 1; j < 21; j++) {
                                            HttpHost iPoolProxy1 = ProxyUtils.getIPoolProxy();
                                            html= HttpClientUtils.get(pageUrl, "UTF-8", header, iPoolProxy1);
                                            if(StringUtils.isNotBlank(html) && html.contains("<tr>")){
                                                System.out.println("重试成功"+j);
                                                break;
                                            }else {
                                                System.out.println("重试"+j);
                                                continue;
                                            }
                                        }
                                    }
                                    if(StringUtils.isNotBlank(html) && html.contains("<tr>")){
                                        Document document = Jsoup.parse("<table>"+html+"</table>");
                                        List<ZhugeCommunityDeal> zhugeCommunityDeals = parseJiaoyi1(document);
                                        if(zhugeCommunityDeals!=null && zhugeCommunityDeals.size()!=0){
                                            for (ZhugeCommunityDeal zhugeCommunityDeal : zhugeCommunityDeals) {
                                                zhugeCommunityDeal.setDetailUrl(detailUrl);
                                                zhugeCommunityDeal.setTitleId(titleId);
                                                zhugeCommunityDealMapper.insert(zhugeCommunityDeal);
                                            }
                                        }
                                    }

                                }
                                //修改详情的状态
                                zhugeCommunity.setStatus("1");
                                zhugeCommunityMapper.updateByPrimaryKeySelective(zhugeCommunity);
                            }else{
                                //修改详情的状态
                                zhugeCommunity.setStatus("2");
                                zhugeCommunityMapper.updateByPrimaryKeySelective(zhugeCommunity);
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }
                    }
                });
            }

        }

        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("结束==");
    }
    
    /**
     *
     * 功能描述: 解析交易记录
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/28 14:53
     */
    private List<ZhugeCommunityDeal> parseJiaoyi1(Document document) {
        List<ZhugeCommunityDeal> listZhugeCommunityDeal=new ArrayList<>();
        if(document!=null){
            Elements select = document.select("tr");
            if(!select.isEmpty()){
                for (Element element : select) {
                    ZhugeCommunityDeal  zhugeCommunityDeal= new ZhugeCommunityDeal();
                    zhugeCommunityDeal.setId(UUID.randomUUID().toString());
                    
                    Elements selectTd = element.select("td");
                    if(!selectTd.isEmpty() && selectTd.size()==7){
                        String s0 = selectTd.get(0).text().replaceAll(" +","");
                        String s1 = selectTd.get(1).text().replaceAll(" +","");
                        String s2 = selectTd.get(2).text().replaceAll(" +","");
                        String s3 = selectTd.get(3).text().replaceAll(" +","");
                        String s4 = selectTd.get(4).text().replaceAll(" +","");
                        String s5 = selectTd.get(5).text().replaceAll(" +","");
                        String s6 = selectTd.get(6).text().replaceAll(" +","");

                        System.out.println(s0+"__"+s1);
                        zhugeCommunityDeal.setDealTotalPrice(s0);
                        zhugeCommunityDeal.setDealAveragePrice(s1);
                        zhugeCommunityDeal.setArea(s2);
                        zhugeCommunityDeal.setLayout(s3);
                        zhugeCommunityDeal.setDealTime(s4);
                        zhugeCommunityDeal.setDealSrc(s5);
                        zhugeCommunityDeal.setDataSrc(s6);
                        zhugeCommunityDeal.setCreatetime(new Date());
                        zhugeCommunityDeal.setBatchId("v1.0");
                    }
                    listZhugeCommunityDeal.add(zhugeCommunityDeal);
                }
            }
        }
        return listZhugeCommunityDeal;
    }

    
    /**
     *
     * 功能描述: 解析交易记录
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/6 12:45
     */
    private List<ZhugeCommunityDeal> parseJiaoyi(Document document) {
        List<ZhugeCommunityDeal> listZhugeCommunityDeal=new ArrayList<>();
        if(document!=null){
            Elements elementsPage = document.select("body");
            String text = elementsPage.text();
            List<String> list=new ArrayList<>();

            if(text.contains("--")){
                text = text.replace("--", "- -");
            }

            String[] split = text.split("\\s");
            for (String s : split) {
                list.add(s);
            }

            System.out.println("------"+list.size());

            if(list.size()%8!=0){
                System.out.println(document);
                return listZhugeCommunityDeal;
            }

            Integer size=list.size()/8;

            for (int i = 0; i < size; i++) {
                ZhugeCommunityDeal  zhugeCommunityDeal= new ZhugeCommunityDeal();
                zhugeCommunityDeal.setId(UUID.randomUUID().toString());

                String s0=list.get(0+i*8);

                String s1=list.get(1+i*8);
                String s2=list.get(2+i*8);
                String s3=list.get(3+i*8)+list.get(4+i*8);
                String s4=list.get(5+i*8);
                String s5=list.get(6+i*8);
                String s6=list.get(7+i*8);

                System.out.println(s0+"__"+s1);
                zhugeCommunityDeal.setDealTotalPrice(s0);
                zhugeCommunityDeal.setDealAveragePrice(s1);
                zhugeCommunityDeal.setArea(s2);
                zhugeCommunityDeal.setLayout(s3);
                zhugeCommunityDeal.setDealTime(s4);
                zhugeCommunityDeal.setDealSrc(s5);
                zhugeCommunityDeal.setDataSrc(s6);
                zhugeCommunityDeal.setCreatetime(new Date());
                zhugeCommunityDeal.setBatchId("v1.0");
                listZhugeCommunityDeal.add(zhugeCommunityDeal);
            }
        }
        return listZhugeCommunityDeal;
    }

    public void parseJiaoyi(){
        /*for (int j=0;j<num;j++){
            String pageUrl="http://sh.house.zhuge.com/jiaoyi/109377/"+j;
            Document documentPage = DownLoadPage.downLoadPage(pageUrl,header);
            Elements elementsPage = documentPage.select("body");
            String text = elementsPage.text();
            List<String> list=new ArrayList<>();

            if(text.contains("--")){
                text = text.replace("--", "- -");
            }

            String[] split = text.split("\\s");
            for (String s : split) {
                list.add(s);
            }

            System.out.println(list.size());

            if(list.size()%8!=0){
                System.out.println(documentPage);
                continue;
            }

            Integer size=list.size()/8;

            for (int i = 0; i < size; i++) {
                ZhugeCommunity zhugeCommunity1 = new ZhugeCommunity();
                zhugeCommunity1=zhugeCommunity;
                zhugeCommunity1.setId(UUID.randomUUID().toString());

                String s0=list.get(0+i*8);

                String s1=list.get(1+i*8);
                String s2=list.get(2+i*8);
                String s3=list.get(3+i*8)+list.get(4+i*8);
                String s4=list.get(5+i*8);
                String s5=list.get(6+i*8);
                String s6=list.get(7+i*8);

                System.out.println(s0+"__"+s1);
                zhugeCommunity1.setDealTotalPrice(s0);
                zhugeCommunity1.setDealAveragePrice(s1);
                zhugeCommunity1.setArea(s2);
                zhugeCommunity1.setLayout(s3);
                zhugeCommunity1.setDealTime(s4);
                zhugeCommunity1.setDealSrc(s5);
                zhugeCommunity1.setDataSrc(s6);
                zhugeCommunity1.setCreatetime(new Date());
                zhugeCommunity1.setBatchId("v1.0");
                zhugeCommunityMapper.insert(zhugeCommunity1);
            }

        }*/
    }

}
