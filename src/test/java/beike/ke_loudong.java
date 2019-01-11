package beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.entity.CommunityKeDetailWithBLOBs;
import com.tt.entity.KeLoudong;
import com.tt.service.CommunityKeDetailService;
import com.tt.service.JedisClientService;
import com.tt.service.KeLoudongServer;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ke_loudong {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

    static CommunityKeDetailService communityKeDetailService = (CommunityKeDetailService)applicationContext.getBean("communityKeDetailServiceImpl");

    static KeLoudongServer keLoudongServer = (KeLoudongServer)applicationContext.getBean("keLoudongServerImpl");

    static JedisClientService jedisClientService = (JedisClientService)applicationContext.getBean("jedisClientServiceImpl");


    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);


    //把种子链接存入redis中
    public static void addUrl(List<CommunityKeDetailWithBLOBs> communityKeDetails) throws InterruptedException {
            for (final CommunityKeDetailWithBLOBs communityKeDetailWithBLOBs : communityKeDetails) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //获取楼栋的url
                        try {
                            String loudongUrl = communityKeDetailWithBLOBs.getLoudongUrl();
                            if(StringUtils.isNotBlank(loudongUrl)){
                                Map<String, Object> map = new HashMap<>();
                                map.put("titleId",communityKeDetailWithBLOBs.getTitleId());
                                map.put("loudongUrl",communityKeDetailWithBLOBs.getLoudongUrl());
                                System.out.println("放入种子"+communityKeDetailWithBLOBs.getLoudongUrl());
                                jedisClientService.addObjectToList("ke_loudong",map);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
    }

    /**
     * 从redis中获取种子链接
     */
    public static void poolUrl() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Map<String, Object> map = (Map<String, Object>) jedisClientService.pollFromList("ke_loudong");
                            System.out.println(Thread.currentThread().getName()+map);
                            if (map != null) {
                                String loudongUrl = (String) map.get("loudongUrl");
                                String titleId = (String) map.get("titleId");
                                if(StringUtils.isNotBlank(loudongUrl) && StringUtils.isNotBlank(titleId)){
                                    Document document = DownLoadPage.downLoadPage(loudongUrl);
                                    if(document!=null){
                                        List<KeLoudong> keLoudongs = parseLouDongUrl(document);
                                        for (KeLoudong keLoudong : keLoudongs) {
                                            //对应的小区ID
                                            keLoudong.setTitleId(titleId);
                                            System.out.println(keLoudong.getBuildingId());
                                            keLoudongServer.insert(keLoudong);
                                        }
                                    }else {
                                        jedisClientService.addObjectToList("ke_loudogn_url",map);
                                    }
                                }else{
                                    Thread.sleep(5000);
                                    System.out.println("种子没有了");
                                }
                            }else {
                                Thread.sleep(5000);
                                System.out.println("种子没有了");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    /**
     * 解析楼栋url，获取楼栋信息
     * @param document
     */
    public static List<KeLoudong> parseLouDongUrl(Document document){
        List<KeLoudong> list =new ArrayList<KeLoudong>();
        String data = document.select("div#map-content").attr("data-info");
        if(StringUtils.isNotBlank(data)){
            JSONObject object = (JSONObject) JSON.parse(data);
            JSONArray building = object.getJSONArray("building");
            for (int i = 0; i < building.size(); i++) {
                JSONObject build = (JSONObject) building.get(i);
                KeLoudong keLoudong = new KeLoudong();
                keLoudong.setId(UUID.randomUUID().toString());
                //build 楼栋ID
                String id = build.getString("id");
                keLoudong.setBuildingId(id);
                //build 楼栋名称
                String name = build.getString("name");
                keLoudong.setBuilding(name);
                //build 有无电梯
                String elevator_count = build.getString("elevator_count");
                keLoudong.setElevator(elevator_count);
                //楼层数（真实楼层）
                String frame_count = build.getString("frame_count");
                keLoudong.setFrameNum(frame_count);
                //建成年代
                String build_years = build.getString("build_years");
                keLoudong.setBuildYear(build_years);
                //建筑类型
                String build_type = build.getString("build_type");
                keLoudong.setBuildType(build_type);
                //单元数量
                String unit_count = build.getString("unit_count");
                keLoudong.setUnitNum(unit_count);
                //百度经度
                String point_lat = build.getString("point_lat");
                keLoudong.setPointLat(point_lat);
                //百度维度
                String point_lng = build.getString("point_lng");
                keLoudong.setPointLng(point_lng);
                //与小区坐标点距离
                String distance = build.getString("distance");
                keLoudong.setDistance(distance);
                //设置数据源
                keLoudong.setSource("ke_loudong_v3.0");

                list.add(keLoudong);
            }
        }
        return list;
    }


    public static void main(String[] args) throws InterruptedException {
        //根据城市分类爬取楼栋信息
       /* List<CommunityKeDetailWithBLOBs> communityKeDetail = communityKeDetailService.getCommunityKeDetail();
        addUrl(communityKeDetail);
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("结束++++");*/


        //北京、深圳、广州、南京、杭州、苏州、成都、武汉、青岛、重庆、东莞（备选）、天津（备选）、沈阳（备选）
        /*String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};*/
        /*for (String city : citys) {
            //根据城市分组，解析楼栋数据
            List<CommunityKeDetailWithBLOBs> communityKeDetail = communityKeDetailService.getCommunityKeDetailByCity(city);
            addUrl(communityKeDetail);
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("结束+++++");*/
        poolUrl();
    }

}
