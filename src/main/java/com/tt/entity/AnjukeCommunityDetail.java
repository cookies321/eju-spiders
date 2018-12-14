package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class AnjukeCommunityDetail implements Serializable {
    private String id;

    private String fangId;

    private String homeName;

    private String detailUrl;

    private String homeTotal;

    private String buildDevelopers;

    private String buildArea;

    private String plotRate;

    private String greenRate;

    private String propertyType;

    private String propertyCompany;

    private String propertyPrice;

    private String duikouSchool;

    private String parkNum;

    private String layoutUrl;

    private String realityUrl;

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

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getHomeTotal() {
        return homeTotal;
    }

    public void setHomeTotal(String homeTotal) {
        this.homeTotal = homeTotal == null ? null : homeTotal.trim();
    }

    public String getBuildDevelopers() {
        return buildDevelopers;
    }

    public void setBuildDevelopers(String buildDevelopers) {
        this.buildDevelopers = buildDevelopers == null ? null : buildDevelopers.trim();
    }

    public String getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea == null ? null : buildArea.trim();
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

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice == null ? null : propertyPrice.trim();
    }

    public String getDuikouSchool() {
        return duikouSchool;
    }

    public void setDuikouSchool(String duikouSchool) {
        this.duikouSchool = duikouSchool == null ? null : duikouSchool.trim();
    }

    public String getParkNum() {
        return parkNum;
    }

    public void setParkNum(String parkNum) {
        this.parkNum = parkNum == null ? null : parkNum.trim();
    }

    public String getLayoutUrl() {
        return layoutUrl;
    }

    public void setLayoutUrl(String layoutUrl) {
        this.layoutUrl = layoutUrl == null ? null : layoutUrl.trim();
    }

    public String getRealityUrl() {
        return realityUrl;
    }

    public void setRealityUrl(String realityUrl) {
        this.realityUrl = realityUrl == null ? null : realityUrl.trim();
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