package beike;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.common.utils.NumUtils;
import com.tt.dao.CommunityKeDetailReleaseHouseMapper;
import com.tt.dao.KeLoudongReleaseHouseMapper;
import com.tt.entity.CommunityKeDetailReleaseHouse;
import com.tt.entity.CommunityKeDetailReleaseHouseExample;
import com.tt.entity.KeLoudongReleaseHouse;
import com.tt.service.JedisClientService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * 功能描述: 
 * 爬去 beike，发布房源的小区楼栋信息
 * @auther: 赵乐
 * @date: 2018/10/19 10:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ke_ReleaseHouse {

   private static final Logger LOGGER = LoggerFactory.getLogger(ke_ReleaseHouse.class);

    @Autowired
    private CommunityKeDetailReleaseHouseMapper communityKeDetailReleaseHouseMapper;

    @Autowired
    private KeLoudongReleaseHouseMapper keLoudongReleaseHouseMapper;

    @Autowired
    private JedisClientService jedisClientService;

    @Test
    public void test(){
        CommunityKeDetailReleaseHouseExample communityKeDetailReleaseHouseExample = new CommunityKeDetailReleaseHouseExample();
        List<CommunityKeDetailReleaseHouse> communityKeDetails = communityKeDetailReleaseHouseMapper.selectByExample(communityKeDetailReleaseHouseExample);

        System.out.println(communityKeDetails.size());

    }

    /**
     * 爬取楼栋
     */
    @Test
    public void loudong() throws InterruptedException {
        //https://ajax.api.ke.com//house/house/getbuildings?community_id=2111103319326
        String url = "https://ajax.api.ke.com//house/house/getbuildings?community_id=";  //GET请求方式

        //从数据中获取要爬取的小区信息
        CommunityKeDetailReleaseHouseExample communityKeDetailReleaseHouseExample = new CommunityKeDetailReleaseHouseExample();
        CommunityKeDetailReleaseHouseExample.Criteria criteria = communityKeDetailReleaseHouseExample.createCriteria();
        criteria.andStatusIsNull();
        List<CommunityKeDetailReleaseHouse> communityKeDetails = communityKeDetailReleaseHouseMapper.selectByExample(communityKeDetailReleaseHouseExample);

        /*List<KeLoudongReleaseHouse> keLoudongReleaseHouses = keLoudongReleaseHouseMapper.selectQueShao();

        List<CommunityKeDetailReleaseHouse> communityKeDetails =new ArrayList<>();*/

        /*for (KeLoudongReleaseHouse keLoudongReleaseHouse : keLoudongReleaseHouses) {
            String titleId = keLoudongReleaseHouse.getTitleId();
            if(StringUtils.isNotBlank(titleId)){
                CommunityKeDetailReleaseHouse communityKeDetailReleaseHouse = new CommunityKeDetailReleaseHouse();
                communityKeDetailReleaseHouse.setTitleId(titleId);
                communityKeDetails.add(communityKeDetailReleaseHouse);
            }
        }*/
        System.out.println(communityKeDetails.size());

        if (CollectionUtils.isEmpty(communityKeDetails)) {
            return;
        }
        //从redis中获取用户登录之后的cookie信息
        List<Object> cookieList = jedisClientService.lrange("cookieList", 0, -1);
        if(CollectionUtils.isEmpty(cookieList)){
            LOGGER.info("redis中存储的cookie为空，多次循环获取cookie的值");
            while (true) {
                List<String> loginCookie = Ke_loginCookie.getLoginCookie();
                if(CollectionUtils.isNotEmpty(loginCookie)){
                    cookieList.add(loginCookie);
                    break;
                }else {
                    LOGGER.info("模拟登陆获取cookie失败，导致没有cookie");
                    continue;
                }
            }
        }else{
            final int fixedNum = 6;
            Semaphore semaphore = new Semaphore(fixedNum);
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);
            for (CommunityKeDetailReleaseHouse communityKeDetail : communityKeDetails) {
                semaphore.acquire();
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //String communityId = "5011102210126";
                            String titleId = communityKeDetail.getTitleId();
                            if(StringUtils.isNotBlank(titleId)){
                                String href=url+titleId;
                                //随机获取一个登录的cookie信息
                                String cookie = (String)cookieList.get(NumUtils.getRandom(cookieList.size(), 0));
                                Map<String, String> heads = new HashMap<>();
                                heads.put("Cookie",cookie);
                                Document document = DownLoadPage.downLoadPage(href, heads);
                                if(document!=null){
                                    String str = document.select("body").text();
                                    JSONObject object = null;
                                    try {
                                        object = JSONObject.parseObject(str);
                                        if (object.getString("errno").equals("0")) {   //请求成功
                                            if (object.get("data") != null) {
                                                JSONObject data = object.getJSONObject("data");
                                                System.out.println(data);
                                                JSONArray list = data.getJSONArray("list");
                                                if (list != null && list.size() > 0) {
                                                    for (Object o : list) {
                                                        JSONObject build=(JSONObject)o;
                                                        String building_id = build.getString("building_id");
                                                        String building_name = build.getString("building_name");
                                                        if(StringUtils.isNotBlank(building_id) && StringUtils.isNotBlank(building_name)){
                                                            KeLoudongReleaseHouse keLoudongReleaseHouse = new KeLoudongReleaseHouse();
                                                            keLoudongReleaseHouse.setId(UUID.randomUUID().toString());
                                                            keLoudongReleaseHouse.setTitleId(titleId);
                                                            keLoudongReleaseHouse.setBuildingId(build.getString("building_id"));
                                                            keLoudongReleaseHouse.setBuilding(build.getString("building_name"));
                                                            keLoudongReleaseHouse.setSource("v3.0");
                                                            keLoudongReleaseHouseMapper.insert(keLoudongReleaseHouse);
                                                        }
                                                    }
                                                    communityKeDetail.setStatus("1");
                                                    communityKeDetailReleaseHouseMapper.updateByPrimaryKey(communityKeDetail);
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }
                    }
                });

            }
            fixedThreadPool.shutdown();
            while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS)) ;
        }
    }

    /**
     * 获取单元ID  （楼栋ID）
     */
    /*@Test
    public void getUnitsId() throws InterruptedException {
        String url = "https://ajax.api.lianjia.com/house/house/getunits";  //GET

        //模拟登陆
        final List<String> cookie = new ArrayList<>();
        Login login = new Login();
        while (true) {
            cookie.addAll(login.getCookie());
            if (CollectionUtils.isNotEmpty(cookie)) {
                LOGGER.info("--Cookie数量---:{}", cookie.size());
                break;
            }
        }
        LianjiaLoudongExample example = new LianjiaLoudongExample();
        LianjiaLoudongExample.Criteria criteria = example.createCriteria();
        criteria.andStatusIsNull();
        criteria.andNidIsNotNull();
        criteria.andBuildingIdIsNotNull();
        criteria.andUnitIdIsNull();
//        criteria.andIdGreaterThan(132242L);
//        criteria.andIdLessThan(350001L);
        List<LianjiaLoudong> queryList = lianjiaLoudongMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(queryList)) {
            return;
        }

        final int fixedNum = 4;
        Semaphore semaphore = new Semaphore(fixedNum);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);
        for (LianjiaLoudong loudong : queryList) {
            semaphore.acquire();
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Map<String, String> parmas = new HashMap<>();
                        parmas.put("community_id", loudong.getNid());
                        parmas.put("building_id", loudong.getBuildingId());
                        Map<String, String> headers = new HashMap<>();
                        Random random = new Random();
                        int n = random.nextInt(cookie.size());
                        headers.put("Cookie", cookie.get(n));
                        LOGGER.info("===Cookie:{}===", cookie.get(n));

                        String str = ProxyUtils.sendGetUrlByMoguProxy(url, parmas, headers, null);
                        if (StringUtils.isEmpty(str)) {
                            return;
                        }

                        try {
                            JSONObject jsonObject = JSON.parseObject(str);
                            JSONObject data = jsonObject.getJSONObject("data");
                            if (data != null) {
                                JSONArray list = data.getJSONArray("list");
                                if (list != null && list.size() > 0) {
                                    JSONObject object = JSON.parseObject(JSON.toJSONString(list.get(0)));
                                    String unitId = object.getString("unit_id");
                                    String unitName = object.getString("unit_name");

                                    loudong.setUnitId(unitId);
                                    loudong.setUnitName(unitName);
                                    loudong.setStatus("1");
                                    lianjiaLoudongMapper.updateByPrimaryKeySelective(loudong);

                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();
        while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS)) ;
    }*/


}
