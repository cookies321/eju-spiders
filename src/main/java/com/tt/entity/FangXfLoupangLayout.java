package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class FangXfLoupangLayout extends FangXfLoupangLayoutKey implements Serializable {
    private String title;

    private String titleId;

    private String detailPc;

    private String huxingUrl;

    private String huxingId;

    private String huxingName;

    private String currentArea;

    private String huxingStatus;

    private String aveprice;

    private String totalprice;

    private String tag;

    private String buildingDist;

    private String score;

    private String description;

    private String frameImage;

    private String uprightScore;

    private String daylightingScore;

    private String distributionScore;

    private String areaScore;

    private String effienScore;

    private String status;

    private Date createtime;

    private String batchId;

    private static final long serialVersionUID = 1L;

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

    public String getDetailPc() {
        return detailPc;
    }

    public void setDetailPc(String detailPc) {
        this.detailPc = detailPc == null ? null : detailPc.trim();
    }

    public String getHuxingUrl() {
        return huxingUrl;
    }

    public void setHuxingUrl(String huxingUrl) {
        this.huxingUrl = huxingUrl == null ? null : huxingUrl.trim();
    }

    public String getHuxingId() {
        return huxingId;
    }

    public void setHuxingId(String huxingId) {
        this.huxingId = huxingId == null ? null : huxingId.trim();
    }

    public String getHuxingName() {
        return huxingName;
    }

    public void setHuxingName(String huxingName) {
        this.huxingName = huxingName == null ? null : huxingName.trim();
    }

    public String getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(String currentArea) {
        this.currentArea = currentArea == null ? null : currentArea.trim();
    }

    public String getHuxingStatus() {
        return huxingStatus;
    }

    public void setHuxingStatus(String huxingStatus) {
        this.huxingStatus = huxingStatus == null ? null : huxingStatus.trim();
    }

    public String getAveprice() {
        return aveprice;
    }

    public void setAveprice(String aveprice) {
        this.aveprice = aveprice == null ? null : aveprice.trim();
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice == null ? null : totalprice.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getBuildingDist() {
        return buildingDist;
    }

    public void setBuildingDist(String buildingDist) {
        this.buildingDist = buildingDist == null ? null : buildingDist.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFrameImage() {
        return frameImage;
    }

    public void setFrameImage(String frameImage) {
        this.frameImage = frameImage == null ? null : frameImage.trim();
    }

    public String getUprightScore() {
        return uprightScore;
    }

    public void setUprightScore(String uprightScore) {
        this.uprightScore = uprightScore == null ? null : uprightScore.trim();
    }

    public String getDaylightingScore() {
        return daylightingScore;
    }

    public void setDaylightingScore(String daylightingScore) {
        this.daylightingScore = daylightingScore == null ? null : daylightingScore.trim();
    }

    public String getDistributionScore() {
        return distributionScore;
    }

    public void setDistributionScore(String distributionScore) {
        this.distributionScore = distributionScore == null ? null : distributionScore.trim();
    }

    public String getAreaScore() {
        return areaScore;
    }

    public void setAreaScore(String areaScore) {
        this.areaScore = areaScore == null ? null : areaScore.trim();
    }

    public String getEffienScore() {
        return effienScore;
    }

    public void setEffienScore(String effienScore) {
        this.effienScore = effienScore == null ? null : effienScore.trim();
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