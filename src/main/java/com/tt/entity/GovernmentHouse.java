package com.tt.entity;

import java.io.Serializable;
import java.util.Date;

public class GovernmentHouse implements Serializable {
    private String id;

    private String building;

    private String buildingId;

    private String houseName;

    private String houseId;

    private String realFloor;

    private String nominalFloor;

    private String status;

    private String batchId;

    private Date createTime;

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

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public String getRealFloor() {
        return realFloor;
    }

    public void setRealFloor(String realFloor) {
        this.realFloor = realFloor == null ? null : realFloor.trim();
    }

    public String getNominalFloor() {
        return nominalFloor;
    }

    public void setNominalFloor(String nominalFloor) {
        this.nominalFloor = nominalFloor == null ? null : nominalFloor.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}