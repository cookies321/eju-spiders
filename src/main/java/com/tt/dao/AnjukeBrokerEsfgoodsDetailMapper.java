package com.tt.dao;

import com.tt.entity.AnjukeBrokerEsfgoodsDetail;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailExample;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeBrokerEsfgoodsDetailMapper {
    int countByExample(AnjukeBrokerEsfgoodsDetailExample example);

    int deleteByExample(AnjukeBrokerEsfgoodsDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeBrokerEsfgoodsDetailWithBLOBs record);

    int insertSelective(AnjukeBrokerEsfgoodsDetailWithBLOBs record);

    List<AnjukeBrokerEsfgoodsDetailWithBLOBs> selectByExampleWithBLOBs(AnjukeBrokerEsfgoodsDetailExample example);

    List<AnjukeBrokerEsfgoodsDetail> selectByExample(AnjukeBrokerEsfgoodsDetailExample example);

    AnjukeBrokerEsfgoodsDetailWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeBrokerEsfgoodsDetailWithBLOBs record, @Param("example") AnjukeBrokerEsfgoodsDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") AnjukeBrokerEsfgoodsDetailWithBLOBs record, @Param("example") AnjukeBrokerEsfgoodsDetailExample example);

    int updateByExample(@Param("record") AnjukeBrokerEsfgoodsDetail record, @Param("example") AnjukeBrokerEsfgoodsDetailExample example);

    int updateByPrimaryKeySelective(AnjukeBrokerEsfgoodsDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnjukeBrokerEsfgoodsDetailWithBLOBs record);

    int updateByPrimaryKey(AnjukeBrokerEsfgoodsDetail record);
}