package com.tt.service.impl;

import com.tt.common.utils.OkHttpUtils;
import com.tt.common.utils.ProxyUtils;
import com.tt.common.utils.ValidateUtil;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/14 11:14
 * @Description:
 */
@Service("ipPoolProxyOkHttp")
public class DownLoadPageOkHttpByIpPoolServiceImpl implements IDownLoadPage{
    private static Integer connTimeoutDefault = 10000;
    private static Integer readTimeoutDefault = 5000;

    @Override
    public Document downLoadPageByGet(String url) {
        return downLoadPageByGet(url,new HashMap<String, String>());
    }

    @Override
    public Document downLoadPageByGet(String url, Map<String, String> headers) {
        return downLoadPageByGet(url, "UTF-8", headers);
    }

    @Override
    public Document downLoadPageByGet(String url, String charset, Map<String, String> headers) {
        return downLoadPageByGet(url,charset,connTimeoutDefault,readTimeoutDefault,headers);
    }

    @Override
    public Document downLoadPageByGet(String url, String charset, Integer connTimeout, Integer readTimeout, Map<String, String> headers) {
        if (StringUtils.isNotBlank(url)) {

            String result = null;
            try {
                //设置代理池
                HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                if(iPoolProxy==null){
                    System.out.println("代理是空,使用蘑菇代理");
                    HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
                    headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                    result = OkHttpUtils.get(url, OkHttpUtils.Charset.UTF_8,connTimeout,readTimeout, headers,mouGuProxy);
                }else{
                    //设置头部信息
                    result = OkHttpUtils.get(url, OkHttpUtils.Charset.UTF_8,connTimeout,readTimeout, headers,iPoolProxy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                Document document = Jsoup.parse(result);
                return document;
            } else {
                System.out.println("响应失败，循环尝试20次--------------------------" + url);
                System.err.println(result);
                for (int i = 1; i < 21; i++) {
                    try {
                        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                        if(iPoolProxy==null){
                            System.out.println("代理是空,使用蘑菇代理");
                            HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
                            headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                            result = OkHttpUtils.get(url, OkHttpUtils.Charset.UTF_8,connTimeout,readTimeout, headers,mouGuProxy);
                        }else{
                            //设置头部信息
                            System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                            result = OkHttpUtils.get(url, OkHttpUtils.Charset.UTF_8,connTimeout,readTimeout, headers,iPoolProxy);
                        }
                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                /*if(i==10){
                                    System.err.println(doc);
                                }*/
                                continue;
                            } else {
                                System.out.println("循环尝试第" + i + "次，相应成功--------------------------" + url);
                                return doc;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Document downLoadPageByPost(String url, Map<String, String> params) {
        return downLoadPageByPost(url,params,null);
    }

    @Override
    public Document downLoadPageByPost(String url, Map<String, String> params, Map<String, String> headers) {
        return downLoadPageByPost(url,params,"UTF-8",headers);
    }

    @Override
    public Document downLoadPageByPost(String url, Map<String, String> params, String charset, Map<String, String> headers) {
        if (StringUtils.isNotBlank(url)) {
            //设置代理池
            String result = null;
            try {
                HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                if(iPoolProxy==null){
                    System.out.println("代理是空,使用蘑菇代理");
                    HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
                    headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                    result = OkHttpUtils.post(url, params, OkHttpUtils.Charset.UTF_8, headers, mouGuProxy);
                }else{
                    //设置头部信息
                    result = OkHttpUtils.post(url, params, OkHttpUtils.Charset.UTF_8, headers, iPoolProxy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                Document document = Jsoup.parse(result);
                return document;
            } else {
                System.out.println("响应失败，循环尝试10次--------------------------" + url);
                for (int i = 1; i < 11; i++) {
                    System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                    try {
                        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                        if(iPoolProxy==null){
                            System.out.println("代理是空,使用蘑菇代理");
                            HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
                            headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                            result = OkHttpUtils.post(url, params, OkHttpUtils.Charset.UTF_8, headers, mouGuProxy);
                        }else{
                            //设置头部信息
                            result = OkHttpUtils.post(url, params, OkHttpUtils.Charset.UTF_8, headers, iPoolProxy);
                        }
                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                System.out.println("循环第" + i + "次,再次失败--------------------------" + url);
                                /*if(i==10){
                                    System.err.println(doc);
                                }*/
                                continue;
                            } else {
                                System.out.println("循环尝试第" + i + "次，相应成功--------------------------" + url);
                                return doc;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Document downLoadPageByPost(String url, String json) {
        return downLoadPageByPost(url,json,"UTF-8",null);
    }

    @Override
    public Document downLoadPageByPost(String url, String json, Map<String, String> headers) {
        return downLoadPageByPost(url,json,"UTF-8",headers);
    }

    @Override
    public Document downLoadPageByPost(String url, String json, String charset, Map<String, String> headers) {

        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                //设置代理池
                HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                if(iPoolProxy==null){
                    System.out.println("代理是空,使用蘑菇代理");
                    HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
                    headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                    result = OkHttpUtils.post(url, json, OkHttpUtils.Charset.UTF_8, headers, mouGuProxy);
                }else{
                    //设置头部信息
                    result = OkHttpUtils.post(url, json, OkHttpUtils.Charset.UTF_8, headers, iPoolProxy);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                Document document = Jsoup.parse(result);
                return document;
            } else {
                System.out.println("响应失败，循环尝试10次--------------------------" + url);
                for (int i = 1; i < 11; i++) {
                    System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                    try {
                        //设置代理池
                        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                        if(iPoolProxy==null){
                            System.out.println("代理是空,使用蘑菇代理");
                            HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
                            headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                            result = OkHttpUtils.post(url, json, OkHttpUtils.Charset.UTF_8, headers, mouGuProxy);
                        }else{
                            //设置头部信息
                            result = OkHttpUtils.post(url, json, OkHttpUtils.Charset.UTF_8, headers, iPoolProxy);
                        }
                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                System.out.println("循环第" + i + "次,再次失败--------------------------" + url);
                                /*if(i==10){
                                    System.err.println(doc);
                                }*/
                                continue;
                            } else {
                                System.out.println("循环尝试第" + i + "次，相应成功--------------------------" + url);
                                return doc;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
                return null;
            }
        }else{
            return null;
        }
    }
}
