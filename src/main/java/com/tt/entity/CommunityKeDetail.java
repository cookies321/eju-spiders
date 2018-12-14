package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class CommunityKeDetail implements Serializable {
    private Long id;

    private String titleId;

    private String title;

    private String alias;

    private String address;

    private String cityCode;

    private String city;

    private String regionCode;

    private String region;

    private String plateCode;

    private String plate;

    private String surfacePlot;

    private String averagePrice;

    private String propertyYear;

    private String buildYear;

    private String tradingRights;

    private String buildDevelopers;

    private String plotRate;

    private String buildType;

    private String loudongNum;

    private String homeTotal;

    private String propertyPrice;

    private String propertyCompany;

    private String propertyPhone;

    private String parkNum;

    private String upperNum;

    private String underNum;

    private String parkRatio;

    private String fixedCharge;

    private String greenRate;

    private String water;

    private String supplyElectricity;

    private String heating;

    private String heatingCost;

    private String gas;

    private String uses;

    private String loudongUrl;

    private String layoutUrl;

    private Date createTime;

    private String source;

    private String tag;

    private String status;

    private String loopPosition;

    private String detailUrl;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode == null ? null : plateCode.trim();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public String getSurfacePlot() {
        return surfacePlot;
    }

    public void setSurfacePlot(String surfacePlot) {
        this.surfacePlot = surfacePlot == null ? null : surfacePlot.trim();
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice == null ? null : averagePrice.trim();
    }

    public String getPropertyYear() {
        return propertyYear;
    }

    public void setPropertyYear(String propertyYear) {
        this.propertyYear = propertyYear == null ? null : propertyYear.trim();
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public String getTradingRights() {
        return tradingRights;
    }

    public void setTradingRights(String tradingRights) {
        this.tradingRights = tradingRights == null ? null : tradingRights.trim();
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

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType == null ? null : buildType.trim();
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

    public String getPropertyPhone() {
        return propertyPhone;
    }

    public void setPropertyPhone(String propertyPhone) {
        this.propertyPhone = propertyPhone == null ? null : propertyPhone.trim();
    }

    public String getParkNum() {
        return parkNum;
    }

    public void setParkNum(String parkNum) {
        this.parkNum = parkNum == null ? null : parkNum.trim();
    }

    public String getUpperNum() {
        return upperNum;
    }

    public void setUpperNum(String upperNum) {
        this.upperNum = upperNum == null ? null : upperNum.trim();
    }

    public String getUnderNum() {
        return underNum;
    }

    public void setUnderNum(String underNum) {
        this.underNum = underNum == null ? null : underNum.trim();
    }

    public String getParkRatio() {
        return parkRatio;
    }

    public void setParkRatio(String parkRatio) {
        this.parkRatio = parkRatio == null ? null : parkRatio.trim();
    }

    public String getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(String fixedCharge) {
        this.fixedCharge = fixedCharge == null ? null : fixedCharge.trim();
    }

    public String getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(String greenRate) {
        this.greenRate = greenRate == null ? null : greenRate.trim();
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water == null ? null : water.trim();
    }

    public String getSupplyElectricity() {
        return supplyElectricity;
    }

    public void setSupplyElectricity(String supplyElectricity) {
        this.supplyElectricity = supplyElectricity == null ? null : supplyElectricity.trim();
    }

    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating == null ? null : heating.trim();
    }

    public String getHeatingCost() {
        return heatingCost;
    }

    public void setHeatingCost(String heatingCost) {
        this.heatingCost = heatingCost == null ? null : heatingCost.trim();
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas == null ? null : gas.trim();
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses == null ? null : uses.trim();
    }

    public String getLoudongUrl() {
        return loudongUrl;
    }

    public void setLoudongUrl(String loudongUrl) {
        this.loudongUrl = loudongUrl == null ? null : loudongUrl.trim();
    }

    public String getLayoutUrl() {
        return layoutUrl;
    }

    public void setLayoutUrl(String layoutUrl) {
        this.layoutUrl = layoutUrl == null ? null : layoutUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLoopPosition() {
        return loopPosition;
    }

    public void setLoopPosition(String loopPosition) {
        this.loopPosition = loopPosition == null ? null : loopPosition.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }
}