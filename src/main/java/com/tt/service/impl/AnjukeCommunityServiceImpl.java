package com.tt.service.impl;

import com.tt.dao.AnjukeCommunityMapper;
import com.tt.entity.AnjukeCommunityWithBLOBs;
import com.tt.service.AnjukeCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnjukeCommunityServiceImpl implements AnjukeCommunityService{

    @Autowired
    private AnjukeCommunityMapper anjukeCommunityMapper;

    public void insertAnjukeCommunity(AnjukeCommunityWithBLOBs anjukeCommunityWithBLOBs) {
        anjukeCommunityMapper.insert(anjukeCommunityWithBLOBs);
    }
}
