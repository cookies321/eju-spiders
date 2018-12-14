package com.tt.dao;

import com.tt.entity.CommunityTmsfHzRegion;
import com.tt.entity.CommunityTmsfHzRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityTmsfHzRegionMapper {
    int countByExample(CommunityTmsfHzRegionExample example);

    int deleteByExample(CommunityTmsfHzRegionExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityTmsfHzRegion record);

    int insertSelective(CommunityTmsfHzRegion record);

    List<CommunityTmsfHzRegion> selectByExample(CommunityTmsfHzRegionExample example);

    CommunityTmsfHzRegion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityTmsfHzRegion record, @Param("example") CommunityTmsfHzRegionExample example);

    int updateByExample(@Param("record") CommunityTmsfHzRegion record, @Param("example") CommunityTmsfHzRegionExample example);

    int updateByPrimaryKeySelective(CommunityTmsfHzRegion record);

    int updateByPrimaryKey(CommunityTmsfHzRegion record);
}