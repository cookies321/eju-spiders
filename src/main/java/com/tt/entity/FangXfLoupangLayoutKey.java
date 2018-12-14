package com.tt.entity;

import java.io.Serializable;

public class FangXfLoupangLayoutKey implements Serializable {
    private String id;

    private String sharesArea;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSharesArea() {
        return sharesArea;
    }

    public void setSharesArea(String sharesArea) {
        this.sharesArea = sharesArea == null ? null : sharesArea.trim();
    }
}