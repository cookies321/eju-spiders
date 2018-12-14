package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class GovernmentCommunity implements Serializable {
    private String id;

    private String title;

    private String titleId;

    private String region;

    private String address;

    private String buildDevelopers;

    private String saleHouse;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId == null ? null : titleId.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBuildDevelopers() {
        return buildDevelopers;
    }

    public void setBuildDevelopers(String buildDevelopers) {
        this.buildDevelopers = buildDevelopers == null ? null : buildDevelopers.trim();
    }

    public String getSaleHouse() {
        return saleHouse;
    }

    public void setSaleHouse(String saleHouse) {
        this.saleHouse = saleHouse == null ? null : saleHouse.trim();
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