package com.tt.dao;

import com.tt.entity.RegionNum;
import com.tt.entity.RegionNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionNumMapper {
    int countByExample(RegionNumExample example);

    int deleteByExample(RegionNumExample example);

    int deleteByPrimaryKey(String id);

    int insert(RegionNum record);

    int insertSelective(RegionNum record);

    List<RegionNum> selectByExample(RegionNumExample example);

    RegionNum selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RegionNum record, @Param("example") RegionNumExample example);

    int updateByExample(@Param("record") RegionNum record, @Param("example") RegionNumExample example);

    int updateByPrimaryKeySelective(RegionNum record);

    int updateByPrimaryKey(RegionNum record);
}