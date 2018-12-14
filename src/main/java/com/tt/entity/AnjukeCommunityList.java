package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class AnjukeCommunityList implements Serializable {
    private String id;

    private String fangId;

    private String homeName;

    private String address;

    private String city;

    private String region;

    private String plate;

    private String buildYear;

    private String averagePrice;

    private String thumbUrl;

    private String detailUrl;

    private String loopPosition;

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

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName == null ? null : homeName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice == null ? null : averagePrice.trim();
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl == null ? null : thumbUrl.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getLoopPosition() {
        return loopPosition;
    }

    public void setLoopPosition(String loopPosition) {
        this.loopPosition = loopPosition == null ? null : loopPosition.trim();
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