package com.tt.controller.Government;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.dao.GovernmentCommunityMapper;
import com.tt.dao.GovernmentHouseMapper;
import com.tt.dao.GovernmentLoudongMapper;
import com.tt.entity.*;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * 爬去政府网站，重庆的房地产信息
 * @Auther: 赵乐
 * @Date: 2018/11/14 15:49
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ParseqcHouse {

    @Autowired
    @Qualifier("ipPoolProxy")
    //@Qualifier("moguProxy")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private GovernmentCommunityMapper governmentCommunityMapper;

    @Autowired
    private GovernmentLoudongMapper governmentLoudongMapper;

    @Autowired
    private GovernmentHouseMapper governmentHouseMapper;


    /**
     *
     * 功能描述: 爬去主页链接，获取楼盘列表
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/14 16:45
     */
    @Test
    public void parseIndex() throws InterruptedException {
        String []sites={"巴南","北碚","大渡口","江北","九龙坡","南岸","沙坪坝","渝北","渝中","两江新"};
        String []roomtypes={"住宅","办公","商铺","其它"};

        Integer numCount=4;
        Semaphore semaphore = new Semaphore(numCount);
        ExecutorService executorService = Executors.newFixedThreadPool(numCount);
        for (String site : sites) {
            for (String roomtype : roomtypes) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            int i=1;
                            while (true){
                                String url="http://www.cq315house.com/315web/webservice/GetMyData999.ashx?projectname=&site="+URLEncoder.encode(site)+
                                        "&kfs=&projectaddr=&pagesize=100&pageindex="+i+"&roomtype="+URLEncoder.encode(roomtype)+"&buildarea=";
                                Document document = iDownLoadPage.downLoadPageByGet(url,"UTF-8",20000,20000,new HashMap<>());
                                if(document!=null){
                                    i++;
                                    String text = document.select("body").text();//btnLast_onclick()  btnLast
                                    String replace = text.replace("\\", "");
                                    JSONArray objects = JSON.parseArray(replace);
                                    System.out.println(objects.size());
                                    if(objects==null || objects.size()==0){
                                        break;
                                    }else{
                                        int pageSize = objects.size();
                                        for (int j = 0; j < pageSize; j++) {
                                            GovernmentCommunity governmentCommunity = new GovernmentCommunity();
                                            governmentCommunity.setId(UUID.randomUUID().toString());
                                            governmentCommunity.setBatchId("v1.0");
                                            governmentCommunity.setCreateTime(new Date());

                                            JSONObject jsonObject = objects.getJSONObject(j);
                                            //id
                                            String parentjectid = jsonObject.getString("PARENTJECTID");
                                            governmentCommunity.setTitleId(parentjectid);
                                            System.out.println(parentjectid);
                                            //楼盘名称
                                            String projectname = jsonObject.getString("PROJECTNAME");
                                            governmentCommunity.setTitle(projectname);
                                            System.out.println(projectname);
                                            //所属区县
                                            String f_site = jsonObject.getString("F_SITE");
                                            governmentCommunity.setRegion(f_site);
                                            //项目地址
                                            String f_addr = jsonObject.getString("F_ADDR");
                                            governmentCommunity.setAddress(f_addr);
                                            //开发商
                                            String enterprisename = jsonObject.getString("ENTERPRISENAME");
                                            governmentCommunity.setBuildDevelopers(enterprisename);

                                            //住宅可售套数
                                            String num = jsonObject.getString("NUM");
                                            governmentCommunity.setSaleHouse(num);

                                            governmentCommunityMapper.insertSelective(governmentCommunity);
                                        }
                                        //判断当前页的条数，小于100，则为最后一页，终止循环
                                        if(pageSize<100){
                                            break;
                                        }else{
                                            continue;
                                        }
                                    }
                                }else {
                                    break;
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
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }
    
    /**
     *
     * 功能描述: 根据小区id，获取楼栋信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/16 10:08
     */
    @Test
    public void parseCommunity() throws InterruptedException {
        GovernmentCommunityExample governmentCommunityExample = new GovernmentCommunityExample();
        governmentCommunityExample.or().andStatusIsNull();
        List<GovernmentCommunity> governmentCommunities = governmentCommunityMapper.selectByExample(governmentCommunityExample);
        System.out.println(governmentCommunities.size());
        Integer num=2;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (GovernmentCommunity governmentCommunity : governmentCommunities) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //小区id
                        String titleId = governmentCommunity.getTitleId();
                        //小区名称
                        String title = governmentCommunity.getTitle();

                        if(StringUtils.isNotBlank(titleId)){
                            String url="http://www.cq315house.com/315web/webservice/GetMyData112.ashx?projectId="+titleId;
                            Document document = iDownLoadPage.downLoadPageByGet(url, "UTF-8", 20000, 20000, new HashMap<>());
                            if(document!=null){
                                String text = document.select("body").text();
                                String replace = text.replace("\\", "");
                                JSONArray objects = JSON.parseArray(replace);
                                for (int i = 0; i < objects.size(); i++) {
                                    JSONObject jsonObject = objects.getJSONObject(i);

                                    //楼栋名称
                                    String f_block = jsonObject.getString("F_BLOCK");

                                    //楼栋id
                                    String buildid = jsonObject.getString("BUILDID");


                                    String[] splitBuildId = buildid.split(",");
                                    String[] splitBuilding = f_block.split(",");

                                    for (int j = 0; j < splitBuildId.length; j++) {
                                        GovernmentLoudong governmentLoudong = new GovernmentLoudong();
                                        governmentLoudong.setId(UUID.randomUUID().toString());
                                        governmentLoudong.setBatchId("v1.0");
                                        governmentLoudong.setCreateTime(new Date());
                                        //关联小区信息
                                        governmentLoudong.setTitleId(titleId);
                                        governmentLoudong.setTitleRelation(title);

                                        //楼栋和楼栋id
                                        String buildId = splitBuildId[j];
                                        String building=splitBuilding[j];
                                        governmentLoudong.setBuilding(building);
                                        governmentLoudong.setBuildingId(buildId);


                                        //小区名称
                                        String parentprojname = jsonObject.getString("PARENTPROJNAME");
                                        governmentLoudong.setTitle(parentprojname);
                                        //预售许可证
                                        String f_presale_cert = jsonObject.getString("F_PRESALE_CERT");
                                        governmentLoudong.setSalesNo(f_presale_cert);
                                        //住宅可售套数
                                        String buildzznum = jsonObject.getString("BUILDZZNUM");
                                        governmentLoudong.setSaleHouse(buildzznum);
                                        //非住宅可售套数
                                        String buildfzznum = jsonObject.getString("BUILDFZZNUM");
                                        governmentLoudong.setSaleNothouse(buildfzznum);
                                        //真实楼高

                                        //名义楼高

                                        //楼栋详情页面
                                        //http://www.cq315house.com/315web/HtmlPage/ShowRoomsNew.aspx?block=D7%u53F7%u697C&buildingid=11157743
                                        String loudongUrl="http://www.cq315house.com/315web/HtmlPage/ShowRoomsNew.aspx?buildingid="+buildId;
                                        System.out.println(loudongUrl+"----楼栋url");
                                        governmentLoudong.setLoudongUrl(loudongUrl);

                                        governmentLoudongMapper.insertSelective(governmentLoudong);
                                    }
                                }
                                //更新小区列表
                                governmentCommunity.setStatus("1");
                                governmentCommunityMapper.updateByPrimaryKeySelective(governmentCommunity);
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
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

   /* @Test
    public void testss(){
        String loudongUrl="http://www.cq315house.com/315web/HtmlPage/ShowRoomsNew.aspx?block=E幢及三区车库&buildingid=10470306";
        //String loudongUrl = governmentLoudong.getLoudongUrl();
        Document document = iDownLoadPage.downLoadPageByGet(loudongUrl,"UTF-8", 20000, 20000, new HashMap<>());
        Elements select = document.select("input#DataHF");
        if(!select.isEmpty()){
            String val = select.val();
            String replace = val.replace("&quot;", "\"");
            JSONArray objects = JSON.parseArray(replace);
            JSONObject jsonObject = objects.getJSONObject(0);
            JSONArray rooms = jsonObject.getJSONArray("rooms");
            System.out.println(rooms.size());
        }

    }*/
    
    /**
     *
     * 功能描述: 解析楼栋，获取房号
     *
     * @param:
     * @return:  fid=11637656
     * @auther: 赵乐
     * @date: 2018/11/16 10:45
     */
    @Test
    public void parseHouse() throws InterruptedException {
        GovernmentLoudongExample governmentLoudongExample = new GovernmentLoudongExample();
        governmentLoudongExample.or().andStatusIsNull();
        List<GovernmentLoudong> governmentLoudongs = governmentLoudongMapper.selectByExample(governmentLoudongExample);
        System.out.println(governmentLoudongs.size());
        Integer num =4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (GovernmentLoudong governmentLoudong : governmentLoudongs) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String buildingId = governmentLoudong.getBuildingId();
                        String building = governmentLoudong.getBuilding();
                        String loudongUrl = governmentLoudong.getLoudongUrl();
                        Document document = iDownLoadPage.downLoadPageByGet(loudongUrl,"UTF-8", 20000, 20000, new HashMap<>());
                        Elements select = document.select("input#DataHF");
                        if(!select.isEmpty()){
                            String val = select.val();
                            String replace = val.replace("&quot;", "\"");
                            JSONArray objects = JSON.parseArray(replace);

                            for (int j = 0; j < objects.size(); j++) {
                                JSONObject jsonObject = objects.getJSONObject(j);
                                JSONArray rooms = jsonObject.getJSONArray("rooms");
                                System.out.println(rooms.size());
                                for (int k = 0; k < rooms.size(); k++) {
                                    GovernmentHouse governmentHouse = new GovernmentHouse();
                                    governmentHouse.setId(UUID.randomUUID().toString());
                                    governmentHouse.setBatchId("v1.0");
                                    governmentHouse.setCreateTime(new Date());

                                    governmentHouse.setBuilding(building);
                                    governmentHouse.setBuildingId(buildingId);

                                    JSONObject jsonObject1 = rooms.getJSONObject(k);
                                    //房号
                                    String rn = jsonObject1.getString("rn");
                                    governmentHouse.setHouseName(rn);
                                    //房号id
                                    String id = jsonObject1.getString("id");
                                    governmentHouse.setHouseId(id);
                                    //真实房号
                                    String flr = jsonObject1.getString("flr");
                                    governmentHouse.setRealFloor(flr);
                                    //物理房号
                                    String y = jsonObject1.getString("y");
                                    governmentHouse.setNominalFloor(y);

                                    governmentHouseMapper.insertSelective(governmentHouse);
                                }
                            }

                            //更新楼栋状态
                            governmentLoudong.setStatus("1");
                            governmentLoudongMapper.updateByPrimaryKeySelective(governmentLoudong);
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
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

}
