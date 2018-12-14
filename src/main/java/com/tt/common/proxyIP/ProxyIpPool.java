package com.tt.common.proxyIP;

import com.tt.common.utils.PageDownLoadUtil;
import com.tt.service.impl.JedisClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 获取代理ip，放入IP池
 * @Auther: 赵乐
 * @Date: 2018/10/26 10:45
 * @Description:
 */

@Component
public class ProxyIpPool {

    @Autowired
    private JedisClientServiceImpl jedisClientService;

    @Value("${proxy.ip.url}")
    private String PROXYURL;

    /**
     *
     * 功能描述: 写入ip池ip
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/26 10:49
     */
    //@Scheduled(fixedRate=2000)
    public void getIpToPool() {
        String url=PROXYURL;
        String ipStr = PageDownLoadUtil.httpClientDefultGet(url);
        try {
            String[] split = ipStr.split(",");
            if(split.length==2){
                String ip1=split[0];
                String ip2=split[1];
                System.out.println(ip1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
