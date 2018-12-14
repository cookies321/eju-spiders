package com.tt.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.Constants;
import com.tt.vo.ProxyVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.tt.common.utils.RandomUtil.RandomChoiceUserAgents;

/**
 * @author NJ
 * @create 2018-08-03 10:31
 **/
public class ProxyUtils {

    private ProxyUtils(){
    }

    /**
     *
     * 功能描述: 获取蘑菇代理
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/6 15:41
     */
    public static HttpHost getMouGuProxy(){
        HttpHost proxy = new HttpHost("transfer.mogumiao.com", 9001);
        return proxy;
    }

    /**
     *
     * 功能描述: 获取代理池ip
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/6 15:46
     */
    public static HttpHost getIPoolProxy(){
        HttpHost proxy = null;
        Set<String> proxy_ip_redis_key = RedisUtil.keys("PROXY_IP_REDIS_KEY");
        if(proxy_ip_redis_key.size()==0){
            System.out.println("获取代理失败");
            return proxy;
        }
        List<String> list = new ArrayList<>(proxy_ip_redis_key);
        if(list!=null && list.size()!=0){
            String ipStr= list.get(new Random().nextInt(list.size()));
            if (StringUtils.isNotBlank(ipStr)) {
                try {
                    String[] split = ipStr.replace("PROXY_IP_REDIS_KEY", "").replace("\r", "").split(":");
                    String ip = split[0];
                    String portStr = split[1];

                    if (StringUtils.isNotBlank(ip) && StringUtils.isNotBlank(portStr)) {
                        Integer port = Integer.parseInt(portStr);
                        proxy = new HttpHost(ip, port);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

        }
        return proxy;
    }
}
