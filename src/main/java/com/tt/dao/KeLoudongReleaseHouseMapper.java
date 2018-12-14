package com.tt.dao;

import com.tt.entity.KeLoudongReleaseHouse;
import com.tt.entity.KeLoudongReleaseHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeLoudongReleaseHouseMapper {
    int countByExample(KeLoudongReleaseHouseExample example);

    int deleteByExample(KeLoudongReleaseHouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(KeLoudongReleaseHouse record);

    int insertSelective(KeLoudongReleaseHouse record);

    List<KeLoudongReleaseHouse> selectByExample(KeLoudongReleaseHouseExample example);

    KeLoudongReleaseHouse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KeLoudongReleaseHouse record, @Param("example") KeLoudongReleaseHouseExample example);

    int updateByExample(@Param("record") KeLoudongReleaseHouse record, @Param("example") KeLoudongReleaseHouseExample example);

    int updateByPrimaryKeySelective(KeLoudongReleaseHouse record);

    int updateByPrimaryKey(KeLoudongReleaseHouse record);

    //新增方法（缺少数据）
    List<KeLoudongReleaseHouse> selectQueShao();

}