package com.tt.controller.fangjia;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.utils.DateUtil;
import com.tt.dao.CommunityPriceFangjiaMapper;
import com.tt.dao.JiageNameListMapper;
import com.tt.entity.CommunityPriceFangjia;
import com.tt.entity.JiageNameList;
import com.tt.entity.JiageNameListExample;
import com.tt.service.IDownLoadPage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * @author NJ
 * @create 2018-08-01 10:50
 **/
@RestController
public class fangjia {

    @Autowired
    @Qualifier("ipPoolProxy")
    //@Qualifier("moguProxy")
    private IDownLoadPage downLoadPage;

    @Autowired
    private JiageNameListMapper jiageNameListMapper;

    @Autowired
    private CommunityPriceFangjiaMapper communityPriceFangjiaMapper;

    /**
     *
     * 功能描述: 
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/7 11:08
     */
    @RequestMapping("/parseFangJia")
    public void parseFangjia() throws InterruptedException {
        JiageNameListExample jiageNameListExample = new JiageNameListExample();
        JiageNameListExample.Criteria criteria = jiageNameListExample.createCriteria();
        criteria.andSourceIsNull();
        List<JiageNameList> jiageNameLists = jiageNameListMapper.selectByExample(jiageNameListExample);

        int num=6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        System.out.println(jiageNameLists.size());
        if (CollectionUtils.isNotEmpty(jiageNameLists)) {
            for (JiageNameList jiageNameList : jiageNameLists) {
                Thread.sleep(3000);
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            String cityName = jiageNameList.getCity();
                            Long id = jiageNameList.getId();
                            String modelUrl = null;
                            //判断城市
                            switch (cityName){
                                case "上海":
                                    modelUrl="http://sh.fangjia.com/trend/year2Data?defaultCityName=上海&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"北京":
                                    modelUrl="http://bj.fangjia.com/trend/year2Data?defaultCityName=北京&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;

                                case "东莞":
                                    modelUrl="http://dongguan.fangjia.com/trend/year2Data?defaultCityName=东莞&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"南京":
                                    modelUrl="http://nj.fangjia.com/trend/year2Data?defaultCityName=南京&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case "天津":
                                    modelUrl="http://tj.fangjia.com/trend/year2Data?defaultCityName=天津&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"广州":
                                    modelUrl="http://gz.fangjia.com/trend/year2Data?defaultCityName=广州&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;

                                case "成都":
                                    modelUrl="http://cd.fangjia.com/trend/year2Data?defaultCityName=成都&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"杭州":
                                    modelUrl="http://hz.fangjia.com/trend/year2Data?defaultCityName=杭州&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;

                                case "武汉":
                                    modelUrl="http://wh.fangjia.com/trend/year2Data?defaultCityName=武汉&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;

                                case "沈阳":
                                    modelUrl="http://sy.fangjia.com/trend/year2Data?defaultCityName=沈阳&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"深圳":
                                    modelUrl="http://sz.fangjia.com/trend/year2Data?defaultCityName=深圳&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;

                                case "苏州":
                                    modelUrl="http://suz.fangjia.com/trend/year2Data?defaultCityName=苏州&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"青岛":
                                    modelUrl="http://qd.fangjia.com/trend/year2Data?defaultCityName=青岛&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                case"重庆":
                                    modelUrl="http://cq.fangjia.com/trend/year2Data?defaultCityName=重庆&districtName=%s&region=%s&block=%s&keyword=%s";
                                    break;
                                default:
                                    break;
                            }
                            if(StringUtils.isBlank(modelUrl)){
                                return;
                            }
                            String str = null;
                            try {
                                try {
                                    Map<String, String> map = new HashMap();
                                    map.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
                                    //map.put("Host", "sh.fangjia.com");

                                    Document document = downLoadPage.downLoadPageByGet(String.format(modelUrl, "", "", "", jiageNameList.getName()),map);
                                    if(document!=null){
                                        str = document.select("body").text();
                                        System.out.println("---返回结果---" + str);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("---请求异常---");
                                return;
                            }

                            if (!str.contains("series")) {
                                return;
                            }
                            try {
                                JSONObject jsonObject = JSON.parseObject(str);
                                JSONArray seriesArr = jsonObject.getJSONArray("series");
                                if (seriesArr.size() > 0) {
                                    JSONObject object = JSON.parseObject(JSON.toJSONString(seriesArr.get(0)));
                                    if (object != null) {
                                        String otherName = object.getString("name");
                                        JSONArray dataArr = object.getJSONArray("data");
                                        if (dataArr.size() > 0) {
                                            for (Object data : dataArr) {
                                                if (data instanceof JSONArray) {
                                                    CommunityPriceFangjia jiage = new CommunityPriceFangjia();
                                                    JSONArray os = JSON.parseArray(JSON.toJSONString(data));
                                                    jiage.setDt(DateUtil.strToDate(DateUtil.timeStamp2Date(os.get(0).toString(), null)));
                                                    jiage.setName(jiageNameList.getName());
                                                    jiage.setNameId(id);
                                                    jiage.setCity(cityName);
                                                    jiage.setOtherName(otherName);
                                                    jiage.setPrice(os.getString(1));
                                                    jiage.setType("community");
                                                    jiage.setSource("fangjia");
                                                    communityPriceFangjiaMapper.insert(jiage);
                                                }
                                            }
                                        }
                                        jiageNameList.setSource("1");
                                    }
                                }else {
                                    jiageNameList.setSource("0");
                                }
                                jiageNameListMapper.updateByPrimaryKeySelective(jiageNameList);
                            } catch (Exception e) {
                                e.printStackTrace();
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

        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("运行结束");
    }
}
