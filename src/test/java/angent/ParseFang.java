package angent;

import com.tt.common.DownLoadPage;
import com.tt.common.utils.NumUtils;
import com.tt.entity.FangAgent;
import com.tt.service.FangAgentService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ParseFang {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        final FangAgentService fangAgentService = (FangAgentService)applicationContext.getBean("fangAgentServiceImpl");

        Integer threadNum=6;
        Semaphore semaphore = new Semaphore(threadNum);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNum);

        String url="http://sh.esf.fang.com/agenthome/-i31-j310/";
        final String city="上海";
        //下载主页页面信息
        Document document = DownLoadPage.downLoadPage(url);
        if(document!=null){
            //解析主页页面
            List<Map<String, Object>> regionMapList= parseIndexPage(document);
            //获取区域的种子链接
            if(regionMapList!=null && regionMapList.size()!=0){
                for (Map<String, Object> regionMap : regionMapList) {
                    String linkRegion =(String) regionMap.get("linkRegion");
                    final String region =(String) regionMap.get("region");
                    //http://sh.esf.fang.com//agenthome-a025/-i31-j310/
                    //下载、解析板块区域链接
                    Document documentRegion = DownLoadPage.downLoadPage(linkRegion);
                    if (documentRegion != null) {
                        List<Map<String, Object>> plateMapList = parseRegionPage(documentRegion);
                        //获取板块的种子链接
                        if(plateMapList!=null && plateMapList.size()!=0){
                            for (Map<String, Object> plateMap: plateMapList) {
                                final String linkPlate =(String) plateMap.get("linkPlate");
                                final String plate =(String) plateMap.get("plate");
                                //多线程爬去板块种子
                                /*executor.execute(new Runnable() {
                                    public void run() {*/
                                        try {
                                            //下载、解析板块板块种子链接
                                            //http://sh.esf.fang.com/agenthome-a025-b01646/-i31-j310/
                                            Document documentPlat = DownLoadPage.downLoadPage(linkPlate);
                                            if(documentPlat!=null){
                                                //解析版快种子链接,获取分页链接
                                                Integer totalNum = parsePlatPage(documentPlat);
                                                if(totalNum!=null && totalNum!=0){
                                                    //存储分页连接
                                                    List<String> listPageLink =new ArrayList<String>();
                                                    for (int i = 1; i <= totalNum; i++) {
                                                        String[] split = linkPlate.split("/-i31");
                                                        String pageHref=split[0]+"/-i3"+i+split[1];
                                                        System.out.println(i);
                                                        System.out.println(pageHref);
                                                        listPageLink.add(pageHref);
                                                    }
                                                    //解析分页连接
                                                    for (final String pageLink : listPageLink) {
                                                        //多线程爬去分页连接
                                                        semaphore.acquire();
                                                        executor.execute(new Runnable() {
                                                            public void run() {
                                                                try {
                                                                    //http://sh.esf.fang.com/agenthome-a025-b01646/-i3 1 -j310/
                                                                    Document documentPage = DownLoadPage.downLoadPage(pageLink);
                                                                    //解析分页链接获取列表的信息
                                                                    if(documentPage!=null){
                                                                        FangAgent fangAgent = new FangAgent();
                                                                        fangAgent.setId(UUID.randomUUID().toString());
                                                                        fangAgent.setCity(city);
                                                                        fangAgent.setRegion(region);
                                                                        fangAgent.setPlate(plate);
                                                                        List<FangAgent> fangAgents = parsePage(documentPage, fangAgent);
                                                                        for (FangAgent agent : fangAgents) {
                                                                            fangAgentService.insertFangAgent(agent);
                                                                        }
                                                                    }
                                                                } catch (Exception e) {
                                                                    e.printStackTrace();
                                                                }finally {
                                                                    semaphore.release();
                                                                }
                                                            }
                                                        });

                                                    }
                                                    //等待所有任务都结束了继续执行
                                                    executor.shutdown();
                                                    while (!executor.awaitTermination(1, TimeUnit.SECONDS)) ;
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                               /*     }
                                });*/
                            }
                        }
                    }
                }
            }

        }

        /*String linkPlate="http://sh.esf.fang.com//agenthome-a022-b05242/-i31-j310/";
        Document documentPlat = DownLoadPage.downLoadPage(linkPlate);
        if(documentPlat!=null){
            //解析版快种子链接,获取分页链接
            Integer totalNum = parsePlatPage(documentPlat);
            if(totalNum!=null && totalNum!=0){
                //存储分页连接
                List<String> listPageLink =new ArrayList<String>();
                for (int i = 1; i <= totalNum; i++) {
                    String[] split = linkPlate.split("/-i31");
                    String pageHref=split[0]+"/-i3"+i+split[1];
                    System.out.println(i);
                    System.out.println(pageHref);
                    listPageLink.add(pageHref);
                }
                //解析分页连接
                for (final String pageLink : listPageLink) {
                    //多线程爬去分页连接
                    executor.execute(new Runnable() {
                        public void run() {
                            try {
                                //http://sh.esf.fang.com/agenthome-a025-b01646/-i3 1 -j310/
                                Document documentPage = DownLoadPage.downLoadPage(pageLink);
                                //解析分页链接获取列表的信息
                                if(documentPage!=null){
                                    FangAgent fangAgent = new FangAgent();
                                    fangAgent.setId(UUID.randomUUID().toString());
                                    fangAgent.setCity("上海");
                                    fangAgent.setRegion("浦东");
                                    fangAgent.setPlate("北蔡");
                                    List<FangAgent> fangAgents = parsePage(documentPage, fangAgent);
                                    for (FangAgent agent : fangAgents) {
                                        fangAgentService.insertFangAgent(agent);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
                //等待所有任务都结束了继续执行
                executor.shutdown();
            }
        }*/
    }
    /**
     * 解析分页链接，获取列表信息
     * @param document
     * @return
     */
    public static List<FangAgent> parsePage(Document document,FangAgent fangAgentold){
        List<FangAgent> fangAgents = new ArrayList<FangAgent>();

        String city = fangAgentold.getCity();
        String region = fangAgentold.getRegion();
        String plate = fangAgentold.getPlate();

        Elements selects = document.select("div.agent_list>ul>li");
        if(!selects.isEmpty()){
            for (Element element : selects) {
                FangAgent fangAgent = new FangAgent();
                fangAgent.setId(UUID.randomUUID().toString());
                fangAgent.setCity(city);
                fangAgent.setRegion(region);
                fangAgent.setPlate(plate);
                //详情页link
                String link = element.attr("link");
                if(StringUtils.isNotBlank(link)){
                    String detailHref="http://sh.esf.fang.com"+link;
                    fangAgent.setUrl(detailHref);
                    System.out.println("详情页url==============================================="+detailHref);
                }
                Elements selectImg = element.select("div.agent_ren.fl>div.ren.fl>a>img");
                if(!selectImg.isEmpty()){
                    //列表头像
                    String src = selectImg.attr("src");
                    fangAgent.setThumbnail(src);
                    System.out.println("头像"+src);
                }
                Elements selectDetail = element.select("div.agent_ren.fl>div.fl");
                if(!selectDetail.isEmpty()){
                    //经济人姓名
                    Elements selectName = selectDetail.select("div.ttop>a>b");
                    if(!selectName.isEmpty()){
                        String name=selectName.text();
                        fangAgent.setAgentName(name);
                        System.out.println("名称"+name);
                    }else{
                        return null;
                    }
                    //经济人手机号
                    Elements selectPhone = selectDetail.select("p.gray3.f14.liaxni");
                    if(!selectPhone.isEmpty()){
                        String phone = selectPhone.text();
                        fangAgent.setPhone(phone);
                        System.out.println("手机号"+phone);
                    }
                    //所属公司
                    Elements selectCompany = selectDetail.select("p.f14.liaxni>span.gray3.fl");
                    if(!selectCompany.isEmpty()){
                        String company = selectCompany.text();
                        fangAgent.setCompany(company);
                        System.out.println("所属公司"+company);
                    }

                    //房源信息
                    Elements selectHousInformations = element.select("div.agent_map.fl.rel>div.taoshu_des>p");
                    if(!selectHousInformations.isEmpty()){
                        for (Element selectHousInformation : selectHousInformations) {
                            Elements elementSpan = selectHousInformation.select("span");
                            Elements elementB = selectHousInformation.select("b");
                            if(elementSpan!=null && elementB!=null){
                                String textSpan = elementSpan.text();
                                String textB = elementB.text();
                                if("在售房源".equals(textSpan)){
                                    fangAgent.setSaleHouse(textB);
                                    System.out.println("在售房源"+textB);
                                }else if("总评价数".equals(textSpan)){
                                    fangAgent.setCommentNum(textB);
                                    System.out.println("总评价数"+textB);
                                }else if("好评率".equals(textSpan)){
                                    fangAgent.setPriceRate(textB);
                                    System.out.println("好评率"+textB);
                                }
                            }
                        }
                    }
                    //地图信息
                    Elements selectMap = element.select("div.agent_map.fl.rel>div.map_dw>div.dw_name>span.diqu");
                    if(!selectMap.isEmpty()){
                        String mapDw = selectMap.text();
                        fangAgent.setAddress(mapDw);
                        System.out.println("地图定点"+mapDw);
                    }

                }
                if(StringUtils.isNotBlank(fangAgent.getAgentName())){
                    fangAgents.add(fangAgent);
                }
            }
        }
        return fangAgents;

    }
    /**
     * 解析板块种子链接，获取分页总数目
     * @param document
     * @return
     */
    public static Integer parsePlatPage(Document document){
        Elements selects = document.select("div#agentlist_B08_01>span.txt");
        if(!selects.isEmpty() && selects.size()>0){
            String totalNum = selects.text();
            Integer num = NumUtils.getInteger(totalNum);
            return num;
        }else {
            return null;
        }

    }

    /**
     * 解析区域链接，获取板块种子链接
     * @param document
     * @return
     */
    public static List<Map<String,Object>> parseRegionPage(Document document){
        //板块的种子链接
        List<Map<String,Object>> listPlat= new ArrayList<Map<String,Object>>();

        Elements selectPlat = document.select("p#shangQuancontain>a").not("a.orange");
        if(!selectPlat.isEmpty() && selectPlat.size()>0){
            //获取板块种子链接
            for (Element elementUrl : selectPlat) {
                if(elementUrl!=null){
                    Map<String,Object> map=new HashMap<String,Object>();
                    String textPlat = elementUrl.text();
                    map.put("plate",textPlat);
                    System.out.println(textPlat);
                    String hrefPlat = elementUrl.attr("href");
                    if(StringUtils.isNotBlank(hrefPlat)){
                        String href = "http://sh.esf.fang.com/"+hrefPlat;
                        map.put("linkPlate",href);
                        System.out.println("版快种子链接"+href);
                        listPlat.add(map);
                    }
                }
            }
        }
        return listPlat;
    }

    /**
     * 解析主链接，获取区域种子链接
     * @param document
     * @return
     */
    public static List<Map<String,Object>> parseIndexPage(Document document){
        //存放区域的种子链接
        List<Map<String,Object>> listRegion= new ArrayList<Map<String,Object>>();

        Elements select = document.select("div#agentlist_B03_01");
        System.out.println(select);

        //获取上海城,区域的种子链接
        Elements selects = document.select("div#agentlist_B03_01>div.qxName>a").not("a.orange");

        if(!selects.isEmpty() && selects.size()>0){
            //获取区域种子链接
            for (Element elementHref : selects) {
                if(elementHref!=null){
                    Map<String,Object> map=new HashMap<String,Object>();

                    String hrefRegion = elementHref.attr("href");
                    String textRegion = elementHref.text();
                    //存放region
                    map.put("region",textRegion);
                    System.out.println(textRegion);
                    if(StringUtils.isNotBlank(hrefRegion)){
                        String href = "http://sh.esf.fang.com/"+hrefRegion;
                        map.put("linkRegion",href);
                        System.out.println("请求解析主链接，获取区域链接+++"+href);
                        listRegion.add(map);
                    }
                }

            }
        }

        return listRegion;
    }

}
