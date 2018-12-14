package Government;

import com.tt.common.utils.UserAgentUtils;
import com.tt.dao.CommunityFdHzHouseMapper;
import com.tt.dao.CommunityFdHzListMapper;
import com.tt.entity.CommunityFdHzHouse;
import com.tt.entity.CommunityFdHzList;
import com.tt.entity.CommunityFdHzListExample;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 赵乐
 *
 * 解析杭州
 * @Date: 2018/12/3 15:33
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ParseHZHouse {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private CommunityFdHzListMapper communityFdHzListMapper;

    @Autowired
    private CommunityFdHzHouseMapper communityFdHzHouseMapper;




    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/6 17:06
     */
    @Test
    public void parseDetail() throws InterruptedException {
        CommunityFdHzListExample communityFdHzListExample = new CommunityFdHzListExample();
        communityFdHzListExample.or().andStatusIsNull();
        List<CommunityFdHzList> communityFdHzLists = communityFdHzListMapper.selectByExample(communityFdHzListExample);
        System.out.println(communityFdHzLists.size());
        Integer num=6;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdHzList communityFdHzList : communityFdHzLists) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String detailUrl = communityFdHzList.getDetailUrl();
                        if(StringUtils.isNotBlank(detailUrl)){
                            Map<String,String> map=new HashMap<>();
                            map.put("User-Agent", UserAgentUtils.randomGet());
                            Document document = iDownLoadPage.downLoadPageByGet(detailUrl, map);

                            String company=null;
                            String text =null;
                            if(document!=null){
                                Element select2 = document.select("div.entry-content>p").first();
                                if(select2!=null){
                                    text=select2.text();
                                }else{
                                    text=document.select("div.entry-content>table>caption").text();
                                }
                                if(StringUtils.isNotBlank(text)){
                                    String[] split = text.split("      ");
                                    if(split.length>0){
                                        company = split[0];
                                    }
                                }
                                System.out.println(company);

                                Elements select = document.select("table>tbody>tr");
                                if(!select.isEmpty() && select.size()>1){
                                    Elements elements = select.get(0).select("td");
                                    Map<String, Integer> mapTitle = new HashMap<>();
                                    for (int i=1;i<elements.size();i++) {
                                        String title = elements.get(i).text();
                                        switch (title){
                                            case "幢号":
                                                mapTitle.put("building",i);
                                                break;
                                            case "单元":
                                                mapTitle.put("unitNum",i);
                                                break;
                                            case "室号":
                                                mapTitle.put("houseNum",i);
                                                break;
                                            case "房屋层高":
                                                mapTitle.put("houseHight",i);
                                                break;
                                            case "户型":
                                                mapTitle.put("layout",i);
                                                break;
                                            case "建筑面积":
                                                mapTitle.put("predictedArea",i);
                                                break;
                                            case "套内建筑面积":
                                                mapTitle.put("dwellingFloorSpace",i);
                                                break;
                                            case "公摊建筑面积":
                                                mapTitle.put("sharedBuildingArea",i);
                                                break;
                                            case "毛坯单价":
                                                mapTitle.put("maoPiPrice",i);
                                                break;
                                            case "装修单价":
                                                mapTitle.put("renovationPrice",i);
                                                break;
                                            case "销售单价":
                                                mapTitle.put("price",i);
                                                break;
                                            case "房屋总价":
                                                mapTitle.put("totalPrice",i);
                                                break;
                                            default:
                                                break;
                                        }
                                    }


                                    for (int i = 1; i < select.size(); i++) {
                                        Elements select1 = select.get(i).select("td");
                                        if(!select1.isEmpty()){
                                            CommunityFdHzHouse communityFdHzHouse = new CommunityFdHzHouse();
                                            communityFdHzHouse.setId(UUID.randomUUID().toString());
                                            communityFdHzHouse.setDetailUrl(detailUrl);
                                            communityFdHzHouse.setBatchId("v1.0");
                                            communityFdHzHouse.setCreateTime(new Date());

                                            //楼栋
                                            Integer integer1 = mapTitle.get("building");
                                            if(integer1!=null){
                                                String building = select1.get(integer1).text();
                                                communityFdHzHouse.setBuilding(building);
                                            }
                                            //单元
                                            Integer integer2 = mapTitle.get("unitNum");
                                            if(integer2!=null){
                                                String unitNum = select1.get(integer2).text();
                                                communityFdHzHouse.setUnitNum(unitNum);
                                            }
                                            //房号
                                            Integer integer3 = mapTitle.get("houseNum");
                                            if(integer3!=null){
                                                String houseNum = select1.get(integer3).text();
                                                communityFdHzHouse.setHouseName(houseNum);
                                            }
                                            //房屋高度
                                            Integer integer4 = mapTitle.get("houseHight");
                                            if(integer4!=null){
                                                String houseHight = select1.get(integer4).text();
                                                communityFdHzHouse.setRealFloor(houseHight);
                                            }
                                            //户型
                                            Integer integer5 = mapTitle.get("layout");
                                            if(integer5!=null){
                                                String layout = select1.get(integer5).text();
                                                communityFdHzHouse.setLayout(layout);
                                            }

                                            Integer integer6 = mapTitle.get("predictedArea");
                                            if(integer6!=null){
                                                //建筑面积
                                                String predictedArea = select1.get(integer6).text();
                                                communityFdHzHouse.setPredictedArea(predictedArea);
                                            }
                                            //套内面积
                                            Integer integer7 = mapTitle.get("dwellingFloorSpace");
                                            if(integer7!=null){
                                                String dwellingFloorSpace = select1.get(integer7).text();
                                                communityFdHzHouse.setDwellingFloorSpace(dwellingFloorSpace);
                                            }

                                            //公摊面积
                                            Integer integer8 = mapTitle.get("sharedBuildingArea");
                                            if(integer8!=null){
                                                String sharedBuildingArea = select1.get(integer8).text();
                                                communityFdHzHouse.setSharedBuildingArea(sharedBuildingArea);
                                            }

                                            //公司
                                            communityFdHzHouse.setPropertyCompany(company);

                                            //毛坯单价
                                            Integer integer9 = mapTitle.get("maoPiPrice");
                                            if(integer9!=null){
                                                String maoPiPrice = select1.get(integer9).text();
                                                communityFdHzHouse.setMaopiPrice(maoPiPrice);
                                            }
                                            //装修单价
                                            Integer integer10 = mapTitle.get("renovationPrice");
                                            if(integer10!=null){
                                                String renovationPrice = select1.get(integer10).text();
                                                communityFdHzHouse.setRenovationPrice(renovationPrice);
                                            }
                                            //销售价格
                                            Integer integer11 = mapTitle.get("price");
                                            if(integer11!=null){
                                                String price = select1.get(integer11).text();
                                                communityFdHzHouse.setSalePrice(price);
                                            }
                                            //总价
                                            Integer integer12 = mapTitle.get("totalPrice");
                                            if(integer12!=null && integer12 < select1.size()){
                                                String totalPrice = select1.get(integer12).text();
                                                communityFdHzHouse.setTotalPrice(totalPrice);
                                            }
                                            int i1 = communityFdHzHouseMapper.insertSelective(communityFdHzHouse);
                                            if(i1==1){
                                                communityFdHzList.setStatus("1");
                                                communityFdHzListMapper.updateByPrimaryKeySelective(communityFdHzList);
                                            }


                                        }
                                    }
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
        executorService.shutdown();
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");
    }


    /**
     *
     * 功能描述: 
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/5 18:06
     */
    @Test
    public void parseIndex() throws InterruptedException {
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (int i = 1; i < 147; i++) {
            semaphore.acquire();
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String indexUrl="http://www.hzjg.gov.cn/cat/xxgk/gzxx/zxgz/sqspzfxsjggs/page/"+ finalI;
                        Map<String,String> map=new HashMap<>();
                        map.put("User-Agent", UserAgentUtils.randomGet());
                        Document document = iDownLoadPage.downLoadPageByGet(indexUrl,map);
                        if(document!=null){
                            Elements select = document.select("main.content.av-content-small.alpha.units>article>div>header>h2>a");
                            if(!select.isEmpty()){
                                for (Element element : select) {
                                    String title = element.text();
                                    String detailHref = element.attr("href");
                                    System.out.println(detailHref+title);
                                    CommunityFdHzList communityFdHzList = new CommunityFdHzList();
                                    communityFdHzList.setId(UUID.randomUUID().toString());
                                    communityFdHzList.setBatchId("v1.0");
                                    communityFdHzList.setCreateTime(new Date());
                                    communityFdHzList.setPageNum(finalI +"");
                                    communityFdHzList.setDetailUrl(detailHref);
                                    communityFdHzList.setTitle(title);
                                    communityFdHzListMapper.insertSelective(communityFdHzList);
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
        executorService.shutdown();
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

    @Test
    public void test(){
        Map<String,String> map=new HashMap<>();
        map.put("User-Agent", UserAgentUtils.randomGet());
        map.put("Cookie","BSFIT_DEVICEID=bQGs8xWtJVBlQibZlCwp84GeWRXGajGs7Cv6kwTFzfZVVbD-k8COBKGo8QeR_Lj-HLXYzBEpy8ZzAdRjKGgh0aQBnD-6gdsfRnkj3c-GKrK5NFds3nsJFwFIAPsbBOmm5GyEAeAaETWQM_nNy5itBMVUXhZc7_Ay");
        Document document = iDownLoadPage.downLoadPageByGet("http://www.tmsf.com/newhouse/property_searchall.htm?sid=33&districtid=330104&areaid=&dealprice=&propertytype=&bbs=&keyword=",map);
        System.out.println(document);

    }
}
