package com.tt.dao;

import com.tt.entity.CommunityKeDetailBaiduAddress;
import com.tt.entity.CommunityKeDetailBaiduAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityKeDetailBaiduAddressMapper {
    int countByExample(CommunityKeDetailBaiduAddressExample example);

    int deleteByExample(CommunityKeDetailBaiduAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommunityKeDetailBaiduAddress record);

    int insertSelective(CommunityKeDetailBaiduAddress record);

    List<CommunityKeDetailBaiduAddress> selectByExample(CommunityKeDetailBaiduAddressExample example);

    CommunityKeDetailBaiduAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommunityKeDetailBaiduAddress record, @Param("example") CommunityKeDetailBaiduAddressExample example);

    int updateByExample(@Param("record") CommunityKeDetailBaiduAddress record, @Param("example") CommunityKeDetailBaiduAddressExample example);

    int updateByPrimaryKeySelective(CommunityKeDetailBaiduAddress record);

    int updateByPrimaryKey(CommunityKeDetailBaiduAddress record);
}