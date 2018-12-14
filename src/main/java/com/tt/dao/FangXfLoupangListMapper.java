package com.tt.dao;

import com.tt.entity.FangXfLoupangList;
import com.tt.entity.FangXfLoupangListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FangXfLoupangListMapper {
    int countByExample(FangXfLoupangListExample example);

    int deleteByExample(FangXfLoupangListExample example);

    int deleteByPrimaryKey(String id);

    int insert(FangXfLoupangList record);

    int insertSelective(FangXfLoupangList record);

    List<FangXfLoupangList> selectByExample(FangXfLoupangListExample example);

    FangXfLoupangList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FangXfLoupangList record, @Param("example") FangXfLoupangListExample example);

    int updateByExample(@Param("record") FangXfLoupangList record, @Param("example") FangXfLoupangListExample example);

    int updateByPrimaryKeySelective(FangXfLoupangList record);

    int updateByPrimaryKey(FangXfLoupangList record);
}