package qfang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.utils.Pinyin4Util;
import com.tt.dao.QFangLoudongMapper;
import com.tt.dao.QFangXiaoquMapper;
import com.tt.dao.QfangXiaoquNotFiveYearMapper;
import com.tt.entity.*;
import com.tt.service.IDownLoadPage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * @author NJ
 * @create 2018-08-28 18:20
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class loudong{

    @Autowired
    @Qualifier("moguProxy")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private QFangXiaoquMapper qFangXiaoquMapper;

    @Autowired
    private QFangLoudongMapper qFangLoudongMapper;

    @Autowired
    private QfangXiaoquNotFiveYearMapper qfangXiaoquNotFiveYearMapper;



    /**
     * 根据 小区名 获取到 Q房对应的小区ID
     */
    @Test
    public void getCommunityId() throws InterruptedException {
        QfangXiaoquNotFiveYearExample qfangXiaoquNotFiveYearExample = new QfangXiaoquNotFiveYearExample();
        qfangXiaoquNotFiveYearExample.or().andSearchNameIsNotNull().andInternalIdIsNull().andSourceEqualTo("not_five_year");
        List<QfangXiaoquNotFiveYear> qfangXiaoquNotFiveYears = qfangXiaoquNotFiveYearMapper.selectByExample(qfangXiaoquNotFiveYearExample);
        System.out.println(qfangXiaoquNotFiveYears.size());
        if (CollectionUtils.isEmpty(qfangXiaoquNotFiveYears)) {
            return;
        }
        final int fixedNum = 4;
        Semaphore semaphore = new Semaphore(fixedNum);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);
        for (QfangXiaoquNotFiveYear xiaoqu : qfangXiaoquNotFiveYears) {
            String city = xiaoqu.getCity();
            if(StringUtils.isBlank(city)){
                continue;
            }
            String cityPin = Pinyin4Util.parse13City(city);
            if(StringUtils.isBlank(cityPin)){
                continue;
            }
            String url = "https://"+cityPin+".qfang.com/delegation/getGarden";  //Q房 根据小区名查询对应小区ID 接口 POST请求
            try {
                semaphore.acquire();
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (StringUtils.isEmpty(xiaoqu.getSearchName())) {
                                return;
                            }
                            Map<String,String> parms = new HashMap<>();
                            parms.put("keyword", xiaoqu.getSearchName());
                            Document document = iDownLoadPage.downLoadPageByPost(url, parms);
                            Elements select = document.select("body");
                            if(!select.isEmpty()){
                                String str=select.text();
                                try {
                                    JSONObject object = JSON.parseObject(str);
                                    if (object.getString("ret").equals("1")) {  //接口又返回结果
                                        JSONObject result = object.getJSONObject("result");
                                        if (result != null) {
                                            JSONArray array = result.getJSONArray("gardenList");
                                            if (array != null && array.size() > 0) {
                                                JSONObject garden = array.getJSONObject(0);

                                                String internalID = garden.getString("internalID");
                                                String id = garden.getString("id");
                                                String alias = garden.getString("alias");

                                                xiaoqu.setInternalId(internalID);
                                                xiaoqu.setqId(id);
                                                xiaoqu.setAlias(alias);
                                                qfangXiaoquNotFiveYearMapper.updateByPrimaryKeySelective(xiaoqu);
                                            }else{
                                                xiaoqu.setStatus("v3.0_0");
                                                qfangXiaoquNotFiveYearMapper.updateByPrimaryKeySelective(xiaoqu);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();
        while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS)) ;
    }

    /**
     * 获取楼栋数据
     */
    @Test
    public void getLoudong() throws InterruptedException {
        QfangXiaoquNotFiveYearExample qfangXiaoquNotFiveYearExample = new QfangXiaoquNotFiveYearExample();
        qfangXiaoquNotFiveYearExample.or().andInternalIdIsNotNull().andAliasIsNull().andSourceEqualTo("not_five_year");
        List<QfangXiaoquNotFiveYear> qfangXiaoquNotFiveYears = qfangXiaoquNotFiveYearMapper.selectByExample(qfangXiaoquNotFiveYearExample);

        System.out.println(qfangXiaoquNotFiveYears.size()+"==================================");
        if (CollectionUtils.isEmpty(qfangXiaoquNotFiveYears)) {
            return;
        }
        final int fixedNum = 4;
        Semaphore semaphore = new Semaphore(fixedNum);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fixedNum);
        for (QfangXiaoquNotFiveYear xiaoqu : qfangXiaoquNotFiveYears) {
            //根据城市拼音拼接url
            String city = xiaoqu.getCity();
            if(StringUtils.isBlank(city)){
                continue;
            }
            String cityPin = Pinyin4Util.parse13City(city);
            if(StringUtils.isBlank(cityPin)){
                continue;
            }
            String url = "https://"+cityPin+".qfang.com/delegation/getBuilding"; //获取楼栋数据 POST请求
            try {
                semaphore.acquire();
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (StringUtils.isEmpty(xiaoqu.getInternalId())) {
                                return;
                            }
                            Map parms = new HashMap<>();
                            parms.put("gardenInternalId", xiaoqu.getInternalId());

                            Document document = iDownLoadPage.downLoadPageByPost(url, parms);
                            Elements select = document.select("body");
                            if(!select.isEmpty()) {
                                String str = select.text();
                                try {
                                    JSONObject object = JSON.parseObject(str);
                                    if (object.getString("ret").equals("1")) {  //接口又返回结果
                                        JSONObject result = object.getJSONObject("result");
                                        if (result != null) {
                                            JSONArray array = result.getJSONArray("buildingList");
                                            if (array != null && array.size() > 0) {
                                                for (Object o : array) {
                                                    JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(o));
                                                    if (jsonObject != null) {
                                                        QFangLoudong loudong = new QFangLoudong();
                                                        String buildName = jsonObject.getString("buildName");
                                                        String buildId = jsonObject.getString("buildId");
                                                        String buildRegisterName = jsonObject.getString("buildRegisterName");

                                                        loudong.setqId(xiaoqu.getqId());
                                                        loudong.setInternalId(xiaoqu.getInternalId());
                                                        loudong.setBuildId(buildId);
                                                        loudong.setBuildName(buildName);
                                                        loudong.setBuildRegisterName(buildRegisterName);
                                                        loudong.setStatus("v3.0");
                                                        loudong.setSource("not_five_year");
                                                        qFangLoudongMapper.insert(loudong);
                                                    }
                                                }
                                                xiaoqu.setStatus("v3.0_1");
                                                qfangXiaoquNotFiveYearMapper.updateByPrimaryKeySelective(xiaoqu);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();
        while (!fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }
}
