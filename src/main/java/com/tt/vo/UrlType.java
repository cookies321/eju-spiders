package com.tt.vo;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/22 14:10
 * @Description:
 */
public enum UrlType implements Serializable{
    /**
     * get请求类型
     */
    GET,
    /**
     * post请求类型
     */
    POST,
    /**
     * 安居客小区第一链接
     */
    ANJUKE_COMMUNITY_INDEX,
    /**
     * 安居客的小区区域链接
     */
    ANJUKE_COMMUNITY_REGION,
    /**
     * 安居客的小区板块链接
     */
    ANJUKE_COMMUNITY_PLATE,
    /**
     * 安居客小区列表分页链接
     */
    ANJUKE_COMMUNITY_PAGE,
    /**
     * 安居客小区列表详情链接
     */
    ANJUKE_COMMUNITY_DATAIL,
    /**
     * 安居客小区房型图链接
     */
    ANJUKE_COMMUNITY_MODEL,
    /**
     * 安居客小区实景图链接
     */
    ANJUKE_COMMUNITY_VIEW,

}
