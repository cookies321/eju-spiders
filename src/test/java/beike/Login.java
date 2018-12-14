package beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.jetty.util.URIUtil.HTTPS;

/**
 * @author NJ
 * @create 2018-08-31 9:49
 **/
public class Login {
    private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);
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
            cm.setMaxTotal(200);//max connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        String url = "https://upassport.lianjia.com/login";
//        HttpClient httpClient = new HttpClient();
//
//        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
//        PostMethod postMethod = new PostMethod(url);
//        // 设置登陆时要求的信息，用户名和密码
//        NameValuePair[] data = {new NameValuePair("username", "18516262188"), new NameValuePair("password", "ni55275730"),
//                new NameValuePair("service", "[{\"key\":\"service\",\"value\":\" https://ajax.api.lianjia.com/login/login/getuserinfo\",\"type\":\"text\",\"enabled\":true,\"description\":\"\"}]"),
//                new NameValuePair("isajax", "true"), new NameValuePair("", ""), new NameValuePair("", "")};
//        postMethod.setRequestBody(data);
//
//        // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
//        try {
//            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
//            int statusCode = httpClient.executeMethod(postMethod);
//
//            // 获得登陆后的 Cookie
//            Cookie[] cookies = httpClient.getState().getCookies();
//            StringBuffer tmpcookies = new StringBuffer();
//            for (Cookie c : cookies) {
//                tmpcookies.append(c.toString() + ";");
//                System.out.println("cookies = " + c.toString());
//            }
//            if (statusCode == 302) { //重定向到新的URL
//                System.out.println("模拟登录成功");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public List<String> getCookie() {
        List<String> result = new ArrayList<>();

        Map<String, String> userMap = new HashMap<>();
        userMap.put("18516262188", "ni55275730");
        userMap.put("15800380039", "a12345678");
        userMap.put("18116212736", "123QWEasd");
        userMap.put("15618660226", "ejucy2018");
        userMap.put("18717955209", "ej890iop");
        userMap.put("15221801885", "ejucy19920826");
        userMap.put("18721174109", "ejucy2018");
        userMap.put("18017679712", "EJLJxian0917");


        for (Map.Entry entry : userMap.entrySet()) {
            String url = "https://upassport.lianjia.com/login";  //post请求
            Map<String, String> ticket = getTicket(entry.getKey().toString());
            if (ticket != null && !ticket.isEmpty()) {  //ticket不为空
                String lt = ticket.get("lt");
                String execution = ticket.get("execution");
                if (StringUtils.isNotEmpty(lt) && StringUtils.isNotEmpty(execution)) {  //当都不为空的时候

                    Map<String, String> params = new HashMap<>();
                    params.put("username", entry.getKey().toString());
                    params.put("password", entry.getValue().toString());
                    params.put("code", "");
                    params.put("service", "https://ajax.api.lianjia.com/login/login/getuserinfo");
                    params.put("isajax", "true");
                    params.put("_eventId", "submit");
                    params.put("remember", "1");
                    params.put("lt", lt);
                    params.put("execution", execution);

                    String cookie = null;
                    while (true) {
                        try {
                            cookie = getLoginCookie(url, params, headersMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (StringUtils.isNotEmpty(cookie) && cookie.contains("token")) {
                            result.add(cookie);
                            break;
                        }
                    }
                }
            }
        }
        return result;
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


    /**
     * 获取Ticket
     *
     * @return
     */
    public Map<String, String> getTicket(String mobileNum) {
        Map<String, String> result = new HashMap<>();
        if (StringUtils.isEmpty(mobileNum)) {
            return null;
        }
        String ticketUrl = "https://upassport.lianjia.com/login";

        Map<String, String> params = new HashMap<>();
        params.put("service", "https://ajax.api.lianjia.com/login/login/getuserinfo");
        params.put("type", "1");
        params.put("get-lt", "true");
        params.put("isajax", "true");
        params.put("from", "lianjiaweb");
        params.put("username", mobileNum);

        String data = doGet(ticketUrl, params);
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        try {
            JSONObject jsonObject = JSON.parseObject(data);
            if (StringUtils.isNotEmpty(jsonObject.getString("code"))) {
                if (jsonObject.getString("code").equals("1")) {  //请求成功
                    result.put("lt", jsonObject.getString("data"));
                    result.put("execution", jsonObject.getString("execution"));
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String doGet(String url, Map<String, String> params) {
//        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpClient httpClient = null;
        String responseString = null;

        HttpHost proxy = new HttpHost("transfer.mogumiao.com", 9001, "http");
        RequestConfig requestConfig = RequestConfig.custom()
//                .setProxy(proxy)
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
                    LOGGER.warn("encode http get params error, value is " + value, e);
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
        try {
            httpClient = getHttpClient();
            CloseableHttpResponse response = httpClient.execute(get);
            String cookie = setCookie(response);
            headersMap.put("Cookie", cookie);
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
                LOGGER.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
                return responseString;
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (SocketTimeoutException e) {
            LOGGER.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
            return responseString;
        } catch (Exception e) {
            LOGGER.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
        } finally {
            get.releaseConnection();
        }
        return responseString;
    }

    /**
     * @return
     */
    public String getLoginCookie(String url, Map<String, String> params, Map<String, String> headers) {
        String responseContent = null;
        CloseableHttpClient httpClient = null;

        HttpPost httpPost = new HttpPost(url);
        try {
            httpClient = getHttpClient();
            headers.put("Proxy-Authorization", "Basic " + Constants.MOGU_KEY);
            HttpHost proxy = new HttpHost("transfer.mogumiao.com", 9001, "http");

            RequestConfig requestConfig = RequestConfig.custom()
//                    .setProxy(proxy)
                    .setSocketTimeout(CONNECT_TIMEOUT)
                    .setConnectTimeout(CONNECT_TIMEOUT)
                    .setConnectionRequestTimeout(CONNECT_TIMEOUT).build();

            httpPost.setConfig(requestConfig);

            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            // 绑定到请求 Entry
            for (Map.Entry<String, String> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));

            // 加header
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String cookie = setCookie(response);
            headersMap.put("Cookie", cookie);
            if (response != null) {
                response.close();
            }
            return cookie;
        } catch (ClientProtocolException e) {
            LOGGER.error("ClientProtocolException", e);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        } catch (Exception e) {
        } finally {
            httpPost.releaseConnection();
        }
        return responseContent;
    }

    public static CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }


}
