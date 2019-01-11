package com.tt.controller.zhuge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.dao.ZhugeCommunityListMapper;
import com.tt.dao.ZhugeCommunityMapper;
import com.tt.entity.ZhugeCommunity;
import com.tt.entity.ZhugeCommunityList;
import com.tt.entity.ZhugeCommunityListExample;
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
 * @Date: 2018/11/5 15:59
 * @Description:
 */
public class ParseDetail {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        ZhugeCommunityMapper zhugeCommunityMapper=(ZhugeCommunityMapper)applicationContext.getBean("zhugeCommunityMapper");
        ZhugeCommunityListMapper zhugeCommunityListMapper=(ZhugeCommunityListMapper)applicationContext.getBean("zhugeCommunityListMapper");

        Integer num =4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        //查询数据库列表详情的url
        ZhugeCommunityListExample zhugeCommunityListExample = new ZhugeCommunityListExample();
        ZhugeCommunityListExample.Criteria criteria = zhugeCommunityListExample.createCriteria();
        criteria.andStatusIsNull();
        List<ZhugeCommunityList> zhugeCommunityLists = zhugeCommunityListMapper.selectByExample(zhugeCommunityListExample);
        System.out.println(zhugeCommunityLists.size());
        if(zhugeCommunityLists!=null && zhugeCommunityLists.size()!=0){
            for (ZhugeCommunityList zhugeCommunityList : zhugeCommunityLists) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String detailUrl = zhugeCommunityList.getDetailUrl();
                            String city = zhugeCommunityList.getCity();

                            Map<String,String> header=new HashMap<>();
                            //header.put("Host","sh.house.zhuge.com");
                            header.put("Accept-Language","zh-CN,zh;q=0.9");
                            header.put("Accept-Encoding","gzip, deflate");
                            header.put("If-None-Match","W/125e-8pYtdxwALKZH7kOMgUjllg");
                            header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                            header.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");


                            if(StringUtils.isNotBlank(detailUrl)){
                                Document documentDetail = DownLoadPage.downLoadPage(detailUrl, header);
                                String titleId = detailUrl.substring(detailUrl.indexOf("com/") + 4, detailUrl.lastIndexOf("."));
                                ZhugeCommunity zhugeCommunity = new ZhugeCommunity();
                                zhugeCommunity.setId(UUID.randomUUID().toString());
                                zhugeCommunity.setDetailUrl(detailUrl);
                                zhugeCommunity.setCity(city);
                                zhugeCommunity.setTitleId(titleId);
                                zhugeCommunity.setCreatetime(new Date());
                                zhugeCommunity.setBatchId("v1.0");
                                parseDetail(documentDetail,zhugeCommunity);
                                //插入数据
                                if(StringUtils.isNotBlank(zhugeCommunity.getTitle())){
                                    int insert = zhugeCommunityMapper.insert(zhugeCommunity);
                                    if(insert==1){
                                        zhugeCommunityList.setStatus("1");
                                        zhugeCommunityListMapper.updateByPrimaryKeySelective(zhugeCommunityList);
                                    }else {
                                        zhugeCommunityList.setStatus("0");
                                        zhugeCommunityListMapper.updateByPrimaryKeySelective(zhugeCommunityList);
                                    }
                                }
                            }else{
                                zhugeCommunityList.setStatus("0");
                                zhugeCommunityListMapper.updateByPrimaryKeySelective(zhugeCommunityList);
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
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("结束");
    }


    /**
     *
     * 功能描述: 解析详情页url
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/5 16:00
     */
    public static void parseDetail(Document document, ZhugeCommunity zhugeCommunity){
        Elements selectLeft = document.select("div.detail_content>div.detail_left");
        if(!selectLeft.isEmpty()){
            Elements selectTitle = selectLeft.select("div.left_header>h1");
            if(!selectTitle.isEmpty()){
                //标题
                String title = selectTitle.text();
                System.out.println(title);
                zhugeCommunity.setTitle(title);
            }
            //地址信息
            Elements selectAddress = selectLeft.select("div.left_header>ul.header_infor>li");
            if(!selectAddress.isEmpty()){
                Elements select = selectAddress.select("a");
                if(!select.isEmpty()){
                    if(select.size()==2){
                        String region= select.get(0).text();
                        String plate= select.get(1).text();
                        String address = selectAddress.get(0).ownText().replace("[ - ]","");
                        zhugeCommunity.setRegion(region);
                        zhugeCommunity.setPlate(plate);
                        zhugeCommunity.setAddress(address);
                        System.out.println(region+"--"+plate+"--"+address);
                    }else if(select.size()==1){
                        String region= select.get(0).text();
                        String address = selectAddress.get(0).ownText().replace("[","");
                        zhugeCommunity.setRegion(region);
                        zhugeCommunity.setAddress(address);
                        System.out.println(region+"--"+address);
                    } else {
                        String address = selectAddress.get(0).ownText();
                        if(StringUtils.isNotBlank(address)){
                            zhugeCommunity.setAddress(address);
                            System.out.println(address);
                        }
                    }

                }
            }
            //详情信息
            Elements selectDetail = selectLeft.select("div.left_basic>ul.basic_list>li");
            if(!selectDetail.isEmpty()){
                for (Element element : selectDetail) {
                    String tag = element.select("label").text();
                    String val = element.select("div").text();

                    switch (tag){
                        case "建造年代：":
                            System.out.println(val);
                            zhugeCommunity.setBuildYear(val);
                            break;
                        case "产权描述：":
                            System.out.println(val);
                            zhugeCommunity.setPropertyYear(val);
                            break;
                        case "容积率：":
                            System.out.println(val);
                            zhugeCommunity.setPlotRate(val);
                            break;
                        case "绿化率：":
                            System.out.println(val);
                            zhugeCommunity.setGreenRate(val);
                            break;
                        case "楼栋总数：":
                            System.out.println(val);
                            zhugeCommunity.setLoudongNum(val);
                            break;
                        case "房屋总数：":
                            System.out.println(val);
                            zhugeCommunity.setHomeTotal(val);
                            break;
                        case "物业费用：":
                            System.out.println(val);
                            zhugeCommunity.setPropertyPrice(val);
                            break;
                        case "物业公司：":
                            System.out.println(val);
                            zhugeCommunity.setPropertyCompany(val);
                            break;
                        case "开发商：":
                            System.out.println(val);
                            zhugeCommunity.setBuildDevelopers(val);
                            break;
                        case "建筑类型：":
                            System.out.println(val);
                            zhugeCommunity.setBuildType(val);
                            break;
                        case "建筑面积：":
                            System.out.println(val);
                            zhugeCommunity.setBuildArea(val);
                            break;
                        case "占地面积：":
                            System.out.println(val);
                            zhugeCommunity.setFloorArea(val);
                            break;
                        case "供暖方式：":
                            System.out.println(val);
                            zhugeCommunity.setHeating(val);
                            break;
                        case "燃气方式：":
                            System.out.println(val);
                            zhugeCommunity.setGas(val);
                            break;
                        case "停车位：":
                            System.out.println(val);
                            zhugeCommunity.setParkNum(val);
                            break;
                        case "电梯：":
                            System.out.println(val);
                            zhugeCommunity.setElevator(val);
                            break;
                        default:
                            break;
                    }
                }
            }

        }
        //价格趋势
        Elements select = document.select("input.average_price");
        if(!select.isEmpty()){
            String val = select.val();
            JSONObject object = JSON.parseObject(val);
            JSONObject sell = object.getJSONObject("sell");
            String jsonString = sell.toJSONString();
            System.out.println(jsonString);
            zhugeCommunity.setAveragePriceTrend(jsonString);
        }
        //成交信息
        Elements select1 = document.select("div.left_record>div.record_title>b");
        if(!select1.isEmpty()){
            String text = select1.text();
            if(StringUtils.isNotBlank(text)){
                String[] split = text.split("成交记录（");
                if(split.length==2){
                    String pageCount = split[1].replace("）","");
                    zhugeCommunity.setJiaoyiNum(pageCount);
                }
            }
        }

    }

}
