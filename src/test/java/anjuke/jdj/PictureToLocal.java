package anjuke.jdj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eju.houseparent.common.security.MD5;
import com.github.pagehelper.PageHelper;
import com.tt.dao.AnjukeBrokerEsfgoodsDetailQuchongMapper;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailQuchongExample;
import com.tt.entity.AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs;
import com.tt.service.IEssUploadService;
import com.tt.vo.Context;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.eju.houseparent.common.utils.ImageReaderUtils.imageToByte;
import static com.eju.houseparent.common.utils.ImageReaderUtils.imgUrlUpdate;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/12 14:23
 * @Description:
 */
public class PictureToLocal {
    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //列表
        AnjukeBrokerEsfgoodsDetailQuchongMapper anjukeBrokerEsfgoodsDetailQuchongMapper = (AnjukeBrokerEsfgoodsDetailQuchongMapper)applicationContext.getBean("anjukeBrokerEsfgoodsDetailQuchongMapper");

        IEssUploadService iEssUploadService = (IEssUploadService)applicationContext.getBean("essUploadServiceImpl");

        AnjukeBrokerEsfgoodsDetailQuchongExample anjukeBrokerEsfgoodsDetailQuchongExample = new AnjukeBrokerEsfgoodsDetailQuchongExample();
        anjukeBrokerEsfgoodsDetailQuchongExample.or().andPicUrlIsNull();
        Integer num=6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (int i = 1; i < 708; i++) {
            PageHelper.startPage(i,1000);
            List<AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs> anjukeBrokerEsfgoodsDetailQuchongWithBLOBs = anjukeBrokerEsfgoodsDetailQuchongMapper.selectByExampleWithBLOBs(anjukeBrokerEsfgoodsDetailQuchongExample);
            System.out.println(anjukeBrokerEsfgoodsDetailQuchongWithBLOBs.size());
            if(anjukeBrokerEsfgoodsDetailQuchongWithBLOBs!=null && anjukeBrokerEsfgoodsDetailQuchongWithBLOBs.size()!=0){
                for (AnjukeBrokerEsfgoodsDetailQuchongWithBLOBs anjukeBrokerEsfgoodsDetailQuchongWithBLOB : anjukeBrokerEsfgoodsDetailQuchongWithBLOBs) {
                    semaphore.acquire();
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String picJson = anjukeBrokerEsfgoodsDetailQuchongWithBLOB.getPicJson();
                                if(StringUtils.isNotBlank(picJson)){
                                    Map<String, Object> map = new HashMap<>();
                                    JSONObject object = JSON.parseObject(picJson);
                                    List<String> hxUrlList = new ArrayList<>();
                                    List<String> roomUrlList = new ArrayList<>();
                                    List<String> surroundUrlList= new ArrayList<>();
                                    //hxpics
                                    JSONArray hxPics = object.getJSONArray("hxPics");
                                    if(hxPics!=null && hxPics.size()!=0){
                                        for (int j=0;j<hxPics.size();j++) {
                                            String hxUrl = hxPics.getString(j);
                                            if(StringUtils.isNotBlank(hxUrl)){
                                                //封装图片类型
                                                String name = "fang/310000/community/"+ MD5.encrypt(hxUrl,"") +".jpg";
                                                byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",hxUrl));
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
                                                hxUrlList.add(newUrl);
                                            }
                                        }
                                    }
                                    //roomPics
                                    JSONArray roomPics = object.getJSONArray("roomPics");
                                    if(roomPics!=null && roomPics.size()!=0){
                                        for (int j = 0; j < roomPics.size(); j++) {
                                            String roomUrl = roomPics.getString(j);
                                            if(StringUtils.isNotBlank(roomUrl)){
                                                //封装图片类型
                                                String name = "fang/310000/community/"+ MD5.encrypt(roomUrl,"") +".jpg";
                                                byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",roomUrl));
                                                Context context = new Context();
                                                context.setFilename(name);
                                                context.setData(data);
                                                context.setContenttype("image/jpeg");
                                                try {
                                                    String newUrl = iEssUploadService.fileUpload(context);
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                roomUrlList.add(roomUrl);
                                            }

                                        }
                                    }
                                    //surroundPics
                                    JSONArray surroundPics = object.getJSONArray("surroundPics");
                                    if(surroundPics!=null && surroundPics.size()!=0){
                                        for (int j = 0; j < surroundPics.size(); j++) {
                                            String surroundUrl = surroundPics.getString(j);
                                            if(StringUtils.isNotBlank(surroundUrl)){
                                                //封装图片类型
                                                String name = "fang/310000/community/"+ MD5.encrypt(surroundUrl,"") +".jpg";
                                                byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",surroundUrl));
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
                                                surroundUrlList.add(newUrl);
                                            }
                                        }
                                    }
                                    //转jison
                                    map.put("hxPics",hxUrlList);
                                    map.put("roomPics",roomUrlList);
                                    map.put("surroundPics",surroundUrlList);
                                    String jsonString = JSON.toJSONString(map);
                                    System.out.println(jsonString);
                                    anjukeBrokerEsfgoodsDetailQuchongWithBLOB.setPicUrl(jsonString);
                                    //更新
                                    anjukeBrokerEsfgoodsDetailQuchongMapper.updateByPrimaryKeyWithBLOBs(anjukeBrokerEsfgoodsDetailQuchongWithBLOB);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                semaphore.release();
                            }
                        }
                    });

                }
            }
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }
}
