package com.tt.dao;

import com.tt.entity.GovernmentCommunity;
import com.tt.entity.GovernmentCommunityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GovernmentCommunityMapper {
    int countByExample(GovernmentCommunityExample example);

    int deleteByExample(GovernmentCommunityExample example);

    int deleteByPrimaryKey(String id);

    int insert(GovernmentCommunity record);

    int insertSelective(GovernmentCommunity record);

    List<GovernmentCommunity> selectByExample(GovernmentCommunityExample example);

    GovernmentCommunity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GovernmentCommunity record, @Param("example") GovernmentCommunityExample example);

    int updateByExample(@Param("record") GovernmentCommunity record, @Param("example") GovernmentCommunityExample example);

    int updateByPrimaryKeySelective(GovernmentCommunity record);

    int updateByPrimaryKey(GovernmentCommunity record);
}