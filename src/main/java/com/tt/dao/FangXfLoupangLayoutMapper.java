package com.tt.dao;

import com.tt.entity.FangXfLoupangLayout;
import com.tt.entity.FangXfLoupangLayoutExample;
import com.tt.entity.FangXfLoupangLayoutKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FangXfLoupangLayoutMapper {
    int countByExample(FangXfLoupangLayoutExample example);

    int deleteByExample(FangXfLoupangLayoutExample example);

    int deleteByPrimaryKey(FangXfLoupangLayoutKey key);

    int insert(FangXfLoupangLayout record);

    int insertSelective(FangXfLoupangLayout record);

    List<FangXfLoupangLayout> selectByExample(FangXfLoupangLayoutExample example);

    FangXfLoupangLayout selectByPrimaryKey(FangXfLoupangLayoutKey key);

    int updateByExampleSelective(@Param("record") FangXfLoupangLayout record, @Param("example") FangXfLoupangLayoutExample example);

    int updateByExample(@Param("record") FangXfLoupangLayout record, @Param("example") FangXfLoupangLayoutExample example);

    int updateByPrimaryKeySelective(FangXfLoupangLayout record);

    int updateByPrimaryKey(FangXfLoupangLayout record);
}