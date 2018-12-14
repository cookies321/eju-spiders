package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class ZhugeCommunityDeal implements Serializable {
    private String id;

    private String detailUrl;

    private String titleId;

    private String dealTotalPrice;

    private String dealAveragePrice;

    private String area;

    private String layout;

    private String dealTime;

    private String dealSrc;

    private String dataSrc;

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

    public String getDealTotalPrice() {
        return dealTotalPrice;
    }

    public void setDealTotalPrice(String dealTotalPrice) {
        this.dealTotalPrice = dealTotalPrice == null ? null : dealTotalPrice.trim();
    }

    public String getDealAveragePrice() {
        return dealAveragePrice;
    }

    public void setDealAveragePrice(String dealAveragePrice) {
        this.dealAveragePrice = dealAveragePrice == null ? null : dealAveragePrice.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime == null ? null : dealTime.trim();
    }

    public String getDealSrc() {
        return dealSrc;
    }

    public void setDealSrc(String dealSrc) {
        this.dealSrc = dealSrc == null ? null : dealSrc.trim();
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
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