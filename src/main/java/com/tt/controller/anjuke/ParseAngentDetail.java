package com.tt.controller.anjuke;

import com.alibaba.fastjson.JSON;
import com.tt.dao.AnjukeBrokerEsfgoodsDetailMapper;
import com.tt.dao.AnjukeBrokerListMapper;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailWithBLOBs;
import com.tt.entity.AnjukeBrokerList;
import com.tt.entity.AnjukeBrokerListExample;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
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
 * 解析经纪人的详情信息
 * @Auther: 赵乐
 * @Date: 2018/10/25 11:45
 * @Description:
 */
@RestController
public class ParseAngentDetail {

    @Autowired
    private AnjukeBrokerListMapper anjukeBrokerListMapper;

    @Autowired
    private AnjukeBrokerEsfgoodsDetailMapper anjukeBrokerEsfgoodsDetailMapper;

    @Autowired
    //@Qualifier("ipPoolProxy")
    @Qualifier("moguProxy")
    private IDownLoadPage downLoadPage;

    @RequestMapping("/parse")
    public String parseBrokerEsfgoods() throws InterruptedException {
        Integer threadNum=6;
        Semaphore semaphore = new Semaphore(threadNum);
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        AnjukeBrokerListExample anjukeBrokerListExample = new AnjukeBrokerListExample();
        AnjukeBrokerListExample.Criteria criteria = anjukeBrokerListExample.createCriteria();
        criteria.andDescriptionIsNull();
        List<AnjukeBrokerList> anjukeBrokerLists = anjukeBrokerListMapper.selectByExample(anjukeBrokerListExample);
        System.out.println(anjukeBrokerLists.size());
        //解析详情页信息
        for (AnjukeBrokerList anjukeBrokerList : anjukeBrokerLists) {
            semaphore.acquire();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("开始------"+anjukeBrokerList.getUrl());
                        List<AnjukeBrokerEsfgoodsDetailWithBLOBs> anjukeBrokerEsfgoodsDetails = new ArrayList<>();
                        //获取经济人的
                        String url = anjukeBrokerList.getUrl();
                        String city = anjukeBrokerList.getCity();
                        String region = anjukeBrokerList.getRegion();
                        String plate = anjukeBrokerList.getPlate();
                        String brokerId = anjukeBrokerList.getBrokerId();

                        //解析经纪人的详情，获取二手房的主页链接
                        Document documentDetail = downLoadPage.downLoadPageByGet(url);
                        anjukeBrokerEsfgoodsDetails = parseDetail(documentDetail, anjukeBrokerEsfgoodsDetails);
                        if(anjukeBrokerEsfgoodsDetails!=null && anjukeBrokerEsfgoodsDetails.size()!=0){
                            //解析二手房的主页链接
                            for (AnjukeBrokerEsfgoodsDetailWithBLOBs anjukeBrokerEsfgoodsDetail : anjukeBrokerEsfgoodsDetails) {
                                try {
                                    //设置公共信息
                                    anjukeBrokerEsfgoodsDetail.setBrokerId(brokerId);
                                    anjukeBrokerEsfgoodsDetail.setBrokerUrl(url);
                                    anjukeBrokerEsfgoodsDetail.setCity(city);
                                    anjukeBrokerEsfgoodsDetail.setRegion(region);
                                    anjukeBrokerEsfgoodsDetail.setPlate(plate);

                                    //获取二手房的链接
                                    String urlErGoods= anjukeBrokerEsfgoodsDetail.getUrl();
                                    Document documentGoodsDetail = downLoadPage.downLoadPageByGet(urlErGoods);
                                    parseGoodsDetail(documentGoodsDetail,anjukeBrokerEsfgoodsDetail);
                                    anjukeBrokerEsfgoodsDetailMapper.insert(anjukeBrokerEsfgoodsDetail);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            //更新操作
                            try {
                                anjukeBrokerList.setDescription("11");
                                anjukeBrokerListMapper.updateByPrimaryKeySelective(anjukeBrokerList);
                            } catch (Exception e) {
                                e.printStackTrace();
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
        executor.shutdown();
        // 等待子线程结束，再继续执行下面的代码
        try {
            while (!executor.awaitTermination(1, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束+++++");

        //测试方法
       /* List<AnjukeBrokerEsfgoodsDetail> anjukeBrokerEsfgoodsDetails = new ArrayList<>();
        String url="https://zhongyuandichan.anjuke.com/gongsi-jjr-3644606/";
        Document documentDetail = DownLoadPage.downLoadPage(url);
        anjukeBrokerEsfgoodsDetails = parseDetail(documentDetail, anjukeBrokerEsfgoodsDetails);
        System.out.println(anjukeBrokerEsfgoodsDetails.size());*/

       /* String urlErGoods= "https://yongxuandichan.anjuke.com/gongsi-esf/A1454176538.html?from=filter-saleMetro-salesxq&spread=filtersearch&position=1&kwtype=filter&now_time=1540457817";
        Document documentGoodsDetail = DownLoadPage.downLoadPage(urlErGoods);
        parseGoodsDetail(documentGoodsDetail,new AnjukeBrokerEsfgoodsDetail());*/
        return "success";
    }
    /**
     *
     * 功能描述:
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/25 15:04
     */
    private void parseGoodsDetail(Document documentGoodsDetail, AnjukeBrokerEsfgoodsDetailWithBLOBs anjukeBrokerEsfgoodsDetail) {
        if(documentGoodsDetail!=null){
            //解析房屋的详情信息
            Elements selectEncod = documentGoodsDetail.select("div.houseInfoBox>h4.block-title.houseInfo-title>span.house-encode");
            if(!selectEncod.isEmpty()){
                //房屋编码： 1454274427，发布时间：2018年10月14日
                String textEncod = selectEncod.text();
                try {
                    String[] split = textEncod.split("，");
                    if(split.length==2){
                        String encodStr = split[0];
                        String pubtimeStr = split[1];

                        String encod = encodStr.substring(encodStr.indexOf("房屋编码： ") + 6, encodStr.length());
                        String pubtime = pubtimeStr.substring(pubtimeStr.indexOf("发布时间：") + 5, pubtimeStr.length());

                        anjukeBrokerEsfgoodsDetail.setGoodsId(encod);
                        anjukeBrokerEsfgoodsDetail.setGoodsPubtime(pubtime);
                        System.out.println(encod+"---------------"+pubtime);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Elements elements = documentGoodsDetail.select("div.houseInfoBox>div.block-wrap.block-nocopy.no-bd-top>div.houseInfo-wrap>ul.houseInfo-detail-list.clearfix>li");
            if(!elements.isEmpty()){
                for (Element element : elements) {
                    String strTag =null;
                    String content=null;
                    Elements selectTag = element.select("div.houseInfo-label.text-overflow");
                    if(!selectTag.isEmpty()){
                        strTag=selectTag.text();
                    }
                    Elements selectContent = element.select("div.houseInfo-content");
                    if(!selectContent.isEmpty()){
                        content = selectContent.text();
                    }
                    //通过标签判断
                    switch (strTag){
                        case "所属小区：":
                            Elements selectA = selectContent.select("a");
                            String title = selectA.text();
                            String titleUrl = selectA.attr("href");
                            //https://shanghai.anjuke.com/community/view/14987
                            String titleId = titleUrl.substring(titleUrl.lastIndexOf("/") + 1, titleUrl.length());
                            anjukeBrokerEsfgoodsDetail.setTitle(title);
                            anjukeBrokerEsfgoodsDetail.setTitleId(titleId);
                            anjukeBrokerEsfgoodsDetail.setTitleUrl(titleUrl);
                            System.out.println(title+"----"+titleId+"-----"+titleUrl);
                            break;
                        case "房屋户型：":
                            String Layout=content;
                            anjukeBrokerEsfgoodsDetail.setLayout(Layout);
                            break;
                        case "房屋单价：":
                            String avgPrice =content;
                            anjukeBrokerEsfgoodsDetail.setAvgPrice(avgPrice);
                            break;
                        case "所在位置：":
                            String address =content;
                            anjukeBrokerEsfgoodsDetail.setAddress(address);
                            break;
                        case "建筑面积：":
                            String area =content;
                            anjukeBrokerEsfgoodsDetail.setArea(area);
                            break;
                        case "参考首付：":
                            String downPayment =content;
                            anjukeBrokerEsfgoodsDetail.setDownPayment(downPayment);
                            break;
                        case "建造年代：":
                            String buildYear =content;
                            anjukeBrokerEsfgoodsDetail.setBuildYear(buildYear);
                            break;
                        case "房屋朝向：":
                            String orientations =content;
                            anjukeBrokerEsfgoodsDetail.setOrientations(orientations);
                            break;
                        /*case "参考月供：":
                            String monthlyPayment =content;
                            anjukeBrokerEsfgoodsDetail.setMonthlyPayment(monthlyPayment);
                            break;*/
                        case "房屋类型：":
                            String propertyType =content;
                            anjukeBrokerEsfgoodsDetail.setPropertyType(propertyType);
                            System.out.println(propertyType);
                            break;
                        case "所在楼层：":
                            String floorHeight =content;
                            anjukeBrokerEsfgoodsDetail.setFloorHeight(floorHeight);
                            break;
                        case "装修程度：":
                            String decoration =content;
                            anjukeBrokerEsfgoodsDetail.setDecoration(decoration);
                            break;
                        case "产权年限：":
                            String propertyYear =content;
                            anjukeBrokerEsfgoodsDetail.setPropertyYear(propertyYear);
                            break;
                        case "唯一住房：":
                            String soleHousing =content;
                            anjukeBrokerEsfgoodsDetail.setSoleHousing(soleHousing);
                            break;
                        case "配套电梯：":
                            String elevator =content;
                            anjukeBrokerEsfgoodsDetail.setElevator(elevator);
                            System.out.println(elevator);
                            break;
                        case "产权性质：":
                            String tradingRights =content;
                            anjukeBrokerEsfgoodsDetail.setTradingRights(tradingRights);
                            break;
                        case "房本年限：":
                            String housingYears =content;
                            anjukeBrokerEsfgoodsDetail.setHousingYears(housingYears);
                            break;
                        default:
                            break;
                    }
                }
            }
            Elements selects = documentGoodsDetail.select("div.block-wrap.block-nocopy.no-bd-top>div.houseInfo-desc>div.houseInfo-item");
            if(!selects.isEmpty()){
                for (Element select : selects) {
                    String strtitle = select.select("h5.houseInfo-item-title>span").text();
                    String strTags = select.select("div.houseInfo-item-tags").text();
                    String strDesc = select.select("div.houseInfo-item-desc").text();

                    switch (strtitle){
                        case "核心卖点":
                            String sellingPoint=strDesc;
                            anjukeBrokerEsfgoodsDetail.setSellingPoint(sellingPoint);
                            break;

                        case "业主心态":
                            String proprietorMentality=strDesc;
                            anjukeBrokerEsfgoodsDetail.setProprietorMentality(proprietorMentality);
                            break;

                        case "服务介绍":
                            String serviceTag=strTags;
                            anjukeBrokerEsfgoodsDetail.setServiceTag(serviceTag);
                            String ServiceIntroduction=strDesc;
                            anjukeBrokerEsfgoodsDetail.setServiceIntroduction(ServiceIntroduction);
                            break;
                        default:
                            break;
                    }

                }
            }
            //图片链接
            Map<String, Object> map = new HashMap<>();
            //室内图
            Elements selectRoomPics = documentGoodsDetail.select("div#room_pic_wrap>div>img");
            if(!selectRoomPics.isEmpty()){
                List<String> list=new ArrayList<>();
                for (Element selectRoomPic : selectRoomPics) {
                    String src = selectRoomPic.attr("data-src");
                    list.add(src);
                }
                map.put("roomPics",list);
            }
            //户型图 hx_pic_wrap
            Elements selectHxPics = documentGoodsDetail.select("div#hx_pic_wrap>div>img");
            if(!selectHxPics.isEmpty()){
                List<String> list=new ArrayList<>();
                for (Element selectHxPic : selectHxPics) {
                    String src = selectHxPic.attr("data-src");
                    list.add(src);
                }
                map.put("hxPics",list);
            }
            //环境图
            Elements selectSurroundpics = documentGoodsDetail.select("div#surround_pic_wrap>div>img");
            if(!selectSurroundpics.isEmpty()){
                List<String> list=new ArrayList<>();
                for (Element selectSurroundpic : selectSurroundpics) {
                    String src = selectSurroundpic.attr("data-src");
                    list.add(src);
                }
                map.put("surroundPics",list);
            }

            String jsonString = JSON.toJSONString(map);
            anjukeBrokerEsfgoodsDetail.setPicJson(jsonString);
            //小区信息
            Elements selectCommonin = documentGoodsDetail.select("div.comm-commoninfo>div.cmmmap-info>div.commap-info-intro");
            if(!selectCommonin.isEmpty()){
                for (Element element : selectCommonin) {
                    String title = element.select("p.cminfo-title").text();
                    String info = element.select("p.info-bd").text();
                    if(StringUtils.isBlank(info)){
                        info="暂无";
                    }
                    switch (title){
                        case "总面积":
                            String titleArea=info;
                            anjukeBrokerEsfgoodsDetail.setTitleArea(titleArea);
                            System.out.println("总面积"+titleArea);
                            break;
                        case "总户数":
                            String homeTotal=info;
                            anjukeBrokerEsfgoodsDetail.setHomeTotal(homeTotal);
                            System.out.println("总户数"+homeTotal);
                            break;
                        case "容积率":
                            String plotRate=info;
                            anjukeBrokerEsfgoodsDetail.setPlotRate(plotRate);
                            System.out.println("容积率"+plotRate);
                            break;
                        case "停车位":
                            String parkNum=info;
                            anjukeBrokerEsfgoodsDetail.setParkNum(parkNum);
                            System.out.println("停车位"+parkNum);
                            break;
                        case "绿化率":
                            String greenRate=info;
                            anjukeBrokerEsfgoodsDetail.setGreenRate(greenRate);
                            System.out.println("绿化率"+greenRate);
                            break;
                        case "物业费用":
                            String propertyPrice=info;
                            anjukeBrokerEsfgoodsDetail.setPropertyPrice(propertyPrice);
                            System.out.println("物业费用"+propertyPrice);
                            break;
                        default:
                            break;
                    }

                }
            }

        }
    }

    /**
     *
     * 功能描述: 解析经济人详情页url，获取经纪人的二手房分页链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/25 14:32
     */
    private List<AnjukeBrokerEsfgoodsDetailWithBLOBs> parseDetail(Document documentDetail,List<AnjukeBrokerEsfgoodsDetailWithBLOBs> list) {
        if(documentDetail!=null){
            //解析经纪人二手房列表信息
            Elements selects = documentDetail.select("ul#houselist-mod>li");
            if(!selects.isEmpty()){
                for (Element element : selects) {
                    AnjukeBrokerEsfgoodsDetailWithBLOBs anjukeBrokerEsfgoodsDetail = new AnjukeBrokerEsfgoodsDetailWithBLOBs();
                    anjukeBrokerEsfgoodsDetail.setId(UUID.randomUUID().toString());
                    anjukeBrokerEsfgoodsDetail.setCreatetime(new Date());
                    anjukeBrokerEsfgoodsDetail.setBatchId("v1.0");
                    //缩略图
                    String src = element.select("div.item-img>img").attr("src");
                    anjukeBrokerEsfgoodsDetail.setSurfacePlot(src);
                    System.out.println(src+"------"+"头像缩略图");
                    //基本信息
                    Elements elementHousedetails = element.select("div.house-details");
                    //goods
                    Elements selectTitel = elementHousedetails.select("div.house-title>a");
                    if(!selectTitel.isEmpty()){
                        String goodsName = selectTitel.text();
                        anjukeBrokerEsfgoodsDetail.setGoodsName(goodsName);
                        String titleHref = selectTitel.attr("href");
                        anjukeBrokerEsfgoodsDetail.setUrl(titleHref);
                        //https://lizixingfangdichan.anjuke.com/gongsi-esf/A1452659204.html?from=filter&spread=filtersearch_p&position=1&kwtype=filter&now_time=1540447182
                        System.out.println(goodsName+"---"+titleHref);
                    }
                    //商业标签
                    Elements select = elementHousedetails.select("div.details-item.details-bottom>span");
                    if(!select.isEmpty()){
                        String tag = select.text();
                        anjukeBrokerEsfgoodsDetail.setTag(tag);
                        System.out.println("商业标签"+tag);
                    }
                    //总价信息
                    Elements selectTotalPrice = element.select("div.pro-price");
                    if(!selectTotalPrice.isEmpty()){
                        String totalPrice=selectTotalPrice.text();
                        anjukeBrokerEsfgoodsDetail.setTotalPrice(totalPrice);
                        System.out.println("总价格"+totalPrice);
                    }

                    //其他信息，在二手房详情页获取
                    list.add(anjukeBrokerEsfgoodsDetail);
                }
            }

            //下一页链接
            Elements selectPage = documentDetail.select("div.multi-page>a.aNxt");
            //递归循环爬去
            if(!selectPage.isEmpty()){
                String hrefNext = selectPage.attr("href");
                if(StringUtils.isNotBlank(hrefNext)){
                    System.out.println("分页链接================================================="+hrefNext);
                    documentDetail = downLoadPage.downLoadPageByGet(hrefNext);
                    parseDetail(documentDetail,list);
                }
            }else {
                System.out.println("最后一页");
            }

        }
        return list;
    }

}
