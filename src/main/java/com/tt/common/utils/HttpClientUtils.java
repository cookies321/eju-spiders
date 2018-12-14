package com.tt.common.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {
    private static Logger log = Logger.getLogger(HttpClientUtils.class);
    private static Integer connTimeoutDefault = 5000;
    private static Integer readTimeoutDefault = 5000;
    private static String charsetDefault= "utf-8";

    public static String get(String url){
        return get(url,charsetDefault,connTimeoutDefault,readTimeoutDefault,null,null);
    }
    public static String get(String url,HttpHost proxyServer){
        return get(url,charsetDefault,connTimeoutDefault,readTimeoutDefault,null,proxyServer);
    }

    public static String get(String url,String charset,HttpHost proxyServer){
        return get(url,charset,connTimeoutDefault,readTimeoutDefault,null,proxyServer);
    }

    public static String get(String url,String charset,Map<String,String> headers,HttpHost proxyServer){
        return get(url,charset,connTimeoutDefault,readTimeoutDefault,headers,proxyServer);
    }

    public static String get(String url,String charset,Integer connTimeout, Integer readTimeout,Map<String,String> headers,HttpHost proxyServer){
        String resultBody = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = null;
        try {
            // 设置请求和传输超时时间
            httpGet = new HttpGet(url);
            RequestConfig requestConfig = null;
            if(proxyServer!=null){
                requestConfig = RequestConfig.custom().setProxy(proxyServer).setSocketTimeout(connTimeout).setConnectTimeout(readTimeout).build();
            }else {
                requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout).setConnectTimeout(readTimeout).build();
            }
            httpGet.setConfig(requestConfig);
            if(headers!=null) {
                for (String key:headers.keySet()){
                    httpGet.addHeader(key,headers.get(key));
                }
            }
            // 执行请求
            httpClient = getClient(url);
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultBody = IOUtils.toString(response.getEntity().getContent(), charset);
                String cookie =  getCookie(response);
                if(cookie!=null&&headers!=null)headers.put("Cookie",cookie);
            }else {
                resultBody = IOUtils.toString(response.getEntity().getContent(), charset);
            }

        } catch (ConnectTimeoutException ce){
            log.error("connect timeout:"+url);
        }catch (SocketTimeoutException se){
            log.error("connect socket timeout:"+url);
        }catch (HttpHostConnectException he){
            log.error("connect httpHost:"+url);
        }catch (Exception e) {
            log.error("connect Exception:{}",e);
        }  finally {
            try {
                if(response!=null){response.getEntity().getContent().close();response.close();}
            } catch (IOException e) {
                log.error("response close Exception:{}",e);
            }
            try {
                if(httpGet!=null) httpGet.releaseConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultBody;
    }

    public static String post(String url,Map<String, String> params){
        return postFrom(url,params,charsetDefault,connTimeoutDefault,readTimeoutDefault,null,null);
    }

    public static String post(String url,Map<String, String> params,String charset){
        return postFrom(url,params,charset,connTimeoutDefault,readTimeoutDefault,null,null);
    }
    public static String post(String url,Map<String, String> params,Map<String,String> headers,HttpHost proxyServer){
        return postFrom(url,params,charsetDefault,connTimeoutDefault,readTimeoutDefault,headers,proxyServer);
    }

    public static String post(String url,Map<String, String> params,String charset,Map<String,String> headers,HttpHost proxyServer){
        return postFrom(url,params,charset,connTimeoutDefault,readTimeoutDefault,headers,proxyServer);
    }

    public static String postFrom(String url,Map<String, String> params,String charset,Integer connTimeout, Integer readTimeout,Map<String,String> headers,HttpHost proxyServer){
        String resultBody = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        try {
            // 设置请求和传输超时时间
            httpPost = new HttpPost(url);
            RequestConfig requestConfig = null;
            if(proxyServer!=null){
                requestConfig = RequestConfig.custom().setProxy(proxyServer).setSocketTimeout(connTimeout).setConnectTimeout(readTimeout).build();
            }else {
                requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout).setConnectTimeout(readTimeout).build();
            }
            httpPost.setConfig(requestConfig);
            if(headers!=null) {
                if(headers!=null) {
                    for (String key:headers.keySet()){
                        httpPost.addHeader(key,headers.get(key));
                    }
                }
            }
            List<NameValuePair> nvps = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, charset));
            // 执行请求
            httpClient = getClient(url);
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultBody = IOUtils.toString(response.getEntity().getContent(), charset);;
                String cookie =  getCookie(response);
                if(cookie!=null&&headers!=null)headers.put("Cookie",cookie);
            }else {
                resultBody = IOUtils.toString(response.getEntity().getContent(), charset);
            }
        } catch (ConnectTimeoutException ce){
            log.error("connect timeout:"+url);
        }catch (SocketTimeoutException se){
            log.error("connect socket timeout:"+url);
        }catch (HttpHostConnectException he){
            log.error("connect httpHost:"+url);
        }catch (Exception e) {
            log.error("connect Exception:{}",e);
        }  finally {
            try {
                if(response!=null){response.getEntity().getContent().close();response.close();}
            } catch (IOException e) {
                log.error("response close Exception:{}",e);
            }
            try {
                if(httpPost!=null) httpPost.releaseConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultBody;
    }

    public static String post(String url,String json){
        return postJson(url,json,charsetDefault,connTimeoutDefault,readTimeoutDefault,null,null);
    }

    public static String post(String url,String json,String charset){
        return postJson(url,json,charset,connTimeoutDefault,readTimeoutDefault,null,null);
    }

    public static String post(String url,String json,String charset,Map<String,String> headers,HttpHost proxyServer){
        return postJson(url,json,charset,connTimeoutDefault,readTimeoutDefault,headers,proxyServer);
    }

    public static String postJson(String url,String json,String charset,Integer connTimeout, Integer readTimeout,Map<String,String> headers,HttpHost proxyServer){
        String resultBody = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        try {
            // 设置请求和传输超时时间
            RequestConfig requestConfig = null;
            httpPost = new HttpPost(url);
            if(proxyServer!=null){
                requestConfig = RequestConfig.custom().setProxy(proxyServer).setSocketTimeout(connTimeout).setConnectTimeout(readTimeout).build();
            }else {
                requestConfig = RequestConfig.custom().setSocketTimeout(connTimeout).setConnectTimeout(readTimeout).build();
            }
            httpPost.setConfig(requestConfig);
            if(headers!=null) {
                if(headers!=null) {
                    for (String key:headers.keySet()){
                        httpPost.addHeader(key,headers.get(key));
                    }
                }
            }
            StringEntity stringEntity = new StringEntity(json);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(stringEntity);
            // 执行请求
            httpClient = getClient(url);
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultBody = IOUtils.toString(response.getEntity().getContent(), charset);;
                String cookie =  getCookie(response);
                if(cookie!=null&&headers!=null)headers.put("Cookie",cookie);
            }else {
                resultBody = IOUtils.toString(response.getEntity().getContent(), charset);
            }
        } catch (ConnectTimeoutException ce){
            log.error("connect timeout:"+url);
        }catch (SocketTimeoutException se){
            log.error("connect socket timeout:"+url);
        }catch (HttpHostConnectException he){
            log.error("connect httpHost:"+url);
        }catch (Exception e) {
            log.error("connect Exception:{}",e);
        }  finally {
            try {
                if(response!=null){response.getEntity().getContent().close();response.close();}
            } catch (IOException e) {
                log.error("response close Exception:{}",e);
            }
            try {
                if(httpPost!=null) httpPost.releaseConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return resultBody;
    }

    /**
     * 获取 HttpClient
     * @return
     */
    private static CloseableHttpClient getClient(String url) {
        if (url != null && url.startsWith("https://")) {
            return sslHttpClient();
        }else {
            return HttpClients.createDefault();
        }
    }

    //从响应信息中获取cookie
    private static String getCookie(HttpResponse httpResponse) {
        Map<String,String> cookieMap = new HashMap<>();
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        if (headers == null || headers.length == 0) {
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
        return cookiesTmp.substring(0, cookiesTmp.length() - 1);
    }
    private static CloseableHttpClient sslHttpClient(){
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https",buildSSLConnectionSocketFactory()).build();
        // 创建ConnectionManager，添加Connection配置信息
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        return closeableHttpClient;
    }

    private static SSLConnectionSocketFactory buildSSLConnectionSocketFactory() {
        try {
            return new SSLConnectionSocketFactory(createIgnoreVerifySSL(), new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"},
                    null,
                    new DefaultHostnameVerifier()); // 优先绕过安全证书
        } catch (KeyManagementException e) {
            log.error("ssl connection fail", e);
        } catch (NoSuchAlgorithmException e) {
            log.error("ssl connection fail", e);
        }
        return SSLConnectionSocketFactory.getSocketFactory();
    }

    private static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        };

        SSLContext sc = SSLContext.getInstance("SSLv3");
        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }


    public static void main(String[] args) {
        HttpHost proxy = new HttpHost("transfer.mogumiao.com", 9001, "http");
        Map<String,String> header = new HashMap<>();
        //QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO
        header.put("Authorization", "Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
        header.put("Host","sh.house.zhuge.com");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        header.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        String url = "http://sh.house.zhuge.com/109377.html";
        String html = HttpClientUtils.get(url,"utf-8",header,proxy);
        System.out.println(html);
    }
}