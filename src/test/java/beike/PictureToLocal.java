package beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eju.houseparent.common.security.MD5;
import com.tt.dao.AnjukeCommunityPicMapper;
import com.tt.dao.CommunityKeDetailReleaseHouseMapper;
import com.tt.dao.KeLayoutMapper;
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
 * 贝壳的图片url入库
 * @Auther: 赵乐
 * @Date: 2018/11/19 17:17
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class PictureToLocal {
    @Autowired
    private CommunityKeDetailReleaseHouseMapper communityKeDetailReleasehouseMapper;

    @Autowired
    private AnjukeCommunityPicMapper anjukeCommunityPicMapper;

    @Autowired
    private KeLayoutMapper keLayoutMapper;

    @Autowired
    private IEssUploadService iEssUploadService;


    /**
     *
     * 功能描述:户型图入库
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/20 14:44
     */
    @Test
    public void layOutPictureTolocal() throws InterruptedException {
        KeLayoutExample keLayoutExample = new KeLayoutExample();
        keLayoutExample.or().andFrameImageIsNotNull().andFrameUrlIsNull().andStatusEqualTo("one");
        List<KeLayout> keLayouts = keLayoutMapper.selectByExample(keLayoutExample);
        System.out.println(keLayouts.size());
        Integer num=6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (KeLayout keLayout : keLayouts) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String frameImage = keLayout.getFrameImage();
                        if(StringUtils.isBlank(frameImage)){
                            return;
                        }
                        String name = "fang/310000/community/"+ MD5.encrypt(frameImage,"") +".jpg";
                        byte[] data = null;

                        try {
                            data=imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",frameImage));
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
                            }
                            keLayout.setFrameUrl(newUrl);
                            keLayout.setStatus("1");
                            //更新操作
                            keLayoutMapper.updateByPrimaryKeySelective(keLayout);
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


    /**
     *
     * 功能描述: 贝壳的小区户型图入库
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/21 10:02
     */
    @Test
    public void dataTrasform() throws InterruptedException {
        CommunityKeDetailReleaseHouseExample communityKeDetailReleasehouseExample = new CommunityKeDetailReleaseHouseExample();
        /*communityKeDetailReleasehouseExample.or().andXiaoquPhotoUrlIsNotNull().andXiaoquPhotoUrlLocalIsNull();
        communityKeDetailReleasehouseExample.setOrderByClause("title_id desc");
        PageHelper.offsetPage(15000,15000);*/
        communityKeDetailReleasehouseExample.or().andXiaoquPhotoUrlIsNotNull().andXiaoquPhotoUrlLocalIsNull().
                andTagEqualTo("four");
        List<CommunityKeDetailReleaseHouseWithBLOBs> communityKeDetailReleaseHouseWithBLOBs = communityKeDetailReleasehouseMapper.selectByExampleWithBLOBs(communityKeDetailReleasehouseExample);
        System.out.println(communityKeDetailReleaseHouseWithBLOBs.size());
        Integer num=4;
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
