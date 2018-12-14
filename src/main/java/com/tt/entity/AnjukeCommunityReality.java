package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class AnjukeCommunityReality implements Serializable {
    private String id;

    private String fangId;

    private String detailUrl;

    private String realityUrl;

    private String picSrc;

    private String picUrl;

    private String status;

    private String batchId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFangId() {
        return fangId;
    }

    public void setFangId(String fangId) {
        this.fangId = fangId == null ? null : fangId.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getRealityUrl() {
        return realityUrl;
    }

    public void setRealityUrl(String realityUrl) {
        this.realityUrl = realityUrl == null ? null : realityUrl.trim();
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}