package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class AnjukeBrokerList implements Serializable {
    private String id;

    private String url;

    private String brokerId;

    private String brokerImage;

    private String name;

    private String company;

    private String store;

    private String city;

    private String region;

    private String plate;

    private String community;

    private String tag;

    private String workYear;

    private String description;

    private Date ceatetime;

    private String batchId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId == null ? null : brokerId.trim();
    }

    public String getBrokerImage() {
        return brokerImage;
    }

    public void setBrokerImage(String brokerImage) {
        this.brokerImage = brokerImage == null ? null : brokerImage.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store == null ? null : store.trim();
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

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear == null ? null : workYear.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCeatetime() {
        return ceatetime;
    }

    public void setCeatetime(Date ceatetime) {
        this.ceatetime = ceatetime;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }
}