package com.tt.dao;

import com.tt.entity.CommunityFdNjBuilding;
import com.tt.entity.CommunityFdNjBuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdNjBuildingMapper {
    int countByExample(CommunityFdNjBuildingExample example);

    int deleteByExample(CommunityFdNjBuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdNjBuilding record);

    int insertSelective(CommunityFdNjBuilding record);

    List<CommunityFdNjBuilding> selectByExample(CommunityFdNjBuildingExample example);

    CommunityFdNjBuilding selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdNjBuilding record, @Param("example") CommunityFdNjBuildingExample example);

    int updateByExample(@Param("record") CommunityFdNjBuilding record, @Param("example") CommunityFdNjBuildingExample example);

    int updateByPrimaryKeySelective(CommunityFdNjBuilding record);

    int updateByPrimaryKey(CommunityFdNjBuilding record);
}