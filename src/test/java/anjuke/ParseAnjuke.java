package anjuke;

import com.alibaba.fastjson.JSON;
import com.tt.common.DownLoadPage;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.Pinyin4Util;
import com.tt.entity.AnjukeCommunityWithBLOBs;
import com.tt.service.AnjukeCommunityService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ParseAnjuke {

    private static Logger logger = LoggerFactory.getLogger(PageDownLoadUtil.class);

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        final AnjukeCommunityService anjukeCommunityService = (AnjukeCommunityService)applicationContext.getBean("anjukeCommunityServiceImpl");

        Integer threadNum=3;
        Semaphore semaphore = new Semaphore(threadNum);
        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNum);

       /* String url="https://shanghai.anjuke.com/community/?from=esf_list_navigation";
        final String city="上海";
        String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};*/
        String[] citys={"杭州"};
        for (String city : citys) {
            String cityPin = Pinyin4Util.parse13City(city);
            if(StringUtils.isBlank(cityPin)){
                continue;
            }
            String url="https://"+cityPin+".anjuke.com/community/?from=esf_list_navigation";

            //下载主页页面
            Document document = DownLoadPage.downLoadPage(url);
            //解析主链接，获取区域种子链接
            List<Map<String, Object>> listRegion = parseIndexPage(document);
            if(listRegion!=null && listRegion.size()!=0){
                for (Map<String, Object> regionMap : listRegion)
                    try {
                        String hrefRegion = (String) regionMap.get("hrefRegion");
                        final String region = (String) regionMap.get("region");
                        //下载区域页面
                        Document documentRegion = DownLoadPage.downLoadPage(hrefRegion);
                        //解析区域的子链接，获取区域下的细分链接
                        List<Map<String, Object>> listPlate = parseRegionPage(documentRegion);
                        if (listPlate != null && listPlate.size() != 0) {
                            //获取每个区域子链接下的分页链接
                            for (Map<String, Object> plateMap : listPlate) {
                                String hrefPlate = (String) plateMap.get("hrefPlate");
                                final String plate = (String) plateMap.get("plate");
                                //解析区域下的细分链接,获取分页链接
                                Document documentPlate = DownLoadPage.downLoadPage(hrefPlate);
                                Integer regionNum = parsePlatePage(documentPlate);
                                if (regionNum != null && regionNum != 0) {
                                    //拼接分页链接
                                    List<String> listPage = new ArrayList<String>();
                                    for (int i = 1; i <= regionNum; i++) {
                                        String regionPage = hrefPlate + "p" + i + "/";
                                        listPage.add(regionPage);
                                    }
                                    //根据分页链接获取列表的详情链接
                                    for (final String list : listPage) {
                                        try {
                                            //解析分页链接，获取列表详情链接
                                            Document documentPage = DownLoadPage.downLoadPage(list);
                                            //详情页链接
                                            //存入城市、区域、板块信息
                                            AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs = new AnjukeCommunityWithBLOBs();
                                            anjukeCommunityWithBLOBs.setCity(city);
                                            anjukeCommunityWithBLOBs.setRegion(region);
                                            anjukeCommunityWithBLOBs.setPlate(plate);

                                            //list集合中含有列表中基本信息
                                            List<AnjukeCommunityWithBLOBs> anjukeCommunityWithBLOBsList = parsePage(documentPage, anjukeCommunityWithBLOBs);

                                            //解析详情页的种子链接
                                            for (AnjukeCommunityWithBLOBs anjukeCommunity : anjukeCommunityWithBLOBsList) {
                                                try {
                                                    semaphore.acquire();
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                                executor.execute(new Runnable() {
                                                    public void run() {
                                                        //获取详情页的url
                                                        String detailHref = anjukeCommunity.getDetailUrl();
                                                        try {
                                                            Document documentDetail = DownLoadPage.downLoadPage(detailHref);
                                                            //解析详情页信息
                                                            parseDetail(documentDetail, anjukeCommunity);
                                                            //房型图链接
                                                            String modelHref = detailHref.replace("view", "photos/model");
                                                            //解析方形图链接
                                                            Document documentModel = DownLoadPage.downLoadPage(modelHref);
                                                            String strModel = parseModel(documentModel);

                                                            //实景图链接
                                                            String bHref = detailHref.replace("view", "photos2/b");
                                                            Document documentViewDiagram = DownLoadPage.downLoadPage(bHref);
                                                            String strViewDiagram = parseViewDiagram(documentViewDiagram);
                                                            anjukeCommunity.setLayoutImages(strModel);
                                                            anjukeCommunity.setRealityImages(strViewDiagram);

                                                            //插入数据库
                                                            anjukeCommunityService.insertAnjukeCommunity(anjukeCommunity);

                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            Document documentDetail = DownLoadPage.downLoadPage(detailHref);
                                                            System.err.println("detailPage============================================================");
                                                            System.out.println(documentDetail);
                                                        }finally {
                                                            semaphore.release();
                                                        }
                                                    }
                                                });
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }else{
                logger.info("解析主链接，获取区域种子链接为空========================="+url);
            }
        }
        //等待所有任务都结束了继续执行
        executor.shutdown();
        // 等待子线程结束，再继续执行下面的代码
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) ;
        System.out.println("结束+++++");
    }


    /**
     *解析房型图的实景图
     */
    public static String parseViewDiagram(Document document){
        List<String> list = new ArrayList<>();
        if(document!=null){
            Elements selects = document.select("div.realmap-contents>ul.list>li.item>img");
            if(selects!=null && ! selects.isEmpty()){
                for (Element select : selects) {
                    String src = select.attr("src");
                    list.add(src);
                }
            }
        }
        String jsonString = JSON.toJSONString(list);
        return jsonString;
    }


    /**
     * 解析房型图的页面
     * @param document
     */
    public static String parseModel(Document document){
        List<Map<String, Object>> floorPlanList = new ArrayList<>();
        if(document==null){
            return null;
        }else{
            Elements selects = document.select("div.chamber-contents>div.chamber-comm-mod");
            if(selects!=null && !selects.isEmpty()){
                //房型分组标签
                Elements selectsHd = selects.select("h3.hd");
                //房型的列表信息
                Elements selectsItem = selects.select("ul.list");

                if(selectsHd!=null && !selectsHd.isEmpty() && selectsItem!=null && !selectsItem.isEmpty()){
                    for (int i = 0; i < selectsHd.size(); i++) {
                        try {
                            Map<String, Object> mapRoom = new HashMap<>();
                            Element elementHd = selectsHd.get(i);
                            //房型分组
                            String textType = elementHd.text();
                            mapRoom.put("roomType",textType);
                            Element elementUl = selectsItem.get(i);
                            if(elementUl!=null){
                                Elements selectsLi = elementUl.select("li.item");
                                List<Map<String, Object>> listUrl = new ArrayList<Map<String, Object>>();
                                for (Element elementLi : selectsLi) {
                                    Map<String, Object> mapUrl = new HashMap<String, Object>();
                                    Elements selectImg = elementLi.select("div.img-box>img");
                                    if(selectImg!=null){
                                        //房型图的url
                                        String src = selectImg.attr("src");
                                        mapUrl.put("src",src);
                                    }
                                    //房型
                                    Elements selectRoom = elementLi.select("p>span.room");
                                    if(selectRoom!=null && selectRoom.size()!=0){
                                        String room = selectRoom.text();
                                        mapUrl.put("room",room);
                                    }
                                    //面积
                                    Elements selectArea = elementLi.select("p>span.area");
                                    if(selectArea!=null && selectArea.size()!=0){
                                        String area = selectArea.text();
                                        mapUrl.put("area",area);
                                    }
                                    //朝向
                                    Elements selectTowards = elementLi.select("p>span.towards");
                                    if(selectTowards!=null && selectTowards.size()!=0){
                                        String towards = selectTowards.text();
                                        mapUrl.put("towards",towards);
                                    }
                                    listUrl.add(mapUrl);
                                }
                                mapRoom.put("floorPlan",listUrl);
                            }
                            floorPlanList.add(mapRoom);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            String jsonString = JSON.toJSONString(floorPlanList);
            return jsonString;
        }
    }

    /**
     * 解析主链接，获取区域种子链接
     * @param document
     * @return
     */
    public static List<Map<String,Object>> parseIndexPage(Document document){
        //存放区域的种子链接
        List<Map<String,Object>> listRegion= new ArrayList<Map<String,Object>>();
        if(document==null){
            return null;
        }else{
            //获取上海城,区域的种子链接
            Elements selects = document.select("div.items>span.elems-l.pp-mod");
            if(!selects.isEmpty() && selects.size()>0){
                //获取城市的区域部分span标签
                Element elementCcommunity = selects.get(0);
                //获取城市的区域种子链接
                Elements elementHrefs = elementCcommunity.select("a").not("a.selected-item");
                for (Element elementHref : elementHrefs) {

                    Map<String,Object> map=new HashMap<String,Object>();
                    String hrefRegion = elementHref.attr("href");
                    System.out.println("请求解析主链接，获取区域链接+++"+hrefRegion);
                    String region = elementHref.text();
                    //临时断点爬去
                    /*"江宁".equals(region) || "浦口".equals(region)||"建邺".equals(region)*/
                    /*if ("江宁".equals(region) || "浦口".equals(region)||"建邺".equals(region)){
                        continue;
                    }else{*/
                        map.put("hrefRegion",hrefRegion);
                        map.put("region",region);
                        listRegion.add(map);
                    //}


                }
            }
            return listRegion;
        }
    }

    /**
     * 解析主链接，获取区域下的板块种子链接
     * @param document
     * @return
     */
    public static List<Map<String,Object>> parseRegionPage(Document document){
        //存放区域下的细分种子链接
        List<Map<String,Object>> listPlate= new ArrayList<Map<String,Object>>();
        if(document==null){
            return listPlate;
        }else {
            //获取上海城,区域下的细分种子链接
            Elements elements = document.select("div.items>span.elems-l.pp-mod>div.sub-items>a").not("a.selected-item");
            if(!elements.isEmpty() && elements.size()>0){
                for (Element elementHref : elements) {
                    Map<String,Object> map=new HashMap<String,Object>();

                    String hrefPlate = elementHref.attr("href");
                    System.out.println("请求解析区域链接，获取板块链接---"+hrefPlate);
                    String plate = elementHref.text();
                    /*if (*//*"磁各庄".equals(plate) || "大兴区其他".equals(plate)|| "观音寺".equals(plate)||"高米店".equals(plate)||"黄村".equals(plate)
                        || "旧宫".equals(plate) || "芦城乡".equals(plate)|| "庞各庄".equals(plate)|| "天宫院北".equals(plate)|| "天宫院南".equals(plate)
                            ||"西红门".equals(plate)||*//*
                            "定淮门大街".equals(plate)|| "凤凰西街".equals(plate) || "福建路".equals(plate) ||
                                    "华侨路".equals(plate) ||"湖南路".equals(plate)
                            ){
                        continue;
                    }else{*/
                        map.put("hrefPlate", hrefPlate);
                        map.put("plate", plate);
                        listPlate.add(map);
                    //}
                }
            }else{
                logger.info("解析区域种子链接,获取板块链接为空=========================");
                System.out.println(document);
            }
            return listPlate;
        }
    }

    /**
     * 解析区域下的细分种子链接,获取分页数目
     * @param document
     * @return
     */
    public static Integer parsePlatePage(Document document){
        //获取当前区域下的小区数目
        Integer regionNum =0;
        if(document==null){
            return regionNum;
        }else{
            Elements elements = document.select("div#list-content>div.sortby>span.tit>em");
            if(elements!=null && elements.size()>1){
                Element element = elements.get(1);
                String numStr = element.text();
                if(StringUtils.isNotBlank(numStr)){
                    regionNum = Integer.parseInt(numStr);
                }
            }
            Integer regionPageNum = regionNum%30 == 0 ? regionNum/30 : regionNum/30+1;
            return regionPageNum;
        }
    }

    /**
     * 解析分页链接，获取列表中的详情链接(每页有三十条数据)
     * @param document
     * @return
     */
    public static List<AnjukeCommunityWithBLOBs> parsePage(Document document,AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs){
        String city = anjukeCommunityWithBLOBs.getCity();
        String region = anjukeCommunityWithBLOBs.getRegion();
        String plate = anjukeCommunityWithBLOBs.getPlate();

        //存放列表下的详情种子链接
        List<AnjukeCommunityWithBLOBs> listDetail= new ArrayList<>();
        if(document==null){
            return listDetail;
        }else{
            //获取上海城,区域下的细分种子链接
            Elements elements = document.select("div#list-content>div.li-itemmod");
            if(!elements.isEmpty()){
                for (Element element : elements) {
                    AnjukeCommunityWithBLOBs anjukeCommunityNew = new AnjukeCommunityWithBLOBs();
                    anjukeCommunityNew.setId(UUID.randomUUID().toString());
                    anjukeCommunityNew.setCity(city);
                    anjukeCommunityNew.setRegion(region);
                    anjukeCommunityNew.setPlate(plate);
                    //缩略图
                    Elements selectThumbUrl = element.select("a.img>img.thumbnail");
                    if(selectThumbUrl!=null){
                        String thumbUrl = selectThumbUrl.attr("src");
                        anjukeCommunityNew.setThumbUrl(thumbUrl);
                    }
                    //详细信息
                    //url
                    String href = element.select("div.li-info>h3>a").attr("href");
                    anjukeCommunityNew.setDetailUrl(href);
                    System.out.println("列表的详情页种子链接"+href);

                    //名称
                    String name = element.select("div.li-info>h3>a").text();
                    anjukeCommunityNew.setHomeName(name);

                    //地址信息
                    String address = element.select("div.li-info>address").text();
                    anjukeCommunityNew.setAddress(address);
                    System.out.println("名称"+address);

                    //竣工时间
                    String date = element.select("div.li-info>p.date").text();
                    anjukeCommunityNew.setBuildYear(date);

                    Elements selectPrice = element.select("div.li-side>p>strong");
                    if(!selectPrice.isEmpty()){
                        String price = selectPrice.text();
                        anjukeCommunityNew.setAveragePrice(price);
                        System.out.println("价格"+price);
                    }
                    Elements selectLoopPrice = element.select("div.li-side>p.price-txt");
                    //环比上个月的增幅
                    if(selectLoopPrice!=null){
                        String loopPrice = selectLoopPrice.text();
                        anjukeCommunityNew.setLoopPosition(loopPrice);
                    }

                    listDetail.add(anjukeCommunityNew);
                }
            }
            return listDetail;
        }
    }

    /**
     * 解析详情页的url，获取详情信息
     * @param document
     * @return
     */
    public static void parseDetail(Document document,AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs){
        if(document!=null){
            Elements elementsBasic = document.select("div#basic-infos-box>dl.basic-parms-mod");
            if(elementsBasic!=null && elementsBasic.size()!=0){
                Elements elementsDt = elementsBasic.get(0).select("dt");
                Elements elementsDd = elementsBasic.get(0).select("dd");
                if(elementsBasic!=null){
                    for (int i=0;i< elementsDd.size();i++) {
                        try {
                            Element dt = elementsDt.get(i);
                            Element dd = elementsDd.get(i);
                            String strDt = dt.text().trim();
                            String strDd = dd.text();
                            if("物业类型：".equals(strDt)){
                                //物业类型
                                anjukeCommunityWithBLOBs.setPropertyType(strDd);
                                continue;
                            }else if("总户数：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setHomeTotal(strDd);
                                continue;
                            }else if("开  发  商：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setBuildDevelopers(strDd);
                                continue;
                            }else if("总建面积：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setBuildArea(strDd);
                                continue;
                            }else if("容  积  率：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setPlotRate(strDd);
                                continue;
                            }else if("绿化率：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setGreenRate(strDd);
                                continue;
                            }else if("物业公司：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setPropertyCompany(strDd);
                                continue;
                            }else if("物业费：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setPropertyPrice(strDd);
                                continue;
                            }else if("停车位：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setParkNum(strDd);
                                continue;
                            }else if("相关学校：".equals(strDt)){
                                anjukeCommunityWithBLOBs.setDuikouSchool(strDd);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

}
