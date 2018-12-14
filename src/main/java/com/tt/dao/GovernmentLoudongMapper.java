package com.tt.dao;

import com.tt.entity.GovernmentLoudong;
import com.tt.entity.GovernmentLoudongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GovernmentLoudongMapper {
    int countByExample(GovernmentLoudongExample example);

    int deleteByExample(GovernmentLoudongExample example);

    int deleteByPrimaryKey(String id);

    int insert(GovernmentLoudong record);

    int insertSelective(GovernmentLoudong record);

    List<GovernmentLoudong> selectByExample(GovernmentLoudongExample example);

    GovernmentLoudong selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GovernmentLoudong record, @Param("example") GovernmentLoudongExample example);

    int updateByExample(@Param("record") GovernmentLoudong record, @Param("example") GovernmentLoudongExample example);

    int updateByPrimaryKeySelective(GovernmentLoudong record);

    int updateByPrimaryKey(GovernmentLoudong record);
}