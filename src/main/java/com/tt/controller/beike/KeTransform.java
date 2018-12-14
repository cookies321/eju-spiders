package com.tt.controller.beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eju.houseparent.common.security.MD5;
import com.tt.dao.AnjukeCommunityPicMapper;
import com.tt.dao.CommunityKeDetailReleaseHouseMapper;
import com.tt.entity.AnjukeCommunityPic;
import com.tt.entity.CommunityKeDetailReleaseHouseExample;
import com.tt.entity.CommunityKeDetailReleaseHouseWithBLOBs;
import com.tt.service.IEssUploadService;
import com.tt.vo.Context;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
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
 * anjuke 老表转入新表
 * 贝壳13城小区，实景图入库
 * @Auther: 赵乐
 * @Date: 2018/11/16 15:17
 * @Description:
 */
@Controller
public class KeTransform {

    @Autowired
    private CommunityKeDetailReleaseHouseMapper communityKeDetailReleasehouseMapper;

    @Autowired
    private AnjukeCommunityPicMapper anjukeCommunityPicMapper;

    @Autowired
    private IEssUploadService iEssUploadService;

    @RequestMapping("/xiaoquPicture")
    public void dataTrasform() throws InterruptedException {
        CommunityKeDetailReleaseHouseExample communityKeDetailReleasehouseExample = new CommunityKeDetailReleaseHouseExample();
        /*communityKeDetailReleasehouseExample.or().andXiaoquPhotoUrlIsNotNull().andXiaoquPhotoUrlLocalIsNull();
        communityKeDetailReleasehouseExample.setOrderByClause("title_id desc");
        PageHelper.offsetPage(0,15000);*/
        communityKeDetailReleasehouseExample.or().andXiaoquPhotoUrlIsNotNull().andXiaoquPhotoUrlLocalIsNull()
                .andTagEqualTo("thirteen");
        List<CommunityKeDetailReleaseHouseWithBLOBs> communityKeDetailReleaseHouseWithBLOBs = communityKeDetailReleasehouseMapper.selectByExampleWithBLOBs(communityKeDetailReleasehouseExample);
        System.out.println(communityKeDetailReleaseHouseWithBLOBs.size());
        Integer num=2;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityKeDetailReleaseHouseWithBLOBs communityKeDetailReleasehouse : communityKeDetailReleaseHouseWithBLOBs) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String xiaoquPhotoUrl = communityKeDetailReleasehouse.getXiaoquPhotoUrl();
                    System.out.println(xiaoquPhotoUrl);
                    List<Map> list = new ArrayList<>();
                    try {
                        if(StringUtils.isNotBlank(xiaoquPhotoUrl)){
                            JSONArray objects = JSON.parseArray(xiaoquPhotoUrl);
                            for (int i = 0; i < objects.size(); i++) {
                                JSONObject jsonObject = objects.getJSONObject(i);

                                String url = jsonObject.getString("url");
                                String type = jsonObject.getString("type");

                                String name = "fang/310000/community/"+ MD5.encrypt(url,"") +".jpg";
                                byte[] data = null;
                                try {
                                    data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",url));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if(data!=null){
                                    Context context = new Context();
                                    context.setFilename(name);
                                    context.setData(data);
                                    context.setContenttype("image/jpeg");
                                    String newUrl = null;
                                    try {
                                        newUrl = iEssUploadService.fileUpload(context);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        continue;
                                    }
                                    if(StringUtils.isNotBlank(newUrl)){
                                        HashMap<String, String> map = new HashMap<>();
                                        map.put("url",newUrl);
                                        map.put("type",type);
                                        list.add(map);

                                        //备份 追溯
                                        try {
                                            AnjukeCommunityPic anjukeCommunityPic = new AnjukeCommunityPic();
                                            anjukeCommunityPic.setId(UUID.randomUUID().toString());
                                            anjukeCommunityPic.setPicSrc(url);
                                            anjukeCommunityPic.setPicUrl(newUrl);
                                            anjukeCommunityPic.setCreateTime(new Date());
                                            anjukeCommunityPicMapper.insertSelective(anjukeCommunityPic);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }else{
                                    continue;
                                }
                            }
                        }
                        if(CollectionUtils.isNotEmpty(list)){
                            String jsonString = JSON.toJSONString(list);
                            communityKeDetailReleasehouse.setXiaoquPhotoUrlLocal(jsonString);
                            //更新
                            communityKeDetailReleasehouseMapper.updateByPrimaryKeySelective(communityKeDetailReleasehouse);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

}
