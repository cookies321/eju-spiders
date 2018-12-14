package com.tt.service.impl;

import com.tt.dao.FangAgentMapper;
import com.tt.entity.FangAgent;
import com.tt.service.FangAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FangAgentServiceImpl implements FangAgentService {

    @Autowired
    private FangAgentMapper fangAgentMapper;

    public void insertFangAgent(FangAgent fangAgent) {
        fangAgentMapper.insert(fangAgent);
    }
}
