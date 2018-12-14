package fang.xinfang;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.xsom.ForeignAttributes;
import com.tt.common.DownLoadPage;
import com.tt.dao.FangXfLoupangBuildingMapper;
import com.tt.dao.FangXfLoupangListMapper;
import com.tt.entity.FangXfLoupangBuilding;
import com.tt.entity.FangXfLoupangList;
import com.tt.entity.FangXfLoupangListExample;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 * @Date: 2018/10/30 18:31
 * @Description:
 */
public class ParseLoudong {
    //http://huanqiuhuitianyu.fang.com/?ctm=1.cd.xf_search.lplist.6
    //http://178186.fang.com/?ctm=1.nanjing.xf_search.lplist.14
    //http://183040.fang.com/
    //http://guanxitairc.fang.com/?ctm=1.cd.xf_search.lplist.2
    //http://d10tianfuxxw.fang.com/?ctm=1.cd.xf_search.lplist.1

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        FangXfLoupangListMapper fangXfLoupangListMapper = (FangXfLoupangListMapper)applicationContext.getBean("fangXfLoupangListMapper");
        FangXfLoupangBuildingMapper fangXfLoupangBuildingMapper = (FangXfLoupangBuildingMapper)applicationContext.getBean("fangXfLoupangBuildingMapper");

        FangXfLoupangListExample fangXfLoupangListExample = new FangXfLoupangListExample();
        FangXfLoupangListExample.Criteria criteria = fangXfLoupangListExample.createCriteria();
        criteria.andStatusIsNull();
        List<FangXfLoupangList> fangXfLoupangLists = fangXfLoupangListMapper.selectByExample(fangXfLoupangListExample);
        System.out.println(fangXfLoupangLists.size());
        Integer num=6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        if(fangXfLoupangLists!=null && fangXfLoupangLists.size()!=0){
            for (FangXfLoupangList fangXfLoupangList : fangXfLoupangLists) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //url
                            String detailPc = fangXfLoupangList.getDetailPc();
                            System.out.println("开始获取"+"---"+detailPc);
                            //楼盘名称
                            String title = fangXfLoupangList.getTitle();
                            System.out.println("楼盘"+title);
                            Document documentIndex = DownLoadPage.downLoadPage(detailPc);
                            List<FangXfLoupangBuilding> fangXfLoupangBuildings = parseIndex(documentIndex);

                            for (FangXfLoupangBuilding fangXfLoupangBuilding : fangXfLoupangBuildings) {
                                fangXfLoupangBuilding.setTitle(title);
                                fangXfLoupangBuilding.setDetailPc(detailPc);
                                fangXfLoupangBuildingMapper.insert(fangXfLoupangBuilding);
                            }

                            fangXfLoupangList.setStatus("1");
                            fangXfLoupangListMapper.updateByPrimaryKeySelective(fangXfLoupangList);

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
        while (executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("运行结束======");
       /* String url="http://d10tianfuxxw.fang.com/?ctm=1.cd.xf_search.lplist.1";
        Document documentIndex = DownLoadPage.downLoadPage(url);
        parseIndex(documentIndex);*/
    }
    
    /**
     *
     * 功能描述: 
     *
     * @param: 解析主页中的楼栋信息
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/30 18:59
     */
    private static List<FangXfLoupangBuilding> parseIndex(Document documentIndex) {
        List<FangXfLoupangBuilding> list =new ArrayList<>();

        if(documentIndex!=null){
            //期数
            Elements select = documentIndex.select("div#xfptxq_B09_01_04>div.tou>div.dong_lunbo_spt");
            if(!select.isEmpty()){
                int i=1;
                for (Element element : select) {
                    //第几期
                    String period=i+"期";
                    System.out.println(period);
                    Elements selectLoudongs = element.select("span");
                    //获取楼栋信息
                    if(!selectLoudongs.isEmpty()){
                        for (Element elementLoudong : selectLoudongs) {
                            try {
                                FangXfLoupangBuilding fangXfLoupangBuilding = new FangXfLoupangBuilding();
                                fangXfLoupangBuilding.setId(UUID.randomUUID().toString());
                                fangXfLoupangBuilding.setCreatetime(new Date());
                                fangXfLoupangBuilding.setBatchId("v1.0");

                                String building = elementLoudong.text();
                                String className = elementLoudong.className();
                                if(className.contains("on")){
                                    className=className.replace(" on","");
                                }
                                fangXfLoupangBuilding.setBuilding(building);
                                fangXfLoupangBuilding.setPeriod(period);
                                System.out.println(building);

                                //获取栋楼信息
                                Elements select1 = documentIndex.select("div#xfptxq_B09_01_04>div.dongInfo>div.xinxi."+className);
                                Elements select2 = select1.select("ul.xn>li");
                                if(!select2.isEmpty()){
                                    for (Element element1 : select2) {
                                        Elements selectKey = element1.select("span");
                                        String tag = selectKey.text();
                                        String val = element1.ownText().replace("：","");
                                        switch (tag){
                                            case "单元":
                                                fangXfLoupangBuilding.setUnitNum(val);
                                                break;
                                            case "电梯数":
                                                fangXfLoupangBuilding.setElevator(val);
                                                break;
                                            case "建筑类型":
                                                fangXfLoupangBuilding.setBuildType(val);
                                                break;
                                            case "楼层":
                                                fangXfLoupangBuilding.setFrameNum(val);
                                                break;
                                            case "户数":
                                                fangXfLoupangBuilding.setHomeTotal(val);
                                                break;
                                            case "在售房源":
                                                fangXfLoupangBuilding.setChushouNum(val);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                //户型信息
                                List<String> listHu=new ArrayList<>();
                                Elements selectHu = select1.select("div.hx>ul>li>a");
                                if(!selectHu.isEmpty()){
                                    for (Element element1 : selectHu) {
                                        String hrefHu = element1.attr("href");
                                        listHu.add(hrefHu);
                                    }
                                }
                                System.out.println("添加户型的url");
                                String jsonString = JSON.toJSONString(listHu);
                                fangXfLoupangBuilding.setLayout(jsonString);

                                if(StringUtils.isNotBlank(fangXfLoupangBuilding.getBuilding())){
                                    list.add(fangXfLoupangBuilding);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    i++;
                }
            }
        }else {
            System.out.println("没有楼栋信息");
        }
        return list;
    }

}
