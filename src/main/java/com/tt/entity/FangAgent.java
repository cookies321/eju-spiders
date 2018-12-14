package com.tt.entity;

import java.io.Serializable;

public class FangAgent implements Serializable {
    private String id;

    private String url;

    private String thumbnail;

    private String agentName;

    private String address;

    private String city;

    private String region;

    private String plate;

    private String phone;

    private String company;

    private String saleHouse;

    private String commentNum;

    private String priceRate;

    private String isDel;

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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getSaleHouse() {
        return saleHouse;
    }

    public void setSaleHouse(String saleHouse) {
        this.saleHouse = saleHouse == null ? null : saleHouse.trim();
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum == null ? null : commentNum.trim();
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate == null ? null : priceRate.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }


    @Override
    public String toString() {
        return "FangAgent{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", agentName='" + agentName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", plate='" + plate + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", saleHouse='" + saleHouse + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", priceRate='" + priceRate + '\'' +
                ", isDel='" + isDel + '\'' +
                '}';
    }
}