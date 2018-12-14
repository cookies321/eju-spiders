package com.tt.dao;

import com.tt.entity.AnjukeCommunityReality;
import com.tt.entity.AnjukeCommunityRealityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityRealityMapper {
    int countByExample(AnjukeCommunityRealityExample example);

    int deleteByExample(AnjukeCommunityRealityExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityReality record);

    int insertSelective(AnjukeCommunityReality record);

    List<AnjukeCommunityReality> selectByExample(AnjukeCommunityRealityExample example);

    AnjukeCommunityReality selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityReality record, @Param("example") AnjukeCommunityRealityExample example);

    int updateByExample(@Param("record") AnjukeCommunityReality record, @Param("example") AnjukeCommunityRealityExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityReality record);

    int updateByPrimaryKey(AnjukeCommunityReality record);
}