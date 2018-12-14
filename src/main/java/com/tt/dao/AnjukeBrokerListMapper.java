package com.tt.dao;

import com.tt.entity.AnjukeBrokerList;
import com.tt.entity.AnjukeBrokerListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeBrokerListMapper {
    int countByExample(AnjukeBrokerListExample example);

    int deleteByExample(AnjukeBrokerListExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeBrokerList record);

    int insertSelective(AnjukeBrokerList record);

    List<AnjukeBrokerList> selectByExample(AnjukeBrokerListExample example);

    AnjukeBrokerList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeBrokerList record, @Param("example") AnjukeBrokerListExample example);

    int updateByExample(@Param("record") AnjukeBrokerList record, @Param("example") AnjukeBrokerListExample example);

    int updateByPrimaryKeySelective(AnjukeBrokerList record);

    int updateByPrimaryKey(AnjukeBrokerList record);
}