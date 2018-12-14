package com.tt.dao;

import com.tt.entity.FangXfLoupangBuildinglayout;
import com.tt.entity.FangXfLoupangBuildinglayoutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FangXfLoupangBuildinglayoutMapper {
    int countByExample(FangXfLoupangBuildinglayoutExample example);

    int deleteByExample(FangXfLoupangBuildinglayoutExample example);

    int deleteByPrimaryKey(String id);

    int insert(FangXfLoupangBuildinglayout record);

    int insertSelective(FangXfLoupangBuildinglayout record);

    List<FangXfLoupangBuildinglayout> selectByExample(FangXfLoupangBuildinglayoutExample example);

    FangXfLoupangBuildinglayout selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FangXfLoupangBuildinglayout record, @Param("example") FangXfLoupangBuildinglayoutExample example);

    int updateByExample(@Param("record") FangXfLoupangBuildinglayout record, @Param("example") FangXfLoupangBuildinglayoutExample example);

    int updateByPrimaryKeySelective(FangXfLoupangBuildinglayout record);

    int updateByPrimaryKey(FangXfLoupangBuildinglayout record);
}