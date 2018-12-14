package com.tt.controller.lianjia;

import com.alibaba.fastjson.JSON;
import com.tt.dao.LianjiaListingHouseDetailMapper;
import com.tt.dao.LianjiaListingHouseListMapper;
import com.tt.dao.LianjiaListingHousePicMapper;
import com.tt.dao.LianjiaListingHousePlateMapper;
import com.tt.entity.*;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/12 17:08
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseListingHouse {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private LianjiaListingHousePlateMapper lianjiaListingHousePlateMapper;

    @Autowired
    private LianjiaListingHouseListMapper lianjiaListingHouseListMapper;

    @Autowired
    private LianjiaListingHouseDetailMapper lianjiaListingHouseDetailMapper;

    @Autowired
    private LianjiaListingHousePicMapper lianjiaListingHousePicMapper;


    @Test
    public void parseDetail() throws InterruptedException {
        LianjiaListingHouseListExample lianjiaListingHouseListExample = new LianjiaListingHouseListExample();
        lianjiaListingHouseListExample.or().andCityEqualTo("杭州").andStatusIsNull().andDetailUrlIsNotNull();

        List<LianjiaListingHouseList> lianjiaListingHouseLists = lianjiaListingHouseListMapper.selectByExample(lianjiaListingHouseListExample);
        System.out.println(lianjiaListingHouseLists.size());
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (LianjiaListingHouseList lianjiaListingHouseList : lianjiaListingHouseLists) {

            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String detailUrl = lianjiaListingHouseList.getDetailUrl();
                    String goodsId = lianjiaListingHouseList.getGoodsId();
                    String viewCount = lianjiaListingHouseList.getViewCount();
                    System.out.println(detailUrl);
                    try {
                        Document document = iDownLoadPage.downLoadPageByGet(detailUrl);
                        if(document!=null){
                            LianjiaListingHouseDetail lianjiaListingHouseDetail = new LianjiaListingHouseDetail();
                            lianjiaListingHouseDetail.setId(UUID.randomUUID().toString());
                            lianjiaListingHouseDetail.setGoodsId(goodsId);
                            lianjiaListingHouseDetail.setDetailUrl(detailUrl);
                            lianjiaListingHouseDetail.setViewCount(viewCount);
                            lianjiaListingHouseDetail.setBatchId("v1.0");
                            lianjiaListingHouseDetail.setCreateTime(new Date());

                            //房源名称和房源描述
                            Elements selectTitle = document.select("div.title-wrapper>div.content>div.title");
                            if(!selectTitle.isEmpty()){
                                String title = selectTitle.select("h1.main").text();
                                String goodsDes = selectTitle.select("div.sub").text();

                                lianjiaListingHouseDetail.setGoodsName(title);
                                lianjiaListingHouseDetail.setGoodsDes(goodsDes);
                            }
                            //关注房源
                            Elements selectFav = document.select("span#favCount");
                            if(!selectFav.isEmpty()){
                                String concernCount = selectFav.text();
                                lianjiaListingHouseDetail.setConcernCount(concernCount);
                            }
                            //conten信息
                            Elements elements = document.select("div.overview>div.content");
                            if(!elements.isEmpty()){
                                //价格信息
                                Elements selectPrice = elements.select("div.price");
                                if(!selectPrice.isEmpty()){
                                    String price = selectPrice.select("span.total").text();
                                    String unit = elements.select("span.unit>span").text();
                                    //总价
                                    String totalPrice=price+unit;
                                    //均价
                                    String avgPrice = selectPrice.select("div.text>div.unitPrice>span.unitPriceValue").text();
                                    lianjiaListingHouseDetail.setTotalPrice(totalPrice);
                                    lianjiaListingHouseDetail.setAvgPrice(avgPrice);
                                }
                                //建造年代
                                String buildYear = elements.select("div.houseInfo>div.area>div.subInfo").text();
                                if(StringUtils.isNotBlank(buildYear)){
                                    String substring = buildYear.substring(0, buildYear.indexOf("/"));
                                    lianjiaListingHouseDetail.setBuildYear(substring);
                                }
                                //小区信息
                                Elements selectXiaoqu = elements.select("div.aroundInfo");

                                if(!selectXiaoqu.isEmpty()){
                                    //小区名称
                                    Elements select = selectXiaoqu.select("div.communityName>a.info");
                                    if(!select.isEmpty()){
                                        ///xiaoqu/1111027376129/
                                        String href = select.attr("href");
                                        if(StringUtils.isNotBlank(href)){
                                            String titleId = href.substring(href.indexOf("xiaoqu/") + 7, href.length() - 1);
                                            lianjiaListingHouseDetail.setTitleId(titleId);
                                        }
                                        //小区名称
                                        String title = select.text();
                                        lianjiaListingHouseDetail.setTitle(title);
                                    }
                                    //所在区域
                                    Elements selectArea = selectXiaoqu.select("div.areaName>span.info");
                                    if(!selectArea.isEmpty()){
                                        Elements selectA = selectArea.select("a");
                                        if(selectA.size()==2){
                                            String region = selectA.get(0).text();
                                            String plate = selectA.get(1).text();
                                            lianjiaListingHouseDetail.setRegion(region);
                                            lianjiaListingHouseDetail.setPlate(plate);
                                        }
                                    }
                                    //环线位置
                                    String loopPosition = selectArea.first().ownText();
                                    if(StringUtils.isNotBlank(loopPosition)){
                                        lianjiaListingHouseDetail.setLoopPosition(loopPosition);
                                    }
                                    //地铁线路
                                    String subway = selectXiaoqu.select("div.areaName>a.supplement").text();
                                    if(StringUtils.isNotBlank(subway)){
                                        lianjiaListingHouseDetail.setSubway(subway);
                                    }
                                    //看房时间
                                    String watchDescription = selectXiaoqu.select("div.visitTime>span.info").text();
                                    if(StringUtils.isNotBlank(watchDescription)){
                                        lianjiaListingHouseDetail.setWatchDescription(watchDescription);
                                    }
                                }
                                //基本信息
                                Elements select = document.select("div#introduction>div>div.introContent");
                                if(!select.isEmpty()){
                                    //基本属性
                                    Elements selectBase = select.select("div.base>div.content>ul>li");
                                    if(!selectBase.isEmpty()){
                                        for (Element element : selectBase) {
                                            String baseTag = element.select("span.label").text();
                                            String value=element.ownText();
                                            switch (baseTag){
                                                case "房屋户型":
                                                    lianjiaListingHouseDetail.setLayout(value);
                                                    break;
                                                case "所在楼层":
                                                    //中楼层 (共29层)
                                                    String[] split = value.split(" \\(");
                                                    if(split.length==2){
                                                        String floorHeight = split[0];
                                                        lianjiaListingHouseDetail.setFloorHeight(floorHeight);
                                                        String totalFloor = split[1].replace(")","");
                                                        lianjiaListingHouseDetail.setTotalFloor(totalFloor);
                                                    }
                                                    break;
                                                case "建筑面积":
                                                    lianjiaListingHouseDetail.setArea(value);
                                                    break;
                                                case "户型结构":
                                                    lianjiaListingHouseDetail.setLayoutStr(value);
                                                    break;
                                                case"套内面积":
                                                    lianjiaListingHouseDetail.setDwellingFloorSpace(value);
                                                    break;
                                                case "建筑类型":
                                                    lianjiaListingHouseDetail.setBuildType(value);
                                                    break;
                                                case "房屋朝向":
                                                    lianjiaListingHouseDetail.setOrientation(value);
                                                    break;
                                                case "建筑结构":
                                                    lianjiaListingHouseDetail.setBuildStr(value);
                                                    break;
                                                case "装修情况":
                                                    lianjiaListingHouseDetail.setDecoration(value);
                                                    break;
                                                case "梯户比例":
                                                    lianjiaListingHouseDetail.setLadderRatio(value);
                                                    break;
                                                case "供暖方式":
                                                    lianjiaListingHouseDetail.setHeating(value);
                                                    break;
                                                case "配备电梯":
                                                    lianjiaListingHouseDetail.setElevator(value);
                                                    break;
                                                case "产权年限":
                                                    lianjiaListingHouseDetail.setPropertyYear(value);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                    //交易属性
                                    Elements selectTransaction = select.select("div.transaction>div.content>ul>li");
                                    if(!selectTransaction.isEmpty()){
                                        for (Element element : selectTransaction) {
                                            String transactionTag = element.select("span.label").text();
                                            String value=element.select("span").not("span.label").text();
                                            switch (transactionTag){
                                                case "挂牌时间":
                                                    lianjiaListingHouseDetail.setGoodsPubtime(value);
                                                    break;
                                                case "交易权属":
                                                    lianjiaListingHouseDetail.setTradingRights(value);
                                                    break;
                                                case "上次交易":
                                                    lianjiaListingHouseDetail.setGoodsLastselltime(value);
                                                    break;
                                                case "房屋用途":
                                                    lianjiaListingHouseDetail.setPropertyType(value);
                                                    break;
                                                case"房屋年限":
                                                    lianjiaListingHouseDetail.setHousingYears(value);
                                                    break;
                                                case "产权所属":
                                                    lianjiaListingHouseDetail.setPropertyOwnership(value);
                                                    break;
                                                case "抵押信息":
                                                    lianjiaListingHouseDetail.setMortgageInformation(value);
                                                    break;
                                                case "房本备件":
                                                    lianjiaListingHouseDetail.setIsCertificate(value);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                //户型分间
                                Elements selectLayout = document.select("div#layout>div.layout>div.content");
                                if(!selectLayout.isEmpty()){
                                    //户型图url
                                    String src = document.select("div.imgdiv>img").attr("src");
                                    Elements select1 = document.select("div#infoList>div.row");
                                    if(!select1.isEmpty()){
                                        List<Map> list = new ArrayList<>();
                                        for (Element element : select1) {
                                            Map<String, String> map = new HashMap<>();
                                            Elements select2 = element.select("div.col");
                                            if(select2.size()==4){
                                                map.put("room",select2.get(0).text());
                                                map.put("area",select2.get(1).text());
                                                map.put("toward",select2.get(2).text());
                                                map.put("window",select2.get(3).text());
                                            }
                                            list.add(map);
                                        }
                                        String jsonString = JSON.toJSONString(list);
                                        lianjiaListingHouseDetail.setApartmentSrc(src);
                                        lianjiaListingHouseDetail.setApartmentDivision(jsonString);
                                    }

                                }
                                //看房记录
                                //七天的带看次数
                                String viewCount7days = document.select("div#record>div.panel>div.count").text();
                                //三十天的带看次数
                                String viewCount30days = document.select("div#record>div.panel>div.totalCount>span").text();
                                lianjiaListingHouseDetail.setViewCount7days(viewCount7days);
                                lianjiaListingHouseDetail.setViewCount30days(viewCount30days);

                                //房源照片
                                Elements select1 = document.select("div.content-wrapper.housePic>div.container>div.list>div");
                                if(!select1.isEmpty()){
                                    for (Element element : select1) {
                                        String attr = element.select("img").attr("src");
                                        String picType = element.select("span.name").text();
                                        if(StringUtils.isNotBlank(attr)){
                                            LianjiaListingHousePic lianjiaListingHousePic = new LianjiaListingHousePic();
                                            lianjiaListingHousePic.setId(UUID.randomUUID().toString());
                                            lianjiaListingHousePic.setDetailUrl(detailUrl);
                                            lianjiaListingHousePic.setGoodId(goodsId);
                                            lianjiaListingHousePic.setBatchId("v1.0");
                                            lianjiaListingHousePic.setCreateTime(new Date());

                                            lianjiaListingHousePic.setPicSrc(attr);
                                            lianjiaListingHousePic.setPicType(picType);
                                            lianjiaListingHousePicMapper.insertSelective(lianjiaListingHousePic);
                                        }

                                    }
                                }
                                //房主自荐
                                Elements selectImg = document.select("div.newwrap.shuofang>div.bd>ul.images>li>img");
                                if(!selectImg.isEmpty()){
                                    for (Element element : selectImg) {
                                        String src = element.attr("src");
                                        if(StringUtils.isNotBlank(src)){
                                            LianjiaListingHousePic lianjiaListingHousePic = new LianjiaListingHousePic();
                                            lianjiaListingHousePic.setId(UUID.randomUUID().toString());
                                            lianjiaListingHousePic.setDetailUrl(detailUrl);
                                            lianjiaListingHousePic.setGoodId(goodsId);
                                            lianjiaListingHousePic.setBatchId("v1.0");
                                            lianjiaListingHousePic.setCreateTime(new Date());

                                            lianjiaListingHousePic.setPicSrc(src);
                                            lianjiaListingHousePic.setPicType("房主自荐");
                                            lianjiaListingHousePicMapper.insertSelective(lianjiaListingHousePic);
                                        }

                                    }
                                }


                                lianjiaListingHouseDetailMapper.insertSelective(lianjiaListingHouseDetail);

                            }


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
            lianjiaListingHouseList.setStatus("1");
            lianjiaListingHouseListMapper.updateByPrimaryKeySelective(lianjiaListingHouseList);
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

    
    /**
     *
     * 功能描述: 解析板块链接，获取详情列表链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/12 18:04
     */
    @Test
    public void parsePlate() throws InterruptedException {
        LianjiaListingHousePlateExample lianjiaListingHousePlateExample = new LianjiaListingHousePlateExample();
        lianjiaListingHousePlateExample.or().andStatusIsNull();
        List<LianjiaListingHousePlate> lianjiaListingHousePlates = lianjiaListingHousePlateMapper.selectByExample(lianjiaListingHousePlateExample);
        System.out.println(lianjiaListingHousePlates.size());
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (LianjiaListingHousePlate lianjiaListingHousePlate : lianjiaListingHousePlates) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String city = lianjiaListingHousePlate.getCity();
                        String region = lianjiaListingHousePlate.getRegion();
                        String plate = lianjiaListingHousePlate.getPlate();

                        String plateUrl = lianjiaListingHousePlate.getPlateUrl();
                        System.out.println(plateUrl);
                        Document document = iDownLoadPage.downLoadPageByGet(plateUrl);
                        if(document!=null){
                            Elements select = document.select("h2.total.fl>span");
                            if(!select.isEmpty()){
                                //板块的总条数
                                String listCount = select.text();
                                System.out.println(listCount);

                                //解析当前页面的列表信息
                                List<LianjiaListingHouseList> lianjiaListingHouseLists = parseListMessage(document);
                                for (LianjiaListingHouseList lianjiaListingHouseList : lianjiaListingHouseLists) {
                                    lianjiaListingHouseList.setCity(city);
                                    lianjiaListingHouseList.setRegion(region);
                                    lianjiaListingHouseList.setPlate(plate);
                                    lianjiaListingHouseListMapper.insertSelective(lianjiaListingHouseList);
                                }

                                //翻页请求
                                //计算页码数量
                                Integer count = Integer.valueOf(listCount);
                                if(count!=0 && count>30){
                                    Integer pageNum= count % 30==0? count/30:(count/30)+1;
                                    for (int i = 2; i <= pageNum; i++) {
                                        String pageUrl = plateUrl + "pg" + i+"/";
                                        Document doc = iDownLoadPage.downLoadPageByGet(pageUrl);
                                        if(doc!=null){
                                            //解析当前页面的列表信息
                                            List<LianjiaListingHouseList> lianjiaListingHouseLists1 = parseListMessage(doc);
                                            for (LianjiaListingHouseList lianjiaListingHouseList1 : lianjiaListingHouseLists1) {
                                                lianjiaListingHouseList1.setCity(city);
                                                lianjiaListingHouseList1.setRegion(region);
                                                lianjiaListingHouseList1.setPlate(plate);
                                                lianjiaListingHouseListMapper.insertSelective(lianjiaListingHouseList1);
                                            }
                                        }
                                    }
                                }

                                //修改状态
                                lianjiaListingHousePlate.setSource(listCount);
                                lianjiaListingHousePlate.setStatus("1");
                                lianjiaListingHousePlateMapper.updateByPrimaryKeySelective(lianjiaListingHousePlate);
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
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }
    
    /**
     *
     * 功能描述: 解析当前列表页信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/12 18:38
     */
    public List<LianjiaListingHouseList> parseListMessage(Document document) {
        List<LianjiaListingHouseList> list=new ArrayList<>();
        Elements selectLi = document.select("ul.sellListContent>li");
        if(!selectLi.isEmpty()){
            for (Element element : selectLi) {
                LianjiaListingHouseList lianjiaListingHouseList = new LianjiaListingHouseList();
                lianjiaListingHouseList.setId(UUID.randomUUID().toString());
                lianjiaListingHouseList.setBatchId("v1.0");
                lianjiaListingHouseList.setCreateTime(new Date());
                //详情的url
                Elements select = element.select("a.noresultRecommend");
                if(!select.isEmpty()){
                    String detailUrl = select.attr("href");
                    lianjiaListingHouseList.setDetailUrl(detailUrl);
                    if(StringUtils.isNotBlank(detailUrl)){
                        String goodesId =null;
                        try {
                            goodesId = detailUrl.substring(detailUrl.lastIndexOf("/")+1, detailUrl.indexOf(".html"));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        System.out.println(goodesId);
                        lianjiaListingHouseList.setGoodsId(goodesId);
                    }
                    String surfacePlot = select.select("img").attr("data-original");
                    lianjiaListingHouseList.setSurfacePlot(surfacePlot);
                    System.out.println(detailUrl);
                    System.out.println(surfacePlot);
                }
                //详情信息
                Elements select1 = element.select("div.info");

                if(!select1.isEmpty()){
                    String goodsName = select1.select("div.title>a").text();
                    lianjiaListingHouseList.setGoodsName(goodsName);
                }
                //带看总次数
                Elements select3 = select1.select("div.followInfo");
                if(!select3.isEmpty()){
                    //13人关注 / 共23次带看 / 4个月以前发布
                    //view_count
                    String follow = select3.get(0).ownText();
                    if(StringUtils.isNotBlank(follow)){
                        String viewCount = follow.substring(follow.indexOf("共") + 1, follow.indexOf("次带看"));
                        System.out.println("带看总次数"+viewCount);
                        lianjiaListingHouseList.setViewCount(viewCount);
                    }

                }
                //标签
                String tag="";
                Elements select2 = select1.select("div.tag>span");
                if(!select2.isEmpty()){
                    for (Element element1 : select2) {
                        String text = element1.text();
                        if(StringUtils.isNotBlank(text)){
                            if(StringUtils.isNotBlank(tag)){
                                tag=tag+","+text;
                            }else {
                                tag=tag+text;
                            }
                        }
                    }
                    lianjiaListingHouseList.setTag(tag);
                }
                list.add(lianjiaListingHouseList);
            }
        }
        return list;
    }


    /**
     *
     * 功能描述: 获取列表的挂牌数据
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/12 17:19
     */
    @Test
    public void parseIndex(){
        Map<String, String> mapCity = new HashMap<>();
        //mapCity.put("杭州","https://hz.lianjia.com/ershoufang/");
        //mapCity.put("上海","https://sh.lianjia.com/ershoufang/");
        mapCity.put("北京","https://bj.lianjia.com/ershoufang/");
        /*mapCity.put("深圳","https://sz.lianjia.com/ershoufang/");
        mapCity.put("广州","https://gz.lianjia.com/ershoufang/");
        mapCity.put("南京","https://nj.lianjia.com/ershoufang/");
        mapCity.put("苏州","https://sz.lianjia.com/ershoufang/");
        mapCity.put("重庆","https://cq.lianjia.com/ershoufang/");
        mapCity.put("成都","https://cd.lianjia.com/ershoufang/");
        mapCity.put("西安","https://xa.lianjia.com/ershoufang/");
        mapCity.put("武汉","https://wh.lianjia.com/ershoufang/");
        mapCity.put("郑州","https://zz.lianjia.com/ershoufang/");
        mapCity.put("合肥","https://hf.lianjia.com/ershoufang/");
        mapCity.put("青岛","https://qd.lianjia.com/ershoufang/");
        mapCity.put("天津","https://tj.lianjia.com/ershoufang/");
        mapCity.put("沈阳","https://sy.lianjia.com/ershoufang/");
        mapCity.put("济南","https://jn.lianjia.com/ershoufang/");*/

        for (String city : mapCity.keySet()) {
            String indexUrl = mapCity.get(city);
            String hostName=indexUrl.replace("/ershoufang/","");

            Document document = iDownLoadPage.downLoadPageByGet(indexUrl);
            Elements select = document.select("div[data-role=ershoufang]>div>a");
            if(!select.isEmpty()){
                for (Element element : select) {
                    String regionHref = element.attr("href");
                    String region = element.text();
                    if(StringUtils.isNotBlank(regionHref) && StringUtils.isNotBlank(region) && (!regionHref.contains("https"))){
                        //区域链接
                        regionHref=hostName+regionHref;
                        System.out.println(regionHref+region);
                        //板块链接
                        Document document1 = iDownLoadPage.downLoadPageByGet(regionHref);
                        Elements select1 = document1.select("div[data-role=ershoufang]>div");
                        if(select1.size()==2){
                            Elements select2 = select1.get(1).select("a");
                            if(!select2.isEmpty()){
                                for (Element element1 : select2) {
                                    String plateHref = element1.attr("href");
                                    String plate = element1.text();
                                    if(StringUtils.isNotBlank(plateHref) && StringUtils.isNotBlank(plate)){
                                        LianjiaListingHousePlate lianjiaListingHousePlate = new LianjiaListingHousePlate();
                                        lianjiaListingHousePlate.setId(UUID.randomUUID().toString());
                                        lianjiaListingHousePlate.setBatchId("v1.0");
                                        lianjiaListingHousePlate.setCreateDate(new Date());
                                        lianjiaListingHousePlate.setCity(city);
                                        lianjiaListingHousePlate.setRegion(region);
                                        lianjiaListingHousePlate.setRegionUrl(regionHref);
                                        //区域链接
                                        plateHref=hostName+plateHref;
                                        System.out.println(plateHref+plate);

                                        lianjiaListingHousePlate.setPlate(plate);
                                        lianjiaListingHousePlate.setPlateUrl(plateHref);
                                        //插入数据
                                        lianjiaListingHousePlateMapper.insertSelective(lianjiaListingHousePlate);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

}
