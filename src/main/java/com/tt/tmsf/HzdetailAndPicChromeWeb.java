package com.tt.tmsf;

import com.tt.dao.CommunityTmsfHzDetailMapper;
import com.tt.dao.CommunityTmsfHzListMapper;
import com.tt.dao.CommunityTmsfHzPicMapper;
import com.tt.entity.CommunityTmsfHzDetail;
import com.tt.entity.CommunityTmsfHzList;
import com.tt.entity.CommunityTmsfHzListExample;
import com.tt.entity.CommunityTmsfHzPic;
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
 * @Date: 2018/12/10 13:50
 * @Description:
 */
@Service
public class HzdetailAndPicChromeWeb extends BaseChromeWebDriver{

    @Autowired
    private CommunityTmsfHzListMapper communityTmsfHzListMapper;

    @Autowired
    private CommunityTmsfHzDetailMapper communityTmsfHzDetailMapper;

    @Autowired
    private CommunityTmsfHzPicMapper communityTmsfHzPicMapper;

    @Override
    public void init() {
        super.url="http://www.tmsf.com/index.jsp";
        super.time=1000;
        super.rnt=10;
    }

    @Override
    public Map<String, String> doWebPrase(WebDriver webDriver, Map<String, String> map) {
        try {
            Map<String, String> result = new HashMap<>();
            String detailUrl = map.get("detailUrl");
            String pictureUrl = map.get("pictureUrl");
            //传入详情页链接
            if(StringUtils.isNotBlank(detailUrl)){
                try {
                    try {
                        try {
                            webDriver.get(detailUrl);
                        } catch (Exception e) {
                            closeWebDriver(webDriver);
                            result.put("detailUrl",detailUrl);
                            return result;
                        }
                        //点击详情url
                        String pageSource0 = webDriver.getPageSource();

                        //获取详情的信息
                        String pageSource =null;
                        if(StringUtils.isBlank(pageSource0) || pageSource0.contains("未连接到互联网") || pageSource0.contains("代理服务器出现问题，或者地址有误。")
                                ||pageSource0.contains("哦~ 网络似乎开小差了")|| pageSource0.contains("该网页无法正常运作")
                                || pageSource0.contains("An error occurred")){
                            closeWebDriver(webDriver);
                            result.put("detailUrl",detailUrl);
                            return result;
                        }else{
                            Document parse = Jsoup.parse(pageSource0);
                            Elements select = parse.select("div.buildtxtbox.classones>p>a");
                            if(!select.isEmpty()){
                                try {
                                    /*String href = select.attr("href");
                                    webDriver.get("http://www.tmsf.com"+href);*/
                                    WebElement element = webDriver.findElement(By.cssSelector("div.buildtxtbox.classones.fl.famwei>p>a"));
                                    if(element!=null){
                                        element.click();
                                    }
                                    String windowHandle = webDriver.getWindowHandle();
                                    Set<String> windowHandles = webDriver.getWindowHandles();
                                    for (String handle : windowHandles) {
                                        if(windowHandle.equals(handle)){
                                            webDriver.close();
                                            continue;
                                        }else {
                                            webDriver.switchTo().window(handle);
                                            break;
                                        }
                                    }
                                    //获取basicinfo页面信息
                                    pageSource= webDriver.getPageSource();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    result.put("detailUrl",detailUrl);
                                    closeWebDriver(webDriver);
                                    return result;
                                }
                            }else{
                                //另一种模板
                                //http://www.tmsf.com/newhouse/property_330188_21079206_info.htm

                                CommunityTmsfHzDetail communityTmsfHzDetail = new CommunityTmsfHzDetail();
                                communityTmsfHzDetail.setId(UUID.randomUUID().toString());
                                communityTmsfHzDetail.setDetailUrl(detailUrl);
                                communityTmsfHzDetail.setCreateTime(new Date());
                                communityTmsfHzDetail.setBatchId("v1.0");
                                CommunityTmsfHzDetail communityTmsfHzDetail1 = parseDetailTwo(communityTmsfHzDetail, pageSource0);
                                //插入小区详情信息
                                if(communityTmsfHzDetail1!=null){
                                    communityTmsfHzDetailMapper.insertSelective(communityTmsfHzDetail1);
                                }
                                return null;
                            }
                        }
                        if(StringUtils.isNotBlank(pageSource)){
                            if(StringUtils.isBlank(pageSource) || pageSource.contains("未连接到互联网") || pageSource.contains("代理服务器出现问题，或者地址有误。")
                                    ||pageSource.contains("哦~ 网络似乎开小差了")|| pageSource.contains("该网页无法正常运作")
                                    || pageSource.contains("An error occurred")){
                                result.put("detailUrl",detailUrl);
                                closeWebDriver(webDriver);
                                return result;
                            }else{
                                CommunityTmsfHzDetail communityTmsfHzDetail = new CommunityTmsfHzDetail();
                                communityTmsfHzDetail.setId(UUID.randomUUID().toString());
                                communityTmsfHzDetail.setDetailUrl(detailUrl);
                                communityTmsfHzDetail.setCreateTime(new Date());
                                communityTmsfHzDetail.setBatchId("v1.0");
                                CommunityTmsfHzDetail communityTmsfHzDetail1 = parseDetail(communityTmsfHzDetail, pageSource);
                                //插入小区详情信息
                                if(communityTmsfHzDetail1!=null){
                                    communityTmsfHzDetailMapper.insertSelective(communityTmsfHzDetail1);
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        result.put("detailUrl",detailUrl);
                        closeWebDriver(webDriver);
                        return result;
                    }

                } catch (Exception e) {
                    result.put("detailUrl",detailUrl);
                    closeWebDriver(webDriver);
                    return result;
                }

                //传入中断的楼盘相册链接
            }else if(StringUtils.isNotBlank(pictureUrl)){
                try {
                    webDriver.get(pictureUrl);

                    String pageSource = webDriver.getPageSource();
                    if(StringUtils.isBlank(pageSource) || pageSource.contains("未连接到互联网") || pageSource.contains("代理服务器出现问题，或者地址有误。")
                            ||pageSource.contains("哦~ 网络似乎开小差了")|| pageSource.contains("该网页无法正常运作")
                            ||pageSource.contains("浏览器的页面无法") || pageSource.contains("An error occurred")){
                        result.put("pictureUrl",pictureUrl);
                        closeWebDriver(webDriver);
                        return result;
                    }else{
                        //解析楼盘的图片信息
                        String detailUrlRe=pictureUrl.replace("pics","info");
                        List<CommunityTmsfHzPic> communityTmsfHzPics = parsePicture(pageSource);
                        for (CommunityTmsfHzPic communityTmsfHzPic : communityTmsfHzPics) {
                            communityTmsfHzPic.setDetailUrl(detailUrlRe);
                            communityTmsfHzPicMapper.insertSelective(communityTmsfHzPic);
                        }
                    }

                } catch (Exception e) {
                    result.put("picutreUrl",pictureUrl);
                    closeWebDriver(webDriver);
                    return result;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void callBackDriverServies() {
        init();
        WebDriver webDriver = openUrl(url, time, rnt);
        if(webDriver!=null && (!webDriver.toString().contains("null"))){
            try {
                CommunityTmsfHzListExample communityTmsfHzListExample = new CommunityTmsfHzListExample();
                communityTmsfHzListExample.or().andSourceEqualTo("1").andStatusIsNull();
                List<CommunityTmsfHzList> communityTmsfHzLists = communityTmsfHzListMapper.selectByExample(communityTmsfHzListExample);
                System.out.println(communityTmsfHzLists.size());
                for (CommunityTmsfHzList communityTmsfHzList : communityTmsfHzLists) {
                    String detailUrl1 = communityTmsfHzList.getDetailUrl();
                    Map<String, String> map=new HashMap<>();
                    map.put("detailUrl",detailUrl1);
                    Map<String, String> result = doWebPrase(webDriver, map);
                    int count=0;
                    while (result!=null && count<5){
                        count++;
                        String detailUrl = result.get("detailUrl");
                        String pictureUrl = result.get("pictureUrl");

                        Map<String, String> map2 = new HashMap<>();
                        if(StringUtils.isNotBlank(detailUrl)){
                            map2.put("detailUrl",detailUrl);
                        }
                        if(StringUtils.isNotBlank(pictureUrl)){
                            map2.put("pictureUrl",pictureUrl);
                        }
                        init();
                        webDriver = openUrl(url, 1000, 10);
                        result=doWebPrase(webDriver, map2);
                    }
                    communityTmsfHzList.setStatus("1");
                    communityTmsfHzListMapper.updateByPrimaryKeySelective(communityTmsfHzList);
                }
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
    
    /**
     *
     * 功能描述: 解析小区基本信息 模板二
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/11 10:12
     */
    private CommunityTmsfHzDetail parseDetailTwo(CommunityTmsfHzDetail communityTmsfHzDetail, String pageSource0) {
        Document document = Jsoup.parse(pageSource0);
        Elements select = document.select("div.xf_box_02>p");
        if(!select.isEmpty()){
            for (Element element : select) {
                Elements select1 = element.select("span");
                if(!select1.isEmpty()){
                    for (int i=0; i< select1.size();i++) {
                        String tag = null;
                        String value=null;
                        try {
                            tag = select1.get(i).text();
                            String[] split = element.ownText().split(" ");
                            value=split[i];
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        switch (tag){
                            case "物业地址：":
                                communityTmsfHzDetail.setAddress(value);
                                System.out.println("物业地址："+value);
                                break;
                            case "物业类型：":
                                communityTmsfHzDetail.setPropertyType(value);
                                System.out.println("物业类型："+value);
                                break;
                            case "主力户型：":
                                communityTmsfHzDetail.setMainLayout(value);
                                System.out.println("主力户型："+value);
                                break;
                            case "建筑形式：":
                                communityTmsfHzDetail.setBuildType(value);
                                System.out.println("建筑形式："+value);
                                break;
                            case "装修状况：":
                                communityTmsfHzDetail.setDecoration(value);
                                System.out.println("装修状况："+value);
                                break;
                            case "项目公司：":
                                communityTmsfHzDetail.setBuildDevelopers(value);
                                System.out.println("项目公司："+value);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            return communityTmsfHzDetail;
        }else {
            return null;
        }
    }

    /**
     *
     * 功能描述: 解析小区基本信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/10 16:27
     */
    public CommunityTmsfHzDetail  parseDetail(CommunityTmsfHzDetail communityTmsfHzDetail, String pageSource) {
        Document document = Jsoup.parse(pageSource);
        Elements select = document.select("div.details-tt>div");
        if(!select.isEmpty()){
            //小区地址
            Elements selectAddress = select.select("div>div.fl>p.details-text-indext2>span");
            if(!selectAddress.isEmpty()){
                String address = selectAddress.text();
                communityTmsfHzDetail.setAddress(address);
                System.out.println(address);
            }
            //其他信息
            Elements select1 = select.select("ul.ft14>li");
            if(!select1.isEmpty()){
                for (Element element : select1) {
                    String tag = element.select("strong").text();
                    String value = element.select("span").text();
                    switch (tag){
                        case "主力户型：":
                            communityTmsfHzDetail.setMainLayout(value);
                            System.out.println("主力户型："+value);
                            break;
                        case "装修状况：":
                            communityTmsfHzDetail.setDecoration(value);
                            System.out.println("装修状况："+value);
                            break;
                        case "物业类型：":
                            communityTmsfHzDetail.setPropertyType(value);
                            System.out.println("物业类型："+value);
                            break;
                        case "建筑形式：":
                            communityTmsfHzDetail.setBuildType(value);
                            System.out.println("建筑形式："+value);
                            break;
                        case "容积率：":
                            communityTmsfHzDetail.setPlotRate(value);
                            System.out.println("容积率："+value);
                            break;
                        case "绿化率：":
                            communityTmsfHzDetail.setGreenRate(value);
                            System.out.println("绿化率："+value);
                            break;
                        case "占地面积：":
                            communityTmsfHzDetail.setFloorArea(value);
                            System.out.println("占地面积："+value);
                            break;
                        case "竣工时间：":
                            communityTmsfHzDetail.setBuildYear(value);
                            System.out.println("竣工时间："+value);
                            break;
                        case "总建筑面积：":
                            communityTmsfHzDetail.setBuildArea(value);
                            System.out.println("总建筑面积："+value);
                            break;
                        case "总户数：":
                            communityTmsfHzDetail.setHomeTotal(value);
                            System.out.println("总户数："+value);
                            break;
                        case "预计交付时间：":
                            communityTmsfHzDetail.setLeadTime(value);
                            System.out.println("预计交付时间："+value);
                            break;
                        case "车位信息：":
                            communityTmsfHzDetail.setParking(value);
                            System.out.println("车位信息："+value);
                            break;
                        case "物业费：":
                            communityTmsfHzDetail.setPropertyPrice(value);
                            System.out.println("物业费："+value);
                            break;
                        case "产权年限：":
                            communityTmsfHzDetail.setPropertyYear(value);
                            System.out.println("产权年限："+value);
                            break;
                        default:
                            break;
                    }

                }
            }
            //小区其他信息
            Elements select2 = select.select("p.details-text-indext2");
            if(!select2.isEmpty()){
                for (Element element : select2) {
                    String tagP = element.select("strong").text();
                    String tagV = element.select("span").text();

                    switch (tagP){
                        case "物业公司：":
                            communityTmsfHzDetail.setPropertyCompany(tagV);
                            System.out.println("物业公司："+ tagV);
                            break;
                        case "项目公司：":
                            communityTmsfHzDetail.setBuildDevelopers(tagV);
                            System.out.println("项目公司："+tagV);
                            break;
                            default:
                                break;
                    }
                }
            }
            return communityTmsfHzDetail;
        }else {
            return null;
        }
    }

    /**
     *
     * 功能描述: 解析楼盘图库
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/10 16:25
     */
    public List<CommunityTmsfHzPic> parsePicture(String html) {
        List<CommunityTmsfHzPic> list =new ArrayList<>();
        Document parse = Jsoup.parse(html);
        //户型图
        Elements selectHuxings = parse.select("div#myCont1>div>ul>li");
        if(!selectHuxings.isEmpty()){
            pictureToList(list, selectHuxings,"户型图");
        }
        Elements select = parse.select("div.bggrey.w1000>div.w948");
        if(!select.isEmpty()){
            for (Element element : select) {
                String tag = element.select("div>h1").text();
                Elements selects = element.select("div.hxshow_contant>ul>li");
                switch (tag){
                    case "效果图":
                        pictureToList(list, selects,"效果图");
                        break;
                    case "位置图":
                        pictureToList(list, selects,"位置图");
                        break;
                    case "样板图":
                        pictureToList(list, selects,"样板图");
                        break;
                    case "周边图":
                        pictureToList(list, selects,"周边图");
                        break;
                    case "实景图":
                        pictureToList(list, selects,"实景图");
                        break;
                    case "交通图":
                        pictureToList(list, selects,"交通图");
                        break;
                        default:
                            break;
                }
            }
        }


        return list;
    }
    /**
     *
     * 功能描述: 图片
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/10 16:58
     */
    public void pictureToList(List<CommunityTmsfHzPic> list, Elements elements,String picType) {
        for (Element selectHuxing : elements) {
            CommunityTmsfHzPic communityTmsfHzPic = new CommunityTmsfHzPic();
            communityTmsfHzPic.setId(UUID.randomUUID().toString());
            communityTmsfHzPic.setCreateTime(new Date());
            communityTmsfHzPic.setBatchId("v1.0");
            communityTmsfHzPic.setPicType(picType);

            Elements select = selectHuxing.select("a>img");
            if(!select.isEmpty()){
                String src = select.attr("src");
                if(StringUtils.isNotBlank(src)){
                    communityTmsfHzPic.setPicSrc("http://www.tmsf.com"+src);
                }

            }
            String picTitle = selectHuxing.select("p>a>span").text();
            communityTmsfHzPic.setPicTitle(picTitle);
            String picTime = selectHuxing.select("p.ft12").text();
            communityTmsfHzPic.setPicTime(picTime);

            list.add(communityTmsfHzPic);
        }
    }

}
