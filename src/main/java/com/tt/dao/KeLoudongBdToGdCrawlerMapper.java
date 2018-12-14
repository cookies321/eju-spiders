package com.tt.dao;

import com.tt.entity.KeLoudongBdToGdCrawler;
import com.tt.entity.KeLoudongBdToGdCrawlerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeLoudongBdToGdCrawlerMapper {
    int countByExample(KeLoudongBdToGdCrawlerExample example);

    int deleteByExample(KeLoudongBdToGdCrawlerExample example);

    int deleteByPrimaryKey(String id);

    int insert(KeLoudongBdToGdCrawler record);

    int insertSelective(KeLoudongBdToGdCrawler record);

    List<KeLoudongBdToGdCrawler> selectByExample(KeLoudongBdToGdCrawlerExample example);

    KeLoudongBdToGdCrawler selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KeLoudongBdToGdCrawler record, @Param("example") KeLoudongBdToGdCrawlerExample example);

    int updateByExample(@Param("record") KeLoudongBdToGdCrawler record, @Param("example") KeLoudongBdToGdCrawlerExample example);

    int updateByPrimaryKeySelective(KeLoudongBdToGdCrawler record);

    int updateByPrimaryKey(KeLoudongBdToGdCrawler record);
}