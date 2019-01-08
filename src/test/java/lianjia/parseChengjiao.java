package lianjia;

import com.tt.common.utils.OkHttpDownLoadUtil;
import com.tt.dao.*;
import com.tt.entity.*;
import com.tt.service.IDownLoadPage;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
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
import java.util.stream.Collectors;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/26 09:54
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseChengjiao {

    @Autowired
    @Qualifier("ipPoolProxyOkHttp")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private CommunityKeDetailMapper communityKeDetailMapper;

    @Autowired
    private LianjiaChengjiaoCommunityDealMapper lianjiaChengjiaoCommunityDealMapper;

    @Autowired
    private LianjiaChengjiaoHousePlateMapper lianjiaChengjiaHousePlateMapper;

    @Autowired
    private LianjiaChengjiaoHouseListMapper lianjiaChengjiaoHouseListMapper;

    @Autowired
    private LianjiaChengjiaoHouseDetailMapper lianjiaChengjiaoHouseDetailMapper;


    @Test
    public void parseDetail() throws InterruptedException {
       List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("重庆");

        /*list.add("上海");
        list.add("南京");
        list.add("合肥");
        list.add("天津");*/
        LianjiaChengjiaoHouseListExample lianjiaChengjiaoHouseListExample = new LianjiaChengjiaoHouseListExample();
        lianjiaChengjiaoHouseListExample.or().andStatusIsNull().andCityIn(list).andDetailUrlIsNotNull();
        List<LianjiaChengjiaoHouseList> lianjiaChengjiaoHouseLists = lianjiaChengjiaoHouseListMapper.selectByExample(lianjiaChengjiaoHouseListExample);
        System.out.println(lianjiaChengjiaoHouseLists.size());
        Integer num=8;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList : lianjiaChengjiaoHouseLists) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String detailUrl = lianjiaChengjiaoHouseList.getDetailUrl();
                    String goodsId = lianjiaChengjiaoHouseList.getGoodsId();
                    String goodsName = lianjiaChengjiaoHouseList.getGoodsName();

                    System.out.println(detailUrl);
                    try {
                        //Document document = iDownLoadPage.downLoadPageByGet(detailUrl);
                        String result = OkHttpDownLoadUtil.createOkHttpClient().proxyGet(detailUrl);
                        if(StringUtils.isNotBlank(result)){
                            Document document = Jsoup.parse(result);
                            if(document!=null){
                                LianjiaChengjiaoHouseDetail lianjiaChengjiaoHouseDetail = new LianjiaChengjiaoHouseDetail();
                                lianjiaChengjiaoHouseDetail.setId(UUID.randomUUID().toString());
                                lianjiaChengjiaoHouseDetail.setGoodsId(goodsId);
                                lianjiaChengjiaoHouseDetail.setGoodsName(goodsName);
                                lianjiaChengjiaoHouseDetail.setDetailUrl(detailUrl);
                                lianjiaChengjiaoHouseDetail.setBatchId("v2.0");
                                lianjiaChengjiaoHouseDetail.setCreateTime(new Date());

                                //conten信息
                                //成交时间
                                Elements elements = document.select("div.wrapper>span");
                                if(!elements.isEmpty()){
                                    try {
                                        String dealTime = elements.text().replace("成交","");
                                        lianjiaChengjiaoHouseDetail.setDealTime(dealTime);
                                    } catch (Exception e1) {
                                        e1.printStackTrace();
                                    }
                                }
                                //成交价格
                                Elements select1 = document.select("div.info.fr>div.price>span.dealTotalPrice>i");
                                if(!select1.isEmpty()){
                                    String dealPrice = select1.text();
                                    lianjiaChengjiaoHouseDetail.setDealPrice(dealPrice);
                                }
                                //成交平均价格
                                Elements select2 = document.select("div.info.fr>div.price>b");
                                //成交平均价格
                                if(!select2.isEmpty()){
                                    String dealAveragePrice = select2.text();
                                    lianjiaChengjiaoHouseDetail.setDealAveragePrice(dealAveragePrice);
                                }
                                //交易信息
                                Elements select3 = document.select("div.info.fr>div.msg>span");
                                if(!select3.isEmpty()){
                                    for (Element element : select3) {
                                        String type = element.ownText();
                                        String value = element.select("label").text().replace("\\s*","");
                                        switch (type){
                                            case"挂牌价格（万）":
                                                lianjiaChengjiaoHouseDetail.setListPrice(value);
                                                break;
                                            case"成交周期（天）":
                                                lianjiaChengjiaoHouseDetail.setDealCycle(value);
                                                break;
                                            case"调价（次）":
                                                lianjiaChengjiaoHouseDetail.setAdjustments(value);
                                                break;
                                            case"带看（次）":
                                                lianjiaChengjiaoHouseDetail.setViewCount(value);
                                                break;
                                            case"关注（人）":
                                                lianjiaChengjiaoHouseDetail.setConcernCount(value);
                                                break;
                                            case"浏览（次）":
                                                lianjiaChengjiaoHouseDetail.setPvCount(value);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                //基本信息
                                Elements select = document.select("div#introduction>div.introContent");
                                if(!select.isEmpty()){
                                    //基本属性
                                    Elements selectBase = select.select("div.base>div.content>ul>li");
                                    if(!selectBase.isEmpty()){
                                        for (Element element : selectBase) {
                                            String baseTag = element.select("span.label").text().replace("\\s*","");
                                            String value=element.ownText();
                                            switch (baseTag){
                                                case "房屋户型":
                                                    lianjiaChengjiaoHouseDetail.setLayout(value);
                                                    break;
                                                case "所在楼层":
                                                    //中楼层(共6层)
                                                    String[] split = value.split("\\(");
                                                    if(split.length==2){
                                                        String floorHeight = split[0];
                                                        lianjiaChengjiaoHouseDetail.setFloorHeight(floorHeight);
                                                        String totalFloor = split[1].replace(")","");
                                                        lianjiaChengjiaoHouseDetail.setTotalFloor(totalFloor);
                                                    }else if (split.length==1){
                                                        String floorHeight = split[0];
                                                        lianjiaChengjiaoHouseDetail.setFloorHeight(floorHeight);
                                                    }
                                                    break;
                                                case "建筑面积":
                                                    lianjiaChengjiaoHouseDetail.setArea(value);
                                                    break;
                                                case "户型结构":
                                                    lianjiaChengjiaoHouseDetail.setLayoutStr(value);
                                                    break;
                                                case"套内面积":
                                                    lianjiaChengjiaoHouseDetail.setDwellingFloorSpace(value);
                                                    break;
                                                case "建筑类型":
                                                    lianjiaChengjiaoHouseDetail.setBuildType(value);
                                                    break;
                                                case "房屋朝向":
                                                    lianjiaChengjiaoHouseDetail.setOrientation(value);
                                                    break;
                                                case "建成年代":
                                                    lianjiaChengjiaoHouseDetail.setBuildYear(value);
                                                    break;
                                                case "建筑结构":
                                                    lianjiaChengjiaoHouseDetail.setBuildStr(value);
                                                    break;
                                                case "装修情况":
                                                    lianjiaChengjiaoHouseDetail.setDecoration(value);
                                                    break;
                                                case "梯户比例":
                                                    lianjiaChengjiaoHouseDetail.setLadderRatio(value);
                                                    break;
                                                case "供暖方式":
                                                    lianjiaChengjiaoHouseDetail.setHeating(value);
                                                    break;
                                                case "配备电梯":
                                                    lianjiaChengjiaoHouseDetail.setElevator(value);
                                                    break;
                                                case "产权年限":
                                                    lianjiaChengjiaoHouseDetail.setPropertyYear(value);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                    //交易属性
                                    Elements selectTransaction = select.select("div.transaction>div.content>ul>li");
                                    if(!selectTransaction.isEmpty()){
                                        for (Element element : selectTransaction) {
                                            String transactionTag = element.select("span.label").text();
                                            String value=element.ownText();
                                            switch (transactionTag){
                                                case "挂牌时间":
                                                    lianjiaChengjiaoHouseDetail.setGoodsPubtime(value);
                                                    break;
                                                case "交易权属":
                                                    lianjiaChengjiaoHouseDetail.setTradingRights(value);
                                                    break;
                                                case "房屋用途":
                                                    lianjiaChengjiaoHouseDetail.setPropertyType(value);
                                                    break;
                                                case"房屋年限":
                                                    lianjiaChengjiaoHouseDetail.setHousingYears(value);
                                                    break;
                                                case "房权所属":
                                                    lianjiaChengjiaoHouseDetail.setPropertyOwnership(value);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                int i = lianjiaChengjiaoHouseDetailMapper.insertSelective(lianjiaChengjiaoHouseDetail);
                                if(i==1){
                                    lianjiaChengjiaoHouseList.setStatus("1");
                                    lianjiaChengjiaoHouseListMapper.updateByPrimaryKeySelective(lianjiaChengjiaoHouseList);
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
     * 功能描述: 获取小区的成交列表信息
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/28 16:01
     */
    @Test
    public void getChengjiaoList() throws InterruptedException {
        LianjiaChengjiaoCommunityDealExample lianjiaChengjiaoCommunityDealExample = new LianjiaChengjiaoCommunityDealExample();
        lianjiaChengjiaoCommunityDealExample.or().andStatusIsNull();
        List<LianjiaChengjiaoCommunityDeal> lianjiaChengjiaoCommunityDeals = lianjiaChengjiaoCommunityDealMapper.selectByExample(lianjiaChengjiaoCommunityDealExample);
        System.out.println(lianjiaChengjiaoCommunityDeals.size());

        Integer count=8;
        Semaphore semaphore = new Semaphore(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (LianjiaChengjiaoCommunityDeal lianjiaChengjiaoCommunityDeal : lianjiaChengjiaoCommunityDeals) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String chengjiaoUrl = lianjiaChengjiaoCommunityDeal.getChengjiaoUrl();
                        String city = lianjiaChengjiaoCommunityDeal.getCity();
                        String titleId = lianjiaChengjiaoCommunityDeal.getTitleId();

                        String hostName=chengjiaoUrl.substring(0,chengjiaoUrl.indexOf("/chengjiao"));
                        Document document = checkTotalCount(chengjiaoUrl);
                        if(document!=null){
                            Elements select = document.select("div.total.fl>span");
                            if(!select.isEmpty()){
                                //板块的总条数
                                String listCount = select.text();
                                Integer count = Integer.valueOf(listCount);
                                if(count>3000){
                                    Elements select1 = document.select("div.m-filter>div.list-more>dl>dd");
                                    if(select1.size()>1){
                                        Element element = select1.get(1);
                                        Elements select2 = element.select("a");
                                        if(!select2.isEmpty()){
                                            for (Element element1 : select2) {
                                                String href = element1.attr("href");
                                                if(StringUtils.isNotBlank(href)){
                                                    String plateUrl = hostName + href;
                                                    Document document2 = checkTotalCount(plateUrl);
                                                    if(document2!=null){
                                                        //获取页面信息
                                                        parseMessage(document,chengjiaoUrl,city,titleId,chengjiaoUrl);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    //获取页面信息
                                    parseMessage(document,chengjiaoUrl,city,titleId,chengjiaoUrl);
                                }
                                //修改状态
                                lianjiaChengjiaoCommunityDeal.setSource(listCount);
                                lianjiaChengjiaoCommunityDeal.setStatus("1");
                                lianjiaChengjiaoCommunityDealMapper.updateByPrimaryKeySelective(lianjiaChengjiaoCommunityDeal);
                            }
                        }

                    } catch (NumberFormatException e) {
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
     * 功能描述:校验总条数是否真实是0
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/28 16:37
     */
    public Document checkTotalCount(String url) {
        Integer count=0;
        Integer flag=0;
        Document doc =null;
        if(count==0){
            while (flag<5){
                doc = iDownLoadPage.downLoadPageByGet(url);
                if(doc!=null){
                    Elements sel = doc.select("div.total.fl>span");
                    if(!sel.isEmpty()){
                        count=Integer.valueOf(sel.text());
                        if(count==0){
                            System.out.println("count是0--循环五次"+flag+"----"+url);
                        }else {
                            System.out.println("成功获取到count，终止循环"+flag+"----"+url);
                            break;
                        }
                    }
                }
                flag++;
            }
        }
        return doc;
    }

    /**
     *
     * 功能描述: 获取下一页的信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/28 16:20
     */
    public void parseMessage(Document document,String url,String city,String titleId,String chengjiaoUrl) {
        Elements select = document.select("div.total.fl>span");
        if(!select.isEmpty()) {
            //板块的总条数
            String listCount = select.text();
            Integer count = Integer.valueOf(listCount);
            if(count!=0){
                //解析当前页面的列表信息
                List<LianjiaChengjiaoHouseList> lianjiaChengjiaoHouseLists = parseListMessage(document);
                for (LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList : lianjiaChengjiaoHouseLists) {
                    lianjiaChengjiaoHouseList.setCity(city);
                    lianjiaChengjiaoHouseList.setRegion(titleId);
                    lianjiaChengjiaoHouseList.setPlate(chengjiaoUrl);
                    lianjiaChengjiaoHouseListMapper.insertSelective(lianjiaChengjiaoHouseList);
                }
                //翻页请求
                //计算页码数量
                if(count>30){
                    Integer pageNum= count % 30==0? count/30:(count/30)+1;
                    pageNum=pageNum>100? 100:pageNum;
                    Integer num=2;
                    System.out.println(count);
                    while (num <= pageNum ){
                        System.out.println("请求第"+num+"页========");
                        String pageUrl = url.replace("chengjiao/", "chengjiao/pg" + num);
                        Document doc = checkTotalCount(pageUrl);
                        if(doc!=null){
                            //解析当前页面的列表信息
                            List<LianjiaChengjiaoHouseList> lianjiaChengjiaoHouseLists1 = parseListMessage(doc);
                            if(lianjiaChengjiaoHouseLists1.size()==0){
                                System.out.println("请求还是空的");
                            }else {
                                for (LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList1 : lianjiaChengjiaoHouseLists1) {
                                    lianjiaChengjiaoHouseList1.setCity(city);
                                    lianjiaChengjiaoHouseList1.setRegion(titleId);
                                    lianjiaChengjiaoHouseList1.setPlate(chengjiaoUrl);
                                    lianjiaChengjiaoHouseListMapper.insertSelective(lianjiaChengjiaoHouseList1);
                                }
                            }
                        }
                        num++;
                    }
                }
            }
        }




    }

    /**
     *
     * 功能描述: 贝壳的详情url转换为交易url
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/28 14:57
     */
    @Test
    public void keUrlTranform(){
        CommunityKeDetailExample communityKeDetailExample = new CommunityKeDetailExample();
        List<CommunityKeDetailWithBLOBs> communityKeDetailWithBLOBs = communityKeDetailMapper.selectByExampleWithBLOBs(communityKeDetailExample);
        ArrayList<CommunityKeDetailWithBLOBs> collect = communityKeDetailWithBLOBs.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(
                                        Comparator.comparing(o -> o.getTitleId()))),
                        ArrayList::new));
        System.out.println(collect.size());

        for (CommunityKeDetailWithBLOBs keDetailWithBLOBs : collect) {
            String titleId = keDetailWithBLOBs.getTitleId();
            //http://m.ke.com/bj/xiaoqu/1111027375686/
            //https://bj.lianjia.com/chengjiao/c1111027382209/
            String detailUrl = keDetailWithBLOBs.getDetailUrl();
            String city = keDetailWithBLOBs.getCity();
            if(StringUtils.isNotBlank(detailUrl)){
                LianjiaChengjiaoCommunityDeal lianjiaChengjiaoCommunityDeal = new LianjiaChengjiaoCommunityDeal();
                lianjiaChengjiaoCommunityDeal.setId(UUID.randomUUID().toString());
                lianjiaChengjiaoCommunityDeal.setBatchId("v1.0");
                lianjiaChengjiaoCommunityDeal.setCreateDate(new Date());
                lianjiaChengjiaoCommunityDeal.setTitleId(titleId);
                lianjiaChengjiaoCommunityDeal.setCommunityUrl(detailUrl);
                lianjiaChengjiaoCommunityDeal.setCity(city);

                String substring = detailUrl.substring(detailUrl.indexOf("ke.com/") + 7, detailUrl.length()).replace("/xiaoqu/",".lianjia.com/chengjiao/c");
                if(StringUtils.isNotBlank(substring)){
                    String chengjiaoUrl="https://"+substring;
                    System.out.println(chengjiaoUrl);
                    lianjiaChengjiaoCommunityDeal.setChengjiaoUrl(chengjiaoUrl);
                    lianjiaChengjiaoCommunityDealMapper.insertSelective(lianjiaChengjiaoCommunityDeal);
                }

            }


        }


    }






    /**
     *
     * 功能描述: 解析板块链接，获取详情列表链接
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/12 18:04
     */
    @Test
    public void parsePlate() throws InterruptedException {
        LianjiaChengjiaoHousePlateExample lianjiaChengjiaoHousePlateExample = new LianjiaChengjiaoHousePlateExample();
        lianjiaChengjiaoHousePlateExample.or().andStatusIsNull();
        List<LianjiaChengjiaoHousePlate> lianjiaChengjiaoHousePlateList = lianjiaChengjiaHousePlateMapper.selectByExample(lianjiaChengjiaoHousePlateExample);
        System.out.println(lianjiaChengjiaoHousePlateList.size());
        Integer num=8;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (LianjiaChengjiaoHousePlate lianjiaChengjiaoHousePlate : lianjiaChengjiaoHousePlateList) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String city = lianjiaChengjiaoHousePlate.getCity();
                        String region = lianjiaChengjiaoHousePlate.getRegion();
                        String plate = lianjiaChengjiaoHousePlate.getPlate();

                        String plateUrl = lianjiaChengjiaoHousePlate.getPlateUrl();
                        System.out.println(plateUrl);
                        Document document = iDownLoadPage.downLoadPageByGet(plateUrl);
                        if(document!=null){
                            Elements select = document.select("div.total.fl>span");
                            if(!select.isEmpty()){
                                //板块的总条数
                                String listCount = select.text();
                                System.out.println(listCount);

                                //解析当前页面的列表信息
                                List<LianjiaChengjiaoHouseList> lianjiaChengjiaoHouseLists = parseListMessage(document);
                                for (LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList : lianjiaChengjiaoHouseLists) {
                                    lianjiaChengjiaoHouseList.setCity(city);
                                    lianjiaChengjiaoHouseList.setRegion(region);
                                    lianjiaChengjiaoHouseList.setPlate(plate);
                                    lianjiaChengjiaoHouseListMapper.insertSelective(lianjiaChengjiaoHouseList);
                                }

                                //翻页请求
                                //计算页码数量
                                Integer count = Integer.valueOf(listCount);
                                if(count!=0 && count>30){
                                    Integer pageNum= count % 30==0? count/30:(count/30)+1;
                                    pageNum=pageNum>100? 100:pageNum;
                                    Integer flag=0;
                                    Integer num=2;
                                    while (num <= pageNum && flag<5){
                                        String pageUrl = plateUrl + "pg" + num+"/";
                                        Document doc = iDownLoadPage.downLoadPageByGet(pageUrl);
                                        if(doc!=null){
                                            //解析当前页面的列表信息
                                            List<LianjiaChengjiaoHouseList> lianjiaChengjiaoHouseLists1 = parseListMessage(doc);
                                            if(lianjiaChengjiaoHouseLists1.size()==0){
                                                flag++;
                                            }else {
                                                for (LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList1 : lianjiaChengjiaoHouseLists1) {
                                                    lianjiaChengjiaoHouseList1.setCity(city);
                                                    lianjiaChengjiaoHouseList1.setRegion(region);
                                                    lianjiaChengjiaoHouseList1.setPlate(plate);
                                                    lianjiaChengjiaoHouseListMapper.insertSelective(lianjiaChengjiaoHouseList1);
                                                }
                                            }
                                        }
                                        num++;
                                    }
                                    /*for (int i = 2; i <= pageNum; i++) {
                                        String pageUrl = plateUrl + "pg" + i+"/";
                                        Document doc = iDownLoadPage.downLoadPageByGet(pageUrl);
                                        if(doc!=null){
                                            //解析当前页面的列表信息
                                            List<LianjiaChengjiaoHouseList> lianjiaChengjiaoHouseLists1 = parseListMessage(doc);
                                            if(lianjiaChengjiaoHouseLists1.size()==0){
                                                num++;
                                            }else {
                                                for (LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList1 : lianjiaChengjiaoHouseLists1) {
                                                    lianjiaChengjiaoHouseList1.setCity(city);
                                                    lianjiaChengjiaoHouseList1.setRegion(region);
                                                    lianjiaChengjiaoHouseList1.setPlate(plate);
                                                    lianjiaChengjiaoHouseListMapper.insertSelective(lianjiaChengjiaoHouseList1);
                                                }
                                            }
                                        }
                                    }*/

                                }

                                //修改状态
                                lianjiaChengjiaoHousePlate.setSource(listCount);
                                lianjiaChengjiaoHousePlate.setStatus("1");
                                lianjiaChengjiaHousePlateMapper.updateByPrimaryKeySelective(lianjiaChengjiaoHousePlate);
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
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
        System.out.println("任务结束");
    }


    /**
     *
     * 功能描述: 解析当前列表页信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/12 18:38
     */
    public List<LianjiaChengjiaoHouseList> parseListMessage(Document document) {
        List<LianjiaChengjiaoHouseList> list=new ArrayList<>();
        Elements selectLi = document.select("ul.listContent>li");
        if(!selectLi.isEmpty()){
            for (Element element : selectLi) {
                LianjiaChengjiaoHouseList lianjiaChengjiaoHouseList = new LianjiaChengjiaoHouseList();
                lianjiaChengjiaoHouseList.setId(UUID.randomUUID().toString());
                lianjiaChengjiaoHouseList.setBatchId("v1.0");
                lianjiaChengjiaoHouseList.setCreateTime(new Date());
                //详情的url
                //详情信息
                Elements select1 = element.select("div.info");
                if(!select1.isEmpty()){
                    String detailUrl = select1.select("div.title>a").attr("href");
                    String goodsName = select1.select("div.title>a").text();
                    if(StringUtils.isNotBlank(detailUrl)){
                        lianjiaChengjiaoHouseList.setDetailUrl(detailUrl);
                        String goodesId =null;
                        try {
                            goodesId = detailUrl.substring(detailUrl.lastIndexOf("/")+1, detailUrl.indexOf(".html"));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        System.out.println(goodesId);
                        lianjiaChengjiaoHouseList.setGoodsId(goodesId);
                    }
                    System.out.println(detailUrl);
                    lianjiaChengjiaoHouseList.setGoodsName(goodsName);
                }
                list.add(lianjiaChengjiaoHouseList);
            }
        }
        return list;
    }





    @Test
    public void parseIndex(){
        Map<String, String> mapCity = new HashMap<>();
        //mapCity.put("上海","https://sh.lianjia.com/chengjiao/");
        mapCity.put("苏州","https://su.lianjia.com/chengjiao/");
        mapCity.put("杭州","https://hz.lianjia.com/chengjiao/");
        mapCity.put("北京","https://bj.lianjia.com/chengjiao/");
        mapCity.put("深圳","https://sz.lianjia.com/chengjiao/");
        mapCity.put("广州","https://gz.lianjia.com/chengjiao/");
        mapCity.put("南京","https://nj.lianjia.com/chengjiao/");
        mapCity.put("重庆","https://cq.lianjia.com/chengjiao/");
        mapCity.put("成都","https://cd.lianjia.com/chengjiao/");
        mapCity.put("西安","https://xa.lianjia.com/chengjiao/");
        mapCity.put("武汉","https://wh.lianjia.com/chengjiao/");
        mapCity.put("郑州","https://zz.lianjia.com/chengjiao/");
        mapCity.put("合肥","https://hf.lianjia.com/chengjiao/");
        mapCity.put("青岛","https://qd.lianjia.com/chengjiao/");
        mapCity.put("天津","https://tj.lianjia.com/chengjiao/");
        mapCity.put("沈阳","https://sy.lianjia.com/chengjiao/");
        mapCity.put("济南","https://jn.lianjia.com/chengjiao/");

        for (String city : mapCity.keySet()) {
            String indexUrl = mapCity.get(city);
            String hostName=indexUrl.replace("/chengjiao/","");

            Document document = iDownLoadPage.downLoadPageByGet(indexUrl);
            Elements select = document.select("div[data-role=ershoufang]>div>a");
            if(!select.isEmpty()){
                for (Element element : select) {
                    String regionHref = element.attr("href");
                    String region = element.text();
                    if(StringUtils.isNotBlank(regionHref) && StringUtils.isNotBlank(region) && (!regionHref.contains("https"))){
                        //区域链接
                        regionHref=hostName+regionHref;
                        System.out.println(regionHref+region+"--");
                        //板块链接
                        Document document1 = iDownLoadPage.downLoadPageByGet(regionHref);
                        Elements select1 = document1.select("div[data-role=ershoufang]>div");
                        if(select1.size()==2){
                            Elements select2 = select1.get(1).select("a");
                            if(!select2.isEmpty()){
                                for (Element element1 : select2) {
                                    String plateHref = element1.attr("href");
                                    String plate = element1.text();
                                    if(StringUtils.isNotBlank(plateHref) && StringUtils.isNotBlank(plate)){
                                        LianjiaChengjiaoHousePlate lianjiaChengjiaoHousePlate = new LianjiaChengjiaoHousePlate();
                                        lianjiaChengjiaoHousePlate.setId(UUID.randomUUID().toString());
                                        lianjiaChengjiaoHousePlate.setBatchId("v1.0");
                                        lianjiaChengjiaoHousePlate.setCreateDate(new Date());
                                        lianjiaChengjiaoHousePlate.setCity(city);
                                        lianjiaChengjiaoHousePlate.setRegion(region);
                                        lianjiaChengjiaoHousePlate.setRegionUrl(regionHref);
                                        //区域链接
                                        plateHref=hostName+plateHref;
                                        System.out.println(plateHref+plate);

                                        lianjiaChengjiaoHousePlate.setPlate(plate);
                                        lianjiaChengjiaoHousePlate.setPlateUrl(plateHref);
                                        //插入数据
                                        lianjiaChengjiaHousePlateMapper.insertSelective(lianjiaChengjiaoHousePlate);

                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

}
