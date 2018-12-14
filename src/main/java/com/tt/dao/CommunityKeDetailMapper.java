package com.tt.dao;

import com.tt.entity.CommunityKeDetail;
import com.tt.entity.CommunityKeDetailExample;
import com.tt.entity.CommunityKeDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityKeDetailMapper {
    int countByExample(CommunityKeDetailExample example);

    int deleteByExample(CommunityKeDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommunityKeDetailWithBLOBs record);

    int insertSelective(CommunityKeDetailWithBLOBs record);

    List<CommunityKeDetailWithBLOBs> selectByExampleWithBLOBs(CommunityKeDetailExample example);

    List<CommunityKeDetail> selectByExample(CommunityKeDetailExample example);

    CommunityKeDetailWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommunityKeDetailWithBLOBs record, @Param("example") CommunityKeDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") CommunityKeDetailWithBLOBs record, @Param("example") CommunityKeDetailExample example);

    int updateByExample(@Param("record") CommunityKeDetail record, @Param("example") CommunityKeDetailExample example);

    int updateByPrimaryKeySelective(CommunityKeDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommunityKeDetailWithBLOBs record);

    int updateByPrimaryKey(CommunityKeDetail record);
}