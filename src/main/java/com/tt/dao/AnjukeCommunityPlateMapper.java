package com.tt.dao;

import com.tt.entity.AnjukeCommunityPlate;
import com.tt.entity.AnjukeCommunityPlateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityPlateMapper {
    int countByExample(AnjukeCommunityPlateExample example);

    int deleteByExample(AnjukeCommunityPlateExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityPlate record);

    int insertSelective(AnjukeCommunityPlate record);

    List<AnjukeCommunityPlate> selectByExample(AnjukeCommunityPlateExample example);

    AnjukeCommunityPlate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityPlate record, @Param("example") AnjukeCommunityPlateExample example);

    int updateByExample(@Param("record") AnjukeCommunityPlate record, @Param("example") AnjukeCommunityPlateExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityPlate record);

    int updateByPrimaryKey(AnjukeCommunityPlate record);
}