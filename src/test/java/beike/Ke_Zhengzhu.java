package beike;

import com.tt.common.utils.PageDownLoadUtil;
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

import java.util.ArrayList;
import java.util.List;

/**
 * 贝壳的整租（拼住项目组）
 * @Auther: 赵乐
 * @Date: 2018/11/19 17:45
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class Ke_Zhengzhu {

    @Autowired
    @Qualifier("ipPoolProxy")
    //@Qualifier("moguProxy")
    private IDownLoadPage iDownLoadPage;

    @Test
    public void getIndex() {
        String url = "https://sh.zu.ke.com/zufang/ht1rt200600000001/?showMore=1";
        Document document = iDownLoadPage.downLoadPageByGet(url);
        //区域链接的url
        List<String> list = parseIndex(document);
        for (String regionUrl:list){
            Document regionDocument = iDownLoadPage.downLoadPageByGet(regionUrl);
            //解析区域链接，获取板块链接
            List<String> list1 = parseRegion(regionDocument);
            for (String plateUrl : list1) {
                System.out.println(plateUrl);
                Document plateDocument = iDownLoadPage.downLoadPageByGet(plateUrl);
                //解析板块链接，获取分页链接
                //https://sh.zu.ke.com/zufang/caojiadu/ht1rt200600000001/
                //https://sh.zu.ke.com/zufang/caojiadu/ht1pg2rt200600000001/#contentList
                Integer pageNum = parsePlate(plateDocument);
                for (int i = 1; i <=pageNum; i++) {
                    //分页url
                    String pageUrl = plateUrl.replace("ht1rt200600000001", "ht1pg" + i + "rt200600000001");
                    Document pageDocument = iDownLoadPage.downLoadPageByGet(pageUrl);
                    //解析分页url,获取详情url
                    List<String> list2 = parsePage(pageDocument);
                    for (String detailUrl : list2) {
                        Document detailDocument = iDownLoadPage.downLoadPageByGet(detailUrl);
                        //两种模板
                        if(detailUrl.contains("zufang")){
                            parseDetailZhufang(detailDocument);
                        }else {
                            parseDetail(detailDocument);
                        }
                    }
                }
            }
        }


    }
    /**
     *
     * 功能描述: 解析模板二
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/19 18:35
     */
    private void parseDetail(Document detailDocument) {
        if(detailDocument!=null){
            //title名称
            String title = detailDocument.select("p.content__aside--title>span.aside_neme").text();
            //价格
            String price = detailDocument.select("p.content__aside--title>span").not("span.aside_neme").text();
            //地址
            String address = detailDocument.select("p.flat__info--subtitle.online").text();
            //管家姓
            String name = detailDocument.select("p.content__aside__list--title.oneline>span.contact_name").text();
            //手机号
            String phonef = detailDocument.select("p[data-el=updatePhone]").text();

        }
    }
    /**
     *
     * 功能描述: 解析模板一
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/19 18:35
     */
    private void parseDetailZhufang(Document detailDocument) {
        if(detailDocument!=null){
            //名称
            String title = detailDocument.select("p.content__title").text();
            //价格
            String price = detailDocument.select("p.content__aside--title>span").text();
            //管家姓名
            String name = detailDocument.select("div.content__aside__list--title.oneline>span.contact_name").text();
            //管家的手机
            String phone = detailDocument.select("p.content__aside__list--bottom oneline").text();

        }

    }

    /**
     *
     * 功能描述: 解析分页页面，获取detail
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/19 18:29
     */
    private List<String> parsePage(Document pageDocument) {
        List<String> list = new ArrayList<>();
        if(pageDocument!=null){
            Elements select = pageDocument.select("div.content__list>div.content__list--item>a");
            if(!select.isEmpty()){
                String href = select.attr("href");
                if(StringUtils.isNotBlank(href)){
                    String detailUrl="https://sh.zu.ke.com"+href;
                    list.add(detailUrl);
                }
            }
        }
        return list;
    }

    /**
     *
     * 功能描述:
     * 解析板块链接,获取分页链接
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/19 18:11
     */
    private Integer parsePlate(Document plateDocument) {
        Integer pageNum=0;
        if(plateDocument!=null){
            String text = plateDocument.select("p.content__title>span.content__title--hl").text();
            Integer count = Integer.parseInt(text);
            pageNum= count%30==0? count/30:count/30+1;
        }
        return pageNum;
    }

    /**
     *
     * 功能描述: 
     *  解析区域链接，获取板块链接
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/19 17:57
     */
    private List<String> parseRegion(Document regionDocument) {
        List<String> list=new ArrayList<>();
        if(regionDocument!=null){
            Elements select = regionDocument.select("div#filter>ul[data-target=area]");
            if(select.size()>1){
                Element element = select.get(1);
                Elements li = element.select("li").not("li.filter__item--level3.filter__item--aside.strong");
                if(!li.isEmpty()){
                    for (Element element1 : li) {
                        String plate = element1.select("a").text();
                        String plateUrl = element1.select("a").attr("href");
                        if(StringUtils.isNotBlank(plateUrl)){
                            plateUrl="https://sh.zu.ke.com"+plateUrl;
                        }
                        System.out.println(plate+plateUrl);
                        list.add(plateUrl);
                    }
                }
            }
        }
        return list;
    }

    /**
     *
     * 功能描述: 
     * 解析主页url，获取区域链接
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/19 17:54
     */
    private List<String> parseIndex(Document document) {
        List<String> list = new ArrayList<>();
        if(document!=null){
            Elements select = document.select("div#filter>ul[data-target=area]>li").not("li.filter__item--level2.filter__item--aside.strong");
            if(!select.isEmpty()){
                for (Element element : select) {
                    String region = element.select("a").text();
                    String regionUrl = element.select("a").attr("href");
                    if(StringUtils.isNotBlank(regionUrl)){
                        regionUrl="https://sh.zu.ke.com"+regionUrl;
                    }
                    System.out.println(region+ regionUrl);
                    list.add(regionUrl);
                }
            }
        }
        return list;
    }
}
