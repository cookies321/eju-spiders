package com.tt.entity;

import java.io.Serializable;

public class KeLoudong implements Serializable {
    private String id;

    private String titleId;

    private String building;

    private String buildingId;

    private String elevator;

    private String frameNum;

    private String buildYear;

    private String buildType;

    private String unitNum;

    private String pointLat;

    private String pointLng;

    private String gaodeLat;

    private String gaodeLng;

    private String distance;

    private String ladderRatio;

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

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator == null ? null : elevator.trim();
    }

    public String getFrameNum() {
        return frameNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum == null ? null : frameNum.trim();
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType == null ? null : buildType.trim();
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum == null ? null : unitNum.trim();
    }

    public String getPointLat() {
        return pointLat;
    }

    public void setPointLat(String pointLat) {
        this.pointLat = pointLat == null ? null : pointLat.trim();
    }

    public String getPointLng() {
        return pointLng;
    }

    public void setPointLng(String pointLng) {
        this.pointLng = pointLng == null ? null : pointLng.trim();
    }

    public String getGaodeLat() {
        return gaodeLat;
    }

    public void setGaodeLat(String gaodeLat) {
        this.gaodeLat = gaodeLat == null ? null : gaodeLat.trim();
    }

    public String getGaodeLng() {
        return gaodeLng;
    }

    public void setGaodeLng(String gaodeLng) {
        this.gaodeLng = gaodeLng == null ? null : gaodeLng.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getLadderRatio() {
        return ladderRatio;
    }

    public void setLadderRatio(String ladderRatio) {
        this.ladderRatio = ladderRatio == null ? null : ladderRatio.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}