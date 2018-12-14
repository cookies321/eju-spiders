package com.tt.dao;

import com.tt.entity.LianjiaListingHouseList;
import com.tt.entity.LianjiaListingHouseListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LianjiaListingHouseListMapper {
    int countByExample(LianjiaListingHouseListExample example);

    int deleteByExample(LianjiaListingHouseListExample example);

    int deleteByPrimaryKey(String id);

    int insert(LianjiaListingHouseList record);

    int insertSelective(LianjiaListingHouseList record);

    List<LianjiaListingHouseList> selectByExample(LianjiaListingHouseListExample example);

    LianjiaListingHouseList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LianjiaListingHouseList record, @Param("example") LianjiaListingHouseListExample example);

    int updateByExample(@Param("record") LianjiaListingHouseList record, @Param("example") LianjiaListingHouseListExample example);

    int updateByPrimaryKeySelective(LianjiaListingHouseList record);

    int updateByPrimaryKey(LianjiaListingHouseList record);
}