package beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.Constants;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.dao.CommunityKe17cityAbcdMapper;
import com.tt.dao.CommunityKeDetailGaodeAddressMapper;
import com.tt.dao.CommunityKeDetailMapper;
import com.tt.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/24 16:38
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ke_community_addressToGaode {

    @Autowired
    private CommunityKeDetailMapper communityKeDetailMapper;

    @Autowired
    private CommunityKe17cityAbcdMapper communityKe17cityAbcdMapper;

    @Autowired
    private CommunityKeDetailGaodeAddressMapper communityKeDetailGaodeAddressMapper;



    @Test
    public void addressToGaode() throws InterruptedException {
        /*CommunityKeDetailExample communityKeDetailExample = new CommunityKeDetailExample();
        communityKeDetailExample.or().andVersionEqualTo("2011");
        List<CommunityKeDetailWithBLOBs> communityKeDetailWithBLOBs = communityKeDetailMapper.selectByExampleWithBLOBs(communityKeDetailExample);*/
        CommunityKe17cityAbcdExample communityKe17cityAbcdExample = new CommunityKe17cityAbcdExample();
        communityKe17cityAbcdExample.or().andSourceIsNull();
        List<CommunityKe17cityAbcd> communityKe17cityAbcds = communityKe17cityAbcdMapper.selectByExample(communityKe17cityAbcdExample);
        System.out.println(communityKe17cityAbcds.size());
        Integer count=6;
        Semaphore semaphore = new Semaphore(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (CommunityKe17cityAbcd communityKe17cityAbcd : communityKe17cityAbcds) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String city="杭州";
                        String title = communityKe17cityAbcd.getTitle();
                        String titleId = communityKe17cityAbcd.getTitleId();
                        //String url1="https://restapi.amap.com/v3/place/text?keywords=西湖美庐&types=120000&city=杭州&output=json&offset=20&page=1&key=7a87d5b75e0eac5784d90c8654296167&extensions=all";
                        String url="https://restapi.amap.com/v3/place/text?keywords="+title+"&types=120000&city="+city+"&output=json&offset=20&page=1&key="+ Constants.AMAP_KEY+"&extensions=all";
                        String result = PageDownLoadUtil.httpClientDefultGet(url,null);
                        if(StringUtils.isNotBlank(result)){
                            JSONObject object = JSON.parseObject(result);
                            String info = object.getString("info");
                            if("OK".equals(info)){
                                JSONArray pois = object.getJSONArray("pois");
                                if(pois.size()>0){
                                    CommunityKeDetailGaodeAddress communityKeDetailGaodeAddress = new CommunityKeDetailGaodeAddress();
                                    communityKeDetailGaodeAddress.setId(UUID.randomUUID().toString());
                                    communityKeDetailGaodeAddress.setTitle(title);
                                    communityKeDetailGaodeAddress.setTitleId(titleId);
                                    JSONObject jsonObject = pois.getJSONObject(0);
                                    String name = jsonObject.getString("name");
                                    String address = jsonObject.getString("address");
                                    String location = jsonObject.getString("location");
                                    String pname = jsonObject.getString("pname");
                                    String cityname = jsonObject.getString("cityname");
                                    String adname = jsonObject.getString("adname");

                                    communityKeDetailGaodeAddress.setTitleGaode(name);
                                    communityKeDetailGaodeAddress.setAddressGaode(address);
                                    communityKeDetailGaodeAddress.setLocationGaode(location);
                                    communityKeDetailGaodeAddress.setProvinceGaode(pname);
                                    communityKeDetailGaodeAddress.setCityGaode(cityname);
                                    communityKeDetailGaodeAddress.setRegionGaode(adname);
                                    communityKeDetailGaodeAddress.setSource("v2.0");

                                    int i = communityKeDetailGaodeAddressMapper.insertSelective(communityKeDetailGaodeAddress);
                                    if(i==1){
                                        communityKe17cityAbcd.setSource("1");
                                        communityKe17cityAbcdMapper.updateByPrimaryKeySelective(communityKe17cityAbcd);
                                    }

                                }
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
        while (executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");

    }



}

