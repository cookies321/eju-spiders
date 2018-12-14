package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class FangXfLoupangBuildinglayout implements Serializable {
    private String id;

    private String title;

    private String period;

    private String titleId;

    private String detailPc;

    private String building;

    private String buildingId;

    private String huxingUrl;

    private Date createtime;

    private String status;

    private String batchId;

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId == null ? null : titleId.trim();
    }

    public String getDetailPc() {
        return detailPc;
    }

    public void setDetailPc(String detailPc) {
        this.detailPc = detailPc == null ? null : detailPc.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getHuxingUrl() {
        return huxingUrl;
    }

    public void setHuxingUrl(String huxingUrl) {
        this.huxingUrl = huxingUrl == null ? null : huxingUrl.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
}