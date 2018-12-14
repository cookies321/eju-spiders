package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityFdNjHouse implements Serializable {
    private String id;

    private String building;

    private String buildingId;

    private String houseUrl;

    private String houseName;

    private String houseId;

    private String realFloor;

    private String predictedArea;

    private String dwellingFloorSpace;

    private String sharedBuildingArea;

    private String price;

    private String isSale;

    private String propertyType;

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

    public String getHouseUrl() {
        return houseUrl;
    }

    public void setHouseUrl(String houseUrl) {
        this.houseUrl = houseUrl == null ? null : houseUrl.trim();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getIsSale() {
        return isSale;
    }

    public void setIsSale(String isSale) {
        this.isSale = isSale == null ? null : isSale.trim();
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
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