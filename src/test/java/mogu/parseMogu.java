package mogu;

import com.tt.common.utils.NumUtils;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.service.IDownLoadPage;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/16 18:01
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseMogu {

    @Autowired
    @Qualifier("moguProxy")
    private IDownLoadPage iDownLoadPage;


    /**
     *
     * 功能描述:
     * 解析页面信息，获取区域下的板块链接
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/11/19 16:46
     */
    @Test
    public void getPlateUrl(){
        String url="http://www.mgzf.com/list/ft2/?showMore=open";
        Map<String, String> map = new HashMap<>();
        map.put("Referer","http://www.mgzf.com");
        map.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        map.put("Cookie","acw_tc=781bad0a15420155516162777e376f991261c3a059ee9f1c875b31c2794831; UM_distinctid=167074a11430-08c91f449cc471-69101b7d-1fa400-167074a1144276; gr_user_id=98d1b2aa-1942-4bd7-9b16-b9daa7e522c2; grwng_uid=958e44f0-352a-4661-936f-67e18f966141; JSESSIONID=6ee9baa5-7cc3-4bb0-bd01-c6ac3a8edd08; SESSION=6ee9baa5-7cc3-4bb0-bd01-c6ac3a8edd08; aca7dc2ea0f02f49_gr_session_id=7a9880b2-5819-4329-96f9-25394ebc6b6f; aca7dc2ea0f02f49_gr_session_id_7a9880b2-5819-4329-96f9-25394ebc6b6f=true; mogo_headTipsInfo={%22isShowHeadTips%22:false}; mogo_bottomAdvInfo={%22isShowBottomAdv%22:true%2C%22expires%22:1}; CNZZDATA1253147438=1885220646-1542012139-http%253A%252F%252Fwww.mgzf.com%252F%7C1542615417; acw_sc__v2=NWJmMjc2N2U5NmRmODIzOGQ1NzBhOTc2N2JlY2ViMDAzMzdhNjk5Nw==; acw_sc__v3=5bf2766b383bef7f6d768509990fd7f9097920ef");
        String html = PageDownLoadUtil.httpClientDefultGet(url,map);
        Document document = Jsoup.parse(html);
        System.out.println(document);
        //板块链接
        List<String> list = parseIndex(document);
        //根据板块链接，获取分页链接
        for (String plateUrl : list) {
            String plateHtml = PageDownLoadUtil.httpClientDefultGet(plateUrl,map);
            Document parse = Jsoup.parse(plateHtml);
            //分页页码
            String text = parse.select("div.page-box>span").text();
            Integer pageNum = NumUtils.getInteger(text);
            System.out.println(pageNum);
            //http://www.mgzf.com/list/ft2/qy11_61/pg1/?showMore=open
            for (int i = 1; i < pageNum; i++) {
                //分页url
                String pageUrl = plateUrl.replace("/?showMore=open", "/pg" + i + "/?showMore=open");
                //
                String pageHtml = PageDownLoadUtil.httpClientDefultGet(pageUrl,map);
                Document pageDocument = Jsoup.parse(plateHtml);
                //解析分页url，获取详情页url
                List<String> list1 = pagePageUrl(pageDocument);
                for (String detailUrl : list1) {
                    //解析详情url
                    String detailHtml = PageDownLoadUtil.httpClientDefultGet(detailUrl,map);
                    Document detailDocument = Jsoup.parse(plateHtml);
                    parseDetail(detailDocument);
                }
            }
        }

    }
    /**
     *
     * 功能描述: 
     *
     * @param: 解析详情页url，获取详情信息
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/19 17:07
     */
    private void parseDetail(Document detailDocument) {
        if(detailDocument!=null){
            Elements select = detailDocument.select("module-roomintro");
            if(!select.isEmpty()){
                //名称
                String title = select.select("title").text();
                //地址
                String position = select.select("position").text();
                //价格
                String price = select.select("div.w460.price.mt10>div.info>span.num.orange").text();
                //管家
                String name = select.select("div.w460.room-common>div.w460.room-manager").text();
                //手机号
                String phone = select.select("div.w460.room-common>div.w460.room-call>div.left>div.phone.orange").text();

            }
        }
        
    }


    /**
     *
     * 功能描述: 
     *
     * @param: 解析分页链接，获取详情页url
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/19 17:06
     */
    private List<String> pagePageUrl(Document pageDocument) {
        ArrayList<String> list = new ArrayList<>();
        if(pageDocument!=null){
            Elements select = pageDocument.select("divf.small-container");
            if(!select.isEmpty()){
                for (Element element : select) {
                    String attr = element.select("a").attr("href");
                    list.add(attr);
                }
            }
        }
        return list;
    }

    /**
     *
     * 功能描述: 解析主页
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/11/19 16:49
     */
    private List<String> parseIndex(Document document) {
        List<String> list=new ArrayList<>();
        if(document!=null){
            Elements select = document.select("div.filter-content");
            if(!select.isEmpty()){
                Elements select1 = select.select("div.children-box");
                Element element1 = select1.get(0);
                Elements select2 = element1.select("div.children-list>div");
                System.out.println(select2.size());
                if(!select2.isEmpty()){
                    for (int i = 1; i <select2.size(); i++) {
                        Element element = select2.get(i);
                        //区域url
                        String attr = element.select("a").attr("href");
                        String regionUrl="http://www.mgzf.com"+attr;
                        //区域的名称
                        String region = element.select("a>div").first().ownText();
                        System.out.println(regionUrl+region);
                        //获取区域下的板块信息
                        Elements select3 = element.select("a>div.children-options-box");
                        if(!select3.isEmpty()){
                            for (Element element2 : select3) {
                                Elements select4 = element2.select("li>a");
                                if(!select4.isEmpty()){
                                    for (int j = 1; j < select4.size(); j++) {
                                        Element element3 = select4.get(j);
                                        String href = element3.attr("href");
                                        String plate = element3.text();
                                        String plateUrl="http://www.mgzf.com"+href;
                                        System.out.println("---"+plateUrl+plate);
                                        list.add(plateUrl);
                                    }
                                }

                            }
                        }

                    }
                }
            }
        }
        return list;
    }


}
