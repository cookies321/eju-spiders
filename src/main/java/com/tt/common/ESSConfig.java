package com.tt.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ESS 云存储 配置
 *
 * @author NJ
 * @create 2018-01-03 11:03
 **/
@Component
public class ESSConfig {
    public static final String PREFIX = "ess";

    @Value("${uploadUrl}")
    private String uploadUrl;
    @Value("${downloadUrl}")
    private String downloadUrl;
    @Value("${bucketName}")
    private String bucketName;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${secretAccessKey}")
    private String secretAccessKey;

    public static String getPREFIX() {
        return PREFIX;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }
}
