package com.tt.entity;

import java.io.Serializable;

public class CommunityKeDetailReleaseHouseWithBLOBs extends CommunityKeDetailReleaseHouse implements Serializable {
    private String gate;

    private String xiaoquPhotoUrl;

    private String xiaoquPhotoUrlLocal;

    private String introduction;

    private String archDes;

    private String buildingDes;

    private static final long serialVersionUID = 1L;

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate == null ? null : gate.trim();
    }

    public String getXiaoquPhotoUrl() {
        return xiaoquPhotoUrl;
    }

    public void setXiaoquPhotoUrl(String xiaoquPhotoUrl) {
        this.xiaoquPhotoUrl = xiaoquPhotoUrl == null ? null : xiaoquPhotoUrl.trim();
    }

    public String getXiaoquPhotoUrlLocal() {
        return xiaoquPhotoUrlLocal;
    }

    public void setXiaoquPhotoUrlLocal(String xiaoquPhotoUrlLocal) {
        this.xiaoquPhotoUrlLocal = xiaoquPhotoUrlLocal == null ? null : xiaoquPhotoUrlLocal.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getArchDes() {
        return archDes;
    }

    public void setArchDes(String archDes) {
        this.archDes = archDes == null ? null : archDes.trim();
    }

    public String getBuildingDes() {
        return buildingDes;
    }

    public void setBuildingDes(String buildingDes) {
        this.buildingDes = buildingDes == null ? null : buildingDes.trim();
    }
}