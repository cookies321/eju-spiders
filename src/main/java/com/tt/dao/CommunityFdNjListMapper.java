package com.tt.dao;

import com.tt.entity.CommunityFdNjList;
import com.tt.entity.CommunityFdNjListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdNjListMapper {
    int countByExample(CommunityFdNjListExample example);

    int deleteByExample(CommunityFdNjListExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdNjList record);

    int insertSelective(CommunityFdNjList record);

    List<CommunityFdNjList> selectByExample(CommunityFdNjListExample example);

    CommunityFdNjList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdNjList record, @Param("example") CommunityFdNjListExample example);

    int updateByExample(@Param("record") CommunityFdNjList record, @Param("example") CommunityFdNjListExample example);

    int updateByPrimaryKeySelective(CommunityFdNjList record);

    int updateByPrimaryKey(CommunityFdNjList record);
}