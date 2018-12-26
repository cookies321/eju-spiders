package com.tt.common;

import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;

public class DownLoadPage {

    public static String valiResult(String result){
        //判断相应结果不为空，并且判断错误页面
        if (!ValidateUtil.valid(result)) {
            return result;
        } else {
            System.out.println("响应失败，循环尝试10次--------------------------");
            for (int i = 1; i < 11; i++) {
                System.out.println("响应失败，循环尝试第" + i + "次--------------------------");
                try {
                    result = PageDownLoadUtil.httpClientQuanGet("");

                    if (!ValidateUtil.valid(result)) {
                        Document doc = Jsoup.parse(result);
                        if (doc == null) {
                            System.out.println("循环第" + i + "次,再次失败--------------------------");
                            if(i==10){
                                System.err.println(doc);
                            }
                            continue;
                        } else {
                            System.out.println("循环尝试第" + i + "次，相应成功--------------------------");
                            return "";
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            return null;
        }
    }

    /**
     * get下载页面
     *
     * @param url
     * @return
     */
    public static Document downLoadPage(String url) {
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                HttpResponse response = PageDownLoadUtil.httpMoguproxyGet(url);
                if(response!=null){
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    // 打印响应状态
                    if (entity != null) {
                        result = EntityUtils.toString(entity);
                    }
                }
                //result = PageDownLoadUtil.httpClientQuanGet(url);
               /* HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                result = HttpClientUtils0.get(url,"UTF-8",iPoolProxy);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                Document document = Jsoup.parse(result);
                return document;
            } else {
                System.out.println("响应失败，循环尝试10次--------------------------" + url);

                for (int i = 1; i < 21; i++) {
                    System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                    try {
                        HttpResponse response = PageDownLoadUtil.httpMoguproxyGet(url);
                        if(response!=null){
                            // 获取响应实体
                            HttpEntity entity = response.getEntity();
                            // 打印响应状态
                            if (entity != null) {
                                result = EntityUtils.toString(entity);
                            }
                        }
                        /*HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
                        result = HttpClientUtils0.get(url,"UTF-8",iPoolProxy);*/
                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                System.out.println("循环第" + i + "次,再次失败--------------------------" + url);
                                if(i==10){
                                    System.err.println(doc);
                                }
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


    /**
     * get下载页面
     *
     * @param url
     * @return
     */
    public static Document downLoadPage(String url,Map<String,String> headers) {
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                HttpResponse response = PageDownLoadUtil.httpMoguproxyGet(url,headers);
                if(response!=null){
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    // 打印响应状态
                    if (entity != null) {
                        result = EntityUtils.toString(entity);
                    }
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
                System.err.println(result);
                for (int i = 1; i < 11; i++) {
                    try {
                        System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                        HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyGet(url,headers);
                       if(httpResponse!=null){
                            // 获取响应实体
                            HttpEntity entity = httpResponse.getEntity();
                            // 打印响应状态
                            if (entity != null) {
                                result = EntityUtils.toString(entity);
                            }
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

    /**
     * get下载页面
     *
     * @param url
     * @return
     */
    public static Document downLoadPage(String url,String charset) {
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                result = PageDownLoadUtil.httpClientQuanGet(url,charset);
                /*HttpResponse response = PageDownLoadUtil.httpMoguproxyGet(url);
                if(response!=null){
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    // 打印响应状态
                    if (entity != null) {
                        result = EntityUtils.toString(entity);
                    }
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                Document document = Jsoup.parse(result);
                return document;
            } else {
                System.out.println("响应失败，循环尝试10次--------------------------" + url);
                /*System.err.println(result);*/
                for (int i = 1; i < 11; i++) {
                    System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                    try {
                        result = PageDownLoadUtil.httpClientQuanGet(url,charset);
                        /*HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyGet(url);
                        if(httpResponse!=null){
                            // 获取响应实体
                            HttpEntity entity = httpResponse.getEntity();
                            // 打印响应状态
                            if (entity != null) {
                                result = EntityUtils.toString(entity);
                            }
                        }*/
                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                System.out.println("循环第" + i + "次,再次失败--------------------------" + url);
                                if(i==10){
                                    System.err.println(doc);
                                }
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


    /**
     *  post 下载页面
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static Document downLoadPage(String url, Map<String, String> params, Map<String, String> headers) {
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                HttpResponse response = PageDownLoadUtil.httpMoguproxyPost(url,params,headers);
                if(response!=null){
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    // 打印响应状态
                    if (entity != null) {
                        result = EntityUtils.toString(entity);
                    }
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
                /*System.err.println(result);*/
                for (int i = 1; i < 11; i++) {
                    System.out.println("响应失败，循环尝试第" + i + "次--------------------------" + url);
                    try {
                        HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyGet(url);
                        if(httpResponse!=null){
                            // 获取响应实体
                            HttpEntity entity = httpResponse.getEntity();
                            // 打印响应状态
                            if (entity != null) {
                                result = EntityUtils.toString(entity);
                            }
                        }
                        if (!ValidateUtil.valid(result)) {
                            Document doc = Jsoup.parse(result);
                            if (doc == null) {
                                System.out.println("循环第" + i + "次,再次失败--------------------------" + url);
                                if(i==10){
                                    System.err.println(doc);
                                }
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
