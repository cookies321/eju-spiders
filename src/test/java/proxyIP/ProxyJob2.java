package proxyIP;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/29 14:43
 * @Description:
 */
public class ProxyJob2 implements Job {

    @Override
    public void  execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("获取代理ip");
        String url="https://h.wandouip.com/get/ip-list?pack=894&num=20&xy=1&type=2&lb="+ URLEncoder.encode("\\r\\n")+"&mr=2&";
        String ipStr = PageDownLoadUtil.httpClientDefultGet(url);
        long nowTime = System.currentTimeMillis();
        try {
            JSONObject object = JSON.parseObject(ipStr);
            if(object.getInteger("code")==200){
                JSONArray data = object.getJSONArray("data");
                if(data!=null && data.size()!=0){
                    for (int i = 0; i < data.size(); i++) {
                        JSONObject jsonObject = data.getJSONObject(i);
                        String ip = jsonObject.getString("ip");
                        Integer port = jsonObject.getInteger("port");
                        String expireTime = jsonObject.getString("expire_time");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date parseTime = simpleDateFormat.parse(expireTime);
                        long time = parseTime.getTime();
                        Long expire=(time - nowTime)/1000;
                        int ex = expire.intValue();
                        if(ex > 0){
                            System.out.println(ip+":"+port+"---"+ex);
                            RedisUtil.setex("PROXY_IP_REDIS_KEY"+ip+":"+port,ex,"1");
                        }

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
