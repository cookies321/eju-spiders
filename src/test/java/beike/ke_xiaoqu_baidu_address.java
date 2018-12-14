package beike;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.dao.CommunityKeDetailBaiduAddressMapper;
import com.tt.entity.CommunityKeDetailBaiduAddress;
import com.tt.entity.CommunityKeDetailBaiduAddressExample;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/19 15:57
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ke_xiaoqu_baidu_address {

    private static final Logger LOGGER = LoggerFactory.getLogger(ke_xiaoqu_baidu_address.class);

    @Autowired
    private JedisClientService jedisClientService;

    @Autowired
    private CommunityKeDetailBaiduAddressMapper communityKeDetailBaiduAddressMapper;

    @Test
    public void getBaiduAddress() throws InterruptedException {
        //https://map.baidu.com/?newmap=1&from=webmap&qt=s&wd=%E9%A6%99%E6%BA%AA%E5%AE%B6%E5%9B%AD&c=218
        //https://map.baidu.com/?newmap=1&from=webmap&qt=s&wd=%E9%A6%99%E6%BA%AA%E5%AE%B6%E5%9B%AD&c=218
        Map<String, String> mapCityCode = new HashMap<>();
        String url="https://map.baidu.com/?newmap=1&from=webmap&qt=s&wd=";
        CommunityKeDetailBaiduAddressExample communityKeDetailBaiduAddressExample = new CommunityKeDetailBaiduAddressExample();
        CommunityKeDetailBaiduAddressExample.Criteria criteria = communityKeDetailBaiduAddressExample.createCriteria();
        criteria.andSourceIsNull();
        List<CommunityKeDetailBaiduAddress> communityKeDetailBaiduAddresses = communityKeDetailBaiduAddressMapper.selectByExample(communityKeDetailBaiduAddressExample);

        if(CollectionUtils.isNotEmpty(communityKeDetailBaiduAddresses)){

            final int fixedNum = 6;
            Semaphore semaphore = new Semaphore(fixedNum);
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);
            for (CommunityKeDetailBaiduAddress communityKeDetailBaiduAddress : communityKeDetailBaiduAddresses) {
                semaphore.acquire();
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String title = communityKeDetailBaiduAddress.getTitle();
                            String cityName = communityKeDetailBaiduAddress.getCity();
                            if(StringUtils.isNotBlank(title) && StringUtils.isNotBlank(cityName)){
                                String cityCode = mapCityCode.get(cityName);
                                if(StringUtils.isBlank(cityCode)){
                                    cityCode = getBaiduCityCode(cityName);
                                    mapCityCode.put(cityName,cityCode);
                                }
                                String name="";
                                String addressBaidu="";
                                try {
                                    //加入城市code
                                    String href=url+title+"&c="+cityCode;
                                    //String hrefCode = URLEncoder.encode(href, "UTF-8");
                                    Document document = DownLoadPage.downLoadPage(href);
                                    String data = document.select("body").text();
                                    System.out.println(data);
                                    JSONObject object = JSON.parseObject(data);
                                    JSONArray content = object.getJSONArray("content");

                                    if(content.size()>0){
                                        JSONObject object1= (JSONObject)content.get(0);
                                        name = object1.getString("name");
                                        addressBaidu = object1.getString("addr");
                                        System.out.println(name+"-------"+addressBaidu);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if(StringUtils.isNotBlank(addressBaidu)){
                                    communityKeDetailBaiduAddress.setAddressBaidu(addressBaidu);
                                    communityKeDetailBaiduAddress.setSource(name);
                                    communityKeDetailBaiduAddress.setStatus("1");
                                    communityKeDetailBaiduAddress.setCreateTime(new Date());
                                    communityKeDetailBaiduAddressMapper.updateByPrimaryKeySelective(communityKeDetailBaiduAddress);
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
            fixedThreadPool.shutdown();
            while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS)) ;
        }
    }

    /**
     * 根据城市名称获取城市code
     * @param cityName
     * @return
     */
    private String getBaiduCityCode(String cityName) {
        //https://map.baidu.com/?qt=cur&wd=%E4%B8%8A%E6%B5%B7&t=1540174174292&dtype=1
        String url="https://map.baidu.com/?qt=cur&wd="+cityName;
        Document document = DownLoadPage.downLoadPage(url);
        if(document!=null){
            try {
                String dataStr = document.select("body").text();
                JSONObject object = JSON.parseObject(dataStr);
                String cur_area_id = object.getString("cur_area_id");
                if(StringUtils.isNotBlank(cur_area_id)){
                    return cur_area_id;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
