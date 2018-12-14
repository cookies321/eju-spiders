package com.tt.common.utils;

import com.alibaba.fastjson.JSON;
import com.tt.vo.ProxyVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.*;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.*;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static com.tt.common.utils.RandomUtil.RandomChoiceUserAgents;


public class HttpClientUtilold {

    private final static int CONNECT_TIMEOUT = 20000;
    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtilold.class);

    private static PoolingHttpClientConnectionManager connManager = null;
    private static CloseableHttpClient httpclient = null;

    static {
        try {
            SSLContext sslContext = SSLContexts.custom().useTLS().build();
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws CertificateException {

                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

            }}, null);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslContext)).build();

            connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            httpclient = HttpClients.custom().setConnectionManager(connManager).build();
            // Create socket configuration
            SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
            connManager.setDefaultSocketConfig(socketConfig);
            // Create message constraints
            MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200)
                    .setMaxLineLength(2000).build();
            // Create connection configuration
            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                    .setMalformedInputAction(CodingErrorAction.IGNORE)
                    .setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
                    .setMessageConstraints(messageConstraints).build();
            connManager.setDefaultConnectionConfig(connectionConfig);
            connManager.setMaxTotal(200);
            connManager.setDefaultMaxPerRoute(20);
        } catch (KeyManagementException e) {
            logger.error("KeyManagementException", e);
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException", e);
        }
    }

    public static String postJsonBody(String url, int timeout, Map<String, Object> paramsMap, String encoding) {
        HttpPost post = new HttpPost(url);
        try {
            post.setHeader("Content-type", "application/json");
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).setExpectContinueEnabled(false).build();
            post.setConfig(requestConfig);

            String params = JSON.toJSONString(paramsMap);
            post.setEntity(new StringEntity(params, encoding));
//            logger.info("[HttpUtils Post] begin invoke url:" + url + " , params:" + params);
            CloseableHttpResponse response = httpclient.execute(post);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        String str = EntityUtils.toString(entity, encoding);
//                        logger.info("[HttpUtils Post]Debug response, url :" + url + " , response string :" + str);
                        return str;
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException", e);
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
            post.releaseConnection();
        }
        return "";
    }

    @SuppressWarnings("deprecation")
    public static String get(String url, Map<String, String> params, Map<String, String> headers, String encode,
                             int connectTimeout, int soTimeout) {
        String responseString = null;
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout)
                .setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();

        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (params != null) {
            int i = 0;
            for (Entry<String, String> entry : params.entrySet()) {
                if (i == 0 && !url.contains("?")) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                String value = entry.getValue();
                try {
//					sb.append(URLEncoder.encode(value, "UTF-8"));
                    sb.append(URLEncoder.encode(value, "GBK"));
                } catch (UnsupportedEncodingException e) {
                    logger.warn("encode http get params error, value is " + value, e);
                    sb.append(URLEncoder.encode(value));
                }
                i++;
            }
        }
//		logger.info("[HttpUtils Get] begin invoke:" + sb.toString());
        HttpGet get = new HttpGet(sb.toString());
        get.setConfig(requestConfig);

        // 加header
        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                get.addHeader(entry.getKey(), entry.getValue());
            }
        }

        try {
            CloseableHttpResponse response = httpclient.execute(get);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, "GBK");
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                logger.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
                return responseString;
            } finally {
                if (response != null) {
                    response.close();
                }
            }
//			logger.info(
//					String.format("[HttpUtils Get]Debug url:%s , response string %s:", sb.toString(), responseString));
        } catch (SocketTimeoutException e) {
            logger.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
            return responseString;
        } catch (Exception e) {
            logger.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
        } finally {
            get.releaseConnection();
        }
        return responseString;
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers, ProxyVo pxy, String encode,
                             int connectTimeout, int soTimeout) {
        if (StringUtils.isEmpty(encode)) {
            encode = "UTF-8";
        }
        String responseString = null;
        HttpHost proxy = new HttpHost(pxy.getIp(), pxy.getProt(), "http");
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setSocketTimeout(soTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectTimeout)
                .build();

        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (params != null) {
            int i = 0;
            for (Entry<String, String> entry : params.entrySet()) {
                if (i == 0 && !url.contains("?")) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                String value = entry.getValue();
                try {
//					sb.append(URLEncoder.encode(value, "UTF-8"));
                    sb.append(URLEncoder.encode(value, encode));
                } catch (UnsupportedEncodingException e) {
                    logger.warn("encode http get params error, value is " + value, e);
                    sb.append(URLEncoder.encode(value));
                }
                i++;
            }
        }
//		logger.info("[HttpUtils Get] begin invoke:" + sb.toString());
        HttpGet get = new HttpGet(sb.toString());
        get.setConfig(requestConfig);

        // 加header
        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                get.addHeader(entry.getKey(), entry.getValue());
            }
        }

        try {
            CloseableHttpResponse response = httpclient.execute(get);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, encode);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                logger.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
                return responseString;
            } finally {
                if (response != null) {
                    response.close();
                }
            }
//			logger.info(
//					String.format("[HttpUtils Get]Debug url:%s , response string %s:", sb.toString(), responseString));
        } catch (SocketTimeoutException e) {
            logger.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
            return responseString;
        } catch (Exception e) {
            logger.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
        } finally {
            get.releaseConnection();
        }
        return responseString;
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers, String encoding) {
        return get(url, params, headers, encoding, CONNECT_TIMEOUT, CONNECT_TIMEOUT);
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers, ProxyVo proxyVo, String encoding) {
        return get(url, params, headers, proxyVo, encoding, CONNECT_TIMEOUT, CONNECT_TIMEOUT);
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers) {
        return get(url, params, headers, Consts.UTF_8.name(), CONNECT_TIMEOUT, CONNECT_TIMEOUT);
    }

    public static String get(String url, Map<String, String> params) {
        return get(url, params, null);
    }

    public static String post(String reqURL, Map<String, String> params, int timeout) {
        return post(reqURL, params, null, timeout);
    }

    public static String post(String reqURL, Map<String, String> params, Map<String, String> headers, int timeout) {

        String responseContent = null;

        HttpPost httpPost = new HttpPost(reqURL);
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).build();
            httpPost.setConfig(requestConfig);

            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            // 绑定到请求 Entry
            for (Entry<String, String> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));

            // 加header
            if (headers != null) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }

            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                // 执行POST请求
                HttpEntity entity = response.getEntity(); // 获取响应实体
                try {
                    if (null != entity) {
                        responseContent = EntityUtils.toString(entity, Consts.UTF_8);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
//            logger.info("requestURI : " + httpPost.getURI() + ", responseContent: " + responseContent);
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        } finally {
            httpPost.releaseConnection();
        }
        return responseContent;

    }

    public static String post(String reqURL, Map<String, String> params, Map<String, String> headers, ProxyVo pxy, int timeout) {

        String responseContent = null;

        HttpHost proxy = new HttpHost(pxy.getIp(), pxy.getProt(), "http");
        HttpPost httpPost = new HttpPost(reqURL);
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    .setSocketTimeout(timeout)
                    .setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).build();

            httpPost.setConfig(requestConfig);

            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            // 绑定到请求 Entry
            for (Entry<String, String> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));

            // 加header
            if (headers != null) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }

            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                // 执行POST请求
                HttpEntity entity = response.getEntity(); // 获取响应实体
                try {
                    if (null != entity) {
                        responseContent = EntityUtils.toString(entity, Consts.UTF_8);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
//            logger.info("requestURI : " + httpPost.getURI() + ", responseContent: " + responseContent);
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        } finally {
            httpPost.releaseConnection();
        }
        return responseContent;

    }

    /**
     * HTTP/HTTPS请求，默认超时为5S
     *
     * @param reqURL
     * @param params
     * @return
     */
    public static String post(String reqURL, Map<String, String> params) {
        return post(reqURL, params, CONNECT_TIMEOUT);
    }

    public static String post(String reqURL, Map<String, String> params, Map<String, String> headers) {
        return post(reqURL, params, headers, CONNECT_TIMEOUT);
    }

    public static String post(String reqURL, Map<String, String> params, Map<String, String> headers, ProxyVo proxy) {
        return post(reqURL, params, headers, proxy, CONNECT_TIMEOUT);
    }

    public static String sendUrl(String reqURL, ProxyVo pxy) throws Exception {
        String str = null;
        URL url = new URL(reqURL);
        // 创建代理服务器地址对象
        InetSocketAddress addr = new InetSocketAddress(pxy.getIp(), pxy.getProt());
        // 创建HTTP类型代理对象
        Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

        // 设置通过代理访问目标页面
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
        // 设置协议头 (下面的必带，其他的可以自定义，根据自己的需求决定)
        connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
        connection.setRequestProperty("User-Agent", RandomChoiceUserAgents());
        connection.setRequestProperty("Host", "fangjia.fang.com");
        connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
        connection.setRequestProperty("Pragma", "no-cache");
//        connection.setRequestProperty("Referer", "http://fangjia.fang.com/");

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
//        connection.setRequestProperty("Charsert", "gb2312"); //设置请求编码


        // 解析返回数据
        byte[] response = readStream(connection.getInputStream());
        str = new String(response);
        return str;
    }

    /**
     * @return
     * @throws Exception
     */
    public static String readStream(BufferedReader br) throws Exception {
        StringBuffer bankXmlBuffer = new StringBuffer();
        String line = "";
        while (null != (line = br.readLine())) {
            bankXmlBuffer.append(line);
        }
        System.out.println("接到的数据: " + bankXmlBuffer);
//        String data = new String(bankXmlBuffer.toString().getBytes("gb2312"), "utf-8");
        br.close();
        return bankXmlBuffer.toString();
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

}