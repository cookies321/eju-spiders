package com.tt.dao;

import com.tt.entity.CommunityTmsfHzList;
import com.tt.entity.CommunityTmsfHzListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityTmsfHzListMapper {
    int countByExample(CommunityTmsfHzListExample example);

    int deleteByExample(CommunityTmsfHzListExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityTmsfHzList record);

    int insertSelective(CommunityTmsfHzList record);

    List<CommunityTmsfHzList> selectByExample(CommunityTmsfHzListExample example);

    CommunityTmsfHzList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityTmsfHzList record, @Param("example") CommunityTmsfHzListExample example);

    int updateByExample(@Param("record") CommunityTmsfHzList record, @Param("example") CommunityTmsfHzListExample example);

    int updateByPrimaryKeySelective(CommunityTmsfHzList record);

    int updateByPrimaryKey(CommunityTmsfHzList record);
}