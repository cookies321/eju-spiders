package com.tt.dao;

import com.tt.entity.QfangXiaoquNotFiveYear;
import com.tt.entity.QfangXiaoquNotFiveYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QfangXiaoquNotFiveYearMapper {
    int countByExample(QfangXiaoquNotFiveYearExample example);

    int deleteByExample(QfangXiaoquNotFiveYearExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QfangXiaoquNotFiveYear record);

    int insertSelective(QfangXiaoquNotFiveYear record);

    List<QfangXiaoquNotFiveYear> selectByExample(QfangXiaoquNotFiveYearExample example);

    QfangXiaoquNotFiveYear selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QfangXiaoquNotFiveYear record, @Param("example") QfangXiaoquNotFiveYearExample example);

    int updateByExample(@Param("record") QfangXiaoquNotFiveYear record, @Param("example") QfangXiaoquNotFiveYearExample example);

    int updateByPrimaryKeySelective(QfangXiaoquNotFiveYear record);

    int updateByPrimaryKey(QfangXiaoquNotFiveYear record);
}