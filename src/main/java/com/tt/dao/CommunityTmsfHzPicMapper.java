package com.tt.dao;

import com.tt.entity.CommunityTmsfHzPic;
import com.tt.entity.CommunityTmsfHzPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityTmsfHzPicMapper {
    int countByExample(CommunityTmsfHzPicExample example);

    int deleteByExample(CommunityTmsfHzPicExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityTmsfHzPic record);

    int insertSelective(CommunityTmsfHzPic record);

    List<CommunityTmsfHzPic> selectByExample(CommunityTmsfHzPicExample example);

    CommunityTmsfHzPic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityTmsfHzPic record, @Param("example") CommunityTmsfHzPicExample example);

    int updateByExample(@Param("record") CommunityTmsfHzPic record, @Param("example") CommunityTmsfHzPicExample example);

    int updateByPrimaryKeySelective(CommunityTmsfHzPic record);

    int updateByPrimaryKey(CommunityTmsfHzPic record);
}