package proxyIP;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 获取代理ip，放入IP池
 * @Auther: 赵乐
 * @Date: 2018/10/26 10:45
 * @Description:
 */

public class ProxyIpPool {

    public static void main(String[] args) throws Exception {
        // 获取默认调度器
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.start();
        /********************添加代理IP筛选任务*******************/
        JobDetail proxyJob = new JobDetail("proxyJob", Scheduler.DEFAULT_GROUP, ProxyJob3.class);// 20 1/1 * * * ?
        CronTrigger proxyTrigger = new CronTrigger("ProxyJob", Scheduler.DEFAULT_GROUP, "0 0/2 * * * ?");
        defaultScheduler.scheduleJob(proxyJob, proxyTrigger);
        /********************添加代理IP筛选任务*******************/
    }
}
