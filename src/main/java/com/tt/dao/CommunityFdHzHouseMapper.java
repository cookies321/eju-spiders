package com.tt.dao;

import com.tt.entity.CommunityFdHzHouse;
import com.tt.entity.CommunityFdHzHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdHzHouseMapper {
    int countByExample(CommunityFdHzHouseExample example);

    int deleteByExample(CommunityFdHzHouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdHzHouse record);

    int insertSelective(CommunityFdHzHouse record);

    List<CommunityFdHzHouse> selectByExample(CommunityFdHzHouseExample example);

    CommunityFdHzHouse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdHzHouse record, @Param("example") CommunityFdHzHouseExample example);

    int updateByExample(@Param("record") CommunityFdHzHouse record, @Param("example") CommunityFdHzHouseExample example);

    int updateByPrimaryKeySelective(CommunityFdHzHouse record);

    int updateByPrimaryKey(CommunityFdHzHouse record);
}