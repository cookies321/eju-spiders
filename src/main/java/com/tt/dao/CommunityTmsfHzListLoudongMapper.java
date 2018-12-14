package com.tt.dao;

import com.tt.entity.CommunityTmsfHzListLoudong;
import com.tt.entity.CommunityTmsfHzListLoudongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityTmsfHzListLoudongMapper {
    int countByExample(CommunityTmsfHzListLoudongExample example);

    int deleteByExample(CommunityTmsfHzListLoudongExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityTmsfHzListLoudong record);

    int insertSelective(CommunityTmsfHzListLoudong record);

    List<CommunityTmsfHzListLoudong> selectByExample(CommunityTmsfHzListLoudongExample example);

    CommunityTmsfHzListLoudong selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityTmsfHzListLoudong record, @Param("example") CommunityTmsfHzListLoudongExample example);

    int updateByExample(@Param("record") CommunityTmsfHzListLoudong record, @Param("example") CommunityTmsfHzListLoudongExample example);

    int updateByPrimaryKeySelective(CommunityTmsfHzListLoudong record);

    int updateByPrimaryKey(CommunityTmsfHzListLoudong record);
}