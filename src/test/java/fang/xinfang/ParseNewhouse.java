package fang.xinfang;

import com.tt.common.DownLoadPage;
import com.tt.common.utils.NumUtils;
import com.tt.dao.FangXfLoupangListMapper;
import com.tt.entity.FangXfLoupangList;
import com.tt.service.CommunityKeDetailService;
import com.tt.service.JedisClientService;
import com.tt.service.KeLoudongServer;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.plaf.SliderUI;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 解析房天下的新房
 * @Auther: 赵乐
 * @Date: 2018/10/26 16:14
 * @Description:
 */
public class ParseNewhouse {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        FangXfLoupangListMapper fangXfLoupangListMapper = (FangXfLoupangListMapper)applicationContext.getBean("fangXfLoupangListMapper");

        Map<String, String> mapCity = new HashMap<>();
        mapCity.put("成都","http://cd.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");
        mapCity.put("武汉","http://wuhan.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");
        mapCity.put("重庆","http://cq.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");
        mapCity.put("北京","http://newhouse.fang.com/house/s/?ctm=1.gz.xf_search.head.4");
        mapCity.put("深圳","http://sz.newhouse.fang.com/house/s/?ctm=1.bj.xf_search.head.6");
        mapCity.put("广州","http://gz.newhouse.fang.com/house/s/?ctm=1.bj.xf_search.head.6");
        mapCity.put("南京","http://nanjing.newhouse.fang.com/house/s/?ctm=1.sz.xf_search.head.13");
        mapCity.put("杭州","http://hz.newhouse.fang.com/house/s/?ctm=1.nanjing.xf_search.head.39");
        mapCity.put("苏州","http://suzhou.newhouse.fang.com/house/s/?ctm=1.hz.xf_search.head.14");
        mapCity.put("东莞","http://dg.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");
        mapCity.put("天津","http://tj.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");
        mapCity.put("沈阳","http://sy.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");
        mapCity.put("青岛","http://qd.newhouse.fang.com/house/s/?ctm=1.suzhou.xf_search.head.35");

        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (String city : mapCity.keySet()) {
            try {
                String url = mapCity.get(city);
                System.out.println(city+"================"+url);
                //截取url中信息
                String substring = url.substring(0, url.indexOf("/house"));

                Document documentIndex = DownLoadPage.downLoadPage(url,"gb2312");
                List<Map<String, String>> listRgion = parseIndex(documentIndex);
                if(listRgion!=null && listRgion.size()!=0){
                    for (Map<String, String> mapRegion : listRgion) {
                        String hrefStr = mapRegion.get("hrefRegion");
                        String region = mapRegion.get("region");
                        String hrefRegion=null;
                        if(hrefStr.contains("http")){
                            hrefRegion=hrefStr;
                        }else{
                            hrefRegion=substring+hrefStr;
                        }
                        System.out.println(hrefRegion+"----"+region);
                        //解析区域链接，获取板块链接
                        if(StringUtils.isNotBlank(hrefRegion) && StringUtils.isNotBlank(region)){
                            Document documentRegion = DownLoadPage.downLoadPage(hrefRegion,"gb2312");
                            List<Map<String, String>> listPlate = parseRegion(documentRegion);
                            //解析板块链接获取分页链接
                            if(listPlate!=null && listPlate.size()!=0){

                                for (Map<String, String> mapPlate : listPlate) {
                                    semaphore.acquire();
                                    executorService.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                String hrefPlate = mapPlate.get("hrefPlate");
                                                String plate = mapPlate.get("plate");
                                                if(StringUtils.isNotBlank(hrefPlate)){
                                                    hrefPlate=substring+hrefPlate;
                                                }
                                                Document documentPlate = DownLoadPage.downLoadPage(hrefPlate,"gb2312");
                                                Integer pageNum = parsePlate(documentPlate);
                                                //http://newhouse.fang.com/house/s/beijingzhoubian1/
                                                if(pageNum!=0){
                                                    //拼接分页链接
                                                    List<String> listPage = new ArrayList<String>();
                                                    for (int i = 1; i <= pageNum; i++) {
                                                        //http://newhouse.fang.com/house/s/beijingzhoubian1/b91/?ctm=1.bj.xf_search.page.2
                                                        String pageUrl = hrefPlate + "b9" + i;
                                                        listPage.add(pageUrl);
                                                    }
                                                    //解析分页链接，获取详情链接
                                                    for (String pageUrl : listPage) {
                                                        Document documentPage = DownLoadPage.downLoadPage(pageUrl,"gb2312");
                                                        List<FangXfLoupangList> fangXfLoupangLists = parsePage(documentPage);
                                                        for (FangXfLoupangList fangXfLoupangList : fangXfLoupangLists) {
                                                            try {
                                                                fangXfLoupangList.setCity(city);
                                                                fangXfLoupangList.setRegion(region);
                                                                fangXfLoupangList.setPlate(plate);
                                                                fangXfLoupangList.setCreatetime(new Date());
                                                                fangXfLoupangList.setBatchId("v1.0");

                                                                fangXfLoupangListMapper.insert(fangXfLoupangList);
                                                            } catch (Exception e) {
                                                                e.printStackTrace();
                                                            }
                                                        }

                                                    }
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            } finally {
                                                semaphore.release();
                                            }
                                        }
                                    });
                                }
                            }else{
                                System.out.println("该区域小没有板块链接---");
                                //直接解析区域链接，获取详情页链接
                                List<FangXfLoupangList> fangXfLoupangLists = parsePage(documentRegion);
                                for (FangXfLoupangList fangXfLoupangList : fangXfLoupangLists) {
                                    fangXfLoupangList.setCity(city);
                                    fangXfLoupangList.setRegion(region);
                                    fangXfLoupangList.setCreatetime(new Date());
                                    fangXfLoupangList.setBatchId("v1.0");

                                    fangXfLoupangListMapper.insert(fangXfLoupangList);
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        //等待所有任务都结束了继续执行
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) ;
       /* String ur1="http://newhouse.fang.com/house/s/chaoyang/";
        String url2="http://newhouse.fang.com/house/s/yanqing/";
        Document documentRegion = DownLoadPage.downLoadPage(ur1);
        List<Map<String, String>> listPlate = parseRegion(documentRegion);
        if(listPlate.size()==0){
            parsePage(documentRegion);
        }else{
            for (Map<String, String> mapPlate : listPlate) {
                String hrefPlate = mapPlate.get("hrefPlate");
                String plate = mapPlate.get("plate");
                System.out.println(plate+"---"+hrefPlate);
            }
        }*/
       /*String url="http://newhouse.fang.com/house/s/xibahe/";
       String url2="http://newhouse.fang.com/house/s/sanlitun/";
       Document documentPlate = DownLoadPage.downLoadPage(url2);
       Integer pageNum = parsePlate(documentPlate);
       System.out.println(pageNum);
       String pageUrl = url2 + "b9" + pageNum;

        Document documentPage = DownLoadPage.downLoadPage(pageUrl);
        parsePage(documentPage);*/

    }
    /**
     *
     * 功能描述: 解析分页链接，获取详情页链接
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/26 18:02
     */
    private static List<FangXfLoupangList> parsePage(Document documentPage) {
        List<FangXfLoupangList> list=new ArrayList<>();

        if(documentPage!=null){
            Elements selects = documentPage.select("div#newhouse_loupai_list>ul>li>div.clearfix");
            if(!selects.isEmpty()){
                for (Element element : selects) {
                    //详情页
                    FangXfLoupangList fangXfLoupangList = new FangXfLoupangList();
                    fangXfLoupangList.setId(UUID.randomUUID().toString());

                    //title，url
                    Elements select = element.select("div.nlc_details>div.house_value.clearfix>div.nlcd_name>a");
                    if(!select.isEmpty()){
                        String title = select.text();
                        String href = select.attr("href");

                        fangXfLoupangList.setTitle(title);
                        fangXfLoupangList.setDetailPc(href);
                        System.out.println(title+"---"+href);
                    }
                    //地址
                    Elements addressEle = element.select("div.nlc_details>div.relative_message.clearfix>div.address>a");
                    if(!addressEle.isEmpty()){
                        String address = addressEle.text();
                        fangXfLoupangList.setAddress(address);
                        System.out.println(address);
                    }
                    //标签
                    Elements select2 = element.select("div.nlc_details>div.fangyuan");
                    if(!select2.isEmpty()){
                        String tag = select2.text();
                        fangXfLoupangList.setTag(tag);
                        System.out.println(tag);
                    }
                    //价格信息
                    Elements selectPrice = element.select("div.nlc_details>div.nhouse_price");
                    if(!selectPrice.isEmpty()){
                        String price = selectPrice.text();
                        fangXfLoupangList.setAveragePrice(price);
                        System.out.println(price);

                    }
                    //放入list中
                    if(StringUtils.isNotBlank(fangXfLoupangList.getDetailPc())){
                        list.add(fangXfLoupangList);
                    }
                }
            }
        }
        return list;
    }

    /**
     *
     * 功能描述: 解析板块链接，获取分页链接
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/26 17:17
     */
    private static Integer parsePlate(Document documentPlate) {
        Integer regionPageNum=0;
        if(documentPlate!=null){
            String text = documentPlate.select("li#sjina_C01_30>a>span").text();
            if(StringUtils.isNotBlank(text)){
                Integer pageNum = NumUtils.getInteger(text);
                regionPageNum = pageNum%20 == 0 ? pageNum/20 : pageNum/20+1;
            }
        }
        return regionPageNum;
    }

    /**
     *
     * 功能描述:解析区域链接，获取板块链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/26 16:53
     */
    private static List<Map<String,String>> parseRegion(Document documentRegion) {
        //存放区域下的细分种子链接
        List<Map<String,String>> listPlate= new ArrayList<>();
        if(documentRegion!=null){
            Elements selects = documentRegion.select("div.quyu>ol>li>a");
            if(!selects.isEmpty()){
                for (Element element : selects) {
                    Map<String,String> map=new HashMap<>();
                    String plate = element.text();
                    String href = element.attr("href");
                    String hrefPlate=null;
                    if(StringUtils.isNotBlank(plate) && StringUtils.isNotBlank(href)){
                        hrefPlate=href;
                        map.put("hrefPlate", hrefPlate);
                        map.put("plate", plate);
                        listPlate.add(map);
                    }
                }
            }else{
                System.out.println("该区域下没有板块");
            }
        }

        return  listPlate;
    }

    /**
     *
     * 功能描述: 解析主页链接，获取
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/26 16:26
     */
    private static List<Map<String,String>> parseIndex(Document documentIndex) {
        List<Map<String,String>> listRegion= new ArrayList<>();
        if(documentIndex!=null){
            Elements elements = documentIndex.select("li#quyu_name>a").not("a#sjina_D03_05_02");
            if(!elements.isEmpty()){
                for (Element element : elements) {
                    Map<String,String> mapReion=new HashMap<>();

                    String region = element.text();
                    String href = element.attr("href");
                    if(StringUtils.isNotBlank(href) && StringUtils.isNotBlank(region)){
                        mapReion.put("hrefRegion",href);
                        mapReion.put("region",region);
                        listRegion.add(mapReion);
                    }

                }
            }
        }
        return listRegion;
    }


}
