package com.tt.service.impl;

import com.tt.dao.QFangXiaoquMapper;
import com.tt.entity.QFangXiaoqu;
import com.tt.entity.QFangXiaoquExample;
import com.tt.service.QFangXiaoquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QFangXiaoquServiceImpl implements QFangXiaoquService {

    @Autowired
    private QFangXiaoquMapper qFangXiaoquMapper;

    @Override
    public List<QFangXiaoqu> getQFangXiaoqu() {
        QFangXiaoquExample qFangXiaoquExample = new QFangXiaoquExample();
        QFangXiaoquExample.Criteria criteria = qFangXiaoquExample.createCriteria();
        criteria.andSourceEqualTo("add");
        criteria.andStatusIsNull();
        List<QFangXiaoqu> qFangXiaoqus = qFangXiaoquMapper.selectByExample(qFangXiaoquExample);
        return qFangXiaoqus;
    }

    @Override
    public void insertQFangXiaoqu(QFangXiaoqu qFangXiaoqu) {
        qFangXiaoquMapper.insertSelective(qFangXiaoqu);
    }

    @Override
    public void updateQFangXiaoqu(QFangXiaoqu qFangXiaoqu) {
        qFangXiaoquMapper.updateByPrimaryKeySelective(qFangXiaoqu);
    }
}
