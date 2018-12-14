package com.tt.dao;

import com.tt.entity.AnjukeCommunityDetail;
import com.tt.entity.AnjukeCommunityDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityDetailMapper {
    int countByExample(AnjukeCommunityDetailExample example);

    int deleteByExample(AnjukeCommunityDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityDetail record);

    int insertSelective(AnjukeCommunityDetail record);

    List<AnjukeCommunityDetail> selectByExample(AnjukeCommunityDetailExample example);

    AnjukeCommunityDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityDetail record, @Param("example") AnjukeCommunityDetailExample example);

    int updateByExample(@Param("record") AnjukeCommunityDetail record, @Param("example") AnjukeCommunityDetailExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityDetail record);

    int updateByPrimaryKey(AnjukeCommunityDetail record);
}