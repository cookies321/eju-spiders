package com.tt.service;

import com.tt.entity.CommunityKeDetailWithBLOBs;

import java.util.List;

public interface CommunityKeDetailService {
    List<CommunityKeDetailWithBLOBs> getCommunityKeDetail();
    List<CommunityKeDetailWithBLOBs> getCommunityKeDetailBySource(String source);
    List<CommunityKeDetailWithBLOBs> getCommunityKeDetailByCity(String city);
    List<CommunityKeDetailWithBLOBs> getCommunityKeDetailByTitleId(String titleId);
}
