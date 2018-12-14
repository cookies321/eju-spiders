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
        String url="http://1752203729.v4.dailiyun.com/query.txt?key=NPD64FFEAC&word=%E6%B1%9F%E8%8B%8F&c%E6%B1%9F%E8%8B%8F&count=35&rand=false&detail=false";
        String ipStr = PageDownLoadUtil.httpClientDefultGet(url);
        System.out.println(ipStr);
        try {
            //String[] split = ipStr.split(",");
            String[] split=ipStr.split("\n");
            if(split.length!=0){
                for (String fristIp : split) {
                    if(StringUtils.isNotBlank(fristIp)){
                        RedisUtil.setex("PROXY_IP_REDIS_KEY"+fristIp,115,"1");
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
