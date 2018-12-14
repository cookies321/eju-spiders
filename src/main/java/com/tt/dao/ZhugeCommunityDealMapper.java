package com.tt.dao;

import com.tt.entity.ZhugeCommunityDeal;
import com.tt.entity.ZhugeCommunityDealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZhugeCommunityDealMapper {
    int countByExample(ZhugeCommunityDealExample example);

    int deleteByExample(ZhugeCommunityDealExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZhugeCommunityDeal record);

    int insertSelective(ZhugeCommunityDeal record);

    List<ZhugeCommunityDeal> selectByExample(ZhugeCommunityDealExample example);

    ZhugeCommunityDeal selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZhugeCommunityDeal record, @Param("example") ZhugeCommunityDealExample example);

    int updateByExample(@Param("record") ZhugeCommunityDeal record, @Param("example") ZhugeCommunityDealExample example);

    int updateByPrimaryKeySelective(ZhugeCommunityDeal record);

    int updateByPrimaryKey(ZhugeCommunityDeal record);
}