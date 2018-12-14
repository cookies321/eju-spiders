package com.tt.dao;

import com.tt.entity.AnjukeCommunity;
import com.tt.entity.AnjukeCommunityExample;
import com.tt.entity.AnjukeCommunityWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityMapper {
    int countByExample(AnjukeCommunityExample example);

    int deleteByExample(AnjukeCommunityExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityWithBLOBs record);

    int insertSelective(AnjukeCommunityWithBLOBs record);

    List<AnjukeCommunityWithBLOBs> selectByExampleWithBLOBs(AnjukeCommunityExample example);

    List<AnjukeCommunity> selectByExample(AnjukeCommunityExample example);

    AnjukeCommunityWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityWithBLOBs record, @Param("example") AnjukeCommunityExample example);

    int updateByExampleWithBLOBs(@Param("record") AnjukeCommunityWithBLOBs record, @Param("example") AnjukeCommunityExample example);

    int updateByExample(@Param("record") AnjukeCommunity record, @Param("example") AnjukeCommunityExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnjukeCommunityWithBLOBs record);

    int updateByPrimaryKey(AnjukeCommunity record);
}