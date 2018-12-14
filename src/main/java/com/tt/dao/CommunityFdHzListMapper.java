package com.tt.dao;

import com.tt.entity.CommunityFdHzList;
import com.tt.entity.CommunityFdHzListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdHzListMapper {
    int countByExample(CommunityFdHzListExample example);

    int deleteByExample(CommunityFdHzListExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdHzList record);

    int insertSelective(CommunityFdHzList record);

    List<CommunityFdHzList> selectByExample(CommunityFdHzListExample example);

    CommunityFdHzList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdHzList record, @Param("example") CommunityFdHzListExample example);

    int updateByExample(@Param("record") CommunityFdHzList record, @Param("example") CommunityFdHzListExample example);

    int updateByPrimaryKeySelective(CommunityFdHzList record);

    int updateByPrimaryKey(CommunityFdHzList record);
}