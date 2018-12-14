package com.tt.service.impl;

import com.tt.dao.CommunityKeDetailMapper;
import com.tt.entity.CommunityKeDetailExample;
import com.tt.entity.CommunityKeDetailWithBLOBs;
import com.tt.service.CommunityKeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommunityKeDetailServiceImpl implements CommunityKeDetailService {
    @Autowired
    private CommunityKeDetailMapper communityKeDetailMapper;

    @Override
    public List<CommunityKeDetailWithBLOBs> getCommunityKeDetail() {
        CommunityKeDetailExample communityKeDetailExample = new CommunityKeDetailExample();
        communityKeDetailExample.or().andTagEqualTo("0");
        List<CommunityKeDetailWithBLOBs> communityKeDetailWithBLOBs = communityKeDetailMapper.selectByExampleWithBLOBs(communityKeDetailExample);
        return communityKeDetailWithBLOBs;
    }

    @Override
    public List<CommunityKeDetailWithBLOBs> getCommunityKeDetailBySource(String source) {
        CommunityKeDetailExample communityKeDetailExample = new CommunityKeDetailExample();
        CommunityKeDetailExample.Criteria criteria = communityKeDetailExample.createCriteria();
        criteria.andSourceEqualTo(source);
        List<CommunityKeDetailWithBLOBs> communityKeDetailWithBLOBs = communityKeDetailMapper.selectByExampleWithBLOBs(communityKeDetailExample);
        return communityKeDetailWithBLOBs;
    }

    @Override
    public List<CommunityKeDetailWithBLOBs> getCommunityKeDetailByCity(String city) {
        CommunityKeDetailExample communityKeDetailExample = new CommunityKeDetailExample();
        CommunityKeDetailExample.Criteria criteria = communityKeDetailExample.createCriteria();
        criteria.andCityEqualTo(city);
        List<CommunityKeDetailWithBLOBs> communityKeDetailWithBLOBs = communityKeDetailMapper.selectByExampleWithBLOBs(communityKeDetailExample);
        return communityKeDetailWithBLOBs;
    }

    @Override
    public List<CommunityKeDetailWithBLOBs> getCommunityKeDetailByTitleId(String titleId) {
        CommunityKeDetailExample communityKeDetailExample = new CommunityKeDetailExample();
        CommunityKeDetailExample.Criteria criteria = communityKeDetailExample.createCriteria();
        criteria.andTitleIdEqualTo(titleId);
        List<CommunityKeDetailWithBLOBs> communityKeDetailWithBLOBs = communityKeDetailMapper.selectByExampleWithBLOBs(communityKeDetailExample);
        return communityKeDetailWithBLOBs;
    }
}
