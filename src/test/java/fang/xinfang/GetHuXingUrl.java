package fang.xinfang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tt.dao.FangXfLoupangBuildingMapper;
import com.tt.dao.FangXfLoupangBuildinglayoutMapper;
import com.tt.entity.FangXfLoupangBuilding;
import com.tt.entity.FangXfLoupangBuildingExample;
import com.tt.entity.FangXfLoupangBuildinglayout;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 根据楼栋数据，获取户型数据
 * @Auther: 赵乐
 * @Date: 2018/11/1 11:39
 * @Description:
 */
public class GetHuXingUrl {

    static Integer count=0;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        FangXfLoupangBuildingMapper fangXfLoupangBuildingMapper = (FangXfLoupangBuildingMapper)applicationContext.getBean("fangXfLoupangBuildingMapper");
        FangXfLoupangBuildinglayoutMapper fangXfLoupangBuildinglayoutMapper=(FangXfLoupangBuildinglayoutMapper)applicationContext.getBean("fangXfLoupangBuildinglayoutMapper");

        FangXfLoupangBuildingExample fangXfLoupangBuildingExample = new FangXfLoupangBuildingExample();
        FangXfLoupangBuildingExample.Criteria criteria = fangXfLoupangBuildingExample.createCriteria();
        criteria.andLayoutNotEqualTo("[]");
        List<FangXfLoupangBuilding> fangXfLoupangBuildings = fangXfLoupangBuildingMapper.selectByExampleWithBLOBs(fangXfLoupangBuildingExample);
        System.out.println(fangXfLoupangBuildings.size());
        Thread.sleep(3000);
        Integer num =3;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        if(fangXfLoupangBuildings!=null && fangXfLoupangBuildings.size()!=0){
            for (FangXfLoupangBuilding fangXfLoupangBuilding : fangXfLoupangBuildings) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //楼盘的名称
                            String title = fangXfLoupangBuilding.getTitle();
                            //详情url
                            String detailPc = fangXfLoupangBuilding.getDetailPc();

                            //主键id
                            String buildingId = fangXfLoupangBuilding.getId();
                            //楼栋的名称
                            String building = fangXfLoupangBuilding.getBuilding();
                            //期数
                            String period = fangXfLoupangBuilding.getPeriod();
                            String layout = fangXfLoupangBuilding.getLayout();
                            if(StringUtils.isNotBlank(layout)){
                                JSONArray objects = JSON.parseArray(layout);
                                for (Object object : objects) {
                                    FangXfLoupangBuildinglayout fangXfLoupangBuildinglayout = new FangXfLoupangBuildinglayout();

                                    String url=(String)object;
                                    fangXfLoupangBuildinglayout.setId(UUID.randomUUID().toString());
                                    fangXfLoupangBuildinglayout.setCreatetime(new Date());
                                    fangXfLoupangBuildinglayout.setBatchId("v1.0");
                                    fangXfLoupangBuildinglayout.setDetailPc(detailPc);
                                    fangXfLoupangBuildinglayout.setTitle(title);
                                    fangXfLoupangBuildinglayout.setBuilding(building);
                                    fangXfLoupangBuildinglayout.setBuildingId(buildingId);
                                    fangXfLoupangBuildinglayout.setPeriod(period);
                                    fangXfLoupangBuildinglayout.setHuxingUrl(url);
                                    //fangXfLoupangBuildinglayoutMapper.insert(fangXfLoupangBuildinglayout);
                                    synchronized (fangXfLoupangBuildinglayout){
                                        System.out.println(Thread.currentThread().getName()+":"+(++count));
                                    }
                                }

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
        // 等待子线程结束，再继续执行下面的代码
        try {
            while ( !executorService.awaitTermination(1, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        System.out.println("任务结束======");
    }


}
