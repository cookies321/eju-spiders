package com.tt.entity;

import java.io.Serializable;

public class QFangLoudong implements Serializable {
    private Long id;

    private String qId;

    private String internalId;

    private String buildId;

    private String buildName;

    private String buildRegisterName;

    private String status;

    private String source;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId == null ? null : qId.trim();
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId == null ? null : buildId.trim();
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }

    public String getBuildRegisterName() {
        return buildRegisterName;
    }

    public void setBuildRegisterName(String buildRegisterName) {
        this.buildRegisterName = buildRegisterName == null ? null : buildRegisterName.trim();
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