package com.tt.dao;

import com.tt.entity.AnjukeBrokerEsfgoodsDetailQuchong;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailQuchongExample;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeBrokerEsfgoodsDetailQuchongMapper {
    int countByExample(AnjukeBrokerEsfgoodsDetailQuchongExample example);

    int deleteByExample(AnjukeBrokerEsfgoodsDetailQuchongExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs record);

    int insertSelective(AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs record);

    List<AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs> selectByExampleWithBLOBs(AnjukeBrokerEsfgoodsDetailQuchongExample example);

    List<AnjukeBrokerEsfgoodsDetailQuchong> selectByExample(AnjukeBrokerEsfgoodsDetailQuchongExample example);

    AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs record, @Param("example") AnjukeBrokerEsfgoodsDetailQuchongExample example);

    int updateByExampleWithBLOBs(@Param("record") AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs record, @Param("example") AnjukeBrokerEsfgoodsDetailQuchongExample example);

    int updateByExample(@Param("record") AnjukeBrokerEsfgoodsDetailQuchong record, @Param("example") AnjukeBrokerEsfgoodsDetailQuchongExample example);

    int updateByPrimaryKeySelective(AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs record);

    int updateByPrimaryKey(AnjukeBrokerEsfgoodsDetailQuchong record);
}