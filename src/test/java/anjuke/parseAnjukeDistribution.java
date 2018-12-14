package anjuke;

import com.eju.houseparent.common.security.MD5;
import com.tt.common.utils.Pinyin4Util;
import com.tt.dao.*;
import com.tt.entity.*;
import com.tt.service.IDownLoadPage;
import com.tt.service.IEssUploadService;
import com.tt.service.JedisClientService;
import com.tt.vo.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.eju.houseparent.common.utils.ImageReaderUtils.imageToByte;
import static com.eju.houseparent.common.utils.ImageReaderUtils.imgUrlUpdate;

/**
 *
 * 分布获取安居客的二手房小区信息
 * @Auther: 赵乐
 * @Date: 2018/11/13 10:38
 * @Description:
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseAnjukeDistribution {

    @Autowired
    //@Qualifier("ipPoolProxy")
    @Qualifier("moguProxy")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private AnjukeCommunityPlateMapper anjukeCommunityPlateMapper;

    @Autowired
    private AnjukeCommunityListMapper anjukeCommunityListMapper;

    @Autowired
    private AnjukeCommunityDetailMapper anjukeCommunityDetailMapper;

    @Autowired
    private AnjukeCommunityLayoutMapper anjukeCommunityLayoutMapper;

    @Autowired
    private AnjukeCommunityRealityMapper anjukeCommunityRealityMapper;

    @Autowired
    private AnjukeCommunityPicMapper anjukeCommunityPicMapper;

    @Autowired
    private JedisClientService jedisClientService;

    @Autowired
    private IEssUploadService iEssUploadService;


    @Test
    public void testss(){
        AnjukeCommunityRealityExample anjukeCommunityRealityExample = new AnjukeCommunityRealityExample();
        anjukeCommunityRealityExample.or().andStatusEqualTo("one");
        List<AnjukeCommunityReality> anjukeCommunityRealities = anjukeCommunityRealityMapper.selectByExample(anjukeCommunityRealityExample);
        System.out.println(anjukeCommunityRealities.size());
        for (AnjukeCommunityReality anjukeCommunityRealitie : anjukeCommunityRealities) {
            String picSrc = anjukeCommunityRealitie.getPicSrc();
            if(StringUtils.isNotBlank(picSrc)){
                System.out.println(picSrc);
                try {
                    String name = "fang/310000/community/"+ MD5.encrypt(picSrc,"") +".jpg";
                    byte[] data =null;

                    try {
                        data=imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",picSrc));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if(data!=null){
                        Context context = new Context();
                        context.setFilename(name);
                        context.setData(data);
                        context.setContenttype("image/jpeg");
                        String newUrl = null;
                        try {
                            newUrl = iEssUploadService.fileUpload(context);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        anjukeCommunityRealitie.setPicUrl(newUrl);
                        //更新操作
                        anjukeCommunityRealityMapper.updateByPrimaryKeySelective(anjukeCommunityRealitie);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 功能描述: 存储安居客的二手房小区板块信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/13 11:13
     */
    @Test
    public void getPlateSeed() throws InterruptedException {
        /*String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};*/
        String[] citys = {"东莞","重庆",
                "青岛","武汉","成都","苏州"};
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (String city : citys) {
            String cityPin = Pinyin4Util.parse13City(city);
            if (StringUtils.isBlank(cityPin)) {
                continue;
            }
            String url = "https://" + cityPin + ".anjuke.com/community/?from=esf_list_navigation";
            //下载主页页面
            Document document = iDownLoadPage.downLoadPageByGet(url);
            //解析主链接，获取区域种子链接
            List<Map<String, Object>> listRegion = parseIndexPage(document);
            if (listRegion != null && listRegion.size() != 0) {
                for (Map<String, Object> regionMap : listRegion) {
                    semaphore.acquire();
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String hrefRegion = (String) regionMap.get("hrefRegion");
                                String region = (String) regionMap.get("region");
                                //下载区域页面
                                Document documentRegion = iDownLoadPage.downLoadPageByGet(hrefRegion);
                                //解析区域的子链接，获取区域下的细分链接
                                List<Map<String, Object>> listPlate = parseRegionPage(documentRegion);
                                //获取区域下的板块信息
                                if (CollectionUtils.isNotEmpty(listPlate)) {
                                    for (Map<String, Object> plateMap : listPlate) {
                                        AnjukeCommunityPlate anjukeCommunityPlate = new AnjukeCommunityPlate();
                                        anjukeCommunityPlate.setId(UUID.randomUUID().toString());
                                        anjukeCommunityPlate.setBatchId("v1.0");
                                        anjukeCommunityPlate.setCreateDate(new Date());

                                        anjukeCommunityPlate.setCity(city);
                                        anjukeCommunityPlate.setRegion(region);
                                        anjukeCommunityPlate.setRegionUrl(hrefRegion);

                                        String hrefPlate = (String) plateMap.get("hrefPlate");
                                        String plate = (String) plateMap.get("plate");
                                        //插入板块链接
                                        anjukeCommunityPlate.setPlate(plate);
                                        anjukeCommunityPlate.setPlateUrl(hrefPlate);

                                        anjukeCommunityPlateMapper.insertSelective(anjukeCommunityPlate);
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

        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");

    }

    /**
     * 功能描述: 根据板块链接，获取详情链接
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/13 11:22
     */
    @Test
    public void getDetailListSeed() throws InterruptedException {
        AnjukeCommunityPlateExample anjukeCommunityPlateExample = new AnjukeCommunityPlateExample();
        AnjukeCommunityPlateExample.Criteria criteria = anjukeCommunityPlateExample.createCriteria();
        //criteria.andCityEqualTo("重庆");
        criteria.andStatusIsNull();
        List<AnjukeCommunityPlate> anjukeCommunityPlates = anjukeCommunityPlateMapper.selectByExample(anjukeCommunityPlateExample);
        Integer num = 4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        if (CollectionUtils.isNotEmpty(anjukeCommunityPlates)) {
            for (AnjukeCommunityPlate anjukeCommunityPlate : anjukeCommunityPlates) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String city = anjukeCommunityPlate.getCity();
                            String region = anjukeCommunityPlate.getRegion();
                            String plate = anjukeCommunityPlate.getPlate();
                            String plateUrl = anjukeCommunityPlate.getPlateUrl();
                            if (StringUtils.isNotBlank(plate) && StringUtils.isNotBlank(plateUrl)) {
                                //解析区域下的细分链接,获取分页链接
                                Document documentPlate = iDownLoadPage.downLoadPageByGet(plateUrl);
                                Integer regionNum = parsePlatePage(documentPlate);
                                if (regionNum != null && regionNum != 0) {
                                    //拼接分页链接
                                    List<String> listPage = new ArrayList<>();
                                    for (int i = 1; i <= regionNum; i++) {
                                        String regionPage = plateUrl + "p" + i + "/";
                                        listPage.add(regionPage);
                                    }
                                    //根据分页链接获取列表的详情链接
                                    for (final String list : listPage) {
                                        try {
                                            //解析分页链接，获取列表详情链接
                                            Document documentPage = iDownLoadPage.downLoadPageByGet(list);
                                            //详情页链接
                                            //list集合中含有列表中基本信息
                                            List<AnjukeCommunityList> anjukeCommunityLists = parsePage(documentPage);
                                            for (AnjukeCommunityList anjukeCommunityList : anjukeCommunityLists) {
                                                anjukeCommunityList.setCity(city);
                                                anjukeCommunityList.setRegion(region);
                                                anjukeCommunityList.setPlate(plate);
                                                //插入数据
                                                anjukeCommunityListMapper.insertSelective(anjukeCommunityList);
                                                //根据安居客二手房的layout的url和详情url的关系，保存layouturl到缓存中
                                                String detailUrl = anjukeCommunityList.getDetailUrl();
                                                if(StringUtils.isNotBlank(detailUrl)){
                                                    try {
                                                        AnjukeCommunityDetail anjukeCommunityDetail = new AnjukeCommunityDetail();
                                                        //房型图链接
                                                        String layoutHref = detailUrl.replace("view", "photos/model");
                                                        //实景图链接
                                                        String bHref = detailUrl.replace("view", "photos2/b");
                                                        anjukeCommunityDetail.setDetailUrl(detailUrl);
                                                        anjukeCommunityDetail.setLayoutUrl(layoutHref);
                                                        anjukeCommunityDetail.setRealityUrl(bHref);
                                                        jedisClientService.addObjectToList("layout_reality",anjukeCommunityDetail);
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        //修改plate状态
                                        anjukeCommunityPlate.setStatus("1");
                                        anjukeCommunityPlateMapper.updateByPrimaryKeySelective(anjukeCommunityPlate);
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
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) ;
        System.out.println("任务结束");
    }

    /**
     * 功能描述: 从小区列表中获取详情url，解析获取信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/13 13:56
     */
    @Test
    public void getDetailMessage() throws InterruptedException {
        AnjukeCommunityListExample anjukeCommunityListExample = new AnjukeCommunityListExample();
        anjukeCommunityListExample.or().andStatusIsNull();
                //.andCityEqualTo("重庆");
        Integer num = 4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        List<AnjukeCommunityList> anjukeCommunityLists = anjukeCommunityListMapper.selectByExample(anjukeCommunityListExample);
        System.out.println(anjukeCommunityLists.size());
        if (CollectionUtils.isNotEmpty(anjukeCommunityLists)) {
            for (AnjukeCommunityList anjukeCommunityList : anjukeCommunityLists) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //小区详情url
                            String detailUrl = anjukeCommunityList.getDetailUrl();
                            String homeName = anjukeCommunityList.getHomeName();
                            if (StringUtils.isNotBlank(detailUrl)) {
                                Document documentDetail = iDownLoadPage.downLoadPageByGet(detailUrl);
                                //解析详情页信息
                                AnjukeCommunityDetail anjukeCommunityDetail = new AnjukeCommunityDetail();
                                anjukeCommunityDetail.setId(UUID.randomUUID().toString());
                                anjukeCommunityDetail.setHomeName(homeName);
                                anjukeCommunityDetail.setDetailUrl(detailUrl);
                                anjukeCommunityDetail.setBatchId("v1.0");
                                anjukeCommunityDetail.setCreateDate(new Date());
                                parseDetail(documentDetail, anjukeCommunityDetail);
                                //房型图链接
                                String layoutHref = detailUrl.replace("view", "photos/model");
                                //解析方形图链接
                                /* Document documentModel = iDownLoadPage.downLoadPageByGet(modelHref);
                                String strModel = parseModel(documentModel);*/

                                //实景图链接
                                String bHref = detailUrl.replace("view", "photos2/b");
                                /* Document documentViewDiagram = iDownLoadPage.downLoadPageByGet(bHref);
                                String strViewDiagram = parseViewDiagram(documentViewDiagram);*/
                                anjukeCommunityDetail.setLayoutUrl(layoutHref);
                                anjukeCommunityDetail.setRealityUrl(bHref);

                                //插入详情数据
                                int i = anjukeCommunityDetailMapper.insertSelective(anjukeCommunityDetail);
                                if (i == 1) {
                                    anjukeCommunityList.setStatus("1");
                                    anjukeCommunityListMapper.updateByPrimaryKeySelective(anjukeCommunityList);
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
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) ;
        System.out.println("任务结束");
    }

    /**
     * 功能描述: 解析详情中的户型图和实景图
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/13 14:46
     */
    @Test
    public void getLayoutAndRealityFromSql() throws InterruptedException {
        //从数据库的detail表中获取户型和实景图url
        AnjukeCommunityDetailExample anjukeCommunityDetailExample = new AnjukeCommunityDetailExample();
        anjukeCommunityDetailExample.or().andStatusIsNull();
        List<AnjukeCommunityDetail> anjukeCommunityDetails = anjukeCommunityDetailMapper.selectByExample(anjukeCommunityDetailExample);

        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        if (CollectionUtils.isNotEmpty(anjukeCommunityDetails)) {
            for (AnjukeCommunityDetail anjukeCommunityDetail : anjukeCommunityDetails) {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            //详情url
                            String detailUrl = anjukeCommunityDetail.getDetailUrl();
                            //户型url
                            String layoutUrl = anjukeCommunityDetail.getLayoutUrl();
                            if (StringUtils.isNotBlank(layoutUrl)) {
                                Document documentModel = iDownLoadPage.downLoadPageByGet(layoutUrl);
                                //获取户型图片
                                List<AnjukeCommunityLayout> anjukeCommunityLayouts = parseModel(documentModel);
                                for (AnjukeCommunityLayout anjukeCommunityLayout : anjukeCommunityLayouts) {
                                    anjukeCommunityLayout.setDetailUrl(detailUrl);
                                    anjukeCommunityLayout.setLayoutUrl(layoutUrl);
                                    String picSrc = anjukeCommunityLayout.getPicSrc();
                                    //图片存储到本地
                                    if(StringUtils.isNotBlank(picSrc)){
                                        jedisClientService.addObjectToList("picList",picSrc);
                                        //封装图片类型
                                       /* String name = "fang/310000/community/"+ MD5.encrypt(picSrc,"") +".jpg";
                                        byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",picSrc));
                                        Context context = new Context();
                                        context.setFilename(name);
                                        context.setData(data);
                                        context.setContenttype("image/jpeg");
                                        String newUrl = null;
                                        try {
                                            newUrl = iEssUploadService.fileUpload(context);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        anjukeCommunityLayout.setPicUrl(newUrl);*/
                                    }
                                    //存储户型图片
                                    anjukeCommunityLayoutMapper.insertSelective(anjukeCommunityLayout);
                                }
                            }
                            //实景图url
                            String realityUrl = anjukeCommunityDetail.getRealityUrl();
                            if(StringUtils.isNotBlank(realityUrl)){
                                Document documentViewDiagram = iDownLoadPage.downLoadPageByGet(realityUrl);
                                List<AnjukeCommunityReality> anjukeCommunityRealities = parseViewDiagram(documentViewDiagram);
                                for (AnjukeCommunityReality anjukeCommunityReality : anjukeCommunityRealities) {
                                    anjukeCommunityReality.setDetailUrl(detailUrl);
                                    anjukeCommunityReality.setRealityUrl(realityUrl);
                                    String picSrc = anjukeCommunityReality.getPicSrc();
                                    //图片存储到本地
                                    if(StringUtils.isNotBlank(picSrc)){
                                        jedisClientService.addObjectToList("picList",picSrc);
                                        //封装图片类型
                                       /* String name = "fang/310000/community/"+ MD5.encrypt(picSrc,"") +".jpg";
                                        byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",picSrc));
                                        Context context = new Context();
                                        context.setFilename(name);
                                        context.setData(data);
                                        context.setContenttype("image/jpeg");
                                        String newUrl = null;
                                        try {
                                            newUrl = iEssUploadService.fileUpload(context);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        anjukeCommunityReality.setPicUrl(newUrl);*/
                                    }
                                    anjukeCommunityRealityMapper.insertSelective(anjukeCommunityReality);
                                }
                            }
                            anjukeCommunityDetail.setStatus("1");
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
        while (!executorService.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("任务结束");
    }

    /**
     *
     * 功能描述: 从缓存中获取户型和实景图url
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/14 10:04
     */
    @Test
    public void getLayoutAndRealityFromCache() throws InterruptedException {
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        while (true){
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        AnjukeCommunityDetail anjukeCommunityDetail = (AnjukeCommunityDetail)jedisClientService.pollFromList("layout_reality");
                        if(anjukeCommunityDetail!=null){
                            //详情url
                            String detailUrl = anjukeCommunityDetail.getDetailUrl();
                            //户型url
                            String layoutUrl = anjukeCommunityDetail.getLayoutUrl();
                            if (StringUtils.isNotBlank(layoutUrl)) {
                                Document documentModel = iDownLoadPage.downLoadPageByGet(layoutUrl);
                                //获取户型图片
                                List<AnjukeCommunityLayout> anjukeCommunityLayouts = parseModel(documentModel);
                                for (AnjukeCommunityLayout anjukeCommunityLayout : anjukeCommunityLayouts) {
                                    anjukeCommunityLayout.setDetailUrl(detailUrl);
                                    anjukeCommunityLayout.setLayoutUrl(layoutUrl);
                                    String picSrc = anjukeCommunityLayout.getPicSrc();
                                    //图片存储到本地
                                    if(StringUtils.isNotBlank(picSrc)){
                                        //图片url放入缓存
                                        jedisClientService.addObjectToList("picList",picSrc);
                                    }
                                    //存储户型图片
                                    anjukeCommunityLayoutMapper.insertSelective(anjukeCommunityLayout);
                                }
                            }
                            //实景图url
                            String realityUrl = anjukeCommunityDetail.getRealityUrl();
                            if(StringUtils.isNotBlank(realityUrl)){
                                Document documentViewDiagram = iDownLoadPage.downLoadPageByGet(realityUrl);
                                List<AnjukeCommunityReality> anjukeCommunityRealities = parseViewDiagram(documentViewDiagram);
                                for (AnjukeCommunityReality anjukeCommunityReality : anjukeCommunityRealities) {
                                    anjukeCommunityReality.setDetailUrl(detailUrl);
                                    anjukeCommunityReality.setRealityUrl(realityUrl);
                                    String picSrc = anjukeCommunityReality.getPicSrc();
                                    //图片存储到本地
                                    if(StringUtils.isNotBlank(picSrc)){
                                        //图片url放入缓存
                                        jedisClientService.addObjectToList("picList",picSrc);
                                    }
                                    anjukeCommunityRealityMapper.insertSelective(anjukeCommunityReality);
                                }
                            }
                        }else{
                            Thread.sleep(3000);
                            System.out.println("没有链接了");
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

    /**
     *
     * 功能描述: 从缓存中获取图片链接，存入本地
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/13 19:13
     */
    @Test
    public void pictureToLocal() throws InterruptedException {
        Integer num=2;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        while (true){
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String picSrc = (String)jedisClientService.pollFromList("picList");
                        if(StringUtils.isNotBlank(picSrc)){
                            AnjukeCommunityPic anjukeCommunityPic = new AnjukeCommunityPic();
                            anjukeCommunityPic.setId(UUID.randomUUID().toString());
                            anjukeCommunityPic.setCreateTime(new Date());
                            anjukeCommunityPic.setPicSrc(picSrc);
                            String name = "fang/310000/community/"+ MD5.encrypt(picSrc,"") +".jpg";
                            byte[] data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",picSrc));
                            Context context = new Context();
                            context.setFilename(name);
                            context.setData(data);
                            context.setContenttype("image/jpeg");
                            String newUrl = null;
                            try {
                                newUrl = iEssUploadService.fileUpload(context);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            anjukeCommunityPic.setPicUrl(newUrl);
                            anjukeCommunityPicMapper.insertSelective(anjukeCommunityPic);
                        }else{
                            System.out.println("没有图片链接了-----");
                            Thread.sleep(5000);
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
    /**
     *解析房型图的实景图
     */
    public List<AnjukeCommunityReality> parseViewDiagram(Document document){
        List<AnjukeCommunityReality> list = new ArrayList<>();
        if(document!=null){
            Elements selects = document.select("div.realmap-contents>ul.list>li.item>img");
            if(selects!=null && ! selects.isEmpty()){
                for (Element select : selects) {
                    AnjukeCommunityReality anjukeCommunityReality = new AnjukeCommunityReality();
                    anjukeCommunityReality.setId(UUID.randomUUID().toString());
                    anjukeCommunityReality.setBatchId("v1.0");
                    anjukeCommunityReality.setCreateTime(new Date());
                    //图片url
                    String src = select.attr("src");
                    anjukeCommunityReality.setPicSrc(src);
                    list.add(anjukeCommunityReality);
                }
            }
        }
        return list;
    }


    /**
     * 解析户型图的页面
     *
     * @param document
     */
    public List<AnjukeCommunityLayout> parseModel(Document document) {
        List<AnjukeCommunityLayout> anjukeCommunityLayouts = new ArrayList<>();

        if (document != null) {
            Elements selects = document.select("div.chamber-contents>div.chamber-comm-mod");
            if (selects != null && !selects.isEmpty()) {
                //房型分组标签
                Elements selectsHd = selects.select("h3.hd");
                //房型的列表信息
                Elements selectsItem = selects.select("ul.list");

                if (selectsHd != null && !selectsHd.isEmpty() && selectsItem != null && !selectsItem.isEmpty()) {
                    for (int i = 0; i < selectsHd.size(); i++) {
                        try {
                            Element elementHd = selectsHd.get(i);
                            //房型分组
                            String textType = elementHd.text();
                            Element elementUl = selectsItem.get(i);

                            if (elementUl != null) {
                                Elements selectsLi = elementUl.select("li.item");
                                for (Element elementLi : selectsLi) {
                                    AnjukeCommunityLayout anjukeCommunityLayout = new AnjukeCommunityLayout();
                                    anjukeCommunityLayout.setId(UUID.randomUUID().toString());
                                    anjukeCommunityLayout.setBatchId("v1.0");
                                    anjukeCommunityLayout.setCreateTime(new Date());
                                    anjukeCommunityLayout.setRoomtype(textType);

                                    Elements selectImg = elementLi.select("div.img-box>img");
                                    if (selectImg != null) {
                                        //房型图的url
                                        String src = selectImg.attr("src");
                                        anjukeCommunityLayout.setPicSrc(src);
                                    }
                                    //房型
                                    Elements selectRoom = elementLi.select("p>span.room");
                                    if (selectRoom != null && selectRoom.size() != 0) {
                                        String room = selectRoom.text();
                                        anjukeCommunityLayout.setRoom(room);
                                    }
                                    //面积
                                    Elements selectArea = elementLi.select("p>span.area");
                                    if (selectArea != null && selectArea.size() != 0) {
                                        String area = selectArea.text();
                                        anjukeCommunityLayout.setArea(area);
                                    }
                                    //朝向
                                    Elements selectTowards = elementLi.select("p>span.towards");
                                    if (selectTowards != null && selectTowards.size() != 0) {
                                        String towards = selectTowards.text();
                                        anjukeCommunityLayout.setTowards(towards);
                                    }
                                    anjukeCommunityLayouts.add(anjukeCommunityLayout);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return anjukeCommunityLayouts;
    }

    /**
     * 解析详情页的url，获取详情信息
     * @param document
     * @return
     */
    public void parseDetail(Document document,AnjukeCommunityDetail anjukeCommunityDetail){
        if(document!=null){
            Elements elementsBasic = document.select("div#basic-infos-box>dl.basic-parms-mod");
            if(elementsBasic!=null && elementsBasic.size()!=0){
                Elements elementsDt = elementsBasic.get(0).select("dt");
                Elements elementsDd = elementsBasic.get(0).select("dd");
                if(elementsBasic!=null){
                    for (int i=0;i< elementsDd.size();i++) {
                        try {
                            Element dt = elementsDt.get(i);
                            Element dd = elementsDd.get(i);
                            String strDt = dt.text().trim();
                            String strDd = dd.text();
                            if("物业类型：".equals(strDt)){
                                //物业类型
                                anjukeCommunityDetail.setPropertyType(strDd);
                                continue;
                            }else if("总户数：".equals(strDt)){
                                anjukeCommunityDetail.setHomeTotal(strDd);
                                continue;
                            }else if("开  发  商：".equals(strDt)){
                                anjukeCommunityDetail.setBuildDevelopers(strDd);
                                continue;
                            }else if("总建面积：".equals(strDt)){
                                anjukeCommunityDetail.setBuildArea(strDd);
                                continue;
                            }else if("容  积  率：".equals(strDt)){
                                anjukeCommunityDetail.setPlotRate(strDd);
                                continue;
                            }else if("绿化率：".equals(strDt)){
                                anjukeCommunityDetail.setGreenRate(strDd);
                                continue;
                            }else if("物业公司：".equals(strDt)){
                                anjukeCommunityDetail.setPropertyCompany(strDd);
                                continue;
                            }else if("物业费：".equals(strDt)){
                                anjukeCommunityDetail.setPropertyPrice(strDd);
                                continue;
                            }else if("停车位：".equals(strDt)){
                                anjukeCommunityDetail.setParkNum(strDd);
                                continue;
                            }else if("相关学校：".equals(strDt)){
                                anjukeCommunityDetail.setDuikouSchool(strDd);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }




    /**
     * 解析分页链接，获取列表中的详情链接(每页有三十条数据)
     * @param document
     * @return
     */
    public List<AnjukeCommunityList> parsePage(Document document){
        //存放列表下的详情种子链接
        List<AnjukeCommunityList> listDetail= new ArrayList<>();
        if(document==null){
            return listDetail;
        }else{
            //获取上海城,区域下的细分种子链接
            Elements elements = document.select("div#list-content>div.li-itemmod");
            if(!elements.isEmpty()){
                for (Element element : elements) {
                    AnjukeCommunityList anjukeCommunityList = new AnjukeCommunityList();
                    anjukeCommunityList.setId(UUID.randomUUID().toString());
                    anjukeCommunityList.setBatchId("v1.0");
                    anjukeCommunityList.setCreateTime(new Date());
                    //缩略图
                    Elements selectThumbUrl = element.select("a.img>img.thumbnail");
                    if(selectThumbUrl!=null){
                        String thumbUrl = selectThumbUrl.attr("src");
                        anjukeCommunityList.setThumbUrl(thumbUrl);
                    }
                    //详细信息
                    //url
                    String href = element.select("div.li-info>h3>a").attr("href");
                    anjukeCommunityList.setDetailUrl(href);
                    System.out.println("列表的详情页种子链接"+href);

                    //名称
                    String name = element.select("div.li-info>h3>a").text();
                    anjukeCommunityList.setHomeName(name);

                    //地址信息
                    String address = element.select("div.li-info>address").text();
                    anjukeCommunityList.setAddress(address);
                    System.out.println("名称"+address);

                    //竣工时间
                    String date = element.select("div.li-info>p.date").text();
                    anjukeCommunityList.setBuildYear(date);
                    //价格
                    Elements selectPrice = element.select("div.li-side>p>strong");
                    if(!selectPrice.isEmpty()){
                        String price = selectPrice.text();
                        anjukeCommunityList.setAveragePrice(price);
                        System.out.println("价格"+price);
                    }
                    Elements selectLoopPrice = element.select("div.li-side>p.price-txt");
                    //环比上个月的增幅
                    if(selectLoopPrice!=null){
                        String loopPrice = selectLoopPrice.text();
                        anjukeCommunityList.setLoopPosition(loopPrice);
                    }

                    listDetail.add(anjukeCommunityList);
                }
            }
            return listDetail;
        }
    }



    /**
     * 解析区域下的细分种子链接,获取分页数目
     * @param document
     * @return
     */
    public Integer parsePlatePage(Document document){
        //获取当前区域下的小区数目
        Integer regionNum =0;
        if(document==null){
            return regionNum;
        }else{
            Elements elements = document.select("div#list-content>div.sortby>span.tit>em");
            if(elements!=null && elements.size()>1){
                Element element = elements.get(1);
                String numStr = element.text();
                if(StringUtils.isNotBlank(numStr)){
                    regionNum = Integer.parseInt(numStr);
                }
            }
            Integer regionPageNum = regionNum%30 == 0 ? regionNum/30 : regionNum/30+1;
            return regionPageNum;
        }
    }


    /**
     * 解析主链接，获取区域下的板块种子链接
     * @param document
     * @return
     */
    public List<Map<String,Object>> parseRegionPage(Document document){
        //存放区域下的细分种子链接
        List<Map<String,Object>> listPlate= new ArrayList<Map<String,Object>>();
        if(document==null){
            return listPlate;
        }else {
            //获取上海城,区域下的细分种子链接
            Elements elements = document.select("div.items>span.elems-l.pp-mod>div.sub-items>a").not("a.selected-item");
            if(!elements.isEmpty() && elements.size()>0){
                for (Element elementHref : elements) {
                    Map<String,Object> map=new HashMap<String,Object>();
                    String hrefPlate = elementHref.attr("href");
                    System.out.println("请求解析区域链接，获取板块链接---"+hrefPlate);
                    String plate = elementHref.text();
                    if(StringUtils.isNotBlank(hrefPlate) && StringUtils.isNotBlank(plate)){
                        map.put("hrefPlate", hrefPlate);
                        map.put("plate", plate);
                        listPlate.add(map);
                    }
                }
            }else{
                System.out.println(document);
            }
            return listPlate;
        }
    }


    /**
     * 解析主链接，获取区域种子链接
     * @param document
     * @return
     */
    public List<Map<String,Object>> parseIndexPage(Document document){
        //存放区域的种子链接
        List<Map<String,Object>> listRegion= new ArrayList<Map<String,Object>>();
        if(document==null){
            return null;
        }else{
            //获取上海城,区域的种子链接
            Elements selects = document.select("div.items>span.elems-l.pp-mod");
            if(!selects.isEmpty() && selects.size()>0){
                //获取城市的区域部分span标签
                Element elementCcommunity = selects.get(0);
                //获取城市的区域种子链接
                Elements elementHrefs = elementCcommunity.select("a").not("a.selected-item");
                for (Element elementHref : elementHrefs) {
                    Map<String,Object> map=new HashMap<>();
                    String hrefRegion = elementHref.attr("href");
                    System.out.println("请求解析主链接，获取区域链接+++"+hrefRegion);
                    String region = elementHref.text();
                    if(StringUtils.isNotBlank(hrefRegion) && StringUtils.isNotBlank(region)){
                        map.put("hrefRegion",hrefRegion);
                        map.put("region",region);
                        listRegion.add(map);
                    }
                }
            }
            return listRegion;
        }
    }


}
