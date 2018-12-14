package com.tt.dao;

import com.tt.entity.Jiage1107;
import com.tt.entity.Jiage1107Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jiage1107Mapper {
    int countByExample(Jiage1107Example example);

    int deleteByExample(Jiage1107Example example);

    int deleteByPrimaryKey(Long id);

    int insert(Jiage1107 record);

    int insertSelective(Jiage1107 record);

    List<Jiage1107> selectByExample(Jiage1107Example example);

    Jiage1107 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Jiage1107 record, @Param("example") Jiage1107Example example);

    int updateByExample(@Param("record") Jiage1107 record, @Param("example") Jiage1107Example example);

    int updateByPrimaryKeySelective(Jiage1107 record);

    int updateByPrimaryKey(Jiage1107 record);
}