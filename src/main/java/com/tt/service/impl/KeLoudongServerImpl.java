package com.tt.service.impl;

import com.tt.dao.KeLoudongMapper;
import com.tt.entity.KeLoudong;
import com.tt.service.KeLoudongServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeLoudongServerImpl implements KeLoudongServer{

    @Autowired
    private KeLoudongMapper keLoudongMapper;

    @Override
    public void insert(KeLoudong keLoudong) {
        keLoudongMapper.insert(keLoudong);
    }
}
