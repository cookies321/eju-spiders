package com.tt.dao;

import com.tt.entity.LianjiaListingHousePic;
import com.tt.entity.LianjiaListingHousePicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LianjiaListingHousePicMapper {
    int countByExample(LianjiaListingHousePicExample example);

    int deleteByExample(LianjiaListingHousePicExample example);

    int deleteByPrimaryKey(String id);

    int insert(LianjiaListingHousePic record);

    int insertSelective(LianjiaListingHousePic record);

    List<LianjiaListingHousePic> selectByExample(LianjiaListingHousePicExample example);

    LianjiaListingHousePic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LianjiaListingHousePic record, @Param("example") LianjiaListingHousePicExample example);

    int updateByExample(@Param("record") LianjiaListingHousePic record, @Param("example") LianjiaListingHousePicExample example);

    int updateByPrimaryKeySelective(LianjiaListingHousePic record);

    int updateByPrimaryKey(LianjiaListingHousePic record);
}