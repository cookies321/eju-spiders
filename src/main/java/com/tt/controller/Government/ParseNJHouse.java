package com.tt.controller.Government;

import com.eju.houseparent.common.security.MD5;
import com.tt.common.utils.NumUtils;
import com.tt.common.utils.UserAgentUtils;
import com.tt.dao.*;
import com.tt.entity.*;
import com.tt.service.IDownLoadPage;
import com.tt.service.IEssUploadService;
import com.tt.vo.Context;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static com.eju.houseparent.common.utils.ImageReaderUtils.imgUrlUpdate;

/**
 * 获取南京政府网站的房地产信息
 * @Auther: 赵乐
 * @Date: 2018/11/21 17:11
 * @Description:
 */
@RestController
public class ParseNJHouse {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;

    @Autowired
    private CommunityFdNjListMapper communityFdNjListMapper;

    @Autowired
    private CommunityFdNjDetailMapper communityFdNjDetailMapper;

    @Autowired
    private CommunityFdNjSalesMapper communityFdNjSalesMapper;

    @Autowired
    private CommunityFdNjBuildingMapper communityFdNjBuildingMapper;

    @Autowired
    private CommunityFdNjHouseMapper communityFdNjHouseMapper;

    @Autowired
    private CommunityFdNjPicMapper communityFdNjPicMapper;

    @Autowired
    private IEssUploadService iEssUploadService;


    
    /**
     *
     * 功能描述: 功能描述: 解析主页页面,获取详情页链接（楼栋信息）
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/22 11:16
     */
    //@Test
    public void parseIndex() throws InterruptedException {
        String url="http://www.njhouse.com.cn/2016/spf/list.php?dist=&use=0&saledate=&pgno=";

        List<String> user_agent=new ArrayList<>();
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        Integer pageNum=80;
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (int i = 1; i <= pageNum; i++) {
            int finalI = i;
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                        Document document = iDownLoadPage.downLoadPageByGet(url+ finalI,"gbk",map);
                        //解析主页
                        List<CommunityFdNjList> communityFdNjLists = parseIndexDocument(document);
                        if(communityFdNjLists.size()!=0){
                            for (CommunityFdNjList communityFdNjList : communityFdNjLists) {
                                communityFdNjList.setSource(finalI+"");
                                communityFdNjListMapper.insertSelective(communityFdNjList);
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
     * 功能描述: 解析楼盘的详情url，获取详细信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/27 14:53
     */
    @Test
    public void parseLoudongDetail() throws InterruptedException {
        CommunityFdNjListExample communityFdNjListExample = new CommunityFdNjListExample();
        communityFdNjListExample.or().andStatusIsNull();
        List<CommunityFdNjList> communityFdNjLists = communityFdNjListMapper.selectByExample(communityFdNjListExample);
        System.out.println(communityFdNjLists.size());

        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdNjList communityFdNjList : communityFdNjLists) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String city = communityFdNjList.getCity();
                        String region = communityFdNjList.getRegion();
                        String title = communityFdNjList.getTitle();
                        String titleId = communityFdNjList.getTitleId();
                        List<String> user_agent=new ArrayList<>();
                        user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

                        HashMap<String, String> map = new HashMap<>();
                        map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                        String url=communityFdNjList.getDetailUrl();
                        Document document = iDownLoadPage.downLoadPageByGet(url,map);

                        CommunityFdNjDetail communityFdNjDetail = new CommunityFdNjDetail();
                        communityFdNjDetail.setId(UUID.randomUUID().toString());
                        communityFdNjDetail.setCreateTime(new Date());
                        communityFdNjDetail.setBatchId("v1.0");
                        communityFdNjDetail.setCity(city);
                        communityFdNjDetail.setRegion(region);
                        communityFdNjDetail.setTitle(title);
                        communityFdNjDetail.setTitleId(titleId);
                        parseDetail(document,communityFdNjDetail);
                        String layoutUrl="http://www.njhouse.com.cn/2016/spf/tx.php?prjid="+titleId;
                        communityFdNjDetail.setXiaoquLayoutPhotoUrl(layoutUrl);
                        if(StringUtils.isNotBlank(communityFdNjDetail.getLandUsePermit())){
                            int i = communityFdNjDetailMapper.insertSelective(communityFdNjDetail);
                            if(i==1){
                                communityFdNjList.setStatus("1");
                                communityFdNjListMapper.updateByPrimaryKeySelective(communityFdNjList);
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
     * 功能描述: 解析楼盘的许可/备案证公示
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/27 17:11
     */
    @Test
    public void parseLoudongSales() throws InterruptedException {
        CommunityFdNjListExample communityFdNjListExample = new CommunityFdNjListExample();
        communityFdNjListExample.or().andStatusEqualTo("2");
        List<CommunityFdNjList> communityFdNjLists = communityFdNjListMapper.selectByExample(communityFdNjListExample);
        System.out.println(communityFdNjLists.size());

        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdNjList communityFdNjList : communityFdNjLists) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String title = communityFdNjList.getTitle();
                        String titleId = communityFdNjList.getTitleId();
                        List<String> user_agent=new ArrayList<>();
                        user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
                        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

                        HashMap<String, String> map = new HashMap<>();
                        map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));

                        String url="http://www.njhouse.com.cn/2016/spf/persalereg_list.php?prjid="+titleId;

                        Document document = iDownLoadPage.downLoadPageByGet(url,map);

                        if(document!=null){
                            Elements select = document.select("div.spl_table>table>tbody");
                            if(!select.isEmpty()){
                                for (Element element : select) {
                                    CommunityFdNjSales communityFdNjSales = new CommunityFdNjSales();
                                    communityFdNjSales.setId(UUID.randomUUID().toString());
                                    communityFdNjSales.setCreateTime(new Date());
                                    communityFdNjSales.setBatchId("v1.0");
                                    communityFdNjSales.setTitle(title);
                                    communityFdNjSales.setTitleId(titleId);

                                    Elements select1 = element.select("tr>td.pcolor");
                                    if(!select1.isEmpty()){
                                        for (Element element1 : select1) {
                                            String tag = element1.text();
                                            String text = element1.nextElementSibling().text();
                                            switch (tag){
                                                case "编号":
                                                    communityFdNjSales.setPermitId(text);
                                                    break;
                                                case "售房单位":
                                                    communityFdNjSales.setBuildDevelopers(text);
                                                    break;
                                                case "区属":
                                                    communityFdNjSales.setRegion(text);
                                                    break;
                                                case "房屋坐落地点":
                                                    communityFdNjSales.setAddress(text);
                                                    break;
                                                case "土地使用证号":
                                                    communityFdNjSales.setLandPropertyCertificate(text);
                                                    break;
                                                case "拟开盘时间":
                                                    communityFdNjSales.setNewOpenTime(text);
                                                case "土地使用年限":
                                                    communityFdNjSales.setPropertyYear(text);
                                                case "房屋用途性质":
                                                    communityFdNjSales.setPropertyType(text);
                                                case "规划许可证号":
                                                    communityFdNjSales.setLandUsePermit(text);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                        int i = communityFdNjSalesMapper.insertSelective(communityFdNjSales);
                                        if(i==1){
                                            communityFdNjList.setStatus("1");
                                            communityFdNjListMapper.updateByPrimaryKeySelective(communityFdNjList);
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
     * 功能描述: 解析小区的相关图片信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/29 11:56
     */
    @Test
    public void parseCommunityPic() throws InterruptedException {
        List<String> user_agent=new ArrayList<>();
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
        user_agent.add("Mozilla/5.0 (X11; CrOS i686 4319.74.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        CommunityFdNjListExample communityFdNjListExample = new CommunityFdNjListExample();
        communityFdNjListExample.or().andStatusEqualTo("1");
        List<CommunityFdNjList> communityFdNjLists = communityFdNjListMapper.selectByExample(communityFdNjListExample);
        System.out.println(communityFdNjLists.size());
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdNjList communityFdNjList : communityFdNjLists) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String title = communityFdNjList.getTitle();
                        String titleId = communityFdNjList.getTitleId();
                        //鸟瞰图
                        try {
                            String niaokanPic="http://www.njhouse.com.cn/spf/niaokan/map/"+titleId+".jpg";
                            CommunityFdNjPic communityFdNjPic = new CommunityFdNjPic();
                            communityFdNjPic.setId(UUID.randomUUID().toString());
                            communityFdNjPic.setCreateTime(new Date());
                            communityFdNjPic.setTitle(title);
                            communityFdNjPic.setTitleId(titleId);
                            communityFdNjPic.setPicSrc(niaokanPic);
                            communityFdNjPic.setSource("niaokantu");
                            communityFdNjPicMapper.insertSelective(communityFdNjPic);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            //区位图
                            Map<String, String> map = new HashMap<>();
                            map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                            String qwtUrl="http://www.njhouse.com.cn/2016/spf/qwt.php?prjid="+titleId;
                            Document document = iDownLoadPage.downLoadPageByGet(qwtUrl, map);
                            Elements select = document.select("div.spf_block_list.qwt>p>img");
                            if(!select.isEmpty()){
                                //   ../.././upload/chart/68/07eece921bbd93a012f00d614856d344.jpg
                                String src = select.attr("src");
                                String replace = src.replace("../../.", "http://www.njhouse.com.cn");
                                if(replace.startsWith("http")){
                                    CommunityFdNjPic communityFdNjPic = new CommunityFdNjPic();
                                    communityFdNjPic.setId(UUID.randomUUID().toString());
                                    communityFdNjPic.setCreateTime(new Date());
                                    communityFdNjPic.setTitle(title);
                                    communityFdNjPic.setTitleId(titleId);
                                    communityFdNjPic.setPicSrc(replace);
                                    communityFdNjPic.setSource("quweitu");
                                    communityFdNjPicMapper.insertSelective(communityFdNjPic);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        try {
                            //效果图
                            Map<String, String> map = new HashMap<>();
                            map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                            String qwtUrl="http://www.njhouse.com.cn/2016/spf/showpic.php?prjid="+titleId;
                            Document document = iDownLoadPage.downLoadPageByGet(qwtUrl, map);

                            Elements select = document.select("div.sdd-photo-top>img");
                            if(!select.isEmpty()){
                                for (Element element : select) {
                                    //   ../../../.././upload/chart/68/31e6f701a24c7ab9928ac5a7f7e5cb74.jpg
                                    String src = element.attr("src");
                                    String replace = src.replace("../../../../.", "http://www.njhouse.com.cn");
                                    if(replace.startsWith("http")){
                                        CommunityFdNjPic communityFdNjPic = new CommunityFdNjPic();
                                        communityFdNjPic.setId(UUID.randomUUID().toString());
                                        communityFdNjPic.setCreateTime(new Date());
                                        communityFdNjPic.setTitle(title);
                                        communityFdNjPic.setTitleId(titleId);
                                        communityFdNjPic.setPicSrc(replace);
                                        communityFdNjPic.setSource("xiaoguotu");
                                        communityFdNjPicMapper.insertSelective(communityFdNjPic);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            //套型图
                            Map<String, String> map = new HashMap<>();
                            map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                            String qwtUrl="http://www.njhouse.com.cn/2016/spf/tx.php?prjid="+titleId;
                            Document document = iDownLoadPage.downLoadPageByGet(qwtUrl, map);

                            Elements select = document.select("ul.clearfix>li>img");
                            if(!select.isEmpty()){
                                for (Element element : select) {
                                    //   ../.././upload/build_type/103/184dda642882d9cc6f2eb44ce86e8923.jpg
                                    String src = element.attr("src");
                                    String replace = src.replace("../../.", "http://www.njhouse.com.cn");
                                    if(replace.startsWith("http")){
                                        CommunityFdNjPic communityFdNjPic = new CommunityFdNjPic();
                                        communityFdNjPic.setId(UUID.randomUUID().toString());
                                        communityFdNjPic.setCreateTime(new Date());
                                        communityFdNjPic.setTitle(title);
                                        communityFdNjPic.setTitleId(titleId);
                                        communityFdNjPic.setPicSrc(replace);
                                        communityFdNjPic.setSource("taoxingtu");
                                        communityFdNjPicMapper.insertSelective(communityFdNjPic);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        communityFdNjList.setStatus("2");
                        communityFdNjListMapper.updateByPrimaryKeySelective(communityFdNjList);
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
     * 功能描述: 解析楼栋销售公示,获取楼栋信息
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/22 11:21
     */
    @Test
    public void parseLoudongBuild() throws InterruptedException {
        List<String> user_agent=new ArrayList<>();
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
        user_agent.add("Mozilla/5.0 (X11; CrOS i686 4319.74.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        CommunityFdNjListExample communityFdNjListExample = new CommunityFdNjListExample();
        communityFdNjListExample.or().andStatusIsNull();
        List<CommunityFdNjList> communityFdNjLists = communityFdNjListMapper.selectByExample(communityFdNjListExample);
        System.out.println(communityFdNjLists.size());


        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdNjList communityFdNjList : communityFdNjLists) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String title = communityFdNjList.getTitle();
                        String titleId = communityFdNjList.getTitleId();

                        String url="http://www.njhouse.com.cn/2016/spf/sales.php?prjid="+titleId;

                        HashMap<String, String> map = new HashMap<>();
                        map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                        Document document = iDownLoadPage.downLoadPageByGet(url,"gbk",map);
                        Elements select = document.select("div.fdxs>ul>li");
                        if(!select.isEmpty()){
                            for (Element element : select) {
                                CommunityFdNjBuilding communityFdNjBuilding = new CommunityFdNjBuilding();
                                communityFdNjBuilding.setId(UUID.randomUUID().toString());
                                communityFdNjBuilding.setCreateTime(new Date());
                                communityFdNjBuilding.setTitle(title);
                                communityFdNjBuilding.setTitleId(titleId);
                                communityFdNjBuilding.setBatchId("v1.0");

                                Elements select1 = element.select("div.fdxs_left>a");
                                String href = select1.attr("href");
                                String text = select1.text();
                                if(StringUtils.isNotBlank(href)){
                                    String buildUrl="http://www.njhouse.com.cn/2016/spf/"+href;
                                    communityFdNjBuilding.setBuildingId(buildUrl);
                                    communityFdNjBuilding.setBuilding(text);
                                    System.out.println(text+"==="+buildUrl);


                                }

                                Element td = element.select("table.fdxs_right>tbody>tr").not("tr.fdxs-tr").select("td").first();
                                if(td!=null){
                                    String openTime = td.text();
                                    communityFdNjBuilding.setNewOpenTime(openTime);
                                    System.out.println(openTime);
                                }

                                //插入数据库
                                int i = communityFdNjBuildingMapper.insertSelective(communityFdNjBuilding);
                                if(i==1){
                                    communityFdNjList.setStatus("1");
                                    communityFdNjListMapper.updateByPrimaryKeySelective(communityFdNjList);
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
     * 功能描述:请求楼栋，获取房号信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/29 16:06
     */
    @Test
    public void parseBuildUrl() throws InterruptedException {
        List<String> user_agent=new ArrayList<>();
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1623.0 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36");
        user_agent.add("Mozilla/5.0 (X11; CrOS i686 4319.74.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
        user_agent.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        CommunityFdNjBuildingExample communityFdNjBuildingExample = new CommunityFdNjBuildingExample();
        communityFdNjBuildingExample.or().andStatusIsNull();
        List<CommunityFdNjBuilding> communityFdNjBuildings = communityFdNjBuildingMapper.selectByExample(communityFdNjBuildingExample);

        Integer num =4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdNjBuilding communityFdNjBuilding : communityFdNjBuildings) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Map<String, String> map = new HashMap<>();
                        map.put("User-Agent",user_agent.get(new Random().nextInt(user_agent.size())));
                        String loudongUrl = communityFdNjBuilding.getBuildingId();
                        String building = communityFdNjBuilding.getBuilding();

                        Document document = iDownLoadPage.downLoadPageByGet(loudongUrl,"gbk",map);
                        if(document!=null){
                            Elements select = document.select("table.ck_table>tbody>tr");
                            if(!select.isEmpty()){
                                for (Element element : select) {
                                    Element element1 = element.select("td").not("td.td_h").select("a").first();
                                    if(element1!=null){
                                        String text = element1.text();
                                        Integer houseId = NumUtils.getInteger(text);
                                        String href = element1.attr("href");
                                        if(StringUtils.isNotBlank(href)){
                                            String houseUrl="http://www.njhouse.com.cn/2016/spf/"+href;
                                            CommunityFdNjHouse communityFdNjHouse = new CommunityFdNjHouse();
                                            communityFdNjHouse.setId(UUID.randomUUID().toString());
                                            communityFdNjHouse.setCreateTime(new Date());
                                            communityFdNjHouse.setBatchId("v1.0");
                                            communityFdNjHouse.setBuilding(building);
                                            communityFdNjHouse.setBuildingId(loudongUrl);
                                            communityFdNjHouse.setHouseUrl(houseUrl);
                                            System.out.println(houseUrl);
                                            communityFdNjHouseMapper.insertSelective(communityFdNjHouse);
                                        }


                                    }
                                }
                                communityFdNjBuilding.setStatus("1");
                                communityFdNjBuildingMapper.updateByPrimaryKeySelective(communityFdNjBuilding);
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
     * 功能描述: 解析房号的详情信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/29 17:02
     */
    @RequestMapping("/parseHouseUrl")
    public void parseHouseUrl() throws InterruptedException {
        CommunityFdNjHouseExample communityFdNjHouseExample = new CommunityFdNjHouseExample();
        communityFdNjHouseExample.or().andHouseNameIsNull().andSourceEqualTo("one");
        List<CommunityFdNjHouse> communityFdNjHouses = communityFdNjHouseMapper.selectByExample(communityFdNjHouseExample);
        Integer num=10;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (CommunityFdNjHouse communityFdNjHouse : communityFdNjHouses) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        long startTime = System.currentTimeMillis();
                        Map<String, String> map = new HashMap<>();
                        map.put("User-Agent", UserAgentUtils.randomGet());
                        String houseUrl=communityFdNjHouse.getHouseUrl();
                        if(StringUtils.isBlank(houseUrl)){
                            return;
                        }
                        Document document = iDownLoadPage.downLoadPageByGet(houseUrl,"gbk", map);
                        if(document!=null){
                            Elements select = document.select("table>tbody>tr>td.colors");
                            if(!select.isEmpty()){
                                for (Element element : select) {
                                    String tag = element.text();
                                    String text = element.nextElementSibling().text();
                                    switch (tag){
                                        case "楼层":
                                            communityFdNjHouse.setRealFloor(text);
                                            System.out.println(text);
                                            break;
                                        case "房号":
                                            communityFdNjHouse.setHouseName(text);
                                            System.out.println(text);
                                            break;
                                        case "预测建筑面积":
                                            communityFdNjHouse.setPredictedArea(text);
                                            System.out.println(text);
                                            break;
                                        case "预测套内面积":
                                            communityFdNjHouse.setDwellingFloorSpace(text);
                                            System.out.println(text);
                                            break;
                                        case "预测分摊面积":
                                            communityFdNjHouse.setSharedBuildingArea(text);
                                            System.out.println(text);
                                            break;
                                        case "房屋类型":
                                            communityFdNjHouse.setPropertyType(text);
                                            System.out.println(text);
                                            break;
                                        case "参考价格":
                                            communityFdNjHouse.setPrice(text);
                                            System.out.println(text);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        long endTime = System.currentTimeMillis();
                        System.out.println(Thread.currentThread().getName()+"请求时间----"+(endTime-startTime));

                        communityFdNjHouse.setStatus("1");
                        communityFdNjHouseMapper.updateByPrimaryKeySelective(communityFdNjHouse);
                        long upTime = System.currentTimeMillis();
                        System.out.println(Thread.currentThread().getName()+"更新时间----"+(upTime-endTime));
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
     * 功能描述:图片存入存储桶
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/29 17:34
     */
    @Test
    public void picToLocal() throws InterruptedException {
        CommunityFdNjPicExample communityFdNjPicExample = new CommunityFdNjPicExample();
        communityFdNjPicExample.or().andStatusIsNull();
        List<CommunityFdNjPic> communityFdNjPics = communityFdNjPicMapper.selectByExample(communityFdNjPicExample);
        Integer num=4;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (CommunityFdNjPic communityFdNjPic : communityFdNjPics) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String picSrc = communityFdNjPic.getPicSrc();

                        if(StringUtils.isNotBlank(picSrc)){
                            String name = "fang/310000/community/"+ MD5.encrypt(picSrc,"") +".jpg";
                            byte[] data = null;

                            URL url = null;
                            InputStream is = null;
                            ByteArrayOutputStream outStream = null;
                            HttpURLConnection httpUrl = null;
                            try {
                                String path = imgUrlUpdate("[0-9]+x[0-9]+", "900x675", picSrc);
                                url = new URL(path);
                                httpUrl = (HttpURLConnection)url.openConnection();
                                httpUrl.setConnectTimeout(10000);
                                httpUrl.setRequestProperty("User-Agent", UserAgentUtils.randomGet());
                                is = httpUrl.getInputStream();
                                outStream = new ByteArrayOutputStream();
                                byte[] buffer = new byte[1024];

                                int len;
                                while((len = is.read(buffer)) != -1) {
                                    outStream.write(buffer, 0, len);
                                }

                                data = outStream.toByteArray();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }finally {
                                if (is != null) {
                                    try {
                                        is.close();
                                    } catch (IOException var20) {
                                        var20.printStackTrace();
                                    }
                                }

                                if (outStream != null) {
                                    try {
                                        outStream.close();
                                    } catch (IOException var19) {
                                        var19.printStackTrace();
                                    }
                                }

                                if (httpUrl != null) {
                                    httpUrl.disconnect();
                                }

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
                                System.out.println(newUrl);
                                communityFdNjPic.setPicUrl(newUrl);
                                communityFdNjPic.setStatus("1");
                                communityFdNjPicMapper.updateByPrimaryKeySelective(communityFdNjPic);
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
     * @date: 2018/11/27 14:54
     */
    private void parseDetail(Document document,CommunityFdNjDetail communityFdNjDetail) {
        if(document!=null){
            Elements select = document.select("table.spf_table>tbody>tr.style2>td.thead");
            if(!select.isEmpty()){
                for (Element element : select) {
                    String tag = element.text();
                    String text = element.nextElementSibling().text();
                    switch (tag){
                        case "项目地址":
                            communityFdNjDetail.setAddress(text);
                            break;
                        case "用途":
                            communityFdNjDetail.setPropertyType(text);
                            break;
                        case "开发企业":
                            communityFdNjDetail.setBuildDevelopers(text);
                            break;
                        case "代理销售企业":
                            communityFdNjDetail.setSalesCompany(text);
                            break;
                        case "最新拟开盘时间":
                            communityFdNjDetail.setNewOpenTime(text);
                            break;
                        case "预售许可证/ 现售备案证":
                            communityFdNjDetail.setPreSalePermit(text);
                            break;
                        case "土地使用权证/ 不动产权证书":
                            communityFdNjDetail.setLandPropertyCertificate(text);
                            break;
                        case "用地规划许可证":
                            communityFdNjDetail.setLandUsePermit(text);
                            break;
                        case "工程规划许可证":
                            communityFdNjDetail.setEngineeringPlanningPermit(text);
                            break;
                        case "施工许可证":
                            communityFdNjDetail.setBuilderLicence(text);
                            break;
                        default:
                            break;
                    }
                }
            }

            Elements select1 = document.select("table.xmgk>tbody>tr");
            if(!select1.isEmpty()){
                Element element = select1.get(0);
                Elements select2 = element.select("td");
                if(select2.size()==4){
                    String text = select2.get(1).text();
                    communityFdNjDetail.setPropertyCompany(text);
                    System.out.println(text);
                }
            }

        }
    }

    /**
     *
     * 功能描述: 解析主页页面,获取详情页（楼栋信息）
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/21 17:54
     */
    private List<CommunityFdNjList> parseIndexDocument(Document document) {
        List<CommunityFdNjList> list=new ArrayList<>();
        if(document!=null){
            Elements select = document.select("div.spl_table>table>tbody");
            if(!select.isEmpty()){
                for (Element element : select) {
                    Elements select1 = element.select("tr");
                    CommunityFdNjList communityFdNjList = new CommunityFdNjList();
                    communityFdNjList.setId(UUID.randomUUID().toString());
                    communityFdNjList.setBatchId("v1.0");
                    communityFdNjList.setCreateTime(new Date());
                    communityFdNjList.setCity("南京");
                    if(!select1.isEmpty()){
                        for (Element element1 : select1) {
                            Elements select2 = element1.select("td.pcolor");
                            if(!select2.isEmpty()){
                                for (Element element2 : select2) {
                                    //表格标签名称
                                    String tag = element2.text();
                                    Element element3 = element2.nextElementSibling();
                                    //表格value值
                                    String text = element3.text();

                                    switch (tag){
                                        case "项目名称":
                                            String href = element3.select("a").attr("href");
                                            if(StringUtils.isNotBlank(href)){
                                                String detialUrl="http://www.njhouse.com.cn/2016/spf/"+href;
                                                String titleId=href.substring(href.indexOf("prjid=")+6,href.length());
                                                communityFdNjList.setDetailUrl(detialUrl);
                                                communityFdNjList.setTitle(text);
                                                communityFdNjList.setTitleId(titleId);
                                                System.out.println(detialUrl);
                                                System.out.println(text);
                                            }
                                            break;
                                        case "区属":
                                            communityFdNjList.setRegion(text);
                                            System.out.println(text);
                                            break;
                                        /*case "最新许可证号":
                                            System.out.println(text);
                                            break;
                                        case "最新拟开盘时间":
                                            System.out.println(text);
                                            break;
                                        case "项目类别":
                                            System.out.println(text);
                                            break;
                                        case "销售热线":
                                            System.out.println(text);
                                            break;
                                        case "项目地址":
                                            System.out.println(text);
                                            break;*/
                                        default:
                                            break;
                                    }
                                }
                            }

                        }
                    }
                    if(StringUtils.isNotBlank(communityFdNjList.getDetailUrl())){
                        list.add(communityFdNjList);
                    }
                }
            }
        }
        return list;
    }

}
