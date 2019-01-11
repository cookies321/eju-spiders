package com.tt.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * @author Created by zcm on 2018/12/21.
 * @version v0.1.0
 * @see <font color="#0000FF">ip-proxy-pool</font>
 */
public class OkHttpDownLoadUtil {

    private Logger log = LoggerFactory.getLogger(OkHttpDownLoadUtil.class);

    private static final String GET = "get";
    private static final String POST_FROM = "post-from";
    private static final String POST_JSON = "post-json";

    private final String proxyJsonDefault;
    private final int proxyLessThan;
    private final String proxyUrl;
    private final String proxySeparator;
    private final int connectTimeout;
    private final int readTimeout;
    private final int retryMax;
    private final boolean retryEnable;
    private final String charset;
    private final List<String> proxyRetryTag;

    private OkHttpDownLoadUtil(OkHttpDownLoadUtil.Builder builder){
        this.proxyLessThan = builder.proxyLessThan;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.retryEnable = builder.retryEnable;
        this.retryMax = builder.retryMax;
        this.charset = builder.charset;
        this.proxyUrl = builder.proxyUrl;
        this.proxySeparator = builder.proxySeparator;
        this.proxyRetryTag = builder.proxyRetryTag;
        this.proxyJsonDefault = builder.proxyJsonDefault;
        SingleOkHttp.pcList.addAll(builder.userAgent);
    }

    public String get(String url) {
        return  httpRequest(url, GET,null,null, null, null,null,null);
    }

    public String get(String url, Map<String, String> headers) {
        return  httpRequest(url, GET,null,null, null, headers,null,null);
    }

    public String get(String url,String charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers) {
        return  httpRequest(url, GET,charset,connTimeout, readTimeout, headers,null,null);
    }

    public String postFrom(String url, Map<String, String> params){
        return  httpRequest(url, POST_FROM ,null,null, null, null,params,null);
    }

    public String postFrom(String url, Map<String, String> headers, Map<String, String> params){
        return  httpRequest(url, POST_FROM ,null,null, null, headers,params,null);
    }

    public String postFrom(String url,String charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers, Map<String, String> params){
        return  httpRequest(url, POST_FROM ,charset,connTimeout, readTimeout, headers,params,null);
    }

    public String postJson(String url, String json) {
        return  httpRequest(url,POST_JSON,null,null, null, null,json,null);
    }

    public String postJson(String url, Map<String, String> headers,String json) {
        return  httpRequest(url,POST_JSON,null,null, null, headers,json,null);
    }

    public String postJson(String url, String charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers,String json) {
        return  httpRequest(url,POST_JSON,charset,connTimeout, readTimeout, headers,json,null);
    }

    public String proxyGet(String url) {
        return proxyRetry(null, null,(httpHostExt) -> httpRequest(url, GET,null, null, null,httpHostExt.getHeaders() ,null,httpHostExt.getHttpHost()));
    }

    public String proxyGet(String url,String charset,Map<String, String> headers) {
        return proxyRetry(null, headers, (httpHostExt) -> httpRequest(url, GET,charset, null, null,httpHostExt.getHeaders() ,null,httpHostExt.getHttpHost()));
    }

    public String proxyGet(String url,String charset, Integer connTimeout, Integer readTimeout, Integer retry, Map<String, String> headers ) {
        return proxyRetry(retry, headers, (httpHostExt) -> httpRequest(url, GET,charset,connTimeout, readTimeout, httpHostExt.getHeaders(),null,httpHostExt.getHttpHost()));
    }

    public String proxyPostFrom(String url,Map<String, String> params){
        return proxyRetry(null, null, (httpHostExt) -> httpRequest(url, POST_FROM ,null,null, null, httpHostExt.getHeaders(),params,httpHostExt.getHttpHost()));
    }

    public String proxyPostFrom(String url,String charset,Map<String, String> headers,Map<String, String> params){
        return proxyRetry(null, headers,(httpHostExt) -> httpRequest(url, POST_FROM ,charset,null, null, httpHostExt.getHeaders(),params,httpHostExt.getHttpHost()));
    }

    public String proxyPostFrom(String url,String charset, Integer connTimeout, Integer readTimeout, Integer retry, Map<String, String> headers,Map<String, String> params){
        return proxyRetry(retry, headers, (httpHostExt) -> httpRequest(url, POST_FROM ,charset,connTimeout, readTimeout, httpHostExt.getHeaders(),params,httpHostExt.getHttpHost()));
    }

    public String proxyPostJson(String url,String json) {
        return proxyRetry(null, null, (httpHostExt) -> httpRequest(url,POST_JSON,null,null, null, httpHostExt.getHeaders(),json,httpHostExt.getHttpHost()));
    }

    public String proxyPostJson(String url,String charset,Map<String, String> headers, String json) {
        return proxyRetry(null, headers, (httpHostExt) -> httpRequest(url,POST_JSON,charset,null, null, httpHostExt.getHeaders(),json,httpHostExt.getHttpHost()));
    }

    public String proxyPostJson(String url, String charset, Integer connTimeout, Integer readTimeout, Integer retry, Map<String, String> headers, String json) {
        return proxyRetry(retry, headers, (httpHostExt) -> httpRequest(url,POST_JSON,charset,connTimeout, readTimeout, httpHostExt.getHeaders(),json,httpHostExt.getHttpHost()));

    }

    private String proxyRetry(Integer retry, Map<String, String> headers, Function<HttpHostExt,String> fn){
        int cnt = retry==null?this.retryMax:retry;
        String body = null;
        boolean flag = true;
        for (int i = 0; i<=cnt && flag; i++){
            flag = false;
            HttpHostExt httpHostExt = getHttpHost();
            if(headers==null){headers = new HashMap<>();}
            if(!headers.containsKey("User-Agent")){
                headers.put("User-Agent", SingleOkHttp.randomPC());
            }
            httpHostExt.setHeaders(headers);
            body = fn.apply(httpHostExt);
            if(proxyRetryTag!=null){
                for(int y =0 ; y<proxyRetryTag.size();y++){
                    if("null".equals(proxyRetryTag.get(y))){
                        flag = body.equals(proxyRetryTag.get(y))?true:false;
                        if(flag){break;}
                    }else if(body.indexOf(proxyRetryTag.get(y))!=-1){
                        flag = true;
                        break;
                    }
                }
            }
        }
        return body;
    }

    //获取代理
    private HttpHostExt getHttpHost(){
        HttpHostExt httpHostExt = new HttpHostExt(null,new HashMap<>());
        int x = 0;
        do{
            httpHostExt.setHttpHost(SingleOkHttp.IP_LIST.poll());
            //请求代理池获取ip
            if(StringUtils.isNotBlank(this.proxyUrl)&& SingleOkHttp.IP_LIST.size()<=proxyLessThan){
                try {
                    SingleOkHttp.LOCK.lock();
                    if(SingleOkHttp.IP_LIST.size()<=proxyLessThan){
                        String body = get(this.proxyUrl);
                        if(StringUtils.isNotBlank(body)&&body.contains(":")){
                            String[] ips = body.split(this.proxySeparator);
                            String[] ipAndPort = ips[0].split(":");
                            int y=0;
                            if(httpHostExt.getHttpHost()==null){
                                httpHostExt.setHttpHost(new HttpHost(ipAndPort[0],Integer.valueOf(ipAndPort[1])));
                                y=1;
                            }
                            while (y<ips.length){
                                ipAndPort = ips[y].split(":");
                                SingleOkHttp.IP_LIST.offer(new HttpHost(ipAndPort[0],Integer.valueOf(ipAndPort[1])));
                                y++;
                            }
                        }
                    }else {
                        httpHostExt.setHttpHost(SingleOkHttp.IP_LIST.poll());
                    }
                } finally {
                    SingleOkHttp.LOCK.unlock();
                }
            }
            if(httpHostExt.getHttpHost()==null){
                try {
                    TimeUnit.MICROSECONDS.sleep(SingleOkHttp.WAIL_PROXY_TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                httpHostExt.setHttpHost(SingleOkHttp.IP_LIST.poll());
                if(httpHostExt.getHttpHost()==null&& JSON.parseObject(this.proxyJsonDefault)!=null){
                    JSONObject jsonObject = JSON.parseObject(this.proxyJsonDefault);
                    jsonObject.getJSONObject("header").entrySet().forEach(e->{
                        httpHostExt.getHeaders().put( e.getKey(),e.getValue()+"");
                    });
                    httpHostExt.setHttpHost(new HttpHost(jsonObject.getString("hostname"),jsonObject.getInteger("port")));
                }else {
                    x++;
                }
            }

        }while (httpHostExt.getHttpHost()==null&&x< SingleOkHttp.PORXT_RETRY_MAX);
        return httpHostExt;
    }

    private String httpRequest(String url, String type, String charset, Integer conTimeout, Integer readTimeout, Map<String, String> headers, Object argus, HttpHost httpHost){
        String resultBody =  null;
        Response response = null;
        try {
            Headers reHeaders = null;
            charset = charset==null?this.charset:charset;
            okhttp3.OkHttpClient.Builder httpBuilder = OkHttpDownLoadUtil.SingleOkHttp.instance.newBuilder()
                    .followRedirects(retryEnable)
                    .followSslRedirects(retryEnable)
                    .hostnameVerifier(SingleOkHttp.HOSTNAME_VERIFIER)
                    .sslSocketFactory(SingleOkHttp.SSL_SOCKET_FACTORY, SingleOkHttp.TRUST_ALL_MANAGER)
                    .connectTimeout(conTimeout==null?this.connectTimeout:conTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(readTimeout==null?this.readTimeout:readTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(readTimeout==null?this.readTimeout:readTimeout, TimeUnit.MILLISECONDS);
            Request.Builder requestBuilder =  new Request.Builder().url(url);
            if(headers!=null){
                headers.entrySet().forEach(e->{
                    if(!"responseHeaders".equals(e.getKey())){
                        requestBuilder.addHeader(e.getKey(),e.getValue());
                    }
                });
            }
            if(httpHost!=null){
                httpBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpHost.getHostName(), httpHost.getPort())));
            }
            if(GET.equals(type)){
                okhttp3.OkHttpClient HttpClient = httpBuilder.build();
                response = HttpClient.newCall(requestBuilder.build()).execute();
                reHeaders= response.headers();
            }else if(POST_FROM.equals(type)){
                //FormBody.Builder formBody = new FormBody.Builder();
                StringBuffer sb = new StringBuffer();
                if(argus!=null && argus instanceof Map){
                    Map<String,String> map = (Map) argus;
                    for (String key : map.keySet()) {
                        sb.append(key+"="+map.get(key)+"&");
                    }
                }
                RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset="+charset), sb.toString());
                okhttp3.OkHttpClient HttpClient = httpBuilder.build();
                response = HttpClient.newCall(requestBuilder.post(body).build()).execute();
                reHeaders= response.headers();
            }else if(POST_JSON.equals(type)){
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), argus+"");
                okhttp3.OkHttpClient HttpClient = httpBuilder.build();
                response = HttpClient.newCall(requestBuilder.post(body).build()).execute();
                reHeaders= response.headers();
            }else {
                throw new UnsupportedOperationException("no support request http type:"+type);
            }

            if (headers != null&&reHeaders!=null) {
                Map<String,String> responseHeaders = new HashMap<>();
                for (String name : reHeaders.names()) {
                    responseHeaders.put(name,reHeaders.get(name));
                }
                headers.put("responseHeaders", JSON.toJSONString(responseHeaders));
            }
            if(response!=null){
                if(response.isSuccessful()){
                    resultBody = IOUtils.toString(response.body().byteStream(), charset);
                }else {
                    resultBody = "ejuResponseCode="+response.code()+" proxy="+ JSON.toJSONString(httpHost) + response.message();
                }
                response.body().close();
            }
        } catch (ConnectTimeoutException cte) {
            resultBody = "ejuResponseCode=exception connect timeout proxy="+ JSON.toJSONString(httpHost);
            //log.error("connect timeout:" + url);
        } catch (SocketTimeoutException se) {
            resultBody = "ejuResponseCode=exception connect socket timeout proxy="+ JSON.toJSONString(httpHost);
            //log.error("connect socket timeout:" + url);
        } catch (HttpHostConnectException he) {
            resultBody = "ejuResponseCode=exception connect http host proxy="+ JSON.toJSONString(httpHost);
            //log.error("connect httpHost:" + url);
        } catch (ConnectException e){
            resultBody = "ejuResponseCode=exception connect proxy="+ JSON.toJSONString(httpHost);
            //log.error("connect httpHost:" + url);
        } catch (IOException e) {
            resultBody = "ejuResponseCode=exception io proxy="+ JSON.toJSONString(httpHost);
            e.printStackTrace();
        } catch (Exception e) {
            resultBody = "ejuResponseCode Exception proxy="+ JSON.toJSONString(httpHost);
            e.printStackTrace();
        } finally {
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

    //构建
    public static final OkHttpDownLoadUtil.Builder newBuilder() {
        return new OkHttpDownLoadUtil.Builder();
    }

    //构建
    public static final class Builder {
        int proxyLessThan;
        int connectTimeout;
        int readTimeout;
        int retryMax;
        boolean retryEnable;
        String charset;
        String proxyJsonDefault;
        String proxyUrl;
        String proxySeparator;
        List<String> proxyRetryTag;
        Set<String> userAgent;

        public Builder(){
            this.proxyLessThan = 3;
            this.connectTimeout = 3000;
            this.readTimeout = 3000;
            this.retryMax = 3;
            this.retryEnable = true;
            this.charset = "utf-8";
            this.proxyJsonDefault = "{'hostname':'transfer.mogumiao.com','port':9001,'scheme':'http','header':{'Proxy-Authorization':'Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO'}}";
            this.proxyUrl = null;
            this.proxySeparator = "\n";
            userAgent = new HashSet<>();
            this.proxyRetryTag = new ArrayList<>();
            this.proxyRetryTag.add("ejuResponseCode=");
        }

        public OkHttpDownLoadUtil.Builder connectTimeout(int connectTimeout){
            if(connectTimeout < 0L) {
                throw new IllegalArgumentException(connectTimeout + " < 0");
            }
            this.connectTimeout = connectTimeout;
            return this;
        }

        public OkHttpDownLoadUtil.Builder readTimeout(int readTimeout){
            if(connectTimeout < 0L) {
                throw new IllegalArgumentException(connectTimeout + " < 0");
            }
            this.readTimeout = readTimeout;
            return this;
        }

        public OkHttpDownLoadUtil.Builder retryDisable(){
            this.retryEnable = false;
            return this;
        }

        public OkHttpDownLoadUtil.Builder retryMax(int retryMax){
            if(this.retryMax < 0){
                throw new NullPointerException("retryMax < "+retryMax);
            }
            this.retryMax = retryMax;
            return this;
        }

        public OkHttpDownLoadUtil.Builder addUserAgent(String userAgent){
            if(userAgent == null) {
                throw new NullPointerException("userAgent == null");
            }else if(this.userAgent==null){
                this.userAgent = new HashSet<>();
            }
            this.userAgent.add(userAgent);
            return this;
        }

        public OkHttpDownLoadUtil.Builder charset(String Charset){
            if(Charset == null || "".equals(Charset.trim())) {
                throw new NullPointerException("charset == null");
            }
            this.charset = Charset;
            return this;
        }

        public OkHttpDownLoadUtil.Builder proxyUrl(String proxyUrl){
            if(proxyUrl == null || "".equals(proxyUrl.trim())) {
                throw new NullPointerException("proxyUrl == null");
            }
            this.proxyUrl = proxyUrl;
            return this;
        }

        public OkHttpDownLoadUtil.Builder proxySeparator(String proxySeparator){
            if(proxySeparator == null) {
                throw new NullPointerException("proxySeparator == null");
            }
            this.proxySeparator = proxySeparator;
            return this;
        }

        public OkHttpDownLoadUtil.Builder proxyRetryTag(List<String> proxyRetryTag){
            if(proxyRetryTag == null) {
                throw new NullPointerException("proxyRetryTag == null");
            }
            this.proxyRetryTag.addAll(proxyRetryTag);
            return this;
        }

        public OkHttpDownLoadUtil.Builder addProxyRetryTag(String proxyRetryTag){
            if(this.proxyRetryTag ==null){
                throw new NullPointerException("proxyRetryTag == null");
            }
            this.proxyRetryTag.add(proxyRetryTag);
            return this;
        }

        public OkHttpDownLoadUtil.Builder proxyJsonDefault(String proxyJsonDefault){
            if(proxyJsonDefault!=null
                    &&(proxyJsonDefault.indexOf("hostname")==-1
                    ||proxyJsonDefault.indexOf("port")==-1
                    ||proxyJsonDefault.indexOf("header")==-1)) {
                throw new IllegalArgumentException("proxyJsonDefault is json , required attribute:hostname、port、header【json】== null");
            }
            this.proxyJsonDefault = proxyJsonDefault;
            return this;
        }

        public OkHttpDownLoadUtil builder(){
            return new OkHttpDownLoadUtil(this);
        }

    }

    //okHttp
    private static final class SingleOkHttp {
        private static final okhttp3.OkHttpClient instance = new okhttp3.OkHttpClient();
        private static final ReentrantLock LOCK = new ReentrantLock();
        private static final List<String> pcList = new ArrayList<>();
        /*private static final List<String> mbList = new ArrayList<>();*/
        private static final int PORXT_RETRY_MAX = 100;
        private static final int WAIL_PROXY_TIMEOUT = 200;
        private static final ConcurrentLinkedQueue<HttpHost> IP_LIST = new ConcurrentLinkedQueue<>();

        private static final X509TrustManager TRUST_ALL_MANAGER = getTrustAllManager();
        private static final HostnameVerifier HOSTNAME_VERIFIER = getHostnameVerifier();
        private static final SSLSocketFactory SSL_SOCKET_FACTORY = createTrustAllSSLFactory(TRUST_ALL_MANAGER);
        private static final Random RANDOM = new Random();

        static {
            pcList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.11 (KHTML, like Gecko) Ubuntu/11.10 Chromium/27.0.1453.93 Chrome/27.0.1453.93 Safari/537.36");
            pcList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");
            pcList.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.94 Safari/537.36");
            pcList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:21.0) Gecko/20100101 Firefox/21.0");
            pcList.add("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:21.0) Gecko/20130331 Firefox/21.0");
            pcList.add("Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
            pcList.add("Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");
            pcList.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
            pcList.add("Mozilla/5.0 (compatible; WOW64; MSIE 10.0; Windows NT 6.2)");
            pcList.add("Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.9.168 Version/11.52");
            pcList.add("Opera/9.80 (Windows NT 6.1; WOW64; U; en) Presto/2.10.229 Version/11.62");
            pcList.add("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_6; en-US) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27");

            /*
            mbList.add("Mozilla/5.0 (Linux; U; Android 8.1.0; zh-CN; EML-AL00 Build/HUAWEIEML-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.9.4.974 UWS/2.13.1.48 Mobile Safari/537.36 AliApp(DingTalk/4.5.11) com.alibaba.android.rimet/10487439 Channel/227200 language/zh-CN");
            mbList.add("Mozilla/5.0 (Linux; U; Android 8.0.0; zh-CN; MI 5 Build/OPR1.170623.032) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/11.8.9.969 Mobile Safari/537.36");
            mbList.add("Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; SM-N9500 Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/8.8 Mobile Safari/537.36");
            mbList.add("Mozilla/5.0 (Linux; U; Android 5.1.1; zh-CN; OPPO R9 Plusm A Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/12.1.4.994 Mobile Safari/537.36");
            mbList.add("Mozilla/5.0 (Linux; Android 7.1.1; OPPO R11s Build/NMF26X; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044205 Mobile Safari/537.36 MicroMessenger/6.7.2.1340(0x26070234) NetType/WIFI Language/zh_CN");
            mbList.add("Mozilla/5.0 (iPhone 6p; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0 MQQBrowser/8.0.0 Mobile/16A5357b Safari/8536.25 MttCustomUA/2 QBWebViewType/1 WKType/1");
            mbList.add("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16A366 MicroMessenger/6.7.3(0x16070321) NetType/WIFI Language/zh_CN");
            mbList.add("Mozilla/5.0 (Linux; U; Android 7.1.2; zh-CN; vivo X9 Build/N2G47H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.89 UCBrowser/11.4.1.939 UCBS/2.10.1.8 Mobile Safari/537.36 AliApp(TB/6.8.6) WindVane/8.0.0 1080X1920 GCanvas/1.4.2.21");
            mbList.add("Mozilla/5.0 (Linux; Android 7.1.2; vivo X9 Build/N2G47H; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044303 Mobile Safari/537.36 V1_AND_SQ_7.8.0_922_YYB_D QQ/7.8.0.3740 NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/72");
            mbList.add("Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; Redmi 6 Pro Build/OPM1.171019.019) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.8.7");
            mbList.add("Mozilla/5.0 (Linux; Android 7.0; Redmi Note 4X Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044304 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/WIFI Language/zh_CN Process/tools");
            mbList.add("Mozilla/5.0 (Linux; U; Android 7.0; zh-cn; FRD-AL10 Build/HUAWEIFRD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/8.8 Mobile Safari/537.36");
            */
        }

        public static String randomPC(){
            return pcList.get(RANDOM.nextInt(pcList.size()));
        }

        /*public static String randomMOBILE(){
            return mbList.get(RANDOM.nextInt(mbList.size()));
        }*/

        //获取这个SSLSocketFactory
        private static final SSLSocketFactory createTrustAllSSLFactory(X509TrustManager trustAllManager) {
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
        private static final X509TrustManager getTrustAllManager(){
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
        private static final HostnameVerifier getHostnameVerifier() {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };
        }
    }

    //host扩展
    private static final class HttpHostExt{
        HttpHost httpHost;
        Map<String,String> headers;

        public HttpHostExt() {
        }

        public HttpHostExt(HttpHost httpHost, Map<String, String> headers) {
            this.httpHost = httpHost;
            this.headers = headers;
        }

        public HttpHost getHttpHost() {
            return httpHost;
        }

        public void setHttpHost(HttpHost httpHost) {
            this.httpHost = httpHost;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }
    }

    public static OkHttpDownLoadUtil createOkHttpClient(){
        OkHttpDownLoadUtil httpClient = OkHttpDownLoadUtil.newBuilder()
                .proxyUrl("http://10.122.139.34:8087/get/ip-list/14?key=7CD7CC040B837F8D91A23CDCF0011D85&degree=2&protocol=https")
                .addProxyRetryTag("null").addProxyRetryTag("rgv587_flag").retryMax(20).builder();
        return httpClient;
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
        OkHttpDownLoadUtil httpClient = OkHttpDownLoadUtil.newBuilder()
                .proxyUrl("http://10.122.139.34:8087/get/ip-list/3?key=557F35CA07AE2470F80E5CFC710FE61E&degree=2&protocol=https")
                .addProxyRetryTag("null").builder();
        String url = "http://qd.ershoufang.zhuge.com/community/";
        Map<String,String> header1=new HashMap<>();
        header1.put("Host","http://qd.ershoufang.zhuge.com");
        header1.put("Accept-Language","zh-CN,zh;q=0.9");
        header1.put("Accept-Encoding","gzip, deflate");
        header1.put("If-None-Match","W/125e-8pYtdxwALKZH7kOMgUjllg");
        header1.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        header1.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        String s = httpClient.proxyGet(url,"UTF-8",header1);
        System.out.println(s);


        //HttpHost proxy = new HttpHost("113.122.173.217", 36410);
        Map<String, String> header = new HashMap<>();
        //QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO
        //MjAxODAxMTFfYW5kcm9pZDplNmYyZDE1NzJiNjU0NGFjNTNkZThjMjkwOTlmZTc1YzVmYTgzZWE4
        header.put("Authorization", "MjAxODAxMTFfYW5kcm9pZDplNmYyZDE1NzJiNjU0NGFjNTNkZThjMjkwOTlmZTc1YzVmYTgzZWE4");
        for (int i=0; i< 10 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String html = httpClient.proxyGet("http://www.fang.com/SoufunFamily.htm","utf-8",header);
                    System.out.println(header.get("responseHeaders"));
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String html = httpClient.proxyGet("https://hz.lianjia.com/ershoufang/103102678884.html","utf-8",header);
                    System.out.println(header.get("responseHeaders"));
                }
            }).start();
        }
        System.out.println("close . . . .. .  . ");

    }
}
