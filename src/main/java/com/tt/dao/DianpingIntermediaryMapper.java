package com.tt.dao;

import com.tt.entity.DianpingIntermediary;
import com.tt.entity.DianpingIntermediaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DianpingIntermediaryMapper {
    int countByExample(DianpingIntermediaryExample example);

    int deleteByExample(DianpingIntermediaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(DianpingIntermediary record);

    int insertSelective(DianpingIntermediary record);

    List<DianpingIntermediary> selectByExample(DianpingIntermediaryExample example);

    DianpingIntermediary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DianpingIntermediary record, @Param("example") DianpingIntermediaryExample example);

    int updateByExample(@Param("record") DianpingIntermediary record, @Param("example") DianpingIntermediaryExample example);

    int updateByPrimaryKeySelective(DianpingIntermediary record);

    int updateByPrimaryKey(DianpingIntermediary record);
}