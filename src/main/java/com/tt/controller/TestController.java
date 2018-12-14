package com.tt.controller;

import com.tt.common.utils.HttpClientUtils;
import com.tt.common.utils.ProxyUtils;
import com.tt.service.IDownLoadPage;
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
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/28 16:26
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    @Qualifier("ipPoolProxy")
    //@Qualifier("moguProxy")
    private IDownLoadPage downLoadPage;


    @RequestMapping("/test")
    public String tetsss(){
        Map<String, String> map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        Document document = downLoadPage.downLoadPageByGet("https://www.ctrip.com/?allianceid=13963&sid=457771");
        Elements select = document.select("body");
        System.out.println(document);
        return select.text();
    }

    @RequestMapping("/test1")
    public String tetsss1() throws Exception{
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
        String result=null;

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
                result = EntityUtils.toString(response.getEntity());
                System.out.println(response.getStatusLine());
                System.out.println(result);

            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return result;
    }



    @RequestMapping("/test2")
    public String tetsss2() {
        Map<String, String> map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        String result = HttpClientUtils.get("https://www.baidu.com/", null);
        System.out.println(result);
        return result;
    }


}
