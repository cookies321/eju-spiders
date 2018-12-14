package com.tt.entity;

import java.io.Serializable;

public class AnjukeCommunityHuizongWithBLOBs extends AnjukeCommunityHuizong implements Serializable {
    private String overheadInformation;

    private String communication;

    private String exitInfos;

    private String traffic;

    private String peripheralInformation;

    private String xiaoquAveragepriceUrl;

    private String openInformationHistory;

    private String photoJson;

    private String layoutImages;

    private String realityImages;

    private static final long serialVersionUID = 1L;

    public String getOverheadInformation() {
        return overheadInformation;
    }

    public void setOverheadInformation(String overheadInformation) {
        this.overheadInformation = overheadInformation == null ? null : overheadInformation.trim();
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication == null ? null : communication.trim();
    }

    public String getExitInfos() {
        return exitInfos;
    }

    public void setExitInfos(String exitInfos) {
        this.exitInfos = exitInfos == null ? null : exitInfos.trim();
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic == null ? null : traffic.trim();
    }

    public String getPeripheralInformation() {
        return peripheralInformation;
    }

    public void setPeripheralInformation(String peripheralInformation) {
        this.peripheralInformation = peripheralInformation == null ? null : peripheralInformation.trim();
    }

    public String getXiaoquAveragepriceUrl() {
        return xiaoquAveragepriceUrl;
    }

    public void setXiaoquAveragepriceUrl(String xiaoquAveragepriceUrl) {
        this.xiaoquAveragepriceUrl = xiaoquAveragepriceUrl == null ? null : xiaoquAveragepriceUrl.trim();
    }

    public String getOpenInformationHistory() {
        return openInformationHistory;
    }

    public void setOpenInformationHistory(String openInformationHistory) {
        this.openInformationHistory = openInformationHistory == null ? null : openInformationHistory.trim();
    }

    public String getPhotoJson() {
        return photoJson;
    }

    public void setPhotoJson(String photoJson) {
        this.photoJson = photoJson == null ? null : photoJson.trim();
    }

    public String getLayoutImages() {
        return layoutImages;
    }

    public void setLayoutImages(String layoutImages) {
        this.layoutImages = layoutImages == null ? null : layoutImages.trim();
    }

    public String getRealityImages() {
        return realityImages;
    }

    public void setRealityImages(String realityImages) {
        this.realityImages = realityImages == null ? null : realityImages.trim();
    }
}