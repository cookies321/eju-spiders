package com.tt.dao;

import com.tt.entity.ZhugeCommunity;
import com.tt.entity.ZhugeCommunityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZhugeCommunityMapper {
    int countByExample(ZhugeCommunityExample example);

    int deleteByExample(ZhugeCommunityExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZhugeCommunity record);

    int insertSelective(ZhugeCommunity record);

    List<ZhugeCommunity> selectByExample(ZhugeCommunityExample example);

    ZhugeCommunity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZhugeCommunity record, @Param("example") ZhugeCommunityExample example);

    int updateByExample(@Param("record") ZhugeCommunity record, @Param("example") ZhugeCommunityExample example);

    int updateByPrimaryKeySelective(ZhugeCommunity record);

    int updateByPrimaryKey(ZhugeCommunity record);
}