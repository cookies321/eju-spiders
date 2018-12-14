package com.tt.dao;

import com.tt.entity.FangXfLoupangBuilding;
import com.tt.entity.FangXfLoupangBuildingExample;
import java.util.List;

import com.tt.entity.FangXfLoupangListExample;
import org.apache.ibatis.annotations.Param;

public interface FangXfLoupangBuildingMapper {
    int countByExample(FangXfLoupangBuildingExample example);

    int deleteByExample(FangXfLoupangBuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(FangXfLoupangBuilding record);

    int insertSelective(FangXfLoupangBuilding record);

    List<FangXfLoupangBuilding> selectByExampleWithBLOBs(FangXfLoupangBuildingExample example);

    List<FangXfLoupangBuilding> selectByExample(FangXfLoupangListExample example);

    FangXfLoupangBuilding selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FangXfLoupangBuilding record, @Param("example") FangXfLoupangBuildingExample example);

    int updateByExampleWithBLOBs(@Param("record") FangXfLoupangBuilding record, @Param("example") FangXfLoupangBuildingExample example);

    int updateByExample(@Param("record") FangXfLoupangBuilding record, @Param("example") FangXfLoupangBuildingExample example);

    int updateByPrimaryKeySelective(FangXfLoupangBuilding record);

    int updateByPrimaryKeyWithBLOBs(FangXfLoupangBuilding record);

    int updateByPrimaryKey(FangXfLoupangBuilding record);
}