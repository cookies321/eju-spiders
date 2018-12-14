package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityFdNjSales implements Serializable {
    private String id;

    private String title;

    private String titleId;

    private String permitId;

    private String buildDevelopers;

    private String region;

    private String address;

    private String landPropertyCertificate;

    private String newOpenTime;

    private String propertyType;

    private String propertyYear;

    private String landUsePermit;

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

    public String getPermitId() {
        return permitId;
    }

    public void setPermitId(String permitId) {
        this.permitId = permitId == null ? null : permitId.trim();
    }

    public String getBuildDevelopers() {
        return buildDevelopers;
    }

    public void setBuildDevelopers(String buildDevelopers) {
        this.buildDevelopers = buildDevelopers == null ? null : buildDevelopers.trim();
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

    public String getLandPropertyCertificate() {
        return landPropertyCertificate;
    }

    public void setLandPropertyCertificate(String landPropertyCertificate) {
        this.landPropertyCertificate = landPropertyCertificate == null ? null : landPropertyCertificate.trim();
    }

    public String getNewOpenTime() {
        return newOpenTime;
    }

    public void setNewOpenTime(String newOpenTime) {
        this.newOpenTime = newOpenTime == null ? null : newOpenTime.trim();
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public String getPropertyYear() {
        return propertyYear;
    }

    public void setPropertyYear(String propertyYear) {
        this.propertyYear = propertyYear == null ? null : propertyYear.trim();
    }

    public String getLandUsePermit() {
        return landUsePermit;
    }

    public void setLandUsePermit(String landUsePermit) {
        this.landUsePermit = landUsePermit == null ? null : landUsePermit.trim();
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