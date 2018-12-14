package com.tt.dao;

import com.tt.entity.AnjukeCommunityList;
import com.tt.entity.AnjukeCommunityListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityListMapper {
    int countByExample(AnjukeCommunityListExample example);

    int deleteByExample(AnjukeCommunityListExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityList record);

    int insertSelective(AnjukeCommunityList record);

    List<AnjukeCommunityList> selectByExample(AnjukeCommunityListExample example);

    AnjukeCommunityList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityList record, @Param("example") AnjukeCommunityListExample example);

    int updateByExample(@Param("record") AnjukeCommunityList record, @Param("example") AnjukeCommunityListExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityList record);

    int updateByPrimaryKey(AnjukeCommunityList record);
}