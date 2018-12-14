package com.tt.service;

import org.jsoup.nodes.Document;

import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/14 10:14
 * @Description:
 */
public interface IDownLoadPage {
    //get
    Document downLoadPageByGet(String url);
    //get
    Document downLoadPageByGet(String url,Map<String,String> headers);
    //get
    Document downLoadPageByGet(String url, String charset, Map<String,String> headers);
    Document downLoadPageByGet(String url, String charset,Integer connTimeout, Integer readTimeout, Map<String,String> headers);

    //post FORM
    Document downLoadPageByPost(String url,Map<String, String> params);
    Document downLoadPageByPost(String url,Map<String, String> params,Map<String,String> headers);
    Document downLoadPageByPost(String url,Map<String, String> params,String charset,Map<String,String> headers);


    //post JOSN
    Document downLoadPageByPost(String url, String json);
    Document downLoadPageByPost(String url, String json, Map<String, String> headers);
    Document downLoadPageByPost(String url, String json, String charset, Map<String, String> headers);
}
