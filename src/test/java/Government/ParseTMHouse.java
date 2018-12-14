package Government;

import com.tt.common.utils.ProxyUtils;
import com.tt.common.utils.WebDriverUtils;
import com.tt.dao.CommunityTmsfHzListMapper;
import com.tt.dao.CommunityTmsfHzRegionMapper;
import com.tt.entity.CommunityTmsfHzRegion;
import com.tt.tmsf.HzListChromeWeb;
import com.tt.tmsf.HzLoudongChromeWeb;
import com.tt.tmsf.HzdetailAndPicChromeWeb;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/7 09:44
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ParseTMHouse {

    @Autowired
    private CommunityTmsfHzRegionMapper communityTmsfHzRegionMapper;

    @Autowired
    private CommunityTmsfHzListMapper communityTmsfHzListMapper;

    @Autowired
    private HzListChromeWeb zfhZhouChromeWeb;

    @Autowired
    private HzdetailAndPicChromeWeb hzdetailAndPicChromeWeb;

    @Autowired
    private HzLoudongChromeWeb hzLoudongChromeWeb;

    public static WebDriver openWebDriver(String url,int time,int r){
        WebDriver webDriver = null;
        int cnt = 0;
        do{
            try {
                System.out.println("webDriver打开次数："+cnt);
                webDriver = WebDriverUtils.openChrome(ProxyUtils.getIPoolProxy());
                //请求页面
                webDriver.get(url);
                Thread.sleep(time);
            } catch (Exception e) {
                System.out.println("webDriver打开异常："+e.getMessage());
                try {
                    if(webDriver!=null && !webDriver.toString().contains("null")) {
                        webDriver.close();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }finally {
                    webDriver.close();
                    webDriver = null;
                }
            }finally {
                cnt++;
            }

        }while ((webDriver!=null && webDriver.toString().contains("null")) && cnt<r);

        return  webDriver;
    }

    @Test
    public void parseLoudong(){
        hzLoudongChromeWeb.callBackDriverServies();
    }

    /**
     *
     * 功能描述: 解析详情页面和图片
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/10 14:01
     */
    @Test
    public void parseDetailAndPic(){
        hzdetailAndPicChromeWeb.callBackDriverServies();
    }



    /**
     *
     * 功能描述: 获取列表详情url
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/10 13:50
     */
    //@Test
    public void parseRegion(){
        zfhZhouChromeWeb.callBackDriverServies();
    }




    /**
     *
     * 功能描述:获取页面的板块取悦链接
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/7 12:49
     */
    @Test
    public void parseIndex(){
        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
        //获取Driver对象
        WebDriver webDriver = null;
        try {
            long startTime = System.currentTimeMillis();
            webDriver = WebDriverUtils.openChrome(iPoolProxy);
            String indexUrl="http://www.tmsf.com/index.jsp";
            //获取当前的窗口句柄
            String windowHandle = webDriver.getWindowHandle();

            //请求页面
            webDriver.get(indexUrl);

            webDriver.get("http://www.tmsf.com/newhouse/property_searchall.htm");
            Thread.sleep(1000);
            String pageSource = webDriver.getPageSource();
            Document document = Jsoup.parse(pageSource);
            Elements elementsli = document.select("ul#districtsearch>li>a").not("a.colorgre.fb");
            if(!elementsli.isEmpty()){
                for (Element element : elementsli) {
                    String region = element.text();
                    String regionId = element.attr("id");
                    if(StringUtils.isNotBlank(regionId)){
                        String replaceId = regionId.replace("s_", "");
                        Elements select = document.select("div#" +"p_"+replaceId+">a");
                        if(!select.isEmpty()){
                            for (Element element1 : select) {
                                String plate = element1.text();
                                String plateId = element1.attr("id");
                                if(StringUtils.isNotBlank(plateId)){
                                    String plateReplace = plateId.replace("t_", "");
                                    System.out.println(plate+plateId);
                                    //http://www.tmsf.com/newhouse/property_searchall.htm?sid=33&districtid=330104&areaid=16050
                                    CommunityTmsfHzRegion communityTmsfHzRegion = new CommunityTmsfHzRegion();
                                    communityTmsfHzRegion.setId(UUID.randomUUID().toString());
                                    communityTmsfHzRegion.setRegion(region);
                                    communityTmsfHzRegion.setPlate(plate);
                                    String url="http://www.tmsf.com/newhouse/property_searchall.htm?sid=33&districtid="+replaceId+"&areaid="+plateReplace;
                                    communityTmsfHzRegion.setUrl(url);
                                    communityTmsfHzRegion.setBatchId("v1.0");
                                    communityTmsfHzRegionMapper.insertSelective(communityTmsfHzRegion);
                                }
                            }
                        }
                    }

                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退出
            webDriver.quit();
        }
    }
}
