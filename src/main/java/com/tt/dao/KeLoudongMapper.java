package com.tt.dao;

import com.tt.entity.KeLoudong;
import com.tt.entity.KeLoudongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeLoudongMapper {
    int countByExample(KeLoudongExample example);

    int deleteByExample(KeLoudongExample example);

    int deleteByPrimaryKey(String id);

    int insert(KeLoudong record);

    int insertSelective(KeLoudong record);

    List<KeLoudong> selectByExample(KeLoudongExample example);

    KeLoudong selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KeLoudong record, @Param("example") KeLoudongExample example);

    int updateByExample(@Param("record") KeLoudong record, @Param("example") KeLoudongExample example);

    int updateByPrimaryKeySelective(KeLoudong record);

    int updateByPrimaryKey(KeLoudong record);
}