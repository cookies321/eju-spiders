package com.tt.dao;

import com.tt.entity.CommunityFdNjHouse;
import com.tt.entity.CommunityFdNjHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdNjHouseMapper {
    int countByExample(CommunityFdNjHouseExample example);

    int deleteByExample(CommunityFdNjHouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdNjHouse record);

    int insertSelective(CommunityFdNjHouse record);

    List<CommunityFdNjHouse> selectByExample(CommunityFdNjHouseExample example);

    CommunityFdNjHouse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdNjHouse record, @Param("example") CommunityFdNjHouseExample example);

    int updateByExample(@Param("record") CommunityFdNjHouse record, @Param("example") CommunityFdNjHouseExample example);

    int updateByPrimaryKeySelective(CommunityFdNjHouse record);

    int updateByPrimaryKey(CommunityFdNjHouse record);
}