package com.tt.common.utils;

import com.tt.service.JedisClientService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.*;
@Component
public class PageDownLoadUtil {

    private static String proxyServer = "transfer.mogumiao.com";
    private static int proxyPort = 9001;

    // 隧道代理订单appKey(请注意替换)
    private static String appKey = "QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO";

    @Autowired
    private static JedisClientService jedisClientService;

    private static Logger logger = LoggerFactory.getLogger(PageDownLoadUtil.class);


    /**
     * 内部类
     */
    private static class ProxyAuthenticator extends Authenticator {

        private  String user, password;

        public ProxyAuthenticator(String user, String password) {
            this.user     = user;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

    //从响应信息中获取cookie
    public static String getResponseCookie(HttpResponse httpResponse) {
        if(httpResponse!=null){
            Map<String, String> cookieMap = new HashMap<String,String>(64);
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
        }else {
            return null;
        }

    }

    /**
     * httpsClientProxy
     * @param targetUrl
     * @return
     */
    public static String httpsClientProxy(String targetUrl) {
        logger.info("进入请求代理方法------------------");
        long startTime = System.currentTimeMillis();

        // 代理服务器
        String proxyServer = "transfer.mogumiao.com";
        int proxyPort      = 9001;

        // 代理隧道验证信息
        String proxyUser  = "C3cHJI1ZW9Eq8jQA";
        String proxyPass  = "Fg6oBg3wNmN2psRN";

        try {
            //该部分必须在获取connection前调用
            trustAllHttpsCertificates();
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            URL url = new URL(targetUrl);
            Authenticator.setDefault(new ProxyAuthenticator(proxyUser, proxyPass));

            // 创建代理服务器地址对象
            InetSocketAddress addr = new InetSocketAddress(proxyServer, proxyPort);
            // 创建HTTP类型代理对象
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

            long mideTime = System.currentTimeMillis();
            logger.info("创建代理服务器地址对象,所用时长----------"+(mideTime-startTime)+"ms");
            // 设置通过代理访问目标页面
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
            InputStream inputStream = connection.getInputStream();
            long fangwenTime = System.currentTimeMillis();
            logger.info("通过代理访问目标页面,所用时长----------"+(fangwenTime-mideTime)+"ms");
            // 解析返回数据
            byte[] bytes = readStream(inputStream);
            long parseTime = System.currentTimeMillis();
            logger.info("解析目标页面,所用时长----------"+(parseTime-fangwenTime)+"ms");
            String response=new String(bytes);
            long endTime = System.currentTimeMillis();

            logger.info("代理请求成功======="+targetUrl);

            logger.info("代理请求成功,所用时长----------"+(endTime-startTime)+"ms");
            return new String(bytes);

            //return response;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }


    /**
     * httpClientProxy
     * @param targetUrl
     * @return
     */
    public static String httpClientProxy(String targetUrl) {
        // 代理服务器
        String proxyServer = "transfer.mogumiao.com";
        int proxyPort = 9001;

        // 隧道代理订单appKey(请注意替换)
        String appKey = "QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO";

        try {
            URL url = new URL(targetUrl);
            // 创建代理服务器地址对象
            InetSocketAddress addr = new InetSocketAddress(proxyServer, proxyPort);
            // 创建HTTP类型代理对象
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

            // 设置通过代理访问目标页面
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
            // 设置协议头 (下面的必带，其他的可以自定义，根据自己的需求决定)
            connection.setRequestProperty("Proxy-Authorization", "Basic " + appKey);

            // 解析返回数据
            byte[] bytes = readStream(connection.getInputStream());

            String response = new String(bytes);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 将输入流转换成字符串
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;

        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();

        return outSteam.toByteArray();
    }

   /* public static String readStream(InputStream inStream) throws IOException {
        StringBuffer result = new StringBuffer();
        BufferedReader in = null;
        try {
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(inStream,"UTF-8"));
            String line=null;
            while ((line = in.readLine())!= null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
        return result.toString();
    }*/


    /**
     *
     * @param url 请求url
     * @param params 请求参数
     * @param headers 请求的头部信息
     * @return
     */
    public static HttpResponse httpMoguproxyPost(String url, Map<String, String> params, Map<String, String> headers) {
        CloseableHttpClient httpClient = SSLClientUtil.createSSLClientDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            headers.put("Proxy-Authorization", "Basic " + appKey);
            HttpHost proxy = new HttpHost(proxyServer, proxyPort);

            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    // Waiting for a connection from connection manager
                    .setConnectionRequestTimeout(10000)
                    // Waiting for connection to establish
                    .setConnectTimeout(5000)
                    .setExpectContinueEnabled(false)
                    .setCookieSpec("easy")
                    // Waiting for data
                    .setSocketTimeout(5000).build();

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

            return response;
        } catch (ClientProtocolException e) {
            logger.info("请求失败======================================================="+url);
        } catch (IOException e) {
            logger.info("请求失败======================================================="+url);
        } catch (Exception e) {
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 蘑菇代理 get请求
     * @param url
     * @return
     */
	public static CloseableHttpResponse httpMoguproxyGet(String url) {
		//CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = SSLClientUtil.createSSLClientDefault();

        try {
			HttpGet get = new HttpGet(url);
			// 创建代理对象
            HttpHost proxy = new HttpHost(proxyServer, proxyPort);

            // 将代理参数配置到请求设置中,由于使用的代理IP,不太稳定,所以要设置响应超时和读取超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    // Waiting for a connection from connection manager
                    .setConnectionRequestTimeout(10000)
                    // Waiting for connection to establish
                    .setConnectTimeout(5000)
                    .setExpectContinueEnabled(false)
                    .setCookieSpec("easy")
                    // Waiting for data
                    .setSocketTimeout(5000).build();
            get.setConfig(requestConfig);
            //设置头部信息
            get.setHeader("Proxy-Authorization","Basic " + appKey);

			CloseableHttpResponse response = httpClient.execute(get);

			return response;
            /*try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }*/
		} catch (Exception e) {
            e.printStackTrace();
            logger.info("请求失败======================================================="+url+"--"+e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return null;
	}
	
	/**
	 *
	 * 功能描述: 
	 *
	 * @param:
	 * @return: 
	 * @auther: 赵乐
	 * @date: 2018/10/19 11:20
	 */
    public static HttpResponse httpMoguproxyGet(String url,Map<String, String> headers) {
        CloseableHttpClient httpClient = SSLClientUtil.createSSLClientDefault();
        try {
            HttpGet get = new HttpGet(url);
            // 创建代理对象
            HttpHost proxy = new HttpHost(proxyServer, proxyPort);

            // 将代理参数配置到请求设置中,由于使用的代理IP,不太稳定,所以要设置响应超时和读取超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    // Waiting for a connection from connection manager
                    .setConnectionRequestTimeout(10000)
                    // Waiting for connection to establish
                    .setConnectTimeout(5000)
                    .setExpectContinueEnabled(false)
                    .setCookieSpec("easy")
                    // Waiting for data
                    .setSocketTimeout(5000).build();
            get.setConfig(requestConfig);
            //设置头部信息
            get.setHeader("Proxy-Authorization","Basic " + appKey);

            // 加header
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    get.addHeader(entry.getKey(), entry.getValue());
                }
            }

            CloseableHttpResponse response = httpClient.execute(get);

            return response;
            /*try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }*/
        } catch (Exception e) {
            logger.info("请求失败======================================================="+url);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



   /* public static RequestConfig getRequestConfig(String key) {
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000)
                .setSocketTimeout(2000).build();
        if (StringUtils.isNotBlank(key)) {
            String replace = key.replace(Config.PROXY_IP_REDIS_KEY, "");
            String[] arr = replace.split(":");
            String proxy_ip = arr[0];
            int proxy_port = Integer.parseInt(arr[1]);
            HttpHost proxy = new HttpHost(proxy_ip, proxy_port);
            config = RequestConfig.custom().setProxy(proxy).setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();
        }
        return config;
    }*/
    /*
     *//* *
     * 获取代理ip
     * @return
    *//*
    public static String getProxyIpPort() {

        jedis.close();
        String ip_port = null;
        List<String> list = new ArrayList<>();
        for (String string : keys) {
            list.add(string);
        }
        for (int i = 0; i < list.size();) {
            ip_port = list.get(NumUtils.getRandom(list.size()-1, 0));
            break;
        }
        return ip_port;
    }*/

    /**
     *
     * 功能描述: 全网代理ip池get
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/29 15:35
     */
    public static String httpClientQuanGet(String url){
        CloseableHttpClient httpClient = SSLClientUtil.createSSLClientDefault();

        Set<String> proxy_ip_redis_key = RedisUtil.keys("PROXY_IP_REDIS_KEY");
        List<String> list = new ArrayList<>(proxy_ip_redis_key);
        String ipStr=null;
        if(list!=null && list.size()!=0){
            ipStr= list.get(new Random().nextInt(list.size()));
        }
        try {
            HttpGet get = new HttpGet(url);
            HttpHost proxy = null;
            if(StringUtils.isNotBlank(ipStr)){
                try {
                    String[] split = ipStr.replace("PROXY_IP_REDIS_KEY","").replace("\r","").split(":");
                    String ip = split[0];
                    String portStr = split[1];

                    if(StringUtils.isNotBlank(ip) && StringUtils.isNotBlank(portStr)){
                        Integer port = Integer.parseInt(portStr);
                        proxy = null;
                        //proxy = new HttpHost("58.218.92.128", 19296);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            RequestConfig config =null;

            if(proxy==null){
                logger.error("代理ip失败，代理为空----------------------");
                config = RequestConfig.custom().
                        setConnectionRequestTimeout(3000).
                        setConnectTimeout(3000).
                      /*  setExpectContinueEnabled(false).
                        setCookieSpec("easy").*/
                        setSocketTimeout(3000).build();
            }else {
                config = RequestConfig.custom().
                        setProxy(proxy).
                        setConnectionRequestTimeout(3000).
                        /*setExpectContinueEnabled(false).
                        setCookieSpec("easy").*/
                        setConnectTimeout(3000).
                        setSocketTimeout(3000).build();
            }
            get.setConfig(config);
            List<String> user_agent=new ArrayList<>();
            user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
            user_agent.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1664.3 Safari/537.36");
            user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
            user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
            user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
            user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
            user_agent.add("Mozilla/5.0 (X11; CrOS i686 4319.74.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
            user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

            get.addHeader("User-Agent",list.get(new Random().nextInt(user_agent.size())));

            String result = null;
            System.out.println("执行");
            CloseableHttpResponse response = httpClient.execute(get);
            System.out.println("响应");
            if(response!=null){
                try {
                    HttpEntity entity = response.getEntity();
                    try {
                        if (null != entity) {
                            result = EntityUtils.toString(entity);
                        }
                    } catch (Exception e) {
                        logger.info("redtime out"+"---"+e);
                    }  finally {
                        if (entity != null) {
                            entity.getContent().close();
                        }
                    }
                } catch (Exception e) {
                    logger.info("响应失败"+e);
                }finally {
                    if(get!=null){
                        get.abort();
                    }
                    if (response != null) {
                        response.close();
                    }
                }
            }
            return result;
        } catch (Exception e) {
            logger.info("响应失败"+"---"+e);
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     *
     * 功能描述: 
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/30 13:01
     */
    public static String httpClientQuanGet(String url,String charset){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        StringBuffer key = new StringBuffer();

        Set<String> proxy_ip_redis_key = RedisUtil.keys("PROXY_IP_REDIS_KEY");
        List<String> list = new ArrayList<>(proxy_ip_redis_key);
        String ipStr=null;

        if(list!=null && list.size()!=0){
            ipStr= list.get(new Random().nextInt(list.size()));
        }
        try {
            HttpGet get = new HttpGet(url);

            HttpHost proxy = null;

            try {
                String[] split = ipStr.replace("PROXY_IP_REDIS_KEY","").split(":");
                String ip = split[0];
                String portStr = split[1];

                if(StringUtils.isNotBlank(ip) && StringUtils.isNotBlank(portStr)){
                    Integer port = Integer.parseInt(portStr);
                    proxy = new HttpHost(ip, port);
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            RequestConfig config =null;



            if(proxy==null){
                logger.error("代理ip失败，代理为空----------------------");
                config = RequestConfig.custom().
                        setConnectionRequestTimeout(10000).
                        setConnectTimeout(5000).
                        setExpectContinueEnabled(false).
                        setCookieSpec("easy").
                        setSocketTimeout(5000).build();
            }else {
                config = RequestConfig.custom().
                        setProxy(proxy).
                        setConnectionRequestTimeout(10000).
                        setConnectTimeout(10000).
                        setExpectContinueEnabled(false).
                        setCookieSpec("easy").
                        setSocketTimeout(10000).build();
            }
            get.setConfig(config);
            String result = null;
            System.out.println("执行");
            CloseableHttpResponse response = httpClient.execute(get);
            System.out.println("响应");
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (null != entity) {
                        result = EntityUtils.toString(entity,charset);
                    }
                } catch (Exception e) {
                    logger.info("redtime out"+"---"+e);
                }  finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                logger.info("响应失败"+e);
            }finally {
                if(get!=null){
                    get.abort();
                }
                if (response != null) {
                    response.close();
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *
     * 功能描述: 全网代理ip池get
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/29 15:35
     */
    public static String httpClientQuanGet(String url,Map<String,String> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        StringBuffer key = new StringBuffer();

        Set<String> proxy_ip_redis_key = RedisUtil.keys("PROXY_IP_REDIS_KEY");
        List<String> list = new ArrayList<>(proxy_ip_redis_key);
        String ipStr=null;

        if(list!=null && list.size()!=0){
            try {
                ipStr= list.get(new Random().nextInt(list.size()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            logger.error("代理ip空了-----等待三秒----------------");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  null;
        }
        try {
            HttpGet get = new HttpGet(url);
            HttpHost proxy = null;
            try {
                String[] split = ipStr.replace("PROXY_IP_REDIS_KEY","").replace("\r","").split(":");
                String ip = split[0];
                String portStr = split[1];

                if(StringUtils.isNotBlank(ip) && StringUtils.isNotBlank(portStr)){
                    Integer port = Integer.parseInt(portStr);
                    proxy = new HttpHost(ip, port);
                }else{
                    return null;
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            RequestConfig config =null;

            if(proxy==null){
                logger.error("代理ip失败，代理为空----------------------");
                 config = RequestConfig.custom().
                        setConnectionRequestTimeout(10000).
                        setConnectTimeout(10000).
                         setExpectContinueEnabled(false).
                         setCookieSpec("easy").
                        setSocketTimeout(10000).build();
            }else {
                 config = RequestConfig.custom().
                        setProxy(proxy).
                        setConnectionRequestTimeout(10000).
                        setConnectTimeout(10000).
                         setExpectContinueEnabled(false).
                         setCookieSpec("easy").
                        setSocketTimeout(10000).build();
            }
            get.setConfig(config);

            // 加header
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    get.addHeader(entry.getKey(), entry.getValue());
                }
            }

            String result = null;
            try {
                CloseableHttpResponse response = httpClient.execute(get);
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean valid = ValidateUtil.valid(result);
            System.out.println("进入请求----"+valid);
            if(valid){
                //删除ip
                try {
                    logger.info("失败ip，从代理池中移除");
                    //RedisUtil.delKey(ipStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return result;
        } catch (Exception e) {
            //RedisUtil.delKey(ipStr);
            logger.error("请求失败,ip，从代理池中移除"+e);
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.error("请求失败"+e);
            }
        }
    }




    /**
     * 本地ip get请求
     * @param url
     * @return
     */
	public static String httpClientDefultGet(String url){
        CloseableHttpClient httpClient = SSLClientUtil.createSSLClientDefault();
        //CloseableHttpClient httpClient = HttpClients.createDefault();
        StringBuffer key = new StringBuffer();
        try {
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	/**
	 * 本地ip get请求(头部信息)
	 * @param url
	 * @param maps
	 * @return
	 */
	public static String httpClientDefultGet(String url, Map<?, ?>... maps) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		StringBuffer key = new StringBuffer();
		try {
			HttpGet get = new HttpGet(url);
			//设置请求的头部信息
			/*setGetHeaders(get, maps);*/
			if(maps!=null){
                for (Map<?, ?> map : maps) {
                    Iterator<?> iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next = (String) iterator.next();
                        String object = (String) map.get(next);
                        get.setHeader(next, object);
                    }
                }
            }
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			return result;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *  设置头部信息
	 */
	/*public static void setGetHeaders(HttpGet get, Map<?, ?>... maps) {
		for (Map<?, ?> map : maps) {
			Iterator<?> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String next = (String) iterator.next();
				String object = (String) map.get(next);
				get.setHeader(next, object);
			}
		}
	}*/

	public static void main(String[] args){
		/*String url="http://www.baidu.com";
        String result = httpClientProxy(url);
        System.out.println(result);*/
        //String target="https://shanghai.anjuke.com/community/beicai/p1/";
        //String url="https://www.baidu.com/";
        /*String target="http://vacations.ctrip.com/";
        HttpResponse httpResponse = httpMoguproxyGet(target);
        String responseCookie = getResponseCookie(httpResponse);
        System.out.println(responseCookie);*/
       /* Map<String,String> map=new HashMap<>();
        map.put("district", "176");
        map.put("rank","0.5572268832772966");
        HttpResponse httpResponse = httpMoguproxyPost("http://you.ctrip.com/Destinationsite/SharedComm/GetExpertPartialView", map, new HashMap<>());
        System.out.println(httpResponse);*/

        /*Map<String,String> headers=new HashMap<>();
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        headers.put("Cookie","s_ViewType=10; _lxsdk_cuid=1667586e694c8-00e4969aba7624-43450521-1fa400-1667586e694c8; _lxsdk=1667586e694c8-00e4969aba7624-43450521-1fa400-1667586e694c8; _hc.v=d56625c3-a595-81a2-6d35-35cf228cef8e.1539570067; cityid=1; logan_custom_report=; logan_session_token=6t1ya7hc41xorsdyojau; default_ab=shop%3AA%3A1%7CshopList%3AA%3A1; msource=default; _lxsdk_s=166a4ddd015-ca9-cc1-835%7C%7C464");
        String url="http://m.dianping.com/shop/44818537";
        String s = httpClientQuanGet(url, headers);
        System.out.println(s);*/

        String url="https://zhongyuandichan.anjuke.com/gongsi-esf/A1476733399.html";
        /*HttpResponse httpResponse = httpMoguproxyGet(url);
        try {
            HttpEntity entity = httpResponse.getEntity();
            String s = EntityUtils.toString(entity);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*for(int i=1;i<20;i++){
            System.out.println(i);
            String s = httpClientQuanGet(url);
        }*/

        Map<String,String> headers=new HashMap<>();
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        headers.put("Cookie","s_ViewType=10; _lxsdk_cuid=1667586e694c8-00e4969aba7624-43450521-1fa400-1667586e694c8; _lxsdk=1667586e694c8-00e4969aba7624-43450521-1fa400-1667586e694c8; _hc.v=d56625c3-a595-81a2-6d35-35cf228cef8e.1539570067; cityid=1; default_ab=shop%3AA%3A1%7CshopList%3AA%3A1%7Cmap%3AA%3A1; m_flash2=1; __utma=1.1437795818.1540373702.1540373702.1540373702.1; __utmc=1; __utmz=1.1540373702.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _lx_utm=utm_source%3DDP_KnowsNav; citypinyin=shanghai; cityname=5LiK5rW3; pvhistory=6L+U5ZuePjo8L2Vycm9yL2Vycm9yX3BhZ2U+OjwxNTQwNDUyMzU5ODc0XV9b; msource=default; _lxsdk_s=166becc5783-cf3-d6f-794%7C%7C26");



        String daUrl="https://zhengzhou.anjuke.com/tycoon/?from=navigation";
        String s = httpClientQuanGet(daUrl);
        System.out.println(s);

    }

}
