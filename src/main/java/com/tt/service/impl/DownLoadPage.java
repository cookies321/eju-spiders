package com.tt.service.impl;

import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DownLoadPage {

    public static void main(String[] args) {
        DownLoadPage downLoadPage = new DownLoadPage();
        String s = downLoadPage.downLoadPage("https://beijing.anjuke.com/community/chaoyang/");
        System.out.println(s);
    }

    /**
     * 下载页面
     *
     * @param url
     * @return
     */
    public String downLoadPage(String url) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                return result;
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

                            if (!ValidateUtil.valid(result)) {
                                System.out.println("循环第" + i + "次,成功响应--------------------------" + url);
                                return result;
                            }else{
                                System.out.println("循环第" + i + "次,响应失败--------------------------" + url);
                                continue;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
    public String downLoadPage(String url,Map<String,String> headers) {
        if (StringUtils.isNotBlank(url)) {
            String result = null;
            try {
                HttpResponse response = PageDownLoadUtil.httpMoguproxyGet(url,headers);
                if(response!=null){
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    if(entity!=null){
                        // 打印响应状态
                        if (entity != null) {
                            result = EntityUtils.toString(entity);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断相应结果不为空，并且判断错误页面
            if (!ValidateUtil.valid(result)) {
                return result;
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

                            if (!ValidateUtil.valid(result)) {
                                System.out.println("循环第" + i + "次,成功响应--------------------------" + url);
                                return result;
                            }else{
                                System.out.println("循环第" + i + "次,响应失败--------------------------" + url);
                                continue;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
    public String downLoadPage(String url, Map<String, String> params, Map<String, String> headers) {
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
                return result;
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

                            if (!ValidateUtil.valid(result)) {
                                System.out.println("循环第" + i + "次,成功响应--------------------------" + url);
                                return result;
                            }else{
                                System.out.println("循环第" + i + "次,响应失败--------------------------" + url);
                                continue;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }else{
            return null;
        }
    }

}
