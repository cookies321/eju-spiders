package proxyIP;

import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/29 14:43
 * @Description:
 */
public class ProxyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("获取代理ip");
        String url="http://10.122.139.34:8087/get/ip-list/3?key=557F35CA07AE2470F80E5CFC710FE61E&degree=2&protocol=https";
        String ipStr = PageDownLoadUtil.httpClientDefultGet(url);
        System.out.println(ipStr);
        try {
            //String[] split = ipStr.split(",");
            String[] split=ipStr.split("\n");
            if(split.length!=0){
                for (String fristIp : split) {
                    if(StringUtils.isNotBlank(fristIp) && !("null".equals(fristIp))){
                        RedisUtil.setex("PROXY_IP_REDIS_KEY"+fristIp,60,"1");
                    }
                }
            }
            /*if(split.length==2){
                String fristIp=split[0];
                String secondIp=split[1];
                RedisUtil.setex("PROXY_IP_REDIS_KEY"+fristIp,55,"1");
                RedisUtil.setex("PROXY_IP_REDIS_KEY"+secondIp,55,"1");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
