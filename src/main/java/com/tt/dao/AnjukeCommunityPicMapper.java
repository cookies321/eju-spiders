package com.tt.dao;

import com.tt.entity.AnjukeCommunityPic;
import com.tt.entity.AnjukeCommunityPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeCommunityPicMapper {
    int countByExample(AnjukeCommunityPicExample example);

    int deleteByExample(AnjukeCommunityPicExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeCommunityPic record);

    int insertSelective(AnjukeCommunityPic record);

    List<AnjukeCommunityPic> selectByExample(AnjukeCommunityPicExample example);

    AnjukeCommunityPic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeCommunityPic record, @Param("example") AnjukeCommunityPicExample example);

    int updateByExample(@Param("record") AnjukeCommunityPic record, @Param("example") AnjukeCommunityPicExample example);

    int updateByPrimaryKeySelective(AnjukeCommunityPic record);

    int updateByPrimaryKey(AnjukeCommunityPic record);
}