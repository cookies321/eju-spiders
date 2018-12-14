package com.tt.dao;

import com.tt.entity.CommunityKeDetailReleaseHouse;
import com.tt.entity.CommunityKeDetailReleaseHouseExample;
import com.tt.entity.CommunityKeDetailReleaseHouseWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityKeDetailReleaseHouseMapper {
    int countByExample(CommunityKeDetailReleaseHouseExample example);

    int deleteByExample(CommunityKeDetailReleaseHouseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommunityKeDetailReleaseHouseWithBLOBs record);

    int insertSelective(CommunityKeDetailReleaseHouseWithBLOBs record);

    List<CommunityKeDetailReleaseHouseWithBLOBs> selectByExampleWithBLOBs(CommunityKeDetailReleaseHouseExample example);

    List<CommunityKeDetailReleaseHouse> selectByExample(CommunityKeDetailReleaseHouseExample example);

    CommunityKeDetailReleaseHouseWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommunityKeDetailReleaseHouseWithBLOBs record, @Param("example") CommunityKeDetailReleaseHouseExample example);

    int updateByExampleWithBLOBs(@Param("record") CommunityKeDetailReleaseHouseWithBLOBs record, @Param("example") CommunityKeDetailReleaseHouseExample example);

    int updateByExample(@Param("record") CommunityKeDetailReleaseHouse record, @Param("example") CommunityKeDetailReleaseHouseExample example);

    int updateByPrimaryKeySelective(CommunityKeDetailReleaseHouseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommunityKeDetailReleaseHouseWithBLOBs record);

    int updateByPrimaryKey(CommunityKeDetailReleaseHouse record);
}