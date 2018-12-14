import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.utils.*;
import com.tt.service.AnjukeCommunityService;
import com.tt.service.IDownLoadPage;
import com.tt.service.IEssUploadService;
import com.tt.service.JedisClientService;
import com.tt.vo.AnjukeParamsVo;
import com.tt.vo.Context;
import com.tt.vo.UrlType;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class test {

    @Autowired
    private AnjukeCommunityService anjukeCommunityService;

    @Autowired
    private JedisClientService jedisClientService;


    @Autowired
    private IEssUploadService essUploadService;

    //redis中存放分页链接的key
    public static final String KEY_URL = "queueUrl";

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;


    @Test
    public void test(){
        String n = "https://ajax.ke.com/map2/search/ershoufang/";
        Map<String,String> a=new HashMap<>();
        a.put("city_id","310000");//从页面中获取
        a.put("group_type","bizcircle");
        a.put("max_lat","31.249813899272");
        a.put("min_lat","31.194663");
        a.put("max_lng","121.51618798431");
        a.put("min_lng","121.463281");
        a.put("filters","{}");//从页面中获取
        a.put("request_ts",new Date().getTime()+"");//时间戳

        String time=new Date().getTime()+"";
        System.out.println(time);
        String md5 = getMd5(a);

    }

    public String getMd5(Map<String,String> map){
        String I = "";
        String a[]=new String[8];
        int j=0;
        for (String s : map.keySet()) {
            a[j]=s;
            j++;
        }
        Arrays.sort(a);

        for (int i=0;i<a.length;i++) {
            String t=a[i];
            if(!"filters".equals(t)){
                I += t + "=" + map.get(t);
            }
        }

        System.out.println(I);
        String s = DigestUtils.md5Hex("0p1pfev3vszn4d91rvn9sis797tl07ay"+I);

        System.out.println(s);
        return s;
    }
    @Test
    public void testss(){
        String url="http://bj.ershoufang.zhuge.com/jiaoyi/1023897/1";
        Map<String, String> map = new HashMap<>();
       /* map.put("cookie","aQQ_ajkguid=7741283B-F507-0499-6879-A73073DC5D1B; _ga=GA1.2.662289424.1539050759; 58tj_uuid=148cede9-c571-4c31-8ccf-ff413f04ce4c; als=0; isp=true; wmda_uuid=fd717993d2bcf0e445a72ae1ddb084e4; wmda_new_uuid=1; wmda_visited_projects=%3B6289197098934; Hm_lvt_c5899c8768ebee272710c9c5f365a6d8=1542175351,1542780404; ctid=26; browse_comm_ids=227613%7C880431%7C272656%7C227458%7C237240; propertys=osrjff-pij75v_onrxuk-pij5lf_otgkbh-pij5k5_oqw71c-pij5he_opg2f5-pij4u0_om1uc8-pij4r7_; lps=http%3A%2F%2Fwww.anjuke.com%2F%3Fpi%3DPZ-baidu-pc-all-biaoti%7C; twe=2; sessid=0C834FF3-0DED-D286-7FFF-A3C0793DAACF; _gid=GA1.2.1656060718.1543223458; wmda_session_id_6289197098934=1543225977348-bdb83785-8ecf-a1eb; init_refer=https%253A%252F%252Fzhengzhou.anjuke.com%252F%253Fpi%253DPZ-baidu-pc-all-biaoti; new_uv=89; __xsptplusUT_8=1; new_session=0; __xsptplus8=8.95.1543225977.1543226558.10%232%7Cwww.baidu.com%7C%7C%7C%25E9%2583%2591%25E5%25B7%259E%25E6%2588%25BF%25E4%25BB%25B7%7C%23%237rbmXkQSi_V9QPVDTxDAxSg5c-vTHssC%23");
        map.put("referer","https://zhengzhou.anjuke.com");
        map.put(":authority","zhengzhou.anjuke.com");*/
        map.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        map.put("Accept-Language","zh-CN,zh;q=0.9");
        map.put("Accept-Encoding","gzip, deflate");
        map.put("If-None-Match","W/125e-8pYtdxwALKZH7kOMgUjllg");
        map.put("X-Requested-With","XMLHttpRequest");
        map.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");

        String result = HttpClientUtils.get("http://www.njhouse.com.cn/upload/chart/3/8eda6cb07ecc83f519672b4950b16a40.jpg", "UTF-8", map, null);
        System.out.println(result);
    }

    @Test
    public void tetsss1() throws Exception{
        // 此例子需要 httpclient4.5.3 以上版本
        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
        String hostName = iPoolProxy.getHostName();
        int port = iPoolProxy.getPort();

        String ProxyAddr = hostName;         // 代理地址
        int ProxyPort = port;               // 端口
        String ProxyUser = "1752203729";           // 平台帐号
        String ProxyPasswd = "848166546";         // 密码

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(ProxyAddr, ProxyPort),
                new UsernamePasswordCredentials(ProxyUser, ProxyPasswd));

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();
        try {
            HttpHost proxy = new HttpHost(ProxyAddr, ProxyPort);

            RequestConfig config = RequestConfig.custom()
                    .setProxy(proxy)
                    .build();
            HttpGet httpget = new HttpGet("https://www.ctrip.com/?allianceid=13963&sid=457771");
            httpget.setConfig(config);

            CloseableHttpResponse response = httpclient.execute(httpget);
            response.setLocale(Locale.CHINESE);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));

            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

    @Test
    public void parseTest(){
        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
        //获取Driver对象
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtils.openChrome(iPoolProxy);
            String indexUrl="http://www.tmsf.com/index.jsp";
            //请求页面
            webDriver.get(indexUrl);

            webDriver.get("http://www.tmsf.com/newhouse/property_searchall.htm");


            String pageSource = webDriver.getPageSource();
            System.out.println(pageSource);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退出
            webDriver.quit();
        }
    }



    @Test
    public void goSeeds(){
        /*String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};*/
        String[] citys={"成都"};
        for (String city : citys) {
            String cityPin = Pinyin4Util.parse13City(city);
            if (StringUtils.isBlank(cityPin)) {
                continue;
            }
            String url = "https://" + cityPin + ".anjuke.com/community/?from=esf_list_navigation";
            AnjukeParamsVo anjukeParamsVo = new AnjukeParamsVo();
            Map<String, String> map = new HashMap<>();
            map.put("city",city);
            anjukeParamsVo.setUrl(url);
            anjukeParamsVo.setHttpType(UrlType.GET);
            anjukeParamsVo.setUrkType(UrlType.ANJUKE_COMMUNITY_INDEX);
            //携带详情信息
            anjukeParamsVo.setDetail(map);
            jedisClientService.addObjectToList(KEY_URL,anjukeParamsVo);
        }
        System.out.println("放入初始链接结束");
    }

    @Test
    public  void upLoad() throws Exception {
    /*Map map = getImageInfoByImageReader("D:\\:\\data.json");
       System.out.println(JSO(ln(JSON.tsrcoJSONString(ing(map));*/
        Context context = new Context();
        String  src= "http://www.njhouse.com.cn/upload/chart/3/8eda6cb07ecc83f519672b4950b16a40.jpg";

        URL url = new URL(src);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(10000);
        con.setRequestProperty("User-Agent", UserAgentUtils.randomGet());
        InputStream is = con.getInputStream();
        System.out.println(is);



       /* String name = "fang/310000/community/"+ MD5.encrypt(src,"") +".jpg";
        byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",src));

        context.setFilename(name);
        context.setData(data);
        context.setContenttype("image/jpeg");
        System.out.println(name);
        System.out.println(essUploadService.fileUpload(context));*/
    }


    @Test
    public void getListTest() {
        System.out.println("获取代理ip");
        String url="https://h.wandouip.com/get/ip-list?pack=894&num=20&xy=1&type=2&lb="+ URLEncoder.encode("\\r\\n")+"&mr=2&";
        String ipStr = PageDownLoadUtil.httpClientDefultGet(url);
        long nowTime = System.currentTimeMillis();
        try {
            JSONObject object = JSON.parseObject(ipStr);
            if(object.getInteger("code")==200){
                JSONArray data = object.getJSONArray("data");
                if(data!=null && data.size()!=0){
                    for (int i = 0; i < data.size(); i++) {
                        JSONObject jsonObject = data.getJSONObject(i);
                        String ip = jsonObject.getString("ip");
                        Integer port = jsonObject.getInteger("port");
                        String expireTime = jsonObject.getString("expire_time");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date parseTime = simpleDateFormat.parse(expireTime);
                        long time = parseTime.getTime();
                        Long expire=(time - nowTime)/1000;
                        int ex = expire.intValue();
                        System.out.println(ip+":"+port+"---"+ex);
                        System.out.println(ex > 0);
                        if(ex > 0){
                            RedisUtil.setex("PROXY_IP_REDIS_KEY"+ip+":"+port,ex,"1");
                        }

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
