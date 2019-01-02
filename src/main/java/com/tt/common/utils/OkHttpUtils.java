package com.tt.common.utils;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author linxi
 */
public class OkHttpUtils {

    //private static Logger log = Logger.getLogger(OkHttpUtils.class);
    private static Integer connTimeoutDefault = 2000;
    private static Integer readTimeoutDefault = 2000;

    public enum Charset{
        UTF_8("UTF-8"),GBK("GBK");
        private String value;
        Charset(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum HttpType{
        GET("get"),POST_JSON("post-json"),POST_FROM("post-from");

        private String value;
        HttpType(String value){
            this.value = value;
        }

    }

    private OkHttpUtils() {
    }

    private static class SingleOkHttp {
        public static final OkHttpClient instance = new OkHttpClient();
    }

    public static Integer getStatusCode(String url, Integer connTimeout, Integer readTimeout, Map<String, String> headers, HttpHost proxyServer) {
        Integer resultBody = -999;
        try {
            Response response = getResponse(url,HttpType.GET,null,connTimeout, readTimeout, headers,null, proxyServer);
            resultBody = response.code();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return resultBody;
    }

    public static String get(String url) {
        return get(url, Charset.UTF_8, connTimeoutDefault, readTimeoutDefault, null, null);
    }

    public static String get(String url, Charset charset, Map<String, String> headers, HttpHost proxyServer) {
        return get(url, charset, connTimeoutDefault, readTimeoutDefault, headers, proxyServer);
    }

    public static String post(String url, String json) {
        return postJson(url, json, Charset.UTF_8, connTimeoutDefault, readTimeoutDefault, null, null);
    }

    public static String post(String url, String json, Charset charset, Map<String, String> headers, HttpHost proxyServer) {
        return postJson(url, json, charset, connTimeoutDefault, readTimeoutDefault, headers, proxyServer);
    }

    public static String post(String url, Map<String, String> params) {
        return postFrom(url, params, Charset.UTF_8, connTimeoutDefault, readTimeoutDefault, null, null);
    }

    public static String post(String url, Map<String, String> params, Charset charset, Map<String, String> headers, HttpHost proxyServer) {
        return postFrom(url, params, charset, connTimeoutDefault, readTimeoutDefault, headers, proxyServer);
    }

    public static String get(String url, Charset charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers, HttpHost proxyServer) {
        String resultBody =  null;
        Response response = null;
        try {
            response = getResponse(url,HttpType.GET,null,connTimeout, readTimeout, headers,null, proxyServer);
            if(response.isSuccessful()){
                resultBody = IOUtils.toString(response.body().byteStream(), charset.getValue());
            }else {
                resultBody = response.code() + response.message();
            }

        }catch (ConnectTimeoutException ce) {
            //log.error("connect timeout:" + url);
        } catch (SocketTimeoutException se) {
            //log.error("connect socket timeout:" + url);
        } catch (HttpHostConnectException he) {
            //log.error("connect httpHost:" + url);
        } catch (IOException e) {
            //log.error("connect Exception:{}", e);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(response!=null){
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  resultBody;
    }

    public static String postFrom(String url, Map<String, String> params, Charset charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers, HttpHost proxyServer){
        String resultBody =  null;
        Response response = null;
        try {
            response = getResponse(url,HttpType.POST_FROM,charset,connTimeout, readTimeout, headers,params, proxyServer);
            if(response.isSuccessful()){
                resultBody = IOUtils.toString(response.body().byteStream(), charset.getValue());
            }else {
                resultBody = response.code() + response.message();
            }

        }catch (ConnectTimeoutException ce) {
            //log.error("connect timeout:" + url);
        } catch (SocketTimeoutException se) {
            //log.error("connect socket timeout:" + url);
        } catch (HttpHostConnectException he) {
            //log.error("connect httpHost:" + url);
        } catch (IOException e) {
            //log.error("connect Exception:{}", e);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(response!=null){
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  resultBody;
    }

    public static String postJson(String url, String json, Charset charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers, HttpHost proxyServer) {
        String resultBody =  null;
        Response response = null;
        try {
            response = getResponse(url,HttpType.POST_JSON,charset,connTimeout, readTimeout, headers,json, proxyServer);
            if(response.isSuccessful()){
                resultBody = IOUtils.toString(response.body().byteStream(), charset.getValue());
            }else {
                resultBody = response.code() + response.message();
            }

        } catch (ConnectTimeoutException ce) {
            //log.error("connect timeout:" + url);
        } catch (SocketTimeoutException se) {
            //log.error("connect socket timeout:" + url);
        } catch (HttpHostConnectException he) {
            //log.error("connect httpHost:" + url);
        } catch (IOException e) {
            //log.error("connect Exception:{}", e);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(response!=null){
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  resultBody;
    }

    private static Response getResponse(String url, HttpType type, Charset charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers, Object argus , HttpHost proxyServer) throws Exception {
        Response response = null;
        Headers reHeaders = null;
        Request.Builder requestBuilder =  new Request.Builder().url(url);
        X509TrustManager trustAllManager = getTrustAllManager();
        OkHttpClient.Builder httpBuilder = SingleOkHttp.instance.newBuilder()
                .connectTimeout(connTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .sslSocketFactory(createTrustAllSSLFactory(trustAllManager),trustAllManager)
                .followRedirects(false)//禁制OkHttp的重定向操作，我们自己处理重定向
                .followSslRedirects(false)//https的重定向也自己处理
                .hostnameVerifier(getHostnameVerifier());
        if(headers!=null){
            headers.entrySet().forEach(e->{
                if(!"responseHeaders".equals(e.getKey())){
                    requestBuilder.addHeader(e.getKey(),e.getValue());
                }
            });
        }
        if(proxyServer!=null){
            httpBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyServer.getHostName(), proxyServer.getPort())));
        }

        if(HttpType.GET.name().equals(type.name())){
            OkHttpClient httpClient = httpBuilder.build();
            response = httpClient.newCall(requestBuilder.build()).execute();
            reHeaders= response.headers();
        }else if(HttpType.POST_FROM.name().equals(type.name())){
            //FormBody.Builder formBody = new FormBody.Builder();
            StringBuffer sb = new StringBuffer();
            if(argus!=null && argus instanceof Map){
                Map<String,String> map = (Map) argus;
                for (String key : map.keySet()) {
                    sb.append(key+"="+map.get(key)+"&");
                }
            }
            RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset="+charset.value), sb.toString());
            OkHttpClient httpClient = httpBuilder.build();
            response = httpClient.newCall(requestBuilder.post(body).build()).execute();
            reHeaders= response.headers();
        }else if(HttpType.POST_JSON.name().equals(type.name())){
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset="+charset.value), argus+"");
            OkHttpClient httpClient = httpBuilder.build();
            response = httpClient.newCall(requestBuilder.post(body).build()).execute();
            reHeaders= response.headers();
        }else {
            throw new UnsupportedOperationException("no support request http type:"+type.value);
        }
        if(headers!=null){
            if (reHeaders != null && reHeaders.names()!=null) {
                Map<String,String> responseHeaders = new HashMap<>();
                for (String name : reHeaders.names()) {
                    responseHeaders.put(name,reHeaders.get(name));
                }
                headers.put("responseHeaders", JSON.toJSONString(responseHeaders));
            }
        }
        return response;
    }

    //获取这个SSLSocketFactory
    private static SSLSocketFactory createTrustAllSSLFactory(X509TrustManager trustAllManager) {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{trustAllManager}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        return ssfFactory;
    }

    //获取TrustManager
    private static X509TrustManager getTrustAllManager(){
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    //获取HostnameVerifier
    private static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        return hostnameVerifier;
    }


    public static void main(String[] args) {
        //HttpHost proxy = new HttpHost("transfer.mogumiao.com", 9001, "http");
        //Map<String, String> header = new HashMap<>();
        //QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO
        //header.put("Authorization", "Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
        /*header.put("Host", "sh.house.zhuge.com");
        header.put("Accept-Language", "zh-CN,zh;q=0.9");
        header.put("Accept-Encoding", "gzip, deflate");
        header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,;q=0.8");
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        **/
        //String url = "https://www.baidu.com";
        String url = "https://hz.lianjia.com/ershoufang/103102678884.html";
        HttpHost proxy = new HttpHost("113.122.173.217", 36410);
        Map<String, String> header = new HashMap<>();
        //QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO
        //MjAxODAxMTFfYW5kcm9pZDplNmYyZDE1NzJiNjU0NGFjNTNkZThjMjkwOTlmZTc1YzVmYTgzZWE4
        header.put("Authorization", "MjAxODAxMTFfYW5kcm9pZDplNmYyZDE1NzJiNjU0NGFjNTNkZThjMjkwOTlmZTc1YzVmYTgzZWE4");
        for (int i=0; i< 50 ; i++){
            String html = get(url, Charset.UTF_8,2000,2000, header, proxy);
            System.out.println(header.get("responseHeaders"));
        }
        System.out.println("close . . . .. .  . ");

    }
}