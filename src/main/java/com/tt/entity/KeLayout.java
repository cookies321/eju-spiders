package com.tt.entity;

import java.io.Serializable;

public class KeLayout implements Serializable {
    private String id;

    private String titleId;

    private String gid;

    private String fid;

    private String huxingType;

    private String huxingName;

    private String frameImage;

    private String frameUrl;

    private String bedroomNum;

    private String hallNum;

    private String currentArea;

    private String buildingDist;

    private String tag;

    private String frameOrientation;

    private String isHot;

    private String houseSellCnt;

    private String houseSoldCnt;

    private String houseCnt;

    private String status;

    private String source;

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

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getHuxingType() {
        return huxingType;
    }

    public void setHuxingType(String huxingType) {
        this.huxingType = huxingType == null ? null : huxingType.trim();
    }

    public String getHuxingName() {
        return huxingName;
    }

    public void setHuxingName(String huxingName) {
        this.huxingName = huxingName == null ? null : huxingName.trim();
    }

    public String getFrameImage() {
        return frameImage;
    }

    public void setFrameImage(String frameImage) {
        this.frameImage = frameImage == null ? null : frameImage.trim();
    }

    public String getFrameUrl() {
        return frameUrl;
    }

    public void setFrameUrl(String frameUrl) {
        this.frameUrl = frameUrl == null ? null : frameUrl.trim();
    }

    public String getBedroomNum() {
        return bedroomNum;
    }

    public void setBedroomNum(String bedroomNum) {
        this.bedroomNum = bedroomNum == null ? null : bedroomNum.trim();
    }

    public String getHallNum() {
        return hallNum;
    }

    public void setHallNum(String hallNum) {
        this.hallNum = hallNum == null ? null : hallNum.trim();
    }

    public String getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(String currentArea) {
        this.currentArea = currentArea == null ? null : currentArea.trim();
    }

    public String getBuildingDist() {
        return buildingDist;
    }

    public void setBuildingDist(String buildingDist) {
        this.buildingDist = buildingDist == null ? null : buildingDist.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getFrameOrientation() {
        return frameOrientation;
    }

    public void setFrameOrientation(String frameOrientation) {
        this.frameOrientation = frameOrientation == null ? null : frameOrientation.trim();
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
    }

    public String getHouseSellCnt() {
        return houseSellCnt;
    }

    public void setHouseSellCnt(String houseSellCnt) {
        this.houseSellCnt = houseSellCnt == null ? null : houseSellCnt.trim();
    }

    public String getHouseSoldCnt() {
        return houseSoldCnt;
    }

    public void setHouseSoldCnt(String houseSoldCnt) {
        this.houseSoldCnt = houseSoldCnt == null ? null : houseSoldCnt.trim();
    }

    public String getHouseCnt() {
        return houseCnt;
    }

    public void setHouseCnt(String houseCnt) {
        this.houseCnt = houseCnt == null ? null : houseCnt.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}