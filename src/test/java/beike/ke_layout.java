package beike;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.entity.CommunityKeDetailWithBLOBs;
import com.tt.entity.KeLayout;
import com.tt.service.CommunityKeDetailService;
import com.tt.service.JedisClientService;
import com.tt.service.KeLayoutService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ke_layout {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

    static CommunityKeDetailService communityKeDetailService = (CommunityKeDetailService)applicationContext.getBean("communityKeDetailServiceImpl");

    static KeLayoutService keLayoutService = (KeLayoutService)applicationContext.getBean("keLayoutServiceImpl");

    static JedisClientService jedisClientService = (JedisClientService)applicationContext.getBean("jedisClientServiceImpl");


    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);


    //把种子链接存入redis中
    public static void addUrl(List<CommunityKeDetailWithBLOBs> communityKeDetails) throws InterruptedException {
            for (final CommunityKeDetailWithBLOBs communityKeDetailWithBLOBs : communityKeDetails) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //获取户型的url
                        try {
                            String layoutUrl = communityKeDetailWithBLOBs.getLayoutUrl();
                            String titleId = communityKeDetailWithBLOBs.getTitleId();
                            if(StringUtils.isNotBlank(layoutUrl) && StringUtils.isNotBlank(titleId)){
                                Map<String, Object> map = new HashMap<>();
                                map.put("titleId",titleId);
                                map.put("layoutUrl",layoutUrl);
                                System.out.println("放入种子"+layoutUrl);
                                jedisClientService.addObjectToList("ke_layout",map);
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
                            Map<String, Object> map = (Map<String, Object>) jedisClientService.pollFromList("ke_layout");
                            System.out.println(Thread.currentThread().getName()+map);
                            if (map != null) {
                                String layoutUrl = (String) map.get("layoutUrl");
                                String titleId = (String) map.get("titleId");
                                if(StringUtils.isNotBlank(layoutUrl) && StringUtils.isNotBlank(titleId)){

                                    Document document = DownLoadPage.downLoadPage(layoutUrl);
                                    if(document!=null){
                                        //获取分页，页码
                                        Integer pageNum = getPageNum(document);
                                        if(pageNum!=0){
                                            for (int j = 1; j <= pageNum; j++) {
                                               String layoutPageUrl=layoutUrl+"?page_size=20&_t=1&page="+j;
                                                Document pageDocument = DownLoadPage.downLoadPage(layoutPageUrl);
                                                List<KeLayout> keLayouts = parselayroutUrl(pageDocument);
                                                if(keLayouts==null || keLayouts.size()==0){
                                                    jedisClientService.addObjectToList("ke_layout_error_url",map);
                                                }else{
                                                    for (KeLayout keLayout : keLayouts) {
                                                        //对应的小区ID
                                                        keLayout.setTitleId(titleId);
                                                        keLayout.setSource("v4.0");
                                                        keLayoutService.insertKeLayout(keLayout);
                                                    }
                                                }
                                            }
                                        }
                                    }else {
                                        jedisClientService.addObjectToList("ke_layout_error_url",map);
                                    }
                                }else{
                                    System.out.println("种子没有了");
                                }
                            }else {
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
    public static List<KeLayout> parselayroutUrl(Document document){
        List<KeLayout> list=new ArrayList<>();
        Elements elements = document.select("div.frame_list>ul>li>div.frame_content");
        if(elements!=null){
            for (Element element : elements) {
                KeLayout keLayout = new KeLayout();
                keLayout.setId(UUID.randomUUID().toString());

                String title = element.select("p.frame_title>span.main_title").text();
                String huxingNname=null;
                if(StringUtils.isNotBlank(title)){
                    String[] split = title.split("/");
                    if(split.length!=0){
                        huxingNname=split[0];
                    }else{
                        huxingNname=title;
                    }
                }
                keLayout.setHuxingName(huxingNname);
                String dataInfo =element.select("div.frame_pic").attr("data-info");
                if(StringUtils.isNotBlank(dataInfo)){
                    try {
                        JSONObject object = JSON.parseObject(dataInfo);
                        String gid = object.getString("gid");
                        keLayout.setGid(gid);

                        String fid = object.getString("fid");
                        keLayout.setFid(fid);
                        //室数
                        String bedroom_num = object.getString("bedroom_num");
                        keLayout.setBedroomNum(bedroom_num);

                        //楼栋分布
                        String building_dist = object.getString("building_dist");
                        keLayout.setBuildingDist(building_dist);

                        String house_sell_num = object.getString("house_sell_num");
                        keLayout.setHouseSellCnt(house_sell_num);

                        String house_sold_num = object.getString("house_sold_num");
                        keLayout.setHouseSoldCnt(house_sold_num);

                        //面积
                        String current_area = object.getString("current_area");
                        keLayout.setCurrentArea(current_area);

                        //厅数
                        String hall_num = object.getString("hall_num");
                        keLayout.setHallNum(hall_num);

                        //
                        String house_cnt = object.getString("house_cnt");
                        keLayout.setHouseCnt(house_cnt);
                        //户型标签
                        String tag = object.getString("tag");
                        keLayout.setTag(tag);
                        //朝向
                        String frame_orientation = object.getString("frame_orientation");
                        keLayout.setFrameOrientation(frame_orientation);
                        //户型图
                        String frame_image = object.getString("frame_image");
                        keLayout.setFrameImage(frame_image);

                        //是否主力户型
                        String is_hot = object.getString("is_hot");
                        keLayout.setIsHot(is_hot);

                        list.add(keLayout);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }

    /**
     *
     * 功能描述:
     *
     * 获取贝壳户型的总条数
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/20 18:55
     */
    public static Integer getPageNum(Document document){
        Integer pageNum=0;
        if(document!=null){
            Elements elements = document.select("div.frame_list>ul");
            if(!elements.isEmpty()){
                String totalStr= elements.attr("data-info");
                if(StringUtils.isNotBlank(totalStr)){
                    String replace = totalStr.replace("total=", "");
                    try {
                        Integer totalNum = Integer.parseInt(replace);
                        pageNum= totalNum %20 ==0 ? totalNum /20 : totalNum/20+1;
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }
        return pageNum;
    }


    public static void main(String[] args) throws InterruptedException {
      /* List<CommunityKeDetailWithBLOBs> communityKeDetail = communityKeDetailService.getCommunityKeDetail();
        System.out.println(communityKeDetail.size());
        addUrl(communityKeDetail);
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("结束++++");*/
        poolUrl();
    }

}
