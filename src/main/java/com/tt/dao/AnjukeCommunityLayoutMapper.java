package com.tt.dao;

import com.tt.entity.AnjukeCommunityLayout;
import com.tt.entity.AnjukeCommunityLayoutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityLayoutMapper {
    int countByExample(AnjukeCommunityLayoutExample example);

    int deleteByExample(AnjukeCommunityLayoutExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityLayout record);

    int insertSelective(AnjukeCommunityLayout record);

    List<AnjukeCommunityLayout> selectByExample(AnjukeCommunityLayoutExample example);

    AnjukeCommunityLayout selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityLayout record, @Param("example") AnjukeCommunityLayoutExample example);

    int updateByExample(@Param("record") AnjukeCommunityLayout record, @Param("example") AnjukeCommunityLayoutExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityLayout record);

    int updateByPrimaryKey(AnjukeCommunityLayout record);
}