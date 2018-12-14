package com.tt.dao;

import com.tt.entity.QFangXiaoquZhaole;
import com.tt.entity.QFangXiaoquZhaoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QFangXiaoquZhaoleMapper {
    int countByExample(QFangXiaoquZhaoleExample example);

    int deleteByExample(QFangXiaoquZhaoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QFangXiaoquZhaole record);

    int insertSelective(QFangXiaoquZhaole record);

    List<QFangXiaoquZhaole> selectByExample(QFangXiaoquZhaoleExample example);

    QFangXiaoquZhaole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QFangXiaoquZhaole record, @Param("example") QFangXiaoquZhaoleExample example);

    int updateByExample(@Param("record") QFangXiaoquZhaole record, @Param("example") QFangXiaoquZhaoleExample example);

    int updateByPrimaryKeySelective(QFangXiaoquZhaole record);

    int updateByPrimaryKey(QFangXiaoquZhaole record);
}