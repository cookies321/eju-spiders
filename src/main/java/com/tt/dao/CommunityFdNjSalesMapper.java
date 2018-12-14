package com.tt.dao;

import com.tt.entity.CommunityFdNjSales;
import com.tt.entity.CommunityFdNjSalesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdNjSalesMapper {
    int countByExample(CommunityFdNjSalesExample example);

    int deleteByExample(CommunityFdNjSalesExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdNjSales record);

    int insertSelective(CommunityFdNjSales record);

    List<CommunityFdNjSales> selectByExample(CommunityFdNjSalesExample example);

    CommunityFdNjSales selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdNjSales record, @Param("example") CommunityFdNjSalesExample example);

    int updateByExample(@Param("record") CommunityFdNjSales record, @Param("example") CommunityFdNjSalesExample example);

    int updateByPrimaryKeySelective(CommunityFdNjSales record);

    int updateByPrimaryKey(CommunityFdNjSales record);
}