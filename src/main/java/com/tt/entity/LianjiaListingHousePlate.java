package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class LianjiaListingHousePlate implements Serializable {
    private String id;

    private String city;

    private String region;

    private String regionUrl;

    private String plate;

    private String plateUrl;

    private String source;

    private String status;

    private String batchId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl == null ? null : regionUrl.trim();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public String getPlateUrl() {
        return plateUrl;
    }

    public void setPlateUrl(String plateUrl) {
        this.plateUrl = plateUrl == null ? null : plateUrl.trim();
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

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}