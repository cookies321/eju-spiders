package com.tt.dao;

import com.tt.entity.CommunityPriceFangjia;
import com.tt.entity.CommunityPriceFangjiaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityPriceFangjiaMapper {
    int countByExample(CommunityPriceFangjiaExample example);

    int deleteByExample(CommunityPriceFangjiaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommunityPriceFangjia record);

    int insertSelective(CommunityPriceFangjia record);

    List<CommunityPriceFangjia> selectByExample(CommunityPriceFangjiaExample example);

    CommunityPriceFangjia selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommunityPriceFangjia record, @Param("example") CommunityPriceFangjiaExample example);

    int updateByExample(@Param("record") CommunityPriceFangjia record, @Param("example") CommunityPriceFangjiaExample example);

    int updateByPrimaryKeySelective(CommunityPriceFangjia record);

    int updateByPrimaryKey(CommunityPriceFangjia record);
}