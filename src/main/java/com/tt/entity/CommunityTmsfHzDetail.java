package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityTmsfHzDetail implements Serializable {
    private String id;

    private String detailUrl;

    private String titleId;

    private String propertyType;

    private String address;

    private String homeTotal;

    private String mainLayout;

    private String decoration;

    private String buildType;

    private String buildDevelopers;

    private String plotRate;

    private String greenRate;

    private String floorArea;

    private String buildArea;

    private String buildYear;

    private String propertyYear;

    private String parking;

    private String propertyPrice;

    private String propertyCompany;

    private String leadTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHomeTotal() {
        return homeTotal;
    }

    public void setHomeTotal(String homeTotal) {
        this.homeTotal = homeTotal == null ? null : homeTotal.trim();
    }

    public String getMainLayout() {
        return mainLayout;
    }

    public void setMainLayout(String mainLayout) {
        this.mainLayout = mainLayout == null ? null : mainLayout.trim();
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration == null ? null : decoration.trim();
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType == null ? null : buildType.trim();
    }

    public String getBuildDevelopers() {
        return buildDevelopers;
    }

    public void setBuildDevelopers(String buildDevelopers) {
        this.buildDevelopers = buildDevelopers == null ? null : buildDevelopers.trim();
    }

    public String getPlotRate() {
        return plotRate;
    }

    public void setPlotRate(String plotRate) {
        this.plotRate = plotRate == null ? null : plotRate.trim();
    }

    public String getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(String greenRate) {
        this.greenRate = greenRate == null ? null : greenRate.trim();
    }

    public String getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea == null ? null : floorArea.trim();
    }

    public String getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea == null ? null : buildArea.trim();
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public String getPropertyYear() {
        return propertyYear;
    }

    public void setPropertyYear(String propertyYear) {
        this.propertyYear = propertyYear == null ? null : propertyYear.trim();
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking == null ? null : parking.trim();
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice == null ? null : propertyPrice.trim();
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime == null ? null : leadTime.trim();
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