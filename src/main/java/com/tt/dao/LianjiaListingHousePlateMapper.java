package com.tt.dao;

import com.tt.entity.LianjiaListingHousePlate;
import com.tt.entity.LianjiaListingHousePlateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LianjiaListingHousePlateMapper {
    int countByExample(LianjiaListingHousePlateExample example);

    int deleteByExample(LianjiaListingHousePlateExample example);

    int deleteByPrimaryKey(String id);

    int insert(LianjiaListingHousePlate record);

    int insertSelective(LianjiaListingHousePlate record);

    List<LianjiaListingHousePlate> selectByExample(LianjiaListingHousePlateExample example);

    LianjiaListingHousePlate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LianjiaListingHousePlate record, @Param("example") LianjiaListingHousePlateExample example);

    int updateByExample(@Param("record") LianjiaListingHousePlate record, @Param("example") LianjiaListingHousePlateExample example);

    int updateByPrimaryKeySelective(LianjiaListingHousePlate record);

    int updateByPrimaryKey(LianjiaListingHousePlate record);
}