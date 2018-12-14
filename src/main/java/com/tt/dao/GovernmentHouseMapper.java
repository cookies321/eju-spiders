package com.tt.dao;

import com.tt.entity.GovernmentHouse;
import com.tt.entity.GovernmentHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GovernmentHouseMapper {
    int countByExample(GovernmentHouseExample example);

    int deleteByExample(GovernmentHouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(GovernmentHouse record);

    int insertSelective(GovernmentHouse record);

    List<GovernmentHouse> selectByExample(GovernmentHouseExample example);

    GovernmentHouse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GovernmentHouse record, @Param("example") GovernmentHouseExample example);

    int updateByExample(@Param("record") GovernmentHouse record, @Param("example") GovernmentHouseExample example);

    int updateByPrimaryKeySelective(GovernmentHouse record);

    int updateByPrimaryKey(GovernmentHouse record);
}