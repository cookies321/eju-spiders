package zhuge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.dao.RegionNumMapper;
import com.tt.dao.ZhugeCommunityListMapper;
import com.tt.dao.ZhugeCommunityMapper;
import com.tt.entity.RegionNum;
import com.tt.entity.ZhugeCommunity;
import com.tt.entity.ZhugeCommunityList;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/1 18:45
 * @Description:
 */
public class ParseZhuge {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        ZhugeCommunityListMapper zhugeCommunityListMapper=(ZhugeCommunityListMapper)applicationContext.getBean("zhugeCommunityListMapper");
        RegionNumMapper regionNumMapper=(RegionNumMapper)applicationContext.getBean("regionNumMapper");
        IDownLoadPage iDownLoadPage =(IDownLoadPage)applicationContext.getBean("moguProxy");

        Integer num=6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        Map<String, String> mapCity = new HashMap<>();
        //mapCity.put("上海","http://sh.ershoufang.zhuge.com/community/");
        /*mapCity.put("南京","http://nj.ershoufang.zhuge.com/community/");
        mapCity.put("天津","http://tj.ershoufang.zhuge.com/community/");
        mapCity.put("重庆 ","http://cq.ershoufang.zhuge.com/community/");*/
        mapCity.put("东莞","http://dg.ershoufang.zhuge.com/community/");
        mapCity.put("北京","http://bj.ershoufang.zhuge.com/community/");
        mapCity.put("广州","http://gz.ershoufang.zhuge.com/community/");
        mapCity.put("成都","http://cd.ershoufang.zhuge.com/community/");
        mapCity.put("杭州","http://hz.ershoufang.zhuge.com/community/");
        mapCity.put("武汉","http://wh.ershoufang.zhuge.com/community/");
        mapCity.put("沈阳","http://sy.ershoufang.zhuge.com/community/");
        mapCity.put("深圳","http://sz.ershoufang.zhuge.com/community/");
        mapCity.put("苏州","http://su.ershoufang.zhuge.com/community/");
        mapCity.put("青岛","http://qd.ershoufang.zhuge.com/community/");
        for (String city : mapCity.keySet()) {

            String indexUrl = mapCity.get(city);
            String homeUrl=indexUrl.replace("/community/","");

            Map<String,String> header=new HashMap<>();
            header.put("Host",homeUrl);
            header.put("Accept-Language","zh-CN,zh;q=0.9");
            header.put("Accept-Encoding","gzip, deflate");
            header.put("If-None-Match","W/125e-8pYtdxwALKZH7kOMgUjllg");
            header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            header.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");

            Document documentIndex = iDownLoadPage.downLoadPageByGet(indexUrl, header);
            //增加方法
            Integer pageCount = parsePlate(documentIndex);
            Integer pageNum=0;
            if(pageCount!=0){
                pageNum = pageCount % 30 == 0 ? pageCount / 30 : (pageCount / 30) + 1;
            }
            if(pageNum==0){
                return;
            }
            for (int j = 1; j <= pageNum; j++) {
                semaphore.acquire();
                int finalJ = j;
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        //分页链接
                        try {
                            String pageUrl=indexUrl+"page/"+ finalJ +"/";
                            Document documentPage = iDownLoadPage.downLoadPageByGet(pageUrl, header);
                            System.out.println(pageUrl);
                            //解析分页链接，获取详情链接
                            List<String> listDetail = parsePage(documentPage);
                            if(listDetail!=null && listDetail.size()!=0){
                                for (String detailUrl : listDetail) {
                                    ZhugeCommunityList zhugeCommunityList = new ZhugeCommunityList();
                                    zhugeCommunityList.setId(UUID.randomUUID().toString());
                                    zhugeCommunityList.setCity(city);
                                    //zhugeCommunityList.setRegion(region);
                                    //zhugeCommunityList.setPlate(plate);
                                    zhugeCommunityList.setDetailUrl(detailUrl);
                                    zhugeCommunityList.setCreatetime(new Date());
                                    zhugeCommunityList.setBatchId("v1.0");
                                    zhugeCommunityListMapper.insert(zhugeCommunityList);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            semaphore.release();
                        }
                    }
                });
            }



            /*List<Map<String, String>> list = parseIndex(documentIndex);
            if(list!=null && list.size()!=0){
                for (Map<String, String> mapRgion : list) {
                    String region = mapRgion.get("region");
                    String hrefRegion = mapRgion.get("hrefRegion");
                    System.out.println(region);
                    //解析区域链接，获取板块链接
                    if(StringUtils.isNotBlank(hrefRegion) &&StringUtils.isNotBlank(region)){
                        hrefRegion=homeUrl+hrefRegion;
                        System.out.println(hrefRegion);
                        Document documentRegion = iDownLoadPage.downLoadPageByGet(hrefRegion, header);
                        //增加方法
                        Integer pageCount = parsePlate(documentRegion);
                        Integer pageNum=0;
                        if(pageCount!=0){
                            pageNum = pageCount % 30 == 0 ? pageCount / 30 : (pageCount / 30) + 1;
                        }
                        if(pageCount>2000){
                            System.out.println("重定向");
                        }
                        if(pageNum==0){
                            return;
                        }
                        //存放区域个数表
                        RegionNum regionNum = new RegionNum();
                        regionNum.setId(UUID.randomUUID().toString());
                        regionNum.setCity(city);
                        regionNum.setRegion(region);
                        regionNum.setNum(pageCount+"");
                        regionNumMapper.insertSelective(regionNum);
                        //页码小于100
                        if(pageNum<=100){
                            for (int j = 1; j <= pageNum; j++) {
                                //分页链接
                                String pageUrl=hrefRegion+"page/"+j+"/";
                                Document documentPage = iDownLoadPage.downLoadPageByGet(pageUrl, header);
                                System.out.println(pageUrl);
                                //解析分页链接，获取详情链接
                                List<String> listDetail = parsePage(documentPage);
                                if(listDetail!=null && listDetail.size()!=0){
                                    for (String detailUrl : listDetail) {
                                        ZhugeCommunityList zhugeCommunityList = new ZhugeCommunityList();
                                        zhugeCommunityList.setId(UUID.randomUUID().toString());
                                        zhugeCommunityList.setCity(city);
                                        zhugeCommunityList.setRegion(region);
                                        //zhugeCommunityList.setPlate(plate);
                                        zhugeCommunityList.setDetailUrl(detailUrl);
                                        zhugeCommunityList.setCreatetime(new Date());
                                        zhugeCommunityList.setBatchId("v1.0");
                                        zhugeCommunityListMapper.insert(zhugeCommunityList);
                                    }
                                }
                            }
                            //页码大于100,分版块
                        }else{
                            //解析板块链接，获取分页链接
                            List<Map<String, String>> listPlate = parseRegion(documentRegion);

                            if(listPlate!=null && listPlate.size()!=0){
                                for (Map<String, String> map : listPlate) {
                                    semaphore.acquire();
                                    executorService.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                String plate = map.get("plate");
                                                String hrefPlate = map.get("hrefPlate");

                                                if(StringUtils.isNotBlank(plate) && StringUtils.isNotBlank(hrefPlate)){
                                                    hrefPlate=homeUrl+hrefPlate;
                                                    System.out.println(hrefPlate);
                                                    Document document = iDownLoadPage.downLoadPageByGet(hrefPlate, header);
                                                    //解析板块链接，获取分页连接
                                                    Integer pageCount = parsePlate(documentRegion);
                                                    Integer pageNum=0;
                                                    if(pageCount!=0){
                                                        pageNum = pageCount % 30 == 0 ? pageCount / 30 : (pageCount / 30) + 1;
                                                    }
                                                    if(pageCount>2000){
                                                        System.out.println("重定向");
                                                    }
                                                    if(pageNum==0){
                                                        return;
                                                    }
                                                    //解析分页链接获取详情也链接
                                                    if(pageNum!=0){
                                                        for (int j = 1; j <= pageNum; j++) {
                                                            //分页链接
                                                            String pageUrl=hrefPlate+"page/"+j+"/";
                                                            Document documentPage = iDownLoadPage.downLoadPageByGet(pageUrl, header);
                                                            System.out.println(pageUrl);
                                                            //解析分页链接，获取详情链接
                                                            List<String> listDetail = parsePage(documentPage);
                                                            if(listDetail!=null && listDetail.size()!=0){
                                                                for (String detailUrl : listDetail) {
                                                                    ZhugeCommunityList zhugeCommunityList = new ZhugeCommunityList();
                                                                    zhugeCommunityList.setId(UUID.randomUUID().toString());
                                                                    zhugeCommunityList.setCity(city);
                                                                    zhugeCommunityList.setRegion(region);
                                                                    zhugeCommunityList.setPlate(plate);
                                                                    zhugeCommunityList.setDetailUrl(detailUrl);
                                                                    zhugeCommunityList.setCreatetime(new Date());
                                                                    zhugeCommunityList.setBatchId("v1.0");
                                                                    zhugeCommunityListMapper.insert(zhugeCommunityList);
                                                                }
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
                            }
                        }
                    }
                }
            }*/
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");

        /*String url="http://sh.house.zhuge.com/109377.html";

        //解析详情页信息
        Document document = DownLoadPage.downLoadPage(url,header);
        //titleid
        Integer integer = NumUtils.getInteger(url);
        System.out.println(integer);
        ZhugeCommunity zhugeCommunity = new ZhugeCommunity();
        zhugeCommunity.setTitleId(integer+"");
        parseDetail(document,zhugeCommunity);*/

    }
    //解析分页链接，获取详情链接
    private static List<String> parsePage(Document documentPage) {
        List<String> list=new ArrayList<>();
        if(documentPage!=null){
            Elements select = documentPage.select("ul#listTableBox>li");
            if(!select.isEmpty()){
                for (Element element : select) {
                    Elements selectA = element.select("div.list-info-box>p.house-name>a");
                    if(!selectA.isEmpty()){
                        String href = selectA.attr("href");
                        if(StringUtils.isNotBlank(href)){
                            list.add(href);
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     *
     * 功能描述: 获取分页链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/2 18:05
     */
    private static Integer parsePlate(Document document) {
        Integer pageCount=0;
        if(document!=null){
            Elements select = document.select("div.list_left>div.list-converge-box>strong");
            if(!select.isEmpty()){
                String text = select.text();
                System.out.println(text);
                pageCount = Integer.parseInt(text);
            }
        }
        return pageCount;
    }


    /**
     *
     * 功能描述: 解析区域链接，获取板块链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/2 17:32
     */
    private static List<Map<String,String>> parseRegion(Document documentRegion) {
        List<Map<String,String>> list=new ArrayList<>();
        if(documentRegion!=null){
            Elements select = documentRegion.select("div.list-screen-sumy-box.area_box>a");
            if(!select.isEmpty()){
                for (Element element : select) {
                    Map<String,String> map=new HashMap<>();
                    String plate = element.text();
                    String hrefPlate = element.attr("href");
                    map.put("plate",plate);
                    map.put("hrefPlate",hrefPlate);
                    list.add(map);
                }
            }
        }else {
            System.out.println(documentRegion);
        }
        return list;
    }

    /**
     *
     * 功能描述: 解析主页链接，获取区域链接
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/2 17:09
     */
    private static List<Map<String,String>> parseIndex(Document documentIndex) {
        List<Map<String,String>> list=new ArrayList<>();
        Elements elementsLi = documentIndex.select("div.list-screen-item-box.area_box>a.list-screen-link").not("a.list-screen-link.hover");
        if(!elementsLi.isEmpty()){
            for (Element element : elementsLi) {
                Map<String,String> map=new HashMap<>();
                String region = element.text();
                String hrefRegion = element.attr("href");
                if(StringUtils.isNotBlank(region) && StringUtils.isNotBlank(hrefRegion)){
                    map.put("region",region);
                    map.put("hrefRegion",hrefRegion);
                    list.add(map);
                }
            }
        }else {
            System.out.println(documentIndex);
        }
        return list;
    }
}
