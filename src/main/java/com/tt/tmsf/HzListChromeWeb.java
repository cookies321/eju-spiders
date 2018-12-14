package com.tt.tmsf;

import com.tt.dao.CommunityTmsfHzListMapper;
import com.tt.dao.CommunityTmsfHzRegionMapper;
import com.tt.entity.CommunityTmsfHzList;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/7 17:37
 * @Description:
 */
@Service
public class HzListChromeWeb extends BaseChromeWebDriver {


    @Autowired
    private CommunityTmsfHzListMapper communityTmsfHzListMapper;

    @Autowired
    private CommunityTmsfHzRegionMapper communityTmsfHzRegionMapper;


    @Override
    public void init(){
        super.url="http://www.tmsf.com/index.jsp";
        super.time=1000;
        super.rnt=6;
    }

    @Override
    public Map<String, String> doWebPrase(WebDriver webDriver,Map<String,String> obj) {
        try {
            Map<String, String> map=new HashMap<>();

            String url=obj.get("url");
            String region = obj.get("region");
            String plate = obj.get("plate");
            try {
                webDriver.get(url);
                Thread.sleep(1000);
            } catch (Exception e) {
                map.put("url",url);
                map.put("region",region);
                map.put("plate",plate);
                closeWebDriver(webDriver);
                return map;
            }
            if(webDriver!=null && (!webDriver.toString().contains("null"))){
                String pageSource = webDriver.getPageSource();
                if(pageSource.contains("未连接到互联网") || pageSource.contains("代理服务器出现问题，或者地址有误。")
                        ||pageSource.contains("哦~ 网络似乎开小差了")|| pageSource.contains("该网页无法正常运作")
                        ||pageSource.contains("浏览器的页面无法") || pageSource.contains("An error occurred")){
                    map.put("url",url);
                    map.put("region",region);
                    map.put("plate",plate);
                    closeWebDriver(webDriver);
                    return map;
                }

                Document document = Jsoup.parse(pageSource);
                //计算总条数
                Element select = document.select("div.searchpage_how>span>font.green1").first();
                Integer pageNum =0;
                if(select!=null){
                    String text = select.text();
                    Integer count=Integer.valueOf(text);
                    pageNum= count % 6 ==0 ? count/6 : (count/6)+1;
                }
                System.out.println("页码数"+pageNum);
                if(pageNum==0 && select!=null){
                    return null;
                }
                //获取当前页列表的详细信息
                List<CommunityTmsfHzList> listMessage = getListMessage(document);
                for (CommunityTmsfHzList communityTmsfHzList : listMessage) {
                    communityTmsfHzList.setRegion(region);
                    communityTmsfHzList.setPlate(plate);
                    communityTmsfHzList.setRegionUrl(url);
                    //插入数据
                    communityTmsfHzListMapper.insertSelective(communityTmsfHzList);
                }

                //获取当前页页码
                int starPage=1;
                int i1 = url.indexOf("&page=");
                if(i1 >= 0){
                    String substring = url.substring(url.indexOf("&page=") + 6, url.length());
                    if(StringUtils.isNotBlank(substring)){
                        starPage=Integer.parseInt(substring);
                    }
                }
                System.out.println("当前页码"+starPage);
                for (int i = starPage; i < pageNum; i++) {
                    By nextClick= By.cssSelector("div.pagenext>a.c");
                    if(nextClick!=null){
                        try {
                            List<WebElement> elements = webDriver.findElements(nextClick);
                            if(elements.size()!=0){
                                System.out.println("点击翻页");
                                elements.get(elements.size()-1).click();
                            }
                        } catch (Exception e) {
                            closeWebDriver(webDriver);

                            if(url.contains("&page=")){
                                map.put("url",url.replace(url.substring(url.indexOf("&page=") + 6, url.length()),i+""));
                            }else{
                                map.put("url",url+"&page="+i);
                            }
                            map.put("region",region);
                            map.put("plate",plate);
                            return map;
                        }
                        if(webDriver!=null && (!webDriver.toString().contains("null"))){
                            //获取当前页列表的详细信息
                            String pageSource1 = webDriver.getPageSource();
                            if(pageSource1.contains("未连接到互联网") || pageSource1.contains("代理服务器出现问题，或者地址有误。")
                                    ||pageSource1.contains("网络似乎开小差了") || pageSource1.contains("该网页无法正常运作")
                                    ||pageSource.contains("浏览器的页面无法") || pageSource1.contains("An error occurred")) {
                                if(url.contains("&page=")){
                                    map.put("url",url.replace(url.substring(url.indexOf("&page=") + 6, url.length()),i+""));
                                }else{
                                    map.put("url",url+"&page="+i);
                                }
                                map.put("region",region);
                                map.put("plate",plate);
                                closeWebDriver(webDriver);
                                return map;
                            }
                            Document parse = Jsoup.parse(pageSource1);

                            List<CommunityTmsfHzList> listMessage1 = getListMessage(parse);

                            for (CommunityTmsfHzList communityTmsfHzList1 : listMessage1) {
                                communityTmsfHzList1.setRegion(region);
                                communityTmsfHzList1.setPlate(plate);
                                communityTmsfHzList1.setRegionUrl(url);
                                //插入数据
                                communityTmsfHzListMapper.insertSelective(communityTmsfHzList1);
                            }
                        }
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    @Override
    public void callBackDriverServies() {
        init();
        WebDriver webDriver = openUrl(url,time,rnt);
        if(webDriver!=null && (!webDriver.toString().contains("null"))){
            try {
                /*CommunityTmsfHzRegionExample communityTmsfHzRegionExample = new CommunityTmsfHzRegionExample();
                communityTmsfHzRegionExample.or().andStatusEqualTo("0");
                List<CommunityTmsfHzRegion> communityTmsfHzRegions = communityTmsfHzRegionMapper.selectByExample(communityTmsfHzRegionExample);
                System.out.println(communityTmsfHzRegions.size());

                for (CommunityTmsfHzRegion communityTmsfHzRegion : communityTmsfHzRegions) {
                    Map<String, String> map = new HashMap<>();
                    map.put("url",communityTmsfHzRegion.getUrl());
                    map.put("region",communityTmsfHzRegion.getRegion());
                    map.put("plate",communityTmsfHzRegion.getPlate());
                    Map<String,String>  result = doWebPrase(webDriver,map);

                    //中断循环请求
                    while (result!=null){
                        init();
                        webDriver = openUrl(url,time,rnt);
                        result = doWebPrase(webDriver,result);
                    }
                    communityTmsfHzRegion.setStatus("1");
                    communityTmsfHzRegionMapper.updateByPrimaryKeySelective(communityTmsfHzRegion);
                }*/

                Map<String, String> map = new HashMap<>();
                map.put("url","http://www.tmsf.com/newhouse/property_searchall.htm?sid=&districtid=&areaid=&page=243");

                Map<String,String>  result = doWebPrase(webDriver,map);

                //中断循环请求
                while (result!=null){
                    init();
                    webDriver = openUrl(url,time,rnt);
                    result = doWebPrase(webDriver,result);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeWebDriver(webDriver);
            }

        }
    }

    /**
     *
     * 功能描述: 获取列表的信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/7 15:43
     */
    private List<CommunityTmsfHzList> getListMessage(Document document){
        List<CommunityTmsfHzList> list=new ArrayList<>();

        Elements elementUl = document.select("div.searchpageall.famwei>div>ul");
        Elements select3 = elementUl.select("li>div.build_des.dingwei");

        if(!elementUl.isEmpty() && !select3.isEmpty()){
            int size = select3.size();
            String fontTag="";
            for (int i = 0; i < size; i++) {

                Elements selects = elementUl.select(fontTag + "li>div");
                if(!selects.isEmpty()){
                    for (Element element : selects) {
                        CommunityTmsfHzList communityTmsfHzList = new CommunityTmsfHzList();
                        communityTmsfHzList.setId(UUID.randomUUID().toString());
                        communityTmsfHzList.setCreateTime(new Date());
                        communityTmsfHzList.setBatchId("v1.0");

                        //小区的缩略图
                        Element select = element.select( "div.build_pic>div.dingwei>a").first();
                        if(select!=null){
                            String href = select.attr("href");
                            String src = select.select("img").attr("src");
                            if(StringUtils.isNotBlank(href)){
                                communityTmsfHzList.setDetailUrl("http://www.tmsf.com"+href);
                            }
                            if(StringUtils.isNotBlank(src)){
                                communityTmsfHzList.setSurfacePlot("http://www.tmsf.com"+src);
                            }
                            System.out.println(href+"---"+src);
                        }
                        //小区名称和别名
                        Element select1 = element.select("div.build_txt.line26").first();
                        if(select1!=null){
                            Elements select2 = select1.select("div.build_word01");
                            if(!select2.isEmpty()){
                                String title = select2.select("a").text();
                                String alias = select2.select("div.fl").text();
                                if(StringUtils.isNotBlank(alias)){
                                    alias = alias.replace("推广名：", "");
                                }
                                communityTmsfHzList.setTitle(title);
                                communityTmsfHzList.setAlias(alias);
                                System.out.println(title+"---"+alias);
                            }
                        }
                        //价格信息
                        Element select2 = element.select( "font.colordg>div.word1").first();
                        String price="";
                        if(select2!=null){
                            Elements select4 = select2.select("span");
                            if(!select4.isEmpty()){
                                for (Element element1 : select4) {
                                    String aClass = element1.attr("class");
                                    String s = transformPrice(aClass);
                                    price=price+s;
                                }
                            }
                        }
                        if(StringUtils.isNotBlank(price)){
                            communityTmsfHzList.setRecordPrice(price);
                        }
                        fontTag+="font.colordg>";

                        if(StringUtils.isNotBlank(communityTmsfHzList.getDetailUrl())){
                            list.add(communityTmsfHzList);
                        }
                    }
                }

            }
        }
        return list;
    }

    /**
     *
     * 功能描述: 转换价格的数值
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/7 15:00
     */
    public String transformPrice(String numClass){
        String price=null;
        if(StringUtils.isNotBlank(numClass)){
            switch (numClass){
                case "numbbzero":
                    price="0";
                    break;
                case "numbbone":
                    price="1";
                    break;
                case "numbbtwo":
                    price="2";
                    break;
                case "numbbthree":
                    price="3";
                    break;
                case "numbbfour":
                    price="4";
                    break;
                case "numbbfive":
                    price="5";
                    break;
                case "numbbsix":
                    price="6";
                    break;
                case "numbbseven":
                    price="7";
                    break;
                case "numbbeight":
                    price="8";
                    break;
                case "numbbnine":
                    price="9";
                    break;
                default:
                    break;
            }
        }

        return price;
    }


}
