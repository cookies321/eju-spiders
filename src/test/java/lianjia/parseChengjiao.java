package lianjia;

import com.tt.entity.LianjiaListingHousePlate;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/26 09:54
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseChengjiao {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;


    @Test
    public void parseIndex(){
        Map<String, String> mapCity = new HashMap<>();
        //mapCity.put("苏州","https://su.lianjia.com/ershoufang/");
        //mapCity.put("杭州","https://hz.lianjia.com/ershoufang/");
        mapCity.put("上海","https://sh.lianjia.com/chengjiao/");
        //mapCity.put("北京","https://bj.lianjia.com/ershoufang/");
        /*mapCity.put("深圳","https://sz.lianjia.com/ershoufang/");
        mapCity.put("广州","https://gz.lianjia.com/ershoufang/");
        mapCity.put("南京","https://nj.lianjia.com/ershoufang/");
        mapCity.put("苏州","https://sz.lianjia.com/ershoufang/");
        mapCity.put("重庆","https://cq.lianjia.com/ershoufang/");
        mapCity.put("成都","https://cd.lianjia.com/ershoufang/");
        mapCity.put("西安","https://xa.lianjia.com/ershoufang/");
        mapCity.put("武汉","https://wh.lianjia.com/ershoufang/");
        mapCity.put("郑州","https://zz.lianjia.com/ershoufang/");
        mapCity.put("合肥","https://hf.lianjia.com/ershoufang/");
        mapCity.put("青岛","https://qd.lianjia.com/ershoufang/");
        mapCity.put("天津","https://tj.lianjia.com/ershoufang/");
        mapCity.put("沈阳","https://sy.lianjia.com/ershoufang/");
        mapCity.put("济南","https://jn.lianjia.com/ershoufang/");*/

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
                                        //区域链接
                                        plateHref=hostName+plateHref;
                                        System.out.println(plateHref+plate);

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
