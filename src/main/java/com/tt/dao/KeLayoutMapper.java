package com.tt.dao;

import com.tt.entity.KeLayout;
import com.tt.entity.KeLayoutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeLayoutMapper {
    int countByExample(KeLayoutExample example);

    int deleteByExample(KeLayoutExample example);

    int deleteByPrimaryKey(String id);

    int insert(KeLayout record);

    int insertSelective(KeLayout record);

    List<KeLayout> selectByExample(KeLayoutExample example);

    KeLayout selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KeLayout record, @Param("example") KeLayoutExample example);

    int updateByExample(@Param("record") KeLayout record, @Param("example") KeLayoutExample example);

    int updateByPrimaryKeySelective(KeLayout record);

    int updateByPrimaryKey(KeLayout record);
}