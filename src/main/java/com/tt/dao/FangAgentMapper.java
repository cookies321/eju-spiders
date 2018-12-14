package com.tt.dao;

import com.tt.entity.FangAgent;
import com.tt.entity.FangAgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FangAgentMapper {
    int countByExample(FangAgentExample example);

    int deleteByExample(FangAgentExample example);

    int deleteByPrimaryKey(String id);

    int insert(FangAgent record);

    int insertSelective(FangAgent record);

    List<FangAgent> selectByExample(FangAgentExample example);

    FangAgent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FangAgent record, @Param("example") FangAgentExample example);

    int updateByExample(@Param("record") FangAgent record, @Param("example") FangAgentExample example);

    int updateByPrimaryKeySelective(FangAgent record);

    int updateByPrimaryKey(FangAgent record);
}