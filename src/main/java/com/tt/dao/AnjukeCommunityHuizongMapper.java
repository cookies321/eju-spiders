package com.tt.dao;

import com.tt.entity.AnjukeCommunityHuizong;
import com.tt.entity.AnjukeCommunityHuizongExample;
import com.tt.entity.AnjukeCommunityHuizongWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityHuizongMapper {
    int countByExample(AnjukeCommunityHuizongExample example);

    int deleteByExample(AnjukeCommunityHuizongExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityHuizongWithBLOBs record);

    int insertSelective(AnjukeCommunityHuizongWithBLOBs record);

    List<AnjukeCommunityHuizongWithBLOBs> selectByExampleWithBLOBs(AnjukeCommunityHuizongExample example);

    List<AnjukeCommunityHuizong> selectByExample(AnjukeCommunityHuizongExample example);

    AnjukeCommunityHuizongWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityHuizongWithBLOBs record, @Param("example") AnjukeCommunityHuizongExample example);

    int updateByExampleWithBLOBs(@Param("record") AnjukeCommunityHuizongWithBLOBs record, @Param("example") AnjukeCommunityHuizongExample example);

    int updateByExample(@Param("record") AnjukeCommunityHuizong record, @Param("example") AnjukeCommunityHuizongExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityHuizongWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnjukeCommunityHuizongWithBLOBs record);

    int updateByPrimaryKey(AnjukeCommunityHuizong record);
}