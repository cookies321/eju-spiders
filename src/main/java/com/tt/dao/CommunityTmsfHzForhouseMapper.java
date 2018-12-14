package com.tt.dao;

import com.tt.entity.CommunityTmsfHzForhouse;
import com.tt.entity.CommunityTmsfHzForhouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityTmsfHzForhouseMapper {
    int countByExample(CommunityTmsfHzForhouseExample example);

    int deleteByExample(CommunityTmsfHzForhouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityTmsfHzForhouse record);

    int insertSelective(CommunityTmsfHzForhouse record);

    List<CommunityTmsfHzForhouse> selectByExample(CommunityTmsfHzForhouseExample example);

    CommunityTmsfHzForhouse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityTmsfHzForhouse record, @Param("example") CommunityTmsfHzForhouseExample example);

    int updateByExample(@Param("record") CommunityTmsfHzForhouse record, @Param("example") CommunityTmsfHzForhouseExample example);

    int updateByPrimaryKeySelective(CommunityTmsfHzForhouse record);

    int updateByPrimaryKey(CommunityTmsfHzForhouse record);
}