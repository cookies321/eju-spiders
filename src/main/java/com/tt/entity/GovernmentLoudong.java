package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class GovernmentLoudong implements Serializable {
    private String id;

    private String title;

    private String titleId;

    private String salesNo;

    private String titleRelation;

    private String building;

    private String buildingId;

    private String saleHouse;

    private String saleNothouse;

    private String loudongUrl;

    private String realFloor;

    private String nominalFloor;

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

    public String getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo == null ? null : salesNo.trim();
    }

    public String getTitleRelation() {
        return titleRelation;
    }

    public void setTitleRelation(String titleRelation) {
        this.titleRelation = titleRelation == null ? null : titleRelation.trim();
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

    public String getSaleHouse() {
        return saleHouse;
    }

    public void setSaleHouse(String saleHouse) {
        this.saleHouse = saleHouse == null ? null : saleHouse.trim();
    }

    public String getSaleNothouse() {
        return saleNothouse;
    }

    public void setSaleNothouse(String saleNothouse) {
        this.saleNothouse = saleNothouse == null ? null : saleNothouse.trim();
    }

    public String getLoudongUrl() {
        return loudongUrl;
    }

    public void setLoudongUrl(String loudongUrl) {
        this.loudongUrl = loudongUrl == null ? null : loudongUrl.trim();
    }

    public String getRealFloor() {
        return realFloor;
    }

    public void setRealFloor(String realFloor) {
        this.realFloor = realFloor == null ? null : realFloor.trim();
    }

    public String getNominalFloor() {
        return nominalFloor;
    }

    public void setNominalFloor(String nominalFloor) {
        this.nominalFloor = nominalFloor == null ? null : nominalFloor.trim();
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