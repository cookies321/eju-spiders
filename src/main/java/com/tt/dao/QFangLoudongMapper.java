package com.tt.dao;

import com.tt.entity.QFangLoudong;
import com.tt.entity.QFangLoudongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QFangLoudongMapper {
    int countByExample(QFangLoudongExample example);

    int deleteByExample(QFangLoudongExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QFangLoudong record);

    int insertSelective(QFangLoudong record);

    List<QFangLoudong> selectByExample(QFangLoudongExample example);

    QFangLoudong selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QFangLoudong record, @Param("example") QFangLoudongExample example);

    int updateByExample(@Param("record") QFangLoudong record, @Param("example") QFangLoudongExample example);

    int updateByPrimaryKeySelective(QFangLoudong record);

    int updateByPrimaryKey(QFangLoudong record);
}