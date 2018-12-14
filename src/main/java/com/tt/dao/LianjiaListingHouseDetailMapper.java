package com.tt.dao;

import com.tt.entity.LianjiaListingHouseDetail;
import com.tt.entity.LianjiaListingHouseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LianjiaListingHouseDetailMapper {
    int countByExample(LianjiaListingHouseDetailExample example);

    int deleteByExample(LianjiaListingHouseDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(LianjiaListingHouseDetail record);

    int insertSelective(LianjiaListingHouseDetail record);

    List<LianjiaListingHouseDetail> selectByExampleWithBLOBs(LianjiaListingHouseDetailExample example);

    List<LianjiaListingHouseDetail> selectByExample(LianjiaListingHouseDetailExample example);

    LianjiaListingHouseDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LianjiaListingHouseDetail record, @Param("example") LianjiaListingHouseDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") LianjiaListingHouseDetail record, @Param("example") LianjiaListingHouseDetailExample example);

    int updateByExample(@Param("record") LianjiaListingHouseDetail record, @Param("example") LianjiaListingHouseDetailExample example);

    int updateByPrimaryKeySelective(LianjiaListingHouseDetail record);

    int updateByPrimaryKeyWithBLOBs(LianjiaListingHouseDetail record);

    int updateByPrimaryKey(LianjiaListingHouseDetail record);
}