import com.tt.common.utils.HttpClientUtils;
import com.tt.common.utils.ProxyUtils;
import org.apache.http.HttpHost;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 蘑菇代理性能测试
 */
public class ProxyperFormanceTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        long startTime = System.currentTimeMillis();
        String url="https://www.baidu.com/";
        Map<String,String> headers=new HashMap<>();
        /*headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");*/
        headers.put("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
        HttpHost mouGuProxy = ProxyUtils.getIPoolProxy();
        /* HashMap<String, String> map = new HashMap<>();
        map.put(":authority","shenzhen.anjuke.com");
        map.put(":method","GET");
        map.put(":scheme","https");
        map.put("cookie","aQQ_ajkguid=7741283B-F507-0499-6879-A73073DC5D1B; _ga=GA1.2.662289424.1539050759; 58tj_uuid=148cede9-c571-4c31-8ccf-ff413f04ce4c; als=0; isp=true; wmda_uuid=d6dff1293ab19062bbd06cf4c876e6f9; wmda_new_uuid=1; wmda_visited_projects=%3B6289197098934; twe=2; sessid=46CB940A-AF44-C26F-A1F2-D41F5622256A; lps=http%3A%2F%2Fshenzhen.anjuke.com%2Fcommunity%2F%3Ffrom%3Desf_list_navigation%7C; init_refer=; new_uv=73; _gid=GA1.2.1846166033.1542171713; new_session=0; Hm_lvt_c5899c8768ebee272710c9c5f365a6d8=1542175351; lp_lt_ut=c4c35f28747704d1c2bd50e5b2d10e8d; Hm_lpvt_c5899c8768ebee272710c9c5f365a6d8=1542175709; ajk_member_captcha=10a7fd736c78c342dee52438857e75d6; ctid=17; wmda_session_id_6289197098934=1542176375784-078764e7-2b5b-52d7; __xsptplusUT_8=1; __xsptplus8=8.78.1542171424.1542177581.43%232%7Csp0.baidu.com%7C%7C%7C%25E5%25AE%2589%25E5%25B1%2585%25E5%25AE%25A2%7C%23%237FsQXyN9SS-R9yqQ62ggT_S65BVKZyDG%23");
        map.put("referer","https://tianjin.anjuke.com/sale/?from=navigation");
        map.put("upgrade-insecure-requests","1");
        map.put("cache-control","max-age=0");
        map.put("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");*/
        String html = HttpClientUtils.get("http://h.wandouip.com/get/ip-list?pack=817&num=20&xy=2&type=1&lb=\\r\\n&mr=2&",null,null);
        System.out.println(html);

       /* System.out.println(startTime);
        String url="http://androidapi.realtynavi.com/v2/android/Deal/getbargainnewdisklist";
        Map<String,String> headers=new HashMap<>();
        headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");

        headers.put("Date","Thu, 08 Nov 2018 03:15:55 GMT+00:00");
        headers.put("Accept","application/json; charset=UTF-8");
        headers.put("Content-Type","application/x-www-form-urlencoded");
        headers.put("X-Ca-Signature-Headers","X-Ca-Timestamp,X-Ca-Key");
        headers.put("X-Ca-Key","24839553");
        headers.put("X-Ca-Signature","K9K46fJ/jlxCf9WwL8HX9o6krCbH/YzngYaG/GCi1FA=");
        //时间戳
        headers.put("X-Ca-Timestamp","1541646955942");

        headers.put("User-Agent","okhttp/3.9.0");
        headers.put("Accept-Encoding","gzip");



        HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();

        Map<String,String> params=new HashMap<>();
        params.put("lng","121.456777");
        params.put("lat","31.278339");
        params.put("pricerange","0");
        params.put("daterange","0");
        params.put("pageindex","1");
        params.put("pagesize","15");
        params.put("livablestar","0");
        params.put("greeningrate","0");
        params.put("plotratio","0");

        String html2 = HttpClientUtils.post(url,params,headers,mouGuProxy);
        System.out.println(html2);*/


        long endTime = System.currentTimeMillis();
        System.out.println("所用时长========"+(endTime-startTime)+"ms");

        /*long startTime = System.currentTimeMillis();
        System.out.println("开始+++++++"+startTime);
        String attr[]={"https://shanghai.anjuke.com/",
                "https://sh.lianjia.com/",
                "https://sh.ke.com/",
                "http://sh.fang.com/",
                "https://shanghai.qfang.com/",
                "http://sh.baletu.com/",
                "https://sh.5i5j.com/",
                "http://sh.ganji.com/fang/",
                "https://sh.58.com/house.shtml",
                "http://sh.house365.com/"};
        for (String s : attr) {
            String s1 = PageDownLoadUtil.httpClientQuanGet(s);
            System.out.println(s1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("结束+++++"+endTime);
        System.out.println("所用时长========"+(endTime-startTime)+"ms");*/

    }




    /*public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("开始+++++++"+startTime);
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < 21; i++) {
            list.add("https://shanghai.anjuke.com/community/beicai/");
            list.add("https://shanghai.anjuke.com/community/beicai/p2/");
            list.add("https://shanghai.anjuke.com/community/view/990111");
            list.add("https://shanghai.anjuke.com/community/photos2/b/990111");
        }
        Integer threadNum=6;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (final String url : list) {
            for (int i = 1; i <=threadNum; i++) {
                new Thread(new Runnable() {
                    public void run() {

                        try {
                            PageDownLoadUtil.httpsClientProxy(url);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }).start();
            }
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("结束+++++"+endTime);
        System.out.println("所用时长========"+(endTime-startTime)+"ms");

    }*/
    /*public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("开始+++++++"+startTime);
        final List<String> list=new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("https://shanghai.anjuke.com/community/beicai/");
        }
        Integer threadNum=8;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNum);
        for (final String url : list) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //等待所有任务都结束了继续执行
        executor.shutdown();
        // 等待子线程结束，再继续执行下面的代码
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        long endTime = System.currentTimeMillis();
        System.out.println("结束+++++"+endTime);
        System.out.println("任务结束了"+(endTime-startTime)+"ms");
    }*/

}
