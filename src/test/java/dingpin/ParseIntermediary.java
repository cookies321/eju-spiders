package dingpin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.DownLoadPage;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.dao.DianpingIntermediaryMapper;
import com.tt.entity.DianpingIntermediary;
import com.tt.entity.DianpingIntermediaryExample;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.*;

/**
 * 获取大众点评中 房产中介信息
 * @Auther: 赵乐
 * @Date: 2018/10/24 11:13
 * @Description:
 */
public class ParseIntermediary {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        DianpingIntermediaryMapper dianpingIntermediaryMapper = (DianpingIntermediaryMapper)applicationContext.getBean("dianpingIntermediaryMapper");

        String url="http://www.dianping.com/shanghai/ch80/g33970r3";
        String city="上海";
        //添加头部信息
        Map<String,String> headers=new HashMap<>();
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        headers.put("Cookie","s_ViewType=10; _lxsdk_cuid=1667586e694c8-00e4969aba7624-43450521-1fa400-1667586e694c8; _lxsdk=1667586e694c8-00e4969aba7624-43450521-1fa400-1667586e694c8; _hc.v=d56625c3-a595-81a2-6d35-35cf228cef8e.1539570067; cityid=1; default_ab=shop%3AA%3A1%7CshopList%3AA%3A1%7Cmap%3AA%3A1; m_flash2=1; __utma=1.1437795818.1540373702.1540373702.1540373702.1; __utmc=1; __utmz=1.1540373702.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _lx_utm=utm_source%3DDP_KnowsNav; citypinyin=shanghai; cityname=5LiK5rW3; pvhistory=6L+U5ZuePjo8L2Vycm9yL2Vycm9yX3BhZ2U+OjwxNTQwNDUyMzU5ODc0XV9b; msource=default; _lxsdk_s=166becc5783-cf3-d6f-794%7C%7C26");

        Document document = DownLoadPage.downLoadPage(url,headers);
        if(document!=null){
            List<Map<String, Object>> list = parseIndex(document);
            //解析区域板块的链接，获取板块链接
            if(list!=null && list.size()!=0){
                for (Map<String, Object> map : list) {
                    String region = (String) map.get("region");
                    String hrefRegion = (String) map.get("hrefRegion");

                    System.out.println(region+"---区域链接---"+hrefRegion);
                    if(StringUtils.isNotBlank(region) && StringUtils.isNotBlank(hrefRegion)){
                        Document documentRegion = DownLoadPage.downLoadPage(hrefRegion,headers);
                        if(documentRegion!=null){
                            List<Map<String, Object>> listPlat = parseRegion(documentRegion);
                            if(listPlat!=null){
                                for (Map<String, Object> stringObjectMap : listPlat) {
                                    String plat = (String) stringObjectMap.get("plat");
                                    String hrefPlat = (String) stringObjectMap.get("hrefPlat");
                                    System.out.println(plat+"-----板块链接----"+hrefPlat);
                                    //解析板块链接,获取分页链接
                                    if(StringUtils.isNotBlank(plat) && StringUtils.isNotBlank(hrefPlat)){
                                        Document documentPlate = DownLoadPage.downLoadPage(hrefPlat, headers);
                                        List<String> listPage = parsePlate(documentPlate, hrefPlat);
                                        //解析分页链接，获取详情链接
                                        if(listPage!=null && listPage.size()!=0){
                                            for (String hrefPage : listPage) {
                                                Document documentPage = DownLoadPage.downLoadPage(hrefPage,headers);
                                                List<String> listDetail = parsePage(documentPage);
                                                //解析详情页链接
                                                if(listDetail!=null){
                                                    for (String hrefDetail : listDetail) {

                                                        DianpingIntermediary dianpingIntermediary = new DianpingIntermediary();
                                                        dianpingIntermediary.setId(UUID.randomUUID().toString());
                                                        dianpingIntermediary.setCity(city);
                                                        dianpingIntermediary.setRegion(region);
                                                        dianpingIntermediary.setPlate(plat);
                                                        dianpingIntermediary.setUrl(hrefDetail);
                                                        dianpingIntermediary.setCreateDate(new Date());

                                                        Document documentDetail = DownLoadPage.downLoadPage(hrefDetail,headers);
                                                        if(documentDetail!=null){
                                                            parseDetail(documentDetail,dianpingIntermediary);
                                                            dianpingIntermediaryMapper.insert(dianpingIntermediary);
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
                }
            }
        }
        //补充数据
        //http://m.dianping.com/shop/76184140
        /*DianpingIntermediaryExample dianpingIntermediaryExample = new DianpingIntermediaryExample();
        DianpingIntermediaryExample.Criteria criteria = dianpingIntermediaryExample.createCriteria();
        criteria.andStatusIsNull();

        List<DianpingIntermediary> dianpingIntermediaries = dianpingIntermediaryMapper.selectByExample(dianpingIntermediaryExample);
        System.out.println(dianpingIntermediaries.size());

        Integer num=1;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for (DianpingIntermediary dianpingIntermediary : dianpingIntermediaries) {
            semaphore.acquire();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String urlDetail = dianpingIntermediary.getUrl();
                        Thread.sleep(6000);
                        Document documentPlate = DownLoadPage.downLoadPage(urlDetail, headers);
                        if(documentPlate!=null){
                            parseDetail(documentPlate,dianpingIntermediary);
                            //更新
                            if(StringUtils.isNotBlank(dianpingIntermediary.getTitle())){
                                dianpingIntermediary.setStatus("1");
                                dianpingIntermediaryMapper.updateByPrimaryKeySelective(dianpingIntermediary);
                            }else{
                                dianpingIntermediary.setStatus("2");
                                dianpingIntermediaryMapper.updateByPrimaryKeySelective(dianpingIntermediary);
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
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
       */

    }
    /**
     *
     * 功能描述: 解析详情链接，获取名称和手机号
     *
     * @param: 
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/24 16:27
     */
    private static void parseDetail(Document documentDetail,DianpingIntermediary dianpingIntermediary) {
        if(documentDetail!=null){
            //先从json字符串中获取值
            String shopName ="";
            String address ="";
            String phoneNum ="";
            Elements select1 = documentDetail.select("textarea#shop-detail");
            //取json值
            if(!select1.isEmpty()){
                String text = select1.text();
                JSONObject object = JSON.parseObject(text);
                shopName = object.getString("shopName");
                address = object.getString("address");
                phoneNum = object.getString("phoneNum");
            }

            if(StringUtils.isBlank(shopName)){
                Elements select = documentDetail.select("div.J_baseinfo>div.shopInfoPagelet>div.shopPicBg>h1");
                if(select!=null && select.size()!=0){
                    String name = select.text();
                    dianpingIntermediary.setTitle(name);
                    System.out.println(name+"-------"+"名称");
                }else{
                    System.out.println(documentDetail);
                }
            }
            //获取json信息失败，去标签信息
            if(StringUtils.isBlank(address)){
                Elements selectAddress = documentDetail.select("div.J_address>div.details-mode.info-address>div.info-list.link-list>a");
                if(!selectAddress.isEmpty()){
                    address = selectAddress.text();
                    dianpingIntermediary.setAddress(address);
                    System.out.println(address+"-------"+"地址");
                }
            }
            //手机号存在多个模板
            Elements selectPhone = documentDetail.select("div.J_phone>div.details-mode.info-address>div.info-list.link-list>div.aboutPhone>div.aboutPhoneNum>a");
            if(selectPhone==null || selectPhone.size()==0){
                selectPhone=documentDetail.select("div.J_phone>div.details-mode.info-address>div.info-list.link-list>div>a.item");
            }
            if(!selectPhone.isEmpty()){
                StringBuffer stringBuffer = new StringBuffer();
                for (Element element : selectPhone) {
                    try {
                        String href = element.attr("href");
                        if(StringUtils.isNotBlank(href)){
                            String replace = href.replace("tel:", "");
                            stringBuffer.append(replace+" ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String phone = stringBuffer.toString();
                if(StringUtils.isBlank(phone)){
                    phone=phoneNum;
                }
                dianpingIntermediary.setPhone(phone);
                System.out.println(phone+"-------"+"手机号");
            }else {
                System.out.println("selectPhone为空");
            }


        }
    }

    /**
     *
     * 功能描述: 解析分页链接，获取主页链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/24 13:53
     */
    private static List<String> parsePage(Document documentPage) {
        List<String> hrefDatail = new ArrayList<>();
        Elements selects = documentPage.select("div#shop-all-list>ul>li");
        if(selects!=null){
            System.out.println(documentPage);
            for (Element select : selects) {
                Elements select1 = select.select("div.txt>div.tit>a");
                if(select1!=null){
                    String href = select1.attr("href");
                    //去手机端链接
                    String replaceHref = href.replace("www", "m");
                    hrefDatail.add(replaceHref);
                }
            }
        }else{
            System.out.println(documentPage);
        }
        return hrefDatail;
    }

    private static List<String> parsePlate(Document documentPlate,String hrefPlat) {
        List<String> listPage=new ArrayList<>();
        //http://www.dianping.com/shanghai/ch80/g33970r22964
        //http://www.dianping.com/shanghai/ch80/g33970r812p2
        Integer pageNum=1;
        if(documentPlate!=null){
            Element last = documentPlate.select("div.page>a.PageLink").last();
            if(last!=null){
                String text = last.text();
                pageNum=Integer.valueOf(text);
            }else{
                System.out.println(documentPlate);
            }
        }
        for (int i = 1; i <=pageNum ; i++) {
            String hrefPage=hrefPlat+"p"+i;
            listPage.add(hrefPage);
        }
        return listPage;

    }

    /**
     *
     * 功能描述: 解析区域链接，获取板块链接
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/24 11:55
     */
    private static List<Map<String,Object>> parseRegion(Document documentRegion) {
        //板块的种子链接
        List<Map<String,Object>> listPlat= new ArrayList<Map<String,Object>>();
        if(documentRegion!=null){
            Elements elements = documentRegion.select("div#region-nav-sub>a").not("a.cur");
            if(elements!=null){
                for (Element element : elements) {
                    Map<String,Object> map=new HashMap<String,Object>();
                    String plat = element.text();
                    String hrefPlat = element.attr("href");
                    if(StringUtils.isNotBlank(plat) || StringUtils.isNotBlank(hrefPlat)){
                        map.put("plat",plat);
                        map.put("hrefPlat",hrefPlat);
                        listPlat.add(map);
                    }
                }
            }
        }

        return listPlat;
    }

    /**
     *
     * 功能描述: 解析主页链接，获取区域链接
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/10/24 11:38
     */
    private static List<Map<String,Object>> parseIndex(Document document) {
        //存放区域的种子链接
        List<Map<String,Object>> listRegion= new ArrayList<Map<String,Object>>();
        if(document!=null){
            Elements selects = document.select("div#region-nav>a");
            if(selects!=null){
                for (Element select : selects) {
                    Map<String,Object> map=new HashMap<String,Object>();
                    String textRegion = select.text();
                    String hrefRegion = select.attr("href");
                    if(StringUtils.isNotBlank(textRegion) || StringUtils.isNotBlank(hrefRegion)){
                        map.put("region",textRegion);
                        map.put("hrefRegion",hrefRegion);
                        listRegion.add(map);
                    }
                }
            }else{
                System.out.println(document);
            }
        }
        return listRegion;
    }
}
