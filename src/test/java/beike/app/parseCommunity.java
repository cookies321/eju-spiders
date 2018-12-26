package beike.app;

import com.tt.common.utils.*;
import com.tt.service.IDownLoadPage;
import org.apache.http.HttpHost;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.ProxySelector;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/18 17:24
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseCommunity {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;

    /**
     *
     * 功能描述: 获取杭州小区列表数据
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/19 17:35
     */
    @Test
    public void parseIndex() throws InterruptedException {
        //String communityUrl="https://app.api.ke.com/yezhu/publish/getBuildings?community_id=1811043642571";
        //String buildUrl="https://app.api.ke.com/yezhu/publish/getUnits?building_id=1812046041105";
        //String unitUrl="https://app.api.ke.com/yezhu/publish/getHouses?unit_id=1810001430622847";
        /*HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
        map.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
        String s = HttpClientUtils.get(buildUrl, "UTF-8",map,mouGuProxy);*/

        String indexUrl="https://app.api.ke.com/house/community/search?limit_offset=0&city_id=330100&limit_count=50";
        String regionUrl="https://app.api.ke.com/house/community/search?limit_offset=0&city_id=330100&region={\"group\":\"bizcircle\",\"id\":\"611100177\",\"key\":\"gudang/\",\"name\":\"古荡\"}&limit_count=20";
        String detailUrl1="https://app.api.ke.com/house/resblock/detailpart1?id=1811063919693";
        String detailUrl2="https://app.api.ke.com/house/resblock/detailpart2?id=1811063919693";
        System.out.println(regionUrl);
        String authorization = BeikeAppUtils.getAuthorization(regionUrl);
        Map<String, String> map = new HashMap<>();
        System.out.println(authorization);
        map.put("Authorization", authorization);
        String substring = regionUrl.substring(regionUrl.indexOf("region=") + 7, regionUrl.indexOf("&limit_count"));
        System.out.println(substring);
        String regionUrl2="https://app.api.ke.com/house/community/search?limit_offset=0&city_id=330100&region="+URLEncoder.encode(substring)+"&limit_count=20";
        Document document = iDownLoadPage.downLoadPageByGet(regionUrl2, map);
        if(document!=null){
            System.out.println(document.select("body").html());
        }


        /*AtomicInteger atom = new AtomicInteger(1);
        Integer count=4;
        Semaphore semaphore = new Semaphore(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (String unitUrl : list) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(atom.getAndIncrement());
                        System.out.println(unitUrl);
                        String authorization = BeikeAppUtils.getAuthorization(unitUrl);
                        Map<String, String> map = new HashMap<>();
                        System.out.println(authorization);
                        map.put("Authorization", authorization);
                        Document document = iDownLoadPage.downLoadPageByGet(unitUrl, map);
                        if (document != null) {
                            String text = document.select("body").text();
                            System.out.println(text);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }*/
        /*for (String unitUrl : list) {
            HttpHost httpHost = new HttpHost("183.129.244.16", 32703);
            //map.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
            String authorization = BeikeAppUtils.getAuthorization(unitUrl);
            Map<String, String> map = new HashMap<>();
            System.out.println(unitUrl);
            map.put("Authorization",authorization);
            System.out.println(authorization);
            String s = HttpClientUtilsnew.get(unitUrl, "UTF-8",map, httpHost);
            System.out.println(s);
        }*/


    }

}
