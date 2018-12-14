package fang.xinfang;

import com.tt.common.DownLoadPage;
import com.tt.dao.FangXfLoupangBuildingMapper;
import com.tt.dao.FangXfLoupangBuildinglayoutMapper;
import com.tt.dao.FangXfLoupangLayoutMapper;
import com.tt.entity.FangXfLoupangBuildingExample;
import com.tt.entity.FangXfLoupangBuildinglayout;
import com.tt.entity.FangXfLoupangBuildinglayoutExample;
import com.tt.entity.FangXfLoupangLayout;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
 *
 * 获取楼栋户型表中户型的url，解析户型的数据
 * @Auther: 赵乐
 * @Date: 2018/11/1 14:09
 * @Description:
 */
public class ParseHuxing {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        FangXfLoupangBuildinglayoutMapper fangXfLoupangBuildinglayoutMapper=(FangXfLoupangBuildinglayoutMapper)applicationContext.getBean("fangXfLoupangBuildinglayoutMapper");
        FangXfLoupangLayoutMapper fangXfLoupangLayoutMapper=(FangXfLoupangLayoutMapper)applicationContext.getBean("fangXfLoupangLayoutMapper");

        FangXfLoupangBuildinglayoutExample fangXfLoupangBuildinglayoutExample = new FangXfLoupangBuildinglayoutExample();
        FangXfLoupangBuildinglayoutExample.Criteria criteria = fangXfLoupangBuildinglayoutExample.createCriteria();
        criteria.andStatusIsNull();
        List<FangXfLoupangBuildinglayout> fangXfLoupangBuildinglayouts = fangXfLoupangBuildinglayoutMapper.selectByExample(fangXfLoupangBuildinglayoutExample);

        System.out.println(fangXfLoupangBuildinglayouts.size());
        Integer num =4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        if(fangXfLoupangBuildinglayouts!=null && fangXfLoupangBuildinglayouts.size()!=0){

            for (FangXfLoupangBuildinglayout fangXfLoupangBuildinglayout : fangXfLoupangBuildinglayouts) {

                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            FangXfLoupangLayout fangXfLoupangLayout = new FangXfLoupangLayout();
                            fangXfLoupangLayout.setId(UUID.randomUUID().toString());
                            fangXfLoupangLayout.setCreatetime(new Date());
                            fangXfLoupangLayout.setBatchId("v1.0");

                            //户型的url
                            String huxingUrl = fangXfLoupangBuildinglayout.getHuxingUrl();

                            String title = fangXfLoupangBuildinglayout.getTitle();
                            String detailPc = fangXfLoupangBuildinglayout.getDetailPc();

                            fangXfLoupangLayout.setTitle(title);
                            fangXfLoupangLayout.setDetailPc(detailPc);
                            fangXfLoupangLayout.setHuxingUrl(huxingUrl);

                            if(!huxingUrl.contains("http")){
                                String substring = detailPc.substring(0, detailPc.indexOf("/house/"));
                                huxingUrl=substring+huxingUrl;
                            }
                            Document document = DownLoadPage.downLoadPage(huxingUrl,"gbk");
                            parseLoupangLayout(document,fangXfLoupangLayout);

                            //插入数据
                            if(StringUtils.isNotBlank(fangXfLoupangLayout.getHuxingId())){
                                int insert = fangXfLoupangLayoutMapper.insert(fangXfLoupangLayout);
                                //更新操作
                                if(insert==1){
                                    fangXfLoupangBuildinglayout.setStatus("1");
                                    fangXfLoupangBuildinglayoutMapper.updateByPrimaryKeySelective(fangXfLoupangBuildinglayout);
                                }
                            }else{
                                fangXfLoupangBuildinglayout.setStatus("0");
                                fangXfLoupangBuildinglayoutMapper.updateByPrimaryKeySelective(fangXfLoupangBuildinglayout);
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
        System.out.println("任务结束======");
        /*String huxingUrl="http://donglinfurc.fang.com/photo/d_house_199631499.htm";
        Document document = DownLoadPage.downLoadPage(huxingUrl,"gbk");
        parseLoupangLayout(document,new FangXfLoupangLayout());*/

    }
    /**
     *
     * 功能描述: 解析户型信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/1 15:27
     */
    private static void parseLoupangLayout(Document document, FangXfLoupangLayout fangXfLoupangLayout) {
        if(document!=null){
            //户型的name
            Elements selecthuxingId = document.select("strong#hxName");
            if(!selecthuxingId.isEmpty()){
                String huxingId = selecthuxingId.text();
                System.out.println(huxingId);
                fangXfLoupangLayout.setHuxingId(huxingId);
            }
            //户型的其他信息
            //居室的类型
            Elements select = document.select("span#jushi");
            if(!select.isEmpty()){
                String text = select.text();
                System.out.println(text);
                fangXfLoupangLayout.setHuxingName(text);
            }
            //建筑mainji 
            Elements selectMianji = document.select("span#mianji_j");
            if(!selectMianji.isEmpty()){
                String text = selectMianji.text();
                System.out.println(text);
                fangXfLoupangLayout.setCurrentArea(text);
            }
            //套内面积
            Elements selectMianji_t = document.select("span#mianji_t");
            if(!selectMianji_t.isEmpty()){
                String text = selectMianji_t.text();
                System.out.println(text);
                fangXfLoupangLayout.setSharesArea(text);
            }
            //均价
            Elements selectJunjia = document.select("div#junjia>span");
            if(!selectJunjia.isEmpty()){
                String text = selectJunjia.text();
                System.out.println(text);
                fangXfLoupangLayout.setAveprice(text);
            }
            //总价
            Elements selectB = document.select("span#zongjia>b");
            if(!selectB.isEmpty()){
                String text = selectB.text();
                System.out.println(text);
                fangXfLoupangLayout.setTotalprice(text);
            }
            //标签
            Elements selectBiaoqian = document.select("div#biaoqian>div>a");
            if(!selectBiaoqian.isEmpty()){
                String text = selectBiaoqian.text();
                System.out.println(text);
                fangXfLoupangLayout.setTag(text);
            }
            //分布
            Elements selectFenbu = document.select("p#fenbu");
            if(!selectFenbu.isEmpty()){
                String text = selectFenbu.text();
                System.out.println(text);
                fangXfLoupangLayout.setBuildingDist(text);
            }
            //评分
            Elements selectHxpingfen = document.select("span#hxpingfen");
            if(!selectHxpingfen.isEmpty()){
                String text = selectHxpingfen.text();
                System.out.println(text);
                fangXfLoupangLayout.setScore(text);
            }
            //户型解析
            Elements selectP = document.select("div#jiexi>p");
            if(!selectP.isEmpty()){
                String text = selectP.attr("title");
                System.out.println(text);
                fangXfLoupangLayout.setDescription(text);
            }
            //户型图
            Elements selectImg = document.select("div#huxinxq_E04_04>a>img");
            if(!selectImg.isEmpty()){
                String src = selectImg.attr("src");
                fangXfLoupangLayout.setFrameImage(src);
                System.out.println(src);
            }

        }
    }

}
