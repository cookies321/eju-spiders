package com.tt.service.impl;

import com.tt.common.utils.HttpClientUtils;
import com.tt.common.utils.ProxyUtils;
import com.tt.common.utils.ValidateUtil;
import com.tt.service.IDownLoadPage;
import com.tt.service.JedisClientService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/14 10:21
 * @Description:
 */
@Service("moguProxy")
public class DownLoadPageByMoguProxyServicImpl implements IDownLoadPage {
    private static Integer connTimeoutDefault = 5000;
    private static Integer readTimeoutDefault = 5000;

    @Autowired
    private JedisClientService jedisClientService;

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
            //设置蘑菇代理
            HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
            String result = null;
            try {
                //设置头部信息
                headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                result = HttpClientUtils.get(url, charset,connTimeout,readTimeout, headers, mouGuProxy);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                Document document = Jsoup.parse(result);
                return document;
            } else {
                System.out.println("响应失败，循环尝试10次--------------------------" + url);
                System.err.println(result);
                for (int i = 1; i < 20; i++) {
                    try {
                        System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                        result = HttpClientUtils.get(url, charset,connTimeout,readTimeout, headers, mouGuProxy);

                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                if(i==20){
                                    System.err.println("失败链接，存入redis中");
                                    /*jedisClientService.addObjectToList("error",url);*/
                                }
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
        return downLoadPageByPost(url,params,new HashMap<>());
    }

    @Override
    public Document downLoadPageByPost(String url, Map<String, String> params, Map<String, String> headers) {
        return downLoadPageByPost(url,params,"UTF-8",headers);
    }

    @Override
    public Document downLoadPageByPost(String url, Map<String, String> params, String charset, Map<String, String> headers) {
        //设置蘑菇代理
        HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                //设置头部信息
                headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                result = HttpClientUtils.post(url, params, charset, headers, mouGuProxy);
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
                        result = HttpClientUtils.post(url, params, charset, headers, mouGuProxy);
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
        return downLoadPageByPost(url,json,"UTF-8",new HashMap<>());
    }

    @Override
    public Document downLoadPageByPost(String url, String json, Map<String, String> headers) {
        return downLoadPageByPost(url,json,"UTF-8",headers);
    }

    @Override
    public Document downLoadPageByPost(String url, String json, String charset, Map<String, String> headers) {
        //设置蘑菇代理
        HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                //设置头部信息
                headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");
                result = HttpClientUtils.post(url, json, charset, headers, mouGuProxy);
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
                        result = HttpClientUtils.post(url, json, charset, headers, mouGuProxy);
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
