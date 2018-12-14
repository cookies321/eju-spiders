package qfang;

import com.sun.jndi.cosnaming.IiopUrl;
import com.tt.common.DownLoadPage;
import com.tt.dao.QFangLoudongMapper;
import com.tt.dao.QFangXiaoquMapper;
import com.tt.dao.QFangXiaoquZhaoleMapper;
import com.tt.entity.QFangXiaoquExample;
import com.tt.entity.QFangXiaoquZhaole;
import com.tt.entity.QFangXiaoquZhaoleExample;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/12 19:00
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class LoudongBuChong {
    @Autowired
    private QFangXiaoquZhaoleMapper qFangXiaoquZhaoleMapper;

    @Test
    public void buchongAddress() throws InterruptedException {
        QFangXiaoquZhaoleExample qFangXiaoquZhaoleExample = new QFangXiaoquZhaoleExample();
        QFangXiaoquZhaoleExample.Criteria criteria = qFangXiaoquZhaoleExample.createCriteria();
        criteria.andAddressIsNull();
        Semaphore semaphore = new Semaphore(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<QFangXiaoquZhaole> qFangXiaoquZhaoles = qFangXiaoquZhaoleMapper.selectByExample(qFangXiaoquZhaoleExample);
        if(qFangXiaoquZhaoles!=null && qFangXiaoquZhaoles.size()!=0){
            for (QFangXiaoquZhaole qFangXiaoquZhaole : qFangXiaoquZhaoles) {

                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String detailUrl = qFangXiaoquZhaole.getDetailUrl();
                            if(StringUtils.isNotBlank(detailUrl)){
                                try {
                                    Document document = DownLoadPage.downLoadPage(detailUrl);
                                    Elements select = document.select("div.garden-address.house-address-wrapper");
                                    if(!select.isEmpty()){
                                        String text = select.text();
                                        System.out.println(text);
                                        if(StringUtils.isNotBlank(text)){
                                            qFangXiaoquZhaole.setAddress(text);
                                            //更新
                                            qFangXiaoquZhaoleMapper.updateByPrimaryKeySelective(qFangXiaoquZhaole);
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
            }
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }


}
