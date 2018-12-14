package com.tt.dao;

import com.tt.entity.AnjukeJjrEsfgoodsPic;
import com.tt.entity.AnjukeJjrEsfgoodsPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnjukeJjrEsfgoodsPicMapper {
    int countByExample(AnjukeJjrEsfgoodsPicExample example);

    int deleteByExample(AnjukeJjrEsfgoodsPicExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnjukeJjrEsfgoodsPic record);

    int insertSelective(AnjukeJjrEsfgoodsPic record);

    List<AnjukeJjrEsfgoodsPic> selectByExample(AnjukeJjrEsfgoodsPicExample example);

    AnjukeJjrEsfgoodsPic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnjukeJjrEsfgoodsPic record, @Param("example") AnjukeJjrEsfgoodsPicExample example);

    int updateByExample(@Param("record") AnjukeJjrEsfgoodsPic record, @Param("example") AnjukeJjrEsfgoodsPicExample example);

    int updateByPrimaryKeySelective(AnjukeJjrEsfgoodsPic record);

    int updateByPrimaryKey(AnjukeJjrEsfgoodsPic record);
}