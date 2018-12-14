package com.tt.dao;

import com.tt.entity.CommunityFdNjPic;
import com.tt.entity.CommunityFdNjPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityFdNjPicMapper {
    int countByExample(CommunityFdNjPicExample example);

    int deleteByExample(CommunityFdNjPicExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommunityFdNjPic record);

    int insertSelective(CommunityFdNjPic record);

    List<CommunityFdNjPic> selectByExample(CommunityFdNjPicExample example);

    CommunityFdNjPic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommunityFdNjPic record, @Param("example") CommunityFdNjPicExample example);

    int updateByExample(@Param("record") CommunityFdNjPic record, @Param("example") CommunityFdNjPicExample example);

    int updateByPrimaryKeySelective(CommunityFdNjPic record);

    int updateByPrimaryKey(CommunityFdNjPic record);
}