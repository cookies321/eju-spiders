package beike;

import com.tt.common.DownLoadPage;
import com.tt.service.JedisClientService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 根据输入的城市，获取城市的cityId
 */
public class Ke_city {

    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

    static JedisClientService jedisClientService = (JedisClientService)applicationContext.getBean("jedisClientServiceImpl");

    /**
     * 将城市cityid,存入redis中
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> cityIdAndCityName = getCityIdAndCityName();
        for (String cityName : cityIdAndCityName.keySet()) {
            jedisClientService.set(cityName,cityIdAndCityName.get(cityName));
            System.out.println(cityName+"--------"+cityIdAndCityName.get(cityName));
        }
    }
    /**
     * 根据城市的主页url获取cityid
     * @return
     */
    public static Map<String, String> getCityIdAndCityName() throws InterruptedException {
        //获取到cityName-cityUrl
        Map<String, String> map = new HashMap<>();
        Map<String, Object> cityUrlMap = getCityUrl();
        if(cityUrlMap!=null){
            final int fixedNum = 4;
            Semaphore semaphore = new Semaphore(fixedNum);
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);

            for (String cityName : cityUrlMap.keySet()) {
                semaphore.acquire();
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String cityUrl = (String) cityUrlMap.get(cityName);
                            Document document = DownLoadPage.downLoadPage(cityUrl);
                            if(document!=null){
                                String cityId = parseCityIndexPage(document);
                                map.put(cityName,cityId);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            semaphore.release();
                        }
                    }
                });
            }
            fixedThreadPool.shutdown();
            while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS)) ;
        }
        return map;
    }

    /**
     * 根据城市的主页url获取cityid
     * @param document
     * @return
     */
    public static String parseCityIndexPage(Document document){
        String html = document.html();
        int i = html.indexOf("city_id: '");
        if(i!=-1){
            int j = html.indexOf("',", i);
            if(j!=-1){
                String cityId = html.substring(i+10, j);
                return cityId;
            }
        }
        return null;
    }

    /**
     * 解析站点城市页面，获取定位站点的主页信息
     * @return
     */
    public static Map<String,Object> getCityUrl(){
        String cityUrl="https://www.ke.com/city/";
        Map<String, Object> map = new HashMap<>();
        Document document = DownLoadPage.downLoadPage(cityUrl);
        if(document!=null){
            map = parseCityPage(document);
        }
        return map;
    }

    /**
     * 解析城市页面，获取城市的链接
     * @param document
     * @return
     */
    public static Map<String,Object> parseCityPage(Document document){
        Map<String, Object> map = new HashMap<>();
        Elements select = document.select("div.city_list_section>ul.city_list_ul>li");
        if(select!=null){
            for (Element element : select) {
                Elements select1 = element.select("div.city_list>div.city_province>ul>li.CLICKDATA>a");
                if(select1!=null){
                    for (Element element1 : select1) {
                        String city = element1.text();
                        String cityUrl = element1.attr("href");
                        if(StringUtils.isNotBlank(city) && StringUtils.isNotBlank(cityUrl)){
                            if((!cityUrl.contains("fang")) && (!cityUrl.contains("i.ke.com"))){
                                System.out.println(city+"----"+"https:"+cityUrl);
                                map.put(city,"https:"+cityUrl);
                            }
                        }
                    }

                }
            }
        }
        return map;
    }
}
