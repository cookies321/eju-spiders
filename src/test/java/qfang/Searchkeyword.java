package qfang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.Constants;
import com.tt.common.utils.Pinyin4Util;
import com.tt.common.utils.ProxyUtils;
import com.tt.dao.QfangXiaoquNotFiveYearMapper;
import com.tt.entity.QFangXiaoqu;
import com.tt.entity.QFangXiaoquExample;
import com.tt.entity.QfangXiaoquNotFiveYear;
import com.tt.entity.QfangXiaoquNotFiveYearExample;
import com.tt.service.IDownLoadPage;
import com.tt.service.QFangXiaoquService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static org.eclipse.jetty.util.URIUtil.HTTPS;

/**
 * @Auther: NJ
 * @Date: 2018/10/8 14:59
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class Searchkeyword {

    @Resource
    private QFangXiaoquService qFangXiaoquService;

    @Resource
    private QfangXiaoquNotFiveYearMapper qfangXiaoquNotFiveYearMapper;

    @Autowired
    @Qualifier("moguProxy")
    private IDownLoadPage iDownLoadPage;

    private final static int CONNECT_TIMEOUT = 20000;

    public static Map<String, String> cookieMap = new HashMap<String, String>(64);
    public static Map<String, String> headersMap = new HashMap<>();
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static final String HTTP = "http";
    private static SSLContextBuilder builder = null;

    static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(2000);//max connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * 功能描述: 根据小区名称搜索别名
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/22 14:22
     */
    @Test
    public void searchKeyword() throws InterruptedException {
        //搜索三成非五年的小区
        QfangXiaoquNotFiveYearExample qfangXiaoquNotFiveYearExample = new QfangXiaoquNotFiveYearExample();
        qfangXiaoquNotFiveYearExample.or().andCityEqualTo("南京").andStatusEqualTo("v3.0").andSearchNameIsNull();
        List<QfangXiaoquNotFiveYear> qfangXiaoquNotFiveYears = qfangXiaoquNotFiveYearMapper.selectByExample(qfangXiaoquNotFiveYearExample);

        if (CollectionUtils.isEmpty(qfangXiaoquNotFiveYears)) {
            return;
        }
        System.out.println(qfangXiaoquNotFiveYears.size());
        final int fixedNum = 4;
        Semaphore semaphore = new Semaphore(fixedNum);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);

        for (QfangXiaoquNotFiveYear xiaoqu : qfangXiaoquNotFiveYears) {
            semaphore.acquire();
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String homeName = xiaoqu.getHomeName();
                        String city = xiaoqu.getCity();
                        String cityPin = Pinyin4Util.parse13City(city);
                        //根据城市的拼音，拼接url
                        //骏丰玲珑坊二期
                        if(StringUtils.isBlank(cityPin)){
                            return;
                        }
                        String indexUrl = "https://m.qfang.com/"+cityPin+"/garden?keyword=%s";
                        String url = "https://m.qfang.com/"+cityPin+"/search/getSearchKeyword";

                        if (StringUtils.isBlank(homeName)) {
                            return;
                        }
                        String cookie = null;
                        try {
                            cookie = doGet(String.format(indexUrl, homeName.replaceAll(" ","")),null);
                            System.out.println("cookie"+cookie);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (StringUtils.isEmpty(cookie)){
                            System.out.println("取cookie是空值============================");

                            for (int i = 1; i < 4; i++) {
                                System.out.println("尝试获取cookie第"+i+"次");
                                cookie = doGet(String.format(indexUrl, homeName.replaceAll(" ","")),null);
                                if(cookie!=null){
                                    break;
                                }
                            }
                            return;
                        }
                        Map<String, String> parmas = new HashMap<>();
                        parmas.put("keyword", homeName.replaceAll(" ",""));
                        parmas.put("type", "GARDEN");
                        parmas.put("ratesType", "ratestype");

                        Map<String, String> headers = new HashMap<>();
                        headers.put("Cookie", cookie);
                        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
                        Document document = iDownLoadPage.downLoadPageByPost(url, parmas,headers);
                        Elements select = document.select("body");
                        if(!select.isEmpty()) {
                            String str = select.text();
                            try {
                                System.out.println(str);
                                JSONObject jsonObject = JSON.parseObject(str);
                                JSONArray dataArr = jsonObject.getJSONArray("data");
                                if (dataArr == null || dataArr.size() == 0) {
                                    xiaoqu.setStatus("v3.0_0");
                                    qfangXiaoquNotFiveYearMapper.updateByPrimaryKeySelective(xiaoqu);
                                    return;
                                }
                                for (Object data : dataArr) {
                                    JSONObject object = JSON.parseObject(JSON.toJSONString(data));

                                    String region = object.getString("parentAreaName");
                                    String plate = object.getString("childAreaName");
                                    String qId = object.getString("id");
                                    String name = object.getString("keyword");
                                    xiaoqu.setqId(qId);
                                    xiaoqu.setRegion(region);
                                    xiaoqu.setPlate(plate);
                                    xiaoqu.setSearchName(name);
                                    xiaoqu.setStatus("v3.0_1");
                                    qfangXiaoquNotFiveYearMapper.updateByPrimaryKeySelective(xiaoqu);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
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
        while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

    public String doGet(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = null;
        String responseString = null;

        HttpHost proxy = new HttpHost("transfer.mogumiao.com", 9001, "http");
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setSocketTimeout(CONNECT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECT_TIMEOUT).build();

        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (params != null) {
            int i = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (i == 0 && !url.contains("?")) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                String value = entry.getValue();
                try {
                    sb.append(URLEncoder.encode(value, "UTF-8"));
//                    sb.append(URLEncoder.encode(value, "GBK"));
                } catch (UnsupportedEncodingException e) {
                    sb.append(URLEncoder.encode(value));
                }
                i++;
            }
        }
        HttpGet get = new HttpGet(sb.toString());
        get.setConfig(requestConfig);

        // 加header
        Map<String, String> headers = new HashMap();
        headers.put("Proxy-Authorization", "Basic " + Constants.MOGU_KEY);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                get.addHeader(entry.getKey(), entry.getValue());
            }
        }
        String cookie = null;
        try {
            httpClient = getHttpClient();
            CloseableHttpResponse response = httpClient.execute(get);
            cookie = setCookie(response);
//            headersMap.put("Cookie", cookie);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, "UTF-8");
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                return responseString;
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (SocketTimeoutException e) {
            return responseString;
        } catch (Exception e) {
        } finally {
            get.releaseConnection();
        }
        return cookie;
    }

    //从响应信息中获取cookie
    public static String setCookie(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        if (headers == null || headers.length == 0) {
            System.out.println("----there are no cookies");
            return null;
        }
        String cookie = "";
        for (int i = 0; i < headers.length; i++) {
            cookie += headers[i].getValue();
            if (i != headers.length - 1) {
                cookie += ";";
            }
        }

        String[] cookies = cookie.split(";");
        for (String c : cookies) {
            c = c.trim();
            if (cookieMap.containsKey(c.split("=")[0])) {
                cookieMap.remove(c.split("=")[0]);
            }
            cookieMap.put(c.split("=")[0], c.split("=").length == 1 ? "" : (c.split("=").length == 2 ? c.split("=")[1] : c.split("=", 2)[1]));
        }
        String cookiesTmp = "";
        for (String key : cookieMap.keySet()) {
            cookiesTmp += key + "=" + cookieMap.get(key) + "; ";
        }
        cookie = cookiesTmp.substring(0, cookiesTmp.length() - 1);
        return cookie;
    }

    public static CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }

    public void sstesy() {
        for (int i = 0; i < 10; i++) {
            String indexUrl = "https://m.qfang.com/shanghai/garden?keyword=%s";
            String cookie = doGet(String.format(indexUrl, "金桥新村五街坊"),null);
            System.out.println(cookie);
        }
    }


}
