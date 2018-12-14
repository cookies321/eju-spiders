package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityFdNjDetail implements Serializable {
    private String id;

    private String title;

    private String titleId;

    private String propertyType;

    private String buildDevelopers;

    private String salesCompany;

    private String newOpenTime;

    private String preSalePermit;

    private String landPropertyCertificate;

    private String landUsePermit;

    private String engineeringPlanningPermit;

    private String builderLicence;

    private String propertyCompany;

    private String xiaoquPhotoUrl;

    private String xiaoquLayoutPhotoUrl;

    private String city;

    private String region;

    private String address;

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

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public String getBuildDevelopers() {
        return buildDevelopers;
    }

    public void setBuildDevelopers(String buildDevelopers) {
        this.buildDevelopers = buildDevelopers == null ? null : buildDevelopers.trim();
    }

    public String getSalesCompany() {
        return salesCompany;
    }

    public void setSalesCompany(String salesCompany) {
        this.salesCompany = salesCompany == null ? null : salesCompany.trim();
    }

    public String getNewOpenTime() {
        return newOpenTime;
    }

    public void setNewOpenTime(String newOpenTime) {
        this.newOpenTime = newOpenTime == null ? null : newOpenTime.trim();
    }

    public String getPreSalePermit() {
        return preSalePermit;
    }

    public void setPreSalePermit(String preSalePermit) {
        this.preSalePermit = preSalePermit == null ? null : preSalePermit.trim();
    }

    public String getLandPropertyCertificate() {
        return landPropertyCertificate;
    }

    public void setLandPropertyCertificate(String landPropertyCertificate) {
        this.landPropertyCertificate = landPropertyCertificate == null ? null : landPropertyCertificate.trim();
    }

    public String getLandUsePermit() {
        return landUsePermit;
    }

    public void setLandUsePermit(String landUsePermit) {
        this.landUsePermit = landUsePermit == null ? null : landUsePermit.trim();
    }

    public String getEngineeringPlanningPermit() {
        return engineeringPlanningPermit;
    }

    public void setEngineeringPlanningPermit(String engineeringPlanningPermit) {
        this.engineeringPlanningPermit = engineeringPlanningPermit == null ? null : engineeringPlanningPermit.trim();
    }

    public String getBuilderLicence() {
        return builderLicence;
    }

    public void setBuilderLicence(String builderLicence) {
        this.builderLicence = builderLicence == null ? null : builderLicence.trim();
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
    }

    public String getXiaoquPhotoUrl() {
        return xiaoquPhotoUrl;
    }

    public void setXiaoquPhotoUrl(String xiaoquPhotoUrl) {
        this.xiaoquPhotoUrl = xiaoquPhotoUrl == null ? null : xiaoquPhotoUrl.trim();
    }

    public String getXiaoquLayoutPhotoUrl() {
        return xiaoquLayoutPhotoUrl;
    }

    public void setXiaoquLayoutPhotoUrl(String xiaoquLayoutPhotoUrl) {
        this.xiaoquLayoutPhotoUrl = xiaoquLayoutPhotoUrl == null ? null : xiaoquLayoutPhotoUrl.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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