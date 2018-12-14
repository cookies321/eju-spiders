package anjuke.jdj;

import com.tt.common.DownLoadPage;
import com.tt.dao.AnjukeBrokerListMapper;
import com.tt.entity.AnjukeBrokerList;
import com.tt.service.AnjukeCommunityService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * 爬取安居客经纪人房源信息
 * @Auther: 赵乐
 * @Date: 2018/10/24 17:53
 * @Description:
 */
public class ParseAngent {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        final AnjukeBrokerListMapper anjukeBrokerListMapper = (AnjukeBrokerListMapper)applicationContext.getBean("anjukeBrokerListMapper");


        String url="https://shanghai.anjuke.com/tycoon/?from=navigation";
        String city="上海";
        Document document = DownLoadPage.downLoadPage(url);
        //解析主页链接，获取区域链接
        if(document!=null){
            List<Map<String, String>> mapRegion = parseIndex(document);
            if(mapRegion!=null && mapRegion.size()!=0){
                //获取区域链接
                for (Map<String, String> map : mapRegion) {
                    String region = map.get("region");
                    String regionHref = map.get("regionHref");
                    System.out.println(region+"---"+regionHref);
                    //解析区域链接
                    if(StringUtils.isNotBlank(region) && StringUtils.isNotBlank(regionHref)){
                        Document documentRegion = DownLoadPage.downLoadPage(regionHref);
                        List<Map<String, String>> mapPlat = parseRegion(documentRegion);
                        //获取板块链接
                        if(mapPlat!=null && mapPlat.size()!=0){
                            for (Map<String, String> stringStringMap : mapPlat) {
                                List<AnjukeBrokerList> anjukeBrokerLists = new ArrayList<>();
                                String plate = stringStringMap.get("plate");
                                String platHref = stringStringMap.get("platHref");
                                System.out.println(plate+"===="+platHref);
                                //解析板块链接
                                Document documentPlat = DownLoadPage.downLoadPage(platHref);
                                List<AnjukeBrokerList> anjukeBrokerListsNew = parsePlat(documentPlat, anjukeBrokerLists);
                                for (AnjukeBrokerList anjukeBrokerList : anjukeBrokerListsNew) {
                                    anjukeBrokerList.setCity(city);
                                    anjukeBrokerList.setRegion(region);
                                    anjukeBrokerList.setPlate(plate);
                                    anjukeBrokerListMapper.insert(anjukeBrokerList);
                                }

                            }

                        }
                    }
                }
            }

        }
        /*String regionHref="https://shanghai.anjuke.com/tycoon/putuo/";
        Document documentRegion = DownLoadPage.downLoadPage(regionHref);
        List<Map<String, String>> mapPlat = parseRegion(documentRegion);
        for (Map<String, String> map : mapPlat) {
            String platHref = map.get("platHref");
            System.out.println(platHref);
        }*/
        /*List<AnjukeBrokerList> anjukeBrokerLists = new ArrayList<>();
        //https://shanghai.anjuke.com/tycoon/lujiazui/
        String regionHref="https://shanghai.anjuke.com/tycoon/cixic/";
        Document documentPlat = DownLoadPage.downLoadPage(regionHref);
        List<AnjukeBrokerList> anjukeBrokerLists1 = parsePlat(documentPlat, anjukeBrokerLists);
        System.out.println(anjukeBrokerLists1.size()+"===========");*/
    }
    /**
     *
     * 功能描述: 解析板块链接，获取分页链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/24 18:37
     */
    private static List<AnjukeBrokerList> parsePlat(Document documentPlat,List<AnjukeBrokerList> list) {
        if(documentPlat!=null){

            //获取当前页的列表的详情链接
            Elements select = documentPlat.select("div#list-content>div.jjr-itemmod");
            if(select!=null){
                for (Element element : select) {
                    AnjukeBrokerList anjukeBrokerList = new AnjukeBrokerList();
                    anjukeBrokerList.setId(UUID.randomUUID().toString());
                    anjukeBrokerList.setBatchId("v1.0");
                    anjukeBrokerList.setCeatetime(new Date());
                    Elements selectImg = element.select("a.img>img");
                    if(selectImg!=null){
                        //经纪人头像
                        String brokerImage = selectImg.attr("src");
                        anjukeBrokerList.setBrokerImage(brokerImage);
                        System.out.println(brokerImage);
                    }
                    Elements selectA = element.select("div.jjr-info>div.jjr-title>h3>a");
                    if(selectA!=null){
                        //经纪人名称和链接
                        String title = selectA.text();
                        String href = selectA.attr("href");
                        anjukeBrokerList.setName(title);
                        anjukeBrokerList.setUrl(href);
                        //https://dulijingjiren11.anjuke.com/gongsi-jjr-648743/
                        String brokerId = href.substring(href.indexOf("/gongsi-jjr-") + 12, href.length() - 1);
                        anjukeBrokerList.setBrokerId(brokerId);
                        System.out.println(title+"----"+href+"----"+brokerId);
                    }
                    Element select1 = element.select("div.jjr-info>p.jjr-desc").first();
                    //获取公司和门店
                    if(select1!=null){
                        Elements select1A = select1.select("a");
                        if(select1A!=null && select1A.size()==2){
                            String company = select1A.get(0).text();
                            String store = select1A.get(1).text();
                            anjukeBrokerList.setCompany(company);
                            anjukeBrokerList.setStore(store);
                            System.out.println(company+"---"+store);
                        }else {
                            String company = select1A.text();
                            anjukeBrokerList.setCompany(company);
                            System.out.println(company+"---");
                        }
                    }
                    Elements select2 = element.select("div.jjr-info>p.jjr-desc.xq_tag>a");
                    if(select2!=null){
                        //主营小区
                        String community = select2.text();
                        anjukeBrokerList.setCommunity(community);
                        System.out.println("主营小区----"+community);
                    }
                    //标签
                    Elements selectTag = element.select("div>div.broker-tags.clearfix>span").not("span.pink-c");
                    if(selectTag!=null){
                        String tag = selectTag.text();
                        anjukeBrokerList.setTag(tag);
                        System.out.println("标签----"+tag);
                    }

                    list.add(anjukeBrokerList);

                }
            }
            //下一页链接
            Elements select3 = documentPlat.select("div.page-content>div.multi-page>a.aNxt");
            //递归循环爬去
            if(select3!=null && select3.size()!=0){
                String hrefNext = select3.attr("href");
                if(StringUtils.isNotBlank(hrefNext)){
                    System.out.println("分页链接================================================="+hrefNext);
                    documentPlat = DownLoadPage.downLoadPage(hrefNext);
                    parsePlat(documentPlat,list);
                }
            }else {
                System.out.println("最后一页");
            }

        }
        return list;
    }

    /**
     *
     * 功能描述: 解析区域链接，获取板块链接
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/24 18:17
     */
    private static List<Map<String,String>> parseRegion(Document documentRegion) {
        //存放区域下的细分种子链接
        List<Map<String,String>> listPlate= new ArrayList<>();

        if(documentRegion!=null){
            Elements selects = documentRegion.select("div.items.with-border>span.elems-l");
            if(selects!=null){
                Elements elements = selects.first().select("div.sub-items>a").not("a.selected-item");
                if(elements!=null){
                    for (Element element : elements) {
                        Map<String,String> map=new HashMap<>();

                        String plate = element.text();
                        String platHref = element.attr("href");
                        map.put("plate",plate);
                        map.put("platHref",platHref);
                        listPlate.add(map);
                    }
                }
            }
        }
        return listPlate;
    }

    /**
     *
     * 功能描述: 解析主页链接，获取区域链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/24 17:57
     */
    private static List<Map<String,String>> parseIndex(Document document) {
        //存放区域的种子链接
        List<Map<String,String>> listRegion= new ArrayList<>();
        if(document!=null){
            Elements elements = document.select("div.items.with-border>span.elems-l");
            if(elements!=null){
                Elements elementsA = elements.first().select("a").not("a.selected-item");
                if(elementsA!=null){
                    for (Element element : elementsA) {
                        Map<String,String> map=new HashMap<>();

                        String regionHref = element.attr("href");
                        String region = element.text();
                        map.put("region",region);
                        map.put("regionHref",regionHref);
                        listRegion.add(map);
                    }
                }
            }
        }
        return listRegion;
    }

}
