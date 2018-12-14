package com.tt.service.impl;

import com.tt.dao.KeLayoutMapper;
import com.tt.entity.KeLayout;
import com.tt.service.KeLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeLayoutServiceImpl implements KeLayoutService {

    @Autowired
    private KeLayoutMapper keLayoutMapper;

    @Override
    public void insertKeLayout(KeLayout keLayout) {
        keLayoutMapper.insert(keLayout);
    }
}
