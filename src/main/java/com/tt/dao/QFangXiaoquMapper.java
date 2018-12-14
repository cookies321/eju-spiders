package com.tt.dao;

import com.tt.entity.QFangXiaoqu;
import com.tt.entity.QFangXiaoquExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QFangXiaoquMapper {
    int countByExample(QFangXiaoquExample example);

    int deleteByExample(QFangXiaoquExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QFangXiaoqu record);

    int insertSelective(QFangXiaoqu record);

    List<QFangXiaoqu> selectByExample(QFangXiaoquExample example);

    QFangXiaoqu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QFangXiaoqu record, @Param("example") QFangXiaoquExample example);

    int updateByExample(@Param("record") QFangXiaoqu record, @Param("example") QFangXiaoquExample example);

    int updateByPrimaryKeySelective(QFangXiaoqu record);

    int updateByPrimaryKey(QFangXiaoqu record);
}