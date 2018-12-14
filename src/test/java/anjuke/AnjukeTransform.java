package anjuke;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eju.houseparent.common.security.MD5;
import com.github.pagehelper.PageHelper;
import com.tt.dao.*;
import com.tt.entity.*;
import com.tt.service.IEssUploadService;
import com.tt.vo.Context;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.eju.houseparent.common.utils.ImageReaderUtils.imageToByte;
import static com.eju.houseparent.common.utils.ImageReaderUtils.imgUrlUpdate;

/**
 *
 * anjuke 老表拆开转入新表
 * anjuke_community_huizong 转入anjuke_community_detail
 *
 * @Auther: 赵乐
 * @Date: 2018/11/16 15:17
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class AnjukeTransform {

    @Autowired
    private AnjukeCommunityHuizongMapper anjukeCommunityHuizongMapper;

    @Autowired
    private AnjukeCommunityListMapper anjukeCommunityListMapper;

    @Autowired
    private AnjukeCommunityDetailMapper anjukeCommunityDetailMapper;

    @Autowired
    private AnjukeCommunityLayoutMapper anjukeCommunityLayoutMapper;

    @Autowired
    private AnjukeCommunityRealityMapper anjukeCommunityRealityMapper;

    
    /**
     *
     * 功能描述: 安居客的老表入新表
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/21 10:22
     */
    @Test
    public void dataTransform(){
        AnjukeCommunityHuizongExample anjukeCommunityHuizongExample = new AnjukeCommunityHuizongExample();
        List<AnjukeCommunityHuizongWithBLOBs> anjukeCommunityHuizongWithBLOBs = anjukeCommunityHuizongMapper.selectByExampleWithBLOBs(anjukeCommunityHuizongExample);
        System.out.println(anjukeCommunityHuizongWithBLOBs.size());
        for (AnjukeCommunityHuizongWithBLOBs anjukeCommunityHuizongWithBLOB : anjukeCommunityHuizongWithBLOBs) {
            String homeName = anjukeCommunityHuizongWithBLOB.getHomeName();
            String address = anjukeCommunityHuizongWithBLOB.getAddress();
            String city = anjukeCommunityHuizongWithBLOB.getCity();
            String region = anjukeCommunityHuizongWithBLOB.getRegion();
            String plate = anjukeCommunityHuizongWithBLOB.getPlate();
            String buildYear = anjukeCommunityHuizongWithBLOB.getBuildYear();
            String averagePrice = anjukeCommunityHuizongWithBLOB.getAveragePrice();
            String thumbUrl = anjukeCommunityHuizongWithBLOB.getThumbUrl();
            String detailUrl = anjukeCommunityHuizongWithBLOB.getDetailUrl();
            String loopPosition = anjukeCommunityHuizongWithBLOB.getLoopPosition();
            String homeTotal = anjukeCommunityHuizongWithBLOB.getHomeTotal();
            String buildDevelopers = anjukeCommunityHuizongWithBLOB.getBuildDevelopers();
            String buildArea = anjukeCommunityHuizongWithBLOB.getBuildArea();
            String plotRate = anjukeCommunityHuizongWithBLOB.getPlotRate();
            String greenRate = anjukeCommunityHuizongWithBLOB.getGreenRate();
            String propertyCompany = anjukeCommunityHuizongWithBLOB.getPropertyCompany();
            String propertyPrice = anjukeCommunityHuizongWithBLOB.getPropertyPrice();
            String propertyType = anjukeCommunityHuizongWithBLOB.getPropertyType();
            String duikouSchool = anjukeCommunityHuizongWithBLOB.getDuikouSchool();
            String parkNum = anjukeCommunityHuizongWithBLOB.getParkNum();
            String layoutImages = anjukeCommunityHuizongWithBLOB.getLayoutImages();
            String realityImages = anjukeCommunityHuizongWithBLOB.getRealityImages();

            //户型图url和实景图url
            String layOutUrl= detailUrl.replace("view", "photos/model");
            String realityUrl= detailUrl.replace("view", "photos2/b");

            //列表
            AnjukeCommunityList anjukeCommunityList = new AnjukeCommunityList();
            anjukeCommunityList.setId(UUID.randomUUID().toString());
            anjukeCommunityList.setHomeName(homeName);
            anjukeCommunityList.setAddress(address);
            anjukeCommunityList.setCity(city);
            anjukeCommunityList.setRegion(region);
            anjukeCommunityList.setPlate(plate);
            anjukeCommunityList.setBuildYear(buildYear);
            anjukeCommunityList.setAveragePrice(averagePrice);
            anjukeCommunityList.setThumbUrl(thumbUrl);
            anjukeCommunityList.setDetailUrl(detailUrl);
            anjukeCommunityList.setLoopPosition(loopPosition);
            anjukeCommunityList.setStatus("0");
            anjukeCommunityList.setBatchId("v1.0");
            anjukeCommunityList.setCreateTime(new Date());
            anjukeCommunityListMapper.insertSelective(anjukeCommunityList);

            //详情
            AnjukeCommunityDetail anjukeCommunityDetail = new AnjukeCommunityDetail();
            anjukeCommunityDetail.setId(UUID.randomUUID().toString());
            anjukeCommunityDetail.setHomeName(homeName);
            anjukeCommunityDetail.setDetailUrl(detailUrl);
            anjukeCommunityDetail.setHomeTotal(homeTotal);
            anjukeCommunityDetail.setBuildDevelopers(buildDevelopers);
            anjukeCommunityDetail.setBuildArea(buildArea);
            anjukeCommunityDetail.setPlotRate(plotRate);
            anjukeCommunityDetail.setGreenRate(greenRate);
            anjukeCommunityDetail.setPropertyType(propertyType);
            anjukeCommunityDetail.setPropertyCompany(propertyCompany);
            anjukeCommunityDetail.setPropertyPrice(propertyPrice);
            anjukeCommunityDetail.setDuikouSchool(duikouSchool);
            anjukeCommunityDetail.setParkNum(parkNum);
            anjukeCommunityDetail.setLayoutUrl(layOutUrl);
            anjukeCommunityDetail.setRealityUrl(realityUrl);
            anjukeCommunityDetail.setBatchId("v1.0");
            anjukeCommunityDetail.setStatus("0");
            anjukeCommunityDetail.setCreateDate(new Date());
            anjukeCommunityDetailMapper.insertSelective(anjukeCommunityDetail);
            //户型图
            if(StringUtils.isNotBlank(layoutImages)|| !("[]".equals(layoutImages))){
                JSONArray objects = JSON.parseArray(layoutImages);
                if(objects!=null && objects.size()!=0){
                    for (int i = 0; i < objects.size(); i++) {
                        JSONObject jsonObject = objects.getJSONObject(i);
                        //房型
                        String roomType = jsonObject.getString("roomType");
                        //房型详情
                        JSONArray floorPlan = jsonObject.getJSONArray("floorPlan");
                        if(floorPlan!=null && floorPlan.size()!=0){
                            for (int j = 0; j < floorPlan.size(); j++) {
                                AnjukeCommunityLayout anjukeCommunityLayout = new AnjukeCommunityLayout();
                                anjukeCommunityLayout.setId(UUID.randomUUID().toString());
                                anjukeCommunityLayout.setDetailUrl(detailUrl);
                                anjukeCommunityLayout.setLayoutUrl(layOutUrl);

                                anjukeCommunityLayout.setBatchId("v1.0");
                                anjukeCommunityLayout.setStatus("0");
                                anjukeCommunityLayout.setCreateTime(new Date());
                                JSONObject jsonObject1 = floorPlan.getJSONObject(j);
                                String area = jsonObject1.getString("area");
                                String src = jsonObject1.getString("src");
                                String towards = jsonObject1.getString("towards");
                                String room = jsonObject1.getString("room");

                                anjukeCommunityLayout.setRoomtype(roomType);
                                anjukeCommunityLayout.setRoom(room);
                                anjukeCommunityLayout.setPicSrc(src);
                                anjukeCommunityLayout.setArea(area);
                                anjukeCommunityLayout.setTowards(towards);
                                anjukeCommunityLayoutMapper.insertSelective(anjukeCommunityLayout);

                            }

                        }
                    }
                }
            }
            //实景图
            if(StringUtils.isNotBlank(realityImages)|| !("[]".equals(realityImages))){
                JSONArray objects = JSON.parseArray(realityImages);
                if(objects!=null && objects.size()!=0){
                    for (int i = 0; i < objects.size(); i++) {
                        AnjukeCommunityReality anjukeCommunityReality = new AnjukeCommunityReality();
                        anjukeCommunityReality.setDetailUrl(detailUrl);
                        anjukeCommunityReality.setRealityUrl(realityUrl);
                        anjukeCommunityReality.setId(UUID.randomUUID().toString());
                        anjukeCommunityReality.setStatus("0");
                        anjukeCommunityReality.setCreateTime(new Date());
                        anjukeCommunityReality.setBatchId("v1.0");

                        String src = objects.getString(i);
                        anjukeCommunityReality.setPicSrc(src);
                        anjukeCommunityRealityMapper.insertSelective(anjukeCommunityReality);
                    }
                }

            }
        }
    }

}
