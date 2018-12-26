package com.tt.entity;

import java.io.Serializable;

public class CommunityKeDetailGaodeAddress implements Serializable {
    private String id;

    private String titleId;

    private String title;

    private String titleGaode;

    private String addressGaode;

    private String locationGaode;

    private String provinceGaode;

    private String cityGaode;

    private String regionGaode;

    private String source;

    private String status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getTitleGaode() {
        return titleGaode;
    }

    public void setTitleGaode(String titleGaode) {
        this.titleGaode = titleGaode == null ? null : titleGaode.trim();
    }

    public String getAddressGaode() {
        return addressGaode;
    }

    public void setAddressGaode(String addressGaode) {
        this.addressGaode = addressGaode == null ? null : addressGaode.trim();
    }

    public String getLocationGaode() {
        return locationGaode;
    }

    public void setLocationGaode(String locationGaode) {
        this.locationGaode = locationGaode == null ? null : locationGaode.trim();
    }

    public String getProvinceGaode() {
        return provinceGaode;
    }

    public void setProvinceGaode(String provinceGaode) {
        this.provinceGaode = provinceGaode == null ? null : provinceGaode.trim();
    }

    public String getCityGaode() {
        return cityGaode;
    }

    public void setCityGaode(String cityGaode) {
        this.cityGaode = cityGaode == null ? null : cityGaode.trim();
    }

    public String getRegionGaode() {
        return regionGaode;
    }

    public void setRegionGaode(String regionGaode) {
        this.regionGaode = regionGaode == null ? null : regionGaode.trim();
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
}