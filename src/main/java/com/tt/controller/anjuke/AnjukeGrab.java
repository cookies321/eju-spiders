package com.tt.controller.anjuke;

import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.ValidateUtil;
import com.tt.service.IParse;
import com.tt.service.JedisClientService;
import com.tt.service.impl.DownLoadPage;
import com.tt.vo.AnjukeParamsVo;
import com.tt.vo.UrlType;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 从缓存中获取种子链接，解析
 * @Auther: 赵乐
 * @Date: 2018/10/22 13:41
 * @Description:
 */
@RestController
public class AnjukeGrab {

    @Autowired
    private JedisClientService jedisClientService;

    @Autowired
    private DownLoadPage downLoadPage;

    @Resource(name="parseAnjukeImpl")
    private IParse iParse;

    //redis中存放分页链接的key
    public static final String KEY_URL = "queueUrl";
    /**
     *
     * @return
     */
    @RequestMapping("/grab")
    public void grab() throws InterruptedException {
        //创建线程池
        final Semaphore semaphore = new Semaphore(6);
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while(true){
            //从队列中获取种子
            AnjukeParamsVo anjukeParamsVo = (AnjukeParamsVo)jedisClientService.pollFromList("queueUrl");

            if(anjukeParamsVo!=null && StringUtils.isNotBlank(anjukeParamsVo.getUrl())){
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //AnjukeParamsVo anjukeParamsVo = (AnjukeParamsVo)jedisClientService.pollFromList("queueUrl");
                            //获取种子链接，判断种子链接的类型
                            String url = anjukeParamsVo.getUrl();
                            //url的请求类型
                            UrlType httpType = anjukeParamsVo.getHttpType();
                            //头部信息(cookie)
                            Map<String, String> header = anjukeParamsVo.getHeader();
                            //getqi请求
                            String result =null;
                            if(httpType.equals(UrlType.GET)){
                                if(header==null || header.keySet().isEmpty()){
                                    result = downLoadPage.downLoadPage(url);
                                }else {
                                    result=downLoadPage.downLoadPage(url, header);
                                }
                            }else if(httpType.equals(UrlType.POST)){
                                //获取参数值
                                Map<String, String> postMapParams = anjukeParamsVo.getPostMapParams();
                                result = downLoadPage.downLoadPage(url, postMapParams, header);
                            }

                            if(result==null){
                                System.out.println("链接请求失败，result==null,放回队里==============="+url);
                                jedisClientService.addObjectToList(KEY_URL,anjukeParamsVo);
                                return;
                            }else{
                                anjukeParamsVo.setContent(result);
                                // 详情解析
                                try {
                                    iParse.parsePage(anjukeParamsVo);
                                } catch (Exception e) {
                                    jedisClientService.addObjectToList(KEY_URL,anjukeParamsVo);
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            /*System.out.println("运行中"+anjukeParamsVo.getUrl());
                            System.out.println(Thread.currentThread().getName());*/
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }
                    }
                });

            }else{
                System.out.println("队列中的数据是空");
                Thread.sleep(5000);
            }
        }
        //executorService.shutdown();
        //while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) ;
    }
}
