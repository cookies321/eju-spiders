package com.tt.vo;

import com.tt.entity.AnjukeCommunityWithBLOBs;

import java.io.Serializable;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/22 14:04
 * @Description:
 */
public class AnjukeParamsVo implements Serializable {
    /**
     * 类型枚举类
     */
    private UrlType urkType;

    /**
     * 数据来源网站
     */
    private UrlType dataSource;

    /**
     * 上一级url
     */
    private String parentUrl;
    /**
     * 请求链接
     */
    private String url;

    /**
     * 基础信息关联uuid
     */
    private String uuid;

    /**
     * 请求类型
     */
    private UrlType httpType;

    /**
     * post请求参数
     */
    private String postJsonParams;

    /**
     * post请求参数
     */
    private Map<String,String> postMapParams;

    /**
     * 请求中需要带的头部信息
     */
    private Map<String,String> header;

   /**
    * 携带基本信息
    */
    private Map<String,String> detail;

    /**
     * 安居客实体信息
     */
    private AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs;

    public AnjukeCommunityWithBLOBs getAnjukeCommunityWithBLOBs() {
        return anjukeCommunityWithBLOBs;
    }

    public void setAnjukeCommunityWithBLOBs(AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs) {
        this.anjukeCommunityWithBLOBs = anjukeCommunityWithBLOBs;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UrlType getUrkType() {
        return urkType;
    }

    public void setUrkType(UrlType urkType) {
        this.urkType = urkType;
    }

    public UrlType getDataSource() {
        return dataSource;
    }

    public void setDataSource(UrlType dataSource) {
        this.dataSource = dataSource;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UrlType getHttpType() {
        return httpType;
    }

    public void setHttpType(UrlType httpType) {
        this.httpType = httpType;
    }

    public String getPostJsonParams() {
        return postJsonParams;
    }

    public void setPostJsonParams(String postJsonParams) {
        this.postJsonParams = postJsonParams;
    }

    public Map<String, String> getPostMapParams() {
        return postMapParams;
    }

    public void setPostMapParams(Map<String, String> postMapParams) {
        this.postMapParams = postMapParams;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, String> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, String> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "AnjukeParamsVo{" +
                "urkType=" + urkType +
                ", dataSource=" + dataSource +
                ", parentUrl='" + parentUrl + '\'' +
                ", url='" + url + '\'' +
                ", uuid='" + uuid + '\'' +
                ", httpType=" + httpType +
                ", postJsonParams='" + postJsonParams + '\'' +
                ", postMapParams=" + postMapParams +
                ", header=" + header +
                ", detail=" + detail +
                ", anjukeCommunityWithBLOBs=" + anjukeCommunityWithBLOBs +
                ", content='" + content + '\'' +
                '}';
    }
}
