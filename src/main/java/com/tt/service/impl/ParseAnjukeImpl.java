package com.tt.service.impl;

import com.alibaba.fastjson.JSON;
import com.tt.entity.AnjukeCommunity;
import com.tt.entity.AnjukeCommunityWithBLOBs;
import com.tt.service.AnjukeCommunityService;
import com.tt.service.IParse;
import com.tt.service.JedisClientService;
import com.tt.vo.AnjukeParamsVo;
import com.tt.vo.UrlType;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.x509.OCSPNoCheckExtension;

import java.util.*;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/22 19:23
 * @Description:
 */
@Service
public class ParseAnjukeImpl implements IParse {

    private Logger logger= LoggerFactory.getLogger(ParseAnjukeImpl.class);

    @Autowired
    private JedisClientService jedisClientService;

    @Autowired
    private AnjukeCommunityService anjukeCommunityService;

    //redis中存放分页链接的key
    public static final String KEY_URL = "queueUrl";

    @Override
    public void parsePage(AnjukeParamsVo anjukeParamsVo) {
        UrlType urlType = anjukeParamsVo.getUrkType();
        String url = anjukeParamsVo.getUrl();
        UrlType httpType = anjukeParamsVo.getHttpType();
        //解析主页链接
        if(urlType==(UrlType.ANJUKE_COMMUNITY_INDEX)){
            anjukeCommunityIndex(anjukeParamsVo);
        }
        //解析区域链接
        if(urlType==(UrlType.ANJUKE_COMMUNITY_REGION)){
            anjukeCommunityRegion(anjukeParamsVo);
        }
        //解析板块链接
        if(urlType==(UrlType.ANJUKE_COMMUNITY_PLATE)){
            anjukeCommunityPlate(anjukeParamsVo);
        }
        //解析分页链接
        if(urlType==(UrlType.ANJUKE_COMMUNITY_PAGE)){
            anjukeCommunityPage(anjukeParamsVo);
        }
        //解析详情链接
        if(urlType==(UrlType.ANJUKE_COMMUNITY_DATAIL)){
            anjukeCommunityDetail(anjukeParamsVo);
        }
        //房型图链接
        if(urlType==(UrlType.ANJUKE_COMMUNITY_MODEL)){
            anjukeCommunityModel(anjukeParamsVo);
        }
        //实景图
        if(urlType==(UrlType.ANJUKE_COMMUNITY_VIEW)){
            anjukeCommunityView(anjukeParamsVo);
        }

    }

    /**
     *解析房型图的实景图
     */
    public static String parseViewDiagram(Document document){
        List<String> list = new ArrayList<String>();
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
     *
     * 功能描述: 解析实景图页面
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/23 13:53
     */
    private void anjukeCommunityView(AnjukeParamsVo anjukeParamsVo) {
        String content = anjukeParamsVo.getContent();
        AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs = anjukeParamsVo.getAnjukeCommunityWithBLOBs();
        if(StringUtils.isNotBlank(content)){
            Document document = Jsoup.parse(content);
            String viewStr = parseViewDiagram(document);
            anjukeCommunityWithBLOBs.setRealityImages(viewStr);
        }
        anjukeCommunityService.insertAnjukeCommunity(anjukeCommunityWithBLOBs);
        System.out.println(anjukeCommunityWithBLOBs);
        System.out.println(anjukeCommunityWithBLOBs.getHomeName()+anjukeCommunityWithBLOBs.getId());
        System.out.println("插入数据");
    }

    /**
     * 解析房型图的页面
     * @param document
     */
    public String parseModel(Document document) {
        List<Map<String, Object>> floorPlanList = new ArrayList<Map<String, Object>>();

        if (document == null) {
            return null;
        } else {
            Elements selects = document.select("div.chamber-contents>div.chamber-comm-mod");
            if (selects != null && !selects.isEmpty()) {
                //房型分组标签
                Elements selectsHd = selects.select("h3.hd");
                //房型的列表信息
                Elements selectsItem = selects.select("ul.list");

                if (selectsHd != null && !selectsHd.isEmpty() && selectsItem != null && !selectsItem.isEmpty()) {
                    for (int i = 0; i < selectsHd.size(); i++) {
                        try {
                            Map<String, Object> mapRoom = new HashMap<String, Object>();
                            Element elementHd = selectsHd.get(i);
                            //房型分组
                            String textType = elementHd.text();
                            mapRoom.put("roomType", textType);
                            Element elementUl = selectsItem.get(i);
                            if (elementUl != null) {
                                Elements selectsLi = elementUl.select("li.item");
                                List<Map<String, Object>> listUrl = new ArrayList<Map<String, Object>>();
                                for (Element elementLi : selectsLi) {
                                    Map<String, Object> mapUrl = new HashMap<String, Object>();
                                    Elements selectImg = elementLi.select("div.img-box>img");
                                    if (selectImg != null) {
                                        //房型图的url
                                        String src = selectImg.attr("src");
                                        mapUrl.put("src", src);
                                    }
                                    //房型
                                    Elements selectRoom = elementLi.select("p>span.room");
                                    if (selectRoom != null && selectRoom.size() != 0) {
                                        String room = selectRoom.text();
                                        mapUrl.put("room", room);
                                    }
                                    //面积
                                    Elements selectArea = elementLi.select("p>span.area");
                                    if (selectArea != null && selectArea.size() != 0) {
                                        String area = selectArea.text();
                                        mapUrl.put("area", area);
                                    }
                                    //朝向
                                    Elements selectTowards = elementLi.select("p>span.towards");
                                    if (selectTowards != null && selectTowards.size() != 0) {
                                        String towards = selectTowards.text();
                                        mapUrl.put("towards", towards);
                                    }
                                    listUrl.add(mapUrl);
                                }
                                mapRoom.put("floorPlan", listUrl);
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
     *
     * 功能描述: 
     *
     * @param: 解析房型图链接
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/23 13:32
     */
    private void anjukeCommunityModel(AnjukeParamsVo anjukeParamsVo) {
        String content = anjukeParamsVo.getContent();
        String url = anjukeParamsVo.getUrl();
        AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs = anjukeParamsVo.getAnjukeCommunityWithBLOBs();
        if(StringUtils.isNotBlank(content) && StringUtils.isNotBlank(url)){
            Document document = Jsoup.parse(content);
            String strModel = parseModel(document);
            anjukeCommunityWithBLOBs.setLayoutImages(strModel);
        }
        AnjukeParamsVo anjukeParamsVoView = new AnjukeParamsVo();
        String viewHref = url.replace("photos/model", "photos2/b");
        anjukeParamsVoView.setUrl(viewHref);
        anjukeParamsVoView.setHttpType(UrlType.GET);
        anjukeParamsVoView.setUrkType(UrlType.ANJUKE_COMMUNITY_VIEW);
        anjukeParamsVoView.setAnjukeCommunityWithBLOBs(anjukeCommunityWithBLOBs);
        jedisClientService.addObjectToList(KEY_URL,anjukeParamsVoView);
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

    /**
     * 解析详情链接
     * @param anjukeParamsVo
     */
    private void anjukeCommunityDetail(AnjukeParamsVo anjukeParamsVo) {
        //详情页链接
        String url = anjukeParamsVo.getUrl();
        String content = anjukeParamsVo.getContent();
        AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs = anjukeParamsVo.getAnjukeCommunityWithBLOBs();
        if(StringUtils.isNotBlank(content)){
            Document document = Jsoup.parse(content);
            //解析详情信息
            parseDetail(document,anjukeCommunityWithBLOBs);
        }
        AnjukeParamsVo anjukeParamsVoModel = new AnjukeParamsVo();
        //房型图链接
        String modelHref = url.replace("view", "photos/model");
        anjukeParamsVoModel.setUrl(modelHref);
        anjukeParamsVoModel.setHttpType(UrlType.GET);
        anjukeParamsVoModel.setUrkType(UrlType.ANJUKE_COMMUNITY_MODEL);
        anjukeParamsVoModel.setAnjukeCommunityWithBLOBs(anjukeCommunityWithBLOBs);

        jedisClientService.addObjectToList(KEY_URL,anjukeParamsVoModel);
    }

    /**
     * 解析分页链接，获取详情信息
     * @param anjukeParamsVo
     */
    private void anjukeCommunityPage(AnjukeParamsVo anjukeParamsVo) {
        String content = anjukeParamsVo.getContent();
        String url = anjukeParamsVo.getUrl();

        Map<String, String> detail = anjukeParamsVo.getDetail();
        String city = detail.get("city");
        String region = detail.get("region");
        String plate = detail.get("plate");

        if(StringUtils.isNotBlank(content)){
            //解析分页链接，获取列表详情链接
            Document document = Jsoup.parse(content);
            //获取上海城,区域下的细分种子链接
            Elements elements = document.select("div#list-content>div.li-itemmod");
            if(!elements.isEmpty()){
                for (Element element : elements) {
                    AnjukeParamsVo anjukeParamsVodetail = new AnjukeParamsVo();

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

                    anjukeParamsVodetail.setUrl(href);
                    anjukeParamsVodetail.setHttpType(UrlType.GET);
                    anjukeParamsVodetail.setUrkType(UrlType.ANJUKE_COMMUNITY_DATAIL);
                    anjukeParamsVodetail.setAnjukeCommunityWithBLOBs(anjukeCommunityNew);
                    //放回队列中
                    jedisClientService.addObjectToList(KEY_URL,anjukeParamsVodetail);
                }
            }

        }
    }

    /**
     * 解析板块链接，获取列表详情信息
     * @param anjukeParamsVo
     */
    private void anjukeCommunityPlate(AnjukeParamsVo anjukeParamsVo) {
        String content = anjukeParamsVo.getContent();
        String hrefPlate = anjukeParamsVo.getUrl();
        Map<String, String> detail = anjukeParamsVo.getDetail();
        if(StringUtils.isNotBlank(content) && StringUtils.isNotBlank(hrefPlate)){
            Document document = Jsoup.parse(content);
            //获取当前区域下的小区数目
            Integer regionNum =0;
            Elements elements = document.select("div#list-content>div.sortby>span.tit>em");
            if(elements!=null && elements.size()>1){
                Element element = elements.get(1);
                String numStr = element.text();
                if(StringUtils.isNotBlank(numStr)){
                    regionNum = Integer.parseInt(numStr);
                }
            }

            Integer regionPageNum = regionNum%30 == 0 ? regionNum/30 : regionNum/30+1;
            //拼接分页的链接
            if (regionPageNum != null && regionPageNum != 0) {
                //拼接分页链接
                for (int i = 1; i <= regionPageNum; i++) {
                    //创建分页种子链接
                    AnjukeParamsVo anjukeParamsVoPage = new AnjukeParamsVo();

                    String regionPage = hrefPlate + "p" + i + "/";

                    anjukeParamsVoPage.setUrl(regionPage);
                    anjukeParamsVoPage.setHttpType(UrlType.GET);
                    anjukeParamsVoPage.setUrkType(UrlType.ANJUKE_COMMUNITY_PAGE);
                    anjukeParamsVoPage.setDetail(detail);
                    jedisClientService.addObjectToList(KEY_URL,anjukeParamsVoPage);
                }
            }

        }
    }


    /**
     * 解析区域链接，获取板块链接
     * @param anjukeParamsVo
     */
    private void anjukeCommunityRegion(AnjukeParamsVo anjukeParamsVo) {
        String content = anjukeParamsVo.getContent();
        Map<String, String> detail = anjukeParamsVo.getDetail();
        if(StringUtils.isNotBlank(content)){
            Document document = Jsoup.parse(content);
            //获取上海城,区域下的细分种子链接
            Elements elements = document.select("div.items>span.elems-l.pp-mod>div.sub-items>a").not("a.selected-item");
            if(!elements.isEmpty() && elements.size()>0){
                for (Element elementHref : elements) {
                    AnjukeParamsVo anjukeParamsVoPlate = new AnjukeParamsVo();

                    String hrefPlate = elementHref.attr("href");
                    System.out.println("请求解析区域链接，获取板块链接---"+hrefPlate);
                    String plate = elementHref.text();
                    detail.put("plate",plate);

                    anjukeParamsVoPlate.setUrl(hrefPlate);
                    anjukeParamsVoPlate.setHttpType(UrlType.GET);
                    anjukeParamsVoPlate.setUrkType(UrlType.ANJUKE_COMMUNITY_PLATE);
                    //携带信息
                    anjukeParamsVoPlate.setDetail(detail);
                    jedisClientService.addObjectToList(KEY_URL,anjukeParamsVoPlate);
                }
            }else{
                logger.info("解析区域种子链接,获取板块链接为空=========================");
                System.out.println(document);
            }
        }
    }

    /**
     * 解析主页链接，获取区域链接
     * @param anjukeParamsVo
     */
    private void anjukeCommunityIndex(AnjukeParamsVo anjukeParamsVo) {
        String content = anjukeParamsVo.getContent();
        Map<String, String> detail = anjukeParamsVo.getDetail();
        if(StringUtils.isNotBlank(content)){
            Document document = Jsoup.parse(content);
            Elements selects = document.select("div.items>span.elems-l.pp-mod");
            if(!selects.isEmpty() && selects.size()>0){
                //获取城市的区域部分span标签
                Element elementCcommunity = selects.get(0);
                //获取城市的区域种子链接
                Elements elementHrefs = elementCcommunity.select("a").not("a.selected-item");
                for (Element elementHref : elementHrefs) {
                    //创建区域链接的种子
                    AnjukeParamsVo anjukeParamsVoRegion = new AnjukeParamsVo();

                    String hrefRegion = elementHref.attr("href");
                    System.out.println("请求解析主链接，获取区域链接+++"+hrefRegion);
                    String region = elementHref.text();
                    detail.put("region",region);

                    anjukeParamsVoRegion.setUrkType(UrlType.ANJUKE_COMMUNITY_REGION);
                    anjukeParamsVoRegion.setUrl(hrefRegion);
                    anjukeParamsVoRegion.setHttpType(UrlType.GET);
                    //附带参数
                    anjukeParamsVoRegion.setDetail(detail);
                    jedisClientService.addObjectToList(KEY_URL,anjukeParamsVoRegion);
                }
            }
        }
    }
}
