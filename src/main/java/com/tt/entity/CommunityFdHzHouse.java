package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityFdHzHouse implements Serializable {
    private String id;

    private String detailUrl;

    private String building;

    private String unitNum;

    private String houseName;

    private String layout;

    private String realFloor;

    private String predictedArea;

    private String dwellingFloorSpace;

    private String sharedBuildingArea;

    private String maopiPrice;

    private String renovationPrice;

    private String salePrice;

    private String totalPrice;

    private String propertyCompany;

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

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum == null ? null : unitNum.trim();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }

    public String getRealFloor() {
        return realFloor;
    }

    public void setRealFloor(String realFloor) {
        this.realFloor = realFloor == null ? null : realFloor.trim();
    }

    public String getPredictedArea() {
        return predictedArea;
    }

    public void setPredictedArea(String predictedArea) {
        this.predictedArea = predictedArea == null ? null : predictedArea.trim();
    }

    public String getDwellingFloorSpace() {
        return dwellingFloorSpace;
    }

    public void setDwellingFloorSpace(String dwellingFloorSpace) {
        this.dwellingFloorSpace = dwellingFloorSpace == null ? null : dwellingFloorSpace.trim();
    }

    public String getSharedBuildingArea() {
        return sharedBuildingArea;
    }

    public void setSharedBuildingArea(String sharedBuildingArea) {
        this.sharedBuildingArea = sharedBuildingArea == null ? null : sharedBuildingArea.trim();
    }

    public String getMaopiPrice() {
        return maopiPrice;
    }

    public void setMaopiPrice(String maopiPrice) {
        this.maopiPrice = maopiPrice == null ? null : maopiPrice.trim();
    }

    public String getRenovationPrice() {
        return renovationPrice;
    }

    public void setRenovationPrice(String renovationPrice) {
        this.renovationPrice = renovationPrice == null ? null : renovationPrice.trim();
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice == null ? null : salePrice.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
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