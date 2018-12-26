package com.tt.tmsf;

import com.tt.dao.CommunityTmsfHzForhouseMapper;
import com.tt.dao.CommunityTmsfHzListLoudongMapper;
import com.tt.entity.CommunityTmsfHzForhouse;
import com.tt.entity.CommunityTmsfHzForhouseExample;
import com.tt.entity.CommunityTmsfHzListLoudong;
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
 * @Date: 2018/12/11 15:25
 * @Description:
 */
@Service
public class HzLoudongChromeWeb extends BaseChromeWebDriver{

    @Autowired
    private CommunityTmsfHzListLoudongMapper communityTmsfHzListLoudongMapper;

    @Autowired
    private CommunityTmsfHzForhouseMapper communityTmsfHzForhouseMapper;

    @Override
    public void init() {
        super.url="http://www.tmsf.com/index.jsp";
        super.time=1000;
        super.rnt=6;
    }

    @Override
    public Map<String, String> doWebPrase(WebDriver webDriver, Map<String, String> map) {
        Map<String, String> result = new HashMap<>();
        String priceUrl = map.get("priceUrl");
        try {
            //传入详情页链接
            if(StringUtils.isNotBlank(priceUrl)) {
                try {
                    try {
                        webDriver.get(priceUrl);
                    } catch (Exception e) {
                        closeWebDriver(webDriver);
                        result.put("priceUrl", priceUrl);
                        return result;
                    }
                    //点击详情url
                    String pageSource = webDriver.getPageSource();
                    //获取详情的信息
                    if (StringUtils.isBlank(pageSource) || pageSource.contains("未连接到互联网") || pageSource.contains("代理服务器出现问题，或者地址有误。")
                            || pageSource.contains("哦~ 网络似乎开小差了") || pageSource.contains("该网页无法正常运作")
                            || pageSource.contains("An error occurred") || pageSource.contains("<body></body>")
                            || pageSource.contains("images/404bg.jpg")) {
                        result.put("priceUrl", priceUrl);
                        closeWebDriver(webDriver);
                        return result;
                    } else {
                        Document document = Jsoup.parse(pageSource);
                        if (pageSource.contains("开发商向物价部门申报的销售备案价格")) {
                            //计算总条数
                            Elements selects = document.select("div.spagenext>span");
                            if (selects.isEmpty()) {
                                System.out.println("条件外的---"+priceUrl);
                                return null;
                            } else {
                                Integer pageNum = 0;
                                if (selects != null) {
                                    try {
                                        //页数 1/73	总数：1010套（含限制房产）
                                        String text = selects.text();
                                        String substring = text.substring(text.indexOf("/") + 1, text.indexOf("总数：")).
                                                replace("\t","").replace(" ","");

                                        pageNum = Integer.valueOf(substring);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println("页码数" + pageNum);
                                if(pageNum==0){
                                    System.out.println("条件外的---"+priceUrl);
                                    return null;
                                }
                                //获取当前页面的房号列表信息
                                String detailUrl = priceUrl.replace("price", "info");
                                List<CommunityTmsfHzListLoudong> houseList = getHouseList(document);
                                for (CommunityTmsfHzListLoudong communityTmsfHzListLoudong : houseList) {
                                    communityTmsfHzListLoudong.setDetailUrl(detailUrl);
                                    //插入
                                    communityTmsfHzListLoudongMapper.insertSelective(communityTmsfHzListLoudong);
                                }

                                //获取当前页页码
                                int starPage=1;
                                int i1 = priceUrl.indexOf("&page=");
                                if(i1 >= 0){
                                    String substring = priceUrl.substring(priceUrl.indexOf("&page=") + 6, priceUrl.length());
                                    if(StringUtils.isNotBlank(substring)){
                                        starPage=Integer.parseInt(substring);
                                    }
                                }
                                for (int i = starPage; i < pageNum; i++) {
                                    By nextClick= By.cssSelector("div.spagenext>a.c");
                                    if(nextClick!=null){
                                        try {
                                            List<WebElement> elements = webDriver.findElements(nextClick);
                                            if(elements.size()!=0){
                                                System.out.println("点击翻页"+i);
                                                elements.get(elements.size()-1).click();
                                            }else{
                                                System.out.println("获取下一页的按钮失败");
                                                closeWebDriver(webDriver);
                                                if(priceUrl.contains("&page=")){
                                                    result.put("priceUrl",priceUrl.replace(priceUrl.substring(priceUrl.indexOf("&page=") + 6, priceUrl.length()),i+""));
                                                }else{
                                                    result.put("priceUrl",priceUrl+"?isopen=&presellid=&buildingid=&area=&allprice=&housestate=&housetype=&page="+i);
                                                }
                                                return result;
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            closeWebDriver(webDriver);
                                            if(priceUrl.contains("&page=")){
                                                result.put("priceUrl",priceUrl.replace(priceUrl.substring(priceUrl.indexOf("&page=") + 6, priceUrl.length()),i+""));
                                            }else{
                                                result.put("priceUrl",priceUrl+"?isopen=&presellid=&buildingid=&area=&allprice=&housestate=&housetype=&page="+i);
                                            }
                                            return result;
                                        }
                                        if(webDriver!=null && (!webDriver.toString().contains("null"))) {
                                            //获取当前页列表的详细信息
                                            String pageSource1 = webDriver.getPageSource();
                                            if (pageSource1.contains("未连接到互联网") || pageSource1.contains("代理服务器出现问题，或者地址有误。")
                                                    || pageSource1.contains("网络似乎开小差了") || pageSource1.contains("该网页无法正常运作")
                                                    || pageSource1.contains("浏览器的页面无法") || pageSource1.contains("An error occurred")
                                                    || pageSource1.contains("<body></body>") ||pageSource1.contains("images/404bg.jpg")
                                                    ) {
                                                if (priceUrl.contains("&page=")) {
                                                    result.put("priceUrl", priceUrl.replace(priceUrl.substring(priceUrl.indexOf("&page=") + 6, priceUrl.length()), i + ""));
                                                } else {
                                                    result.put("priceUrl", priceUrl + "?isopen=&presellid=&buildingid=&area=&allprice=&housestate=&housetype=&page=" + i);
                                                }
                                                closeWebDriver(webDriver);
                                                return result;
                                            }
                                            Document parse = Jsoup.parse(pageSource1);

                                            List<CommunityTmsfHzListLoudong> houseList1 = getHouseList(parse);
                                            for (CommunityTmsfHzListLoudong communityTmsfHzListLoudong1 : houseList1) {
                                                communityTmsfHzListLoudong1.setDetailUrl(detailUrl);
                                                //插入
                                                communityTmsfHzListLoudongMapper.insertSelective(communityTmsfHzListLoudong1);
                                            }
                                        }
                                    }
                                }
                                System.out.println("插入完成");
                                return null;

                            }
                            //另外一种模板
                        } else {
                            //计算总条数
                            Elements selects = document.select("div.pagesinfo>div.pagesinfo_l");
                            if (selects.isEmpty()) {
                                System.out.println("另外一种模板-------");
                                System.out.println(priceUrl);
                                System.out.println(document);
                                /*result.put("priceUrl", priceUrl);
                                return result;*/
                                return null;
                            } else {
                                Integer pageNum = 0;
                                if (selects != null) {
                                    try {
                                        //页数 1/73	总数：1010套（含限制房产）
                                        String text = selects.text();
                                        String substring = text.substring(text.indexOf("/") + 1, text.indexOf("总数：")).
                                                replace("\t", "").replace(" ", "");

                                        pageNum = Integer.valueOf(substring);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println("页码数" + pageNum);
                                //获取当前页面的房号列表信息
                                String detailUrl = priceUrl.replace("price", "info");
                                List<CommunityTmsfHzListLoudong> houseList = getHouseListOther(document);
                                for (CommunityTmsfHzListLoudong communityTmsfHzListLoudong : houseList) {
                                    communityTmsfHzListLoudong.setDetailUrl(detailUrl);
                                    //插入
                                    communityTmsfHzListLoudongMapper.insertSelective(communityTmsfHzListLoudong);
                                }

                                //获取当前页页码
                                int starPage = 1;
                                int i1 = priceUrl.indexOf("&page=");
                                if (i1 >= 0) {
                                    String substring = priceUrl.substring(priceUrl.indexOf("&page=") + 6, priceUrl.length());
                                    if (StringUtils.isNotBlank(substring)) {
                                        starPage = Integer.parseInt(substring);
                                    }
                                }
                                for (int i = starPage; i < pageNum; i++) {
                                    By nextClick = By.cssSelector("div.pagesinfo_r>a.c");
                                    if (nextClick != null) {
                                        try {
                                            List<WebElement> elements = webDriver.findElements(nextClick);
                                            if (elements.size() != 0) {
                                                System.out.println("点击翻页"+i);
                                                elements.get(elements.size() - 1).click();
                                            }
                                        } catch (Exception e) {
                                            closeWebDriver(webDriver);
                                            System.out.println("条件外的---"+priceUrl);
                                            return null;
                                        }

                                        if (webDriver != null) {
                                            //获取当前页列表的详细信息
                                            String pageSource1 = webDriver.getPageSource();
                                            if (pageSource1.contains("未连接到互联网") || pageSource1.contains("代理服务器出现问题，或者地址有误")
                                                    || pageSource1.contains("网络似乎开小差了") || pageSource1.contains("该网页无法正常运作")
                                                    || pageSource.contains("浏览器的页面无法") || pageSource1.contains("An error occurred")
                                                    || pageSource.contains("<body></body>") ||pageSource.contains("images/404bg.jpg")
                                                    ) {
                                                closeWebDriver(webDriver);
                                                System.out.println("条件外的---"+priceUrl);
                                                return null;
                                            }
                                            Document parse = Jsoup.parse(pageSource1);

                                            List<CommunityTmsfHzListLoudong> houseList1 = getHouseListOther(parse);
                                            for (CommunityTmsfHzListLoudong communityTmsfHzListLoudong1 : houseList1) {
                                                communityTmsfHzListLoudong1.setDetailUrl(detailUrl);
                                                //插入
                                                communityTmsfHzListLoudongMapper.insertSelective(communityTmsfHzListLoudong1);
                                            }
                                        }
                                    }
                                }
                                System.out.println("插入完成");
                                return null;
                            }
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("priceUrl", priceUrl);
                    closeWebDriver(webDriver);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("priceUrl", priceUrl);
            closeWebDriver(webDriver);
            return result;
        }
        return null;
    }

    private List<CommunityTmsfHzListLoudong> getHouseListOther(Document document) {
        List<CommunityTmsfHzListLoudong> list=new ArrayList<>();
        Elements select = document.select("table.tb_four>tbody>tr").not("tr.tr_04");
        for (Element element : select) {
            CommunityTmsfHzListLoudong communityTmsfHzListLoudong = new CommunityTmsfHzListLoudong();
            communityTmsfHzListLoudong.setId(UUID.randomUUID().toString());
            communityTmsfHzListLoudong.setBatchId("v1.0");
            communityTmsfHzListLoudong.setCreateTime(new Date());

            Elements select1 = element.select("td.adTr");
            if(select1.size()==11){
                String loudong = select1.get(0).text();

                Element element2 = select1.get(2);
                String houseName = element2.text();
                String houseUrl = element2.select("a").attr("href");

                communityTmsfHzListLoudong.setLoudong(loudong);
                communityTmsfHzListLoudong.setHouseName(houseName);
                if(StringUtils.isNotBlank(houseUrl)){
                    communityTmsfHzListLoudong.setHouseUrl("http://www.tmsf.com"+houseUrl);
                }
                list.add(communityTmsfHzListLoudong);
            }
        }
        return list;
    }

    /**
     *
     * 功能描述: 解析列表页信息
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/11 17:01
     */
    private List<CommunityTmsfHzListLoudong> getHouseList(Document document) {
        List<CommunityTmsfHzListLoudong> list=new ArrayList<>();
        Elements select = document.select("div.onbuildshow_contant>table");
        if(select.size()==2){
            Elements elements = select.get(1).select("tbody>tr");
            if(!elements.isEmpty()){
                for (Element element : elements) {
                    CommunityTmsfHzListLoudong communityTmsfHzListLoudong = new CommunityTmsfHzListLoudong();
                    communityTmsfHzListLoudong.setId(UUID.randomUUID().toString());
                    communityTmsfHzListLoudong.setBatchId("v1.0");
                    communityTmsfHzListLoudong.setCreateTime(new Date());

                    Elements select1 = element.select("td.adTr");
                    if(select1.size()==8){
                        String loudong = select1.get(0).text();

                        Element element2 = select1.get(1);
                        String houseName = element2.text();
                        String houseUrl = element2.select("a").attr("href");

                        communityTmsfHzListLoudong.setLoudong(loudong);
                        communityTmsfHzListLoudong.setHouseName(houseName);
                        if(StringUtils.isNotBlank(houseUrl)){
                            communityTmsfHzListLoudong.setHouseUrl("http://www.tmsf.com"+houseUrl);
                        }
                        list.add(communityTmsfHzListLoudong);
                    }
                }
            }

        }
        return list;
    }

    @Override
    public void callBackDriverServies() {
        init();
        WebDriver webDriver = openUrl(url, time, rnt);
        if(webDriver!=null && (!webDriver.toString().contains("null"))){
            try {
                CommunityTmsfHzForhouseExample communityTmsfHzListExample = new CommunityTmsfHzForhouseExample();
                communityTmsfHzListExample.or().andSourceEqualTo("1").andStatusIsNull();
                List<CommunityTmsfHzForhouse> communityTmsfHzForhouses = communityTmsfHzForhouseMapper.selectByExample(communityTmsfHzListExample);
                System.out.println(communityTmsfHzForhouses.size());

                for (CommunityTmsfHzForhouse communityTmsfHzForhouse : communityTmsfHzForhouses) {
                    String detailUrl1 = communityTmsfHzForhouse.getDetailUrl();
                    String replace = detailUrl1.replace("info", "price");
                    Map<String, String> map=new HashMap<>();
                    map.put("priceUrl",replace);
                    Map<String, String> result = doWebPrase(webDriver, map);
                    int count=0;
                    while (result!=null && count<3){
                        String priceUrl = result.get("priceUrl");
                        if(StringUtils.isNotBlank(priceUrl)){
                            Map<String, String> map2 = new HashMap<>();
                            map2.put("priceUrl",priceUrl);
                            init();
                            webDriver = openUrl(url, 1000, 10);
                            result=doWebPrase(webDriver, map2);
                        }
                        count++;
                        System.out.println("重试次数"+count);
                        System.out.println();
                    }
                    communityTmsfHzForhouse.setStatus("1");
                    communityTmsfHzForhouseMapper.updateByPrimaryKeySelective(communityTmsfHzForhouse);
                }

               /* Map<String, String> map=new HashMap<>();
                //http://www.tmsf.com/newhouse/property_33_687_price.htm
                //http://www.tmsf.com/newhouse/property_330188_21079206_price.htm
                map.put("priceUrl","http://www.tmsf.com/newhouse/property_330188_21079206_price.htm");

                Map<String, String> result = doWebPrase(webDriver, map);
                int count=0;
                while (result!=null && count<5){
                    count++;
                    String priceUrl = result.get("priceUrl");

                    Map<String, String> map2 = new HashMap<>();
                    if(StringUtils.isNotBlank(priceUrl)){
                        map2.put("priceUrl",priceUrl);
                    }
                    init();
                    webDriver = openUrl(url, 1000, 10);
                    result=doWebPrase(webDriver, map2);
                }*/

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(webDriver!=null && (!webDriver.toString().contains("null"))){
                        webDriver.quit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
