package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class FangXfLoupangBuilding implements Serializable {
    private String id;

    private String building;

    private String buildingId;

    private String title;

    private String detailPc;

    private String period;

    private String openTime;

    private String roomtime;

    private String elevator;

    private String unitNum;

    private String chushouNum;

    private String homeTotal;

    private String frameNum;

    private String buildType;

    private String status;

    private Date createtime;

    private String batchId;

    private String layout;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetailPc() {
        return detailPc;
    }

    public void setDetailPc(String detailPc) {
        this.detailPc = detailPc == null ? null : detailPc.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getRoomtime() {
        return roomtime;
    }

    public void setRoomtime(String roomtime) {
        this.roomtime = roomtime == null ? null : roomtime.trim();
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator == null ? null : elevator.trim();
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum == null ? null : unitNum.trim();
    }

    public String getChushouNum() {
        return chushouNum;
    }

    public void setChushouNum(String chushouNum) {
        this.chushouNum = chushouNum == null ? null : chushouNum.trim();
    }

    public String getHomeTotal() {
        return homeTotal;
    }

    public void setHomeTotal(String homeTotal) {
        this.homeTotal = homeTotal == null ? null : homeTotal.trim();
    }

    public String getFrameNum() {
        return frameNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum == null ? null : frameNum.trim();
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType == null ? null : buildType.trim();
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

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }
}