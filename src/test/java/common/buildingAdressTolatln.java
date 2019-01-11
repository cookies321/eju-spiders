package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.Constants;
import com.tt.common.utils.OkHttpDownLoadUtil;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.dao.BuildingKeyListSh2FeedbackMapper;
import com.tt.entity.BuildingKeyListSh2Feedback;
import com.tt.entity.BuildingKeyListSh2FeedbackExample;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2019/1/8 16:13
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class buildingAdressTolatln {

    @Autowired
    private BuildingKeyListSh2FeedbackMapper buildingKeyListSh2FeedbackMapper;

    @Test
    public void addressToGaode() throws InterruptedException {
        BuildingKeyListSh2FeedbackExample buildingKeyListSh2FeedbackExample = new BuildingKeyListSh2FeedbackExample();
        buildingKeyListSh2FeedbackExample.or().andStatusIsNull();
        List<BuildingKeyListSh2Feedback> buildingKeyListSh2Feedbacks = buildingKeyListSh2FeedbackMapper.selectByExample(buildingKeyListSh2FeedbackExample);
        System.out.println(buildingKeyListSh2Feedbacks.size());
        int count=4;
        Semaphore semaphore = new Semaphore(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (BuildingKeyListSh2Feedback buildingKeyListSh2Feedback : buildingKeyListSh2Feedbacks) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String buidingKey = buildingKeyListSh2Feedback.getBuidingKey();
                        String city="上海";
                        /*String url="https://restapi.amap.com/v3/place/text?keywords="+buidingKey+"&types=&city="+city+"&output=json&offset=20&page=1&key="+ Constants.AMAP_KEY+"&extensions=all";
                        String result = PageDownLoadUtil.httpClientDefultGet(url,null);
                        System.out.println(result);
                        if(StringUtils.isNotBlank(result)){
                            JSONObject object = JSON.parseObject(result);
                            String info = object.getString("info");
                            if("OK".equals(info)){
                                JSONArray pois = object.getJSONArray("pois");
                                if(pois.size()>0){
                                    JSONObject jsonObject = pois.getJSONObject(0);
                                    String parent = jsonObject.getString("parent");
                                    String name = jsonObject.getString("name");
                                    String address = jsonObject.getString("address");
                                    String location = jsonObject.getString("location");
                                    String pname = jsonObject.getString("pname");
                                    String cityname = jsonObject.getString("cityname");
                                    String adname = jsonObject.getString("adname");

                                    buildingKeyListSh2Feedback.setParentidGaode(parent);
                                    buildingKeyListSh2Feedback.setBuildingGaode(name);
                                    buildingKeyListSh2Feedback.setAddressGaode(address);
                                    buildingKeyListSh2Feedback.setLocationGaode(location);
                                    buildingKeyListSh2Feedback.setProvinceGaode(pname);
                                    buildingKeyListSh2Feedback.setCityGaode(cityname);
                                    buildingKeyListSh2Feedback.setRegionGaode(adname);
                                    buildingKeyListSh2Feedback.setStatus("1");
                                    buildingKeyListSh2FeedbackMapper.updateByPrimaryKeySelective(buildingKeyListSh2Feedback);
                                }
                            }
                        }*/
                        String url="https://www.amap.com/service/poiInfo?query_type=TQUERY&pagesize=20&pagenum=1&qii=true&cluster_state=5&need_utd=true&utd_sceneid=1000&div=PC1000&addr_poi_merge=true&is_classify=true&zoom=18&city=310000&geoobj=121.342909%7C30.73153%7C121.345623%7C30.734625&keywords="+buidingKey;
                        String result = OkHttpDownLoadUtil.createOkHttpClient().proxyGet(url);
                        System.out.println(result);
                        if(StringUtils.isNotBlank(result) && !result.contains("ejuResponseCode")) {
                            JSONObject object = JSON.parseObject(result);
                            String status = object.getString("status");
                            if ("1".equals(status)) {
                                JSONObject data = object.getJSONObject("data");
                                if(data!=null){
                                    JSONArray pois = data.getJSONArray("poi_list");
                                    if (pois!=null && pois.size() > 0) {
                                        JSONObject jsonObject = pois.getJSONObject(0);
                                        String name = jsonObject.getString("name");
                                        String address = jsonObject.getString("address");

                                        String longitude = jsonObject.getString("longitude");
                                        String latitude = jsonObject.getString("latitude");

                                        buildingKeyListSh2Feedback.setBuildingGaode(name);
                                        buildingKeyListSh2Feedback.setAddressGaode(address);
                                        if(StringUtils.isNotBlank(longitude) && StringUtils.isNotBlank(latitude)){
                                            buildingKeyListSh2Feedback.setLocationGaode(longitude+","+latitude);
                                        }
                                        buildingKeyListSh2Feedback.setStatus("2");
                                        buildingKeyListSh2FeedbackMapper.updateByPrimaryKeySelective(buildingKeyListSh2Feedback);
                                    }
                                }
                            }else {
                                System.out.println(url);
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
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");


    }
}
