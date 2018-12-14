package com.tt.dao;

import com.tt.entity.JiageNameList;
import com.tt.entity.JiageNameListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JiageNameListMapper {
    int countByExample(JiageNameListExample example);

    int deleteByExample(JiageNameListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JiageNameList record);

    int insertSelective(JiageNameList record);

    List<JiageNameList> selectByExample(JiageNameListExample example);

    JiageNameList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JiageNameList record, @Param("example") JiageNameListExample example);

    int updateByExample(@Param("record") JiageNameList record, @Param("example") JiageNameListExample example);

    int updateByPrimaryKeySelective(JiageNameList record);

    int updateByPrimaryKey(JiageNameList record);
}