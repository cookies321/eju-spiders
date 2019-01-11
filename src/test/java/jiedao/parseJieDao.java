package jiedao;

import com.tt.common.utils.OkHttpDownLoadUtil;
import com.tt.dao.CityStreetMapper;
import com.tt.entity.CityStreet;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * @Auther: 赵乐
 * @Date: 2019/1/8 13:58
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseJieDao {

    @Autowired
    private CityStreetMapper cityStreetMapper;

    @Test
    public void parseDetail() throws InterruptedException {
        OkHttpDownLoadUtil okHttpClient = OkHttpDownLoadUtil.createOkHttpClient();
        Map<String,String> map=new HashMap<>();
        map.put("南京","http://nanjing.city8.com/road/");
        map.put("上海","http://sh.city8.com/road/");
        map.put("北京","http://bj.city8.com/road/");
        map.put("合肥","http://hefei.city8.com/road/");
        map.put("天津","http://tj.city8.com/road/");
        map.put("广州","http://gz.city8.com/road/");
        map.put("成都","http://cd.city8.com/road/");
        map.put("杭州","http://hz.city8.com/road/");
        map.put("武汉","http://wh.city8.com/road/");
        map.put("沈阳","http://shenyang.city8.com/road/");
        map.put("济南","http://jn.city8.com/road/");
        map.put("深圳","http://sz.city8.com/road/");
        map.put("苏州","http://suzhou.city8.com/road/");
        map.put("西安","http://xa.city8.com/road/");
        map.put("重庆","http://chongqing.city8.com/road/");
        map.put("郑州","http://zz.city8.com/road/");
        map.put("青岛","http://qd.city8.com/road/");
        Semaphore semaphore = new Semaphore(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (String city : map.keySet()) {
            String url = map.get(city);
            String hostName=url.replace("/road/","");
            String html = okHttpClient.proxyGet(url);
            Document document = Jsoup.parse(html);
            if(document!=null){
                Elements select = document.select("div.lette_sorting>div.lette_test>a");
                if(!select.isEmpty()){
                    for (Element element : select) {
                        semaphore.acquire();
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    String index = element.text();
                                    if(StringUtils.isNotBlank(index)){
                                        String indexUrl=url+index+"/";
                                        System.out.println(indexUrl);
                                        if(StringUtils.isNotBlank(indexUrl)){
                                            String htm = okHttpClient.proxyGet(indexUrl);
                                            if(StringUtils.isNotBlank(htm)){
                                                Document parse = Jsoup.parse(htm);
                                                if(parse!=null){
                                                    Elements select1 = parse.select("div.main_left>div.road_sahngjia.road_zm_list>a");
                                                    if(!select1.isEmpty()){
                                                        for (Element element1 : select1) {
                                                            String href = element1.attr("href");
                                                            if(StringUtils.isNotBlank(href)){
                                                                String streetUrl = hostName + href;
                                                                String street = element1.text();
                                                                System.out.println(streetUrl+"----"+street);
                                                                CityStreet cityStreet = new CityStreet();
                                                                cityStreet.setId(UUID.randomUUID().toString());
                                                                cityStreet.setCreateTime(new Date());
                                                                cityStreet.setCity(city);
                                                                cityStreet.setCityUrl(url);
                                                                cityStreet.setIndexText(index);
                                                                cityStreet.setIndexUrl(indexUrl);
                                                                cityStreet.setStreet(street);
                                                                cityStreet.setStreetUrl(streetUrl);
                                                                cityStreetMapper.insertSelective(cityStreet);
                                                            }
                                                        }
                                                    }
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
                }
            }

        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }
}
