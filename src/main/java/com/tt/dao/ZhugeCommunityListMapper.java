package com.tt.dao;

import com.tt.entity.ZhugeCommunityList;
import com.tt.entity.ZhugeCommunityListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZhugeCommunityListMapper {
    int countByExample(ZhugeCommunityListExample example);

    int deleteByExample(ZhugeCommunityListExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZhugeCommunityList record);

    int insertSelective(ZhugeCommunityList record);

    List<ZhugeCommunityList> selectByExample(ZhugeCommunityListExample example);

    ZhugeCommunityList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZhugeCommunityList record, @Param("example") ZhugeCommunityListExample example);

    int updateByExample(@Param("record") ZhugeCommunityList record, @Param("example") ZhugeCommunityListExample example);

    int updateByPrimaryKeySelective(ZhugeCommunityList record);

    int updateByPrimaryKey(ZhugeCommunityList record);
}