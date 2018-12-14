package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityTmsfHzForhouse implements Serializable {
    private String id;

    private String region;

    private String plate;

    private String regionUrl;

    private String detailUrl;

    private String title;

    private String alias;

    private String surfacePlot;

    private String recordPrice;

    private String batchId;

    private String source;

    private String status;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl == null ? null : regionUrl.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getSurfacePlot() {
        return surfacePlot;
    }

    public void setSurfacePlot(String surfacePlot) {
        this.surfacePlot = surfacePlot == null ? null : surfacePlot.trim();
    }

    public String getRecordPrice() {
        return recordPrice;
    }

    public void setRecordPrice(String recordPrice) {
        this.recordPrice = recordPrice == null ? null : recordPrice.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}