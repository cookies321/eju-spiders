package com.tt.dao;

import com.tt.entity.CommunityTmsfHzDetail;
import com.tt.entity.CommunityTmsfHzDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityTmsfHzDetailMapper {
    int countByExample(CommunityTmsfHzDetailExample example);

    int deleteByExample(CommunityTmsfHzDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityTmsfHzDetail record);

    int insertSelective(CommunityTmsfHzDetail record);

    List<CommunityTmsfHzDetail> selectByExample(CommunityTmsfHzDetailExample example);

    CommunityTmsfHzDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityTmsfHzDetail record, @Param("example") CommunityTmsfHzDetailExample example);

    int updateByExample(@Param("record") CommunityTmsfHzDetail record, @Param("example") CommunityTmsfHzDetailExample example);

    int updateByPrimaryKeySelective(CommunityTmsfHzDetail record);

    int updateByPrimaryKey(CommunityTmsfHzDetail record);
}