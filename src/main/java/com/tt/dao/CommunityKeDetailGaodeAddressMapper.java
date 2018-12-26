package com.tt.dao;

import com.tt.entity.CommunityKeDetailGaodeAddress;
import com.tt.entity.CommunityKeDetailGaodeAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityKeDetailGaodeAddressMapper {
    int countByExample(CommunityKeDetailGaodeAddressExample example);

    int deleteByExample(CommunityKeDetailGaodeAddressExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityKeDetailGaodeAddress record);

    int insertSelective(CommunityKeDetailGaodeAddress record);

    List<CommunityKeDetailGaodeAddress> selectByExample(CommunityKeDetailGaodeAddressExample example);

    CommunityKeDetailGaodeAddress selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityKeDetailGaodeAddress record, @Param("example") CommunityKeDetailGaodeAddressExample example);

    int updateByExample(@Param("record") CommunityKeDetailGaodeAddress record, @Param("example") CommunityKeDetailGaodeAddressExample example);

    int updateByPrimaryKeySelective(CommunityKeDetailGaodeAddress record);

    int updateByPrimaryKey(CommunityKeDetailGaodeAddress record);
}