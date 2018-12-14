package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class ZhugeCommunity implements Serializable {
    private String id;

    private String detailUrl;

    private String titleId;

    private String title;

    private String city;

    private String region;

    private String plate;

    private String address;

    private String buildYear;

    private String propertyYear;

    private String plotRate;

    private String greenRate;

    private String loudongNum;

    private String homeTotal;

    private String propertyPrice;

    private String propertyCompany;

    private String buildDevelopers;

    private String buildType;

    private String buildArea;

    private String floorArea;

    private String heating;

    private String gas;

    private String parkNum;

    private String elevator;

    private String averagePriceTrend;

    private String jiaoyiNum;

    private String status;

    private Date createtime;

    private String batchId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getLoudongNum() {
        return loudongNum;
    }

    public void setLoudongNum(String loudongNum) {
        this.loudongNum = loudongNum == null ? null : loudongNum.trim();
    }

    public String getHomeTotal() {
        return homeTotal;
    }

    public void setHomeTotal(String homeTotal) {
        this.homeTotal = homeTotal == null ? null : homeTotal.trim();
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

    public String getBuildDevelopers() {
        return buildDevelopers;
    }

    public void setBuildDevelopers(String buildDevelopers) {
        this.buildDevelopers = buildDevelopers == null ? null : buildDevelopers.trim();
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType == null ? null : buildType.trim();
    }

    public String getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea == null ? null : buildArea.trim();
    }

    public String getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea == null ? null : floorArea.trim();
    }

    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating == null ? null : heating.trim();
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas == null ? null : gas.trim();
    }

    public String getParkNum() {
        return parkNum;
    }

    public void setParkNum(String parkNum) {
        this.parkNum = parkNum == null ? null : parkNum.trim();
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator == null ? null : elevator.trim();
    }

    public String getAveragePriceTrend() {
        return averagePriceTrend;
    }

    public void setAveragePriceTrend(String averagePriceTrend) {
        this.averagePriceTrend = averagePriceTrend == null ? null : averagePriceTrend.trim();
    }

    public String getJiaoyiNum() {
        return jiaoyiNum;
    }

    public void setJiaoyiNum(String jiaoyiNum) {
        this.jiaoyiNum = jiaoyiNum == null ? null : jiaoyiNum.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }
}