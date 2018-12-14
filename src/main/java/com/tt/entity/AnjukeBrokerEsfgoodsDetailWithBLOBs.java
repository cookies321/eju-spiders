package com.tt.entity;

import java.io.Serializable;

public class AnjukeBrokerEsfgoodsDetailWithBLOBs extends AnjukeBrokerEsfgoodsDetail implements Serializable {
    private String sellingPoint;

    private String serviceIntroduction;

    private String picJson;

    private static final long serialVersionUID = 1L;

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint == null ? null : sellingPoint.trim();
    }

    public String getServiceIntroduction() {
        return serviceIntroduction;
    }

    public void setServiceIntroduction(String serviceIntroduction) {
        this.serviceIntroduction = serviceIntroduction == null ? null : serviceIntroduction.trim();
    }

    public String getPicJson() {
        return picJson;
    }

    public void setPicJson(String picJson) {
        this.picJson = picJson == null ? null : picJson.trim();
    }
}