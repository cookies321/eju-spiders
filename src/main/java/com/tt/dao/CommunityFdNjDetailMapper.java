package com.tt.dao;

import com.tt.entity.CommunityFdNjDetail;
import com.tt.entity.CommunityFdNjDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdNjDetailMapper {
    int countByExample(CommunityFdNjDetailExample example);

    int deleteByExample(CommunityFdNjDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdNjDetail record);

    int insertSelective(CommunityFdNjDetail record);

    List<CommunityFdNjDetail> selectByExample(CommunityFdNjDetailExample example);

    CommunityFdNjDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdNjDetail record, @Param("example") CommunityFdNjDetailExample example);

    int updateByExample(@Param("record") CommunityFdNjDetail record, @Param("example") CommunityFdNjDetailExample example);

    int updateByPrimaryKeySelective(CommunityFdNjDetail record);

    int updateByPrimaryKey(CommunityFdNjDetail record);
}