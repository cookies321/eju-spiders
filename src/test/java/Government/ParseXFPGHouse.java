package Government;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.utils.ProxyUtils;
import com.tt.common.utils.WebDriverUtils;
import com.tt.service.IDownLoadPage;
import org.apache.http.HttpHost;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/6 11:19
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ParseXFPGHouse {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;
    
    /**
     *
     * 功能描述: 获取小区的名称
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/6 17:49
     */
    @Test
    public void searWord(){
        String searWordUrl="http://www.xfpg.com.cn/build.do?method=buildlist";
        Map<String, String> params = new HashMap<>();
        params.put("input","小区");
        Map<String,String> headers =new HashMap<>();
        headers.put("Cookie","xfpgCity=%E6%9D%AD%E5%B7%9E%E5%B8%82; _9755xjdesxxd_=32; gdxidpyhxdE=woeh4H3YKT5rghHnI0l%2Bm4ZRTG6Oh1copVuS7cC6Id%2BzhAZ0yLXRwdsplit%5C8EMYMt8tQ1IawjGH8ifZxUtJeCvDkaqG2BasStx7dACA%2BPjmyt%2F1YdxqNEidXPniW%5CpaZK%5ClvcitU8PiWNy0s7G6D%2BBvG6xqqjaZTuU4eEiAWfX9KwZ6%3A1544081467346; JSESSIONID=38EE2D888BF61DED44BF74544E6FC578;  pname=%u6F6E%u9E23%u5C0F%u533A");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36");
        Document document = iDownLoadPage.downLoadPageByPost(searWordUrl, params,headers);
        String jsonHtml = document.select("body").text();
        JSONArray objects = JSON.parseArray(jsonHtml);
        String comunityName=null;
        if(objects.size()!=0){
            JSONObject jsonObject = objects.getJSONObject(0);
            comunityName = jsonObject.getString("value");
        }
        System.out.println(comunityName);
    }

    @Test
    public void buildInfo(){
        String buildinfoUrl="http://www.xfpg.com.cn/build.do?method=buildinfo";
        Map<String, String> params = new HashMap<>();
        params.put("pname","潮鸣小区");
        Map<String,String> headers =new HashMap<>();
        headers.put("Cookie","xfpgCity=%E6%9D%AD%E5%B7%9E%E5%B8%82; _9755xjdesxxd_=32; gdxidpyhxdE=woeh4H3YKT5rghHnI0l%2Bm4ZRTG6Oh1copVuS7cC6Id%2BzhAZ0yLXRwdsplit%5C8EMYMt8tQ1IawjGH8ifZxUtJeCvDkaqG2BasStx7dACA%2BPjmyt%2F1YdxqNEidXPniW%5CpaZK%5ClvcitU8PiWNy0s7G6D%2BBvG6xqqjaZTuU4eEiAWfX9KwZ6%3A1544081467346; JSESSIONID=38EE2D888BF61DED44BF74544E6FC578;  pname=%u6F6E%u9E23%u5C0F%u533A");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36");
        Document document = iDownLoadPage.downLoadPageByPost(buildinfoUrl, params,headers);
        String buildInfo = document.select("body").text();
        JSONArray objects = JSON.parseArray(buildInfo);
        JSONObject jsonObject = objects.getJSONObject(0);
        String addr = jsonObject.getString("addr");
        String block = jsonObject.getString("block");
        String towns = jsonObject.getString("towns");
        System.out.println(addr+"---"+block+"---"+towns);
    }

    @Test
    public void Loudong(){
        String buildinfoUrl="http://www.xfpg.com.cn/build.do?method=dongnum";
        Map<String, String> params = new HashMap<>();
        params.put("pname","潮鸣小区");
        Map<String,String> headers =new HashMap<>();
        headers.put("Cookie","xfpgCity=%E6%9D%AD%E5%B7%9E%E5%B8%82; _9755xjdesxxd_=32; gdxidpyhxdE=woeh4H3YKT5rghHnI0l%2Bm4ZRTG6Oh1copVuS7cC6Id%2BzhAZ0yLXRwdsplit%5C8EMYMt8tQ1IawjGH8ifZxUtJeCvDkaqG2BasStx7dACA%2BPjmyt%2F1YdxqNEidXPniW%5CpaZK%5ClvcitU8PiWNy0s7G6D%2BBvG6xqqjaZTuU4eEiAWfX9KwZ6%3A1544081467346; JSESSIONID=38EE2D888BF61DED44BF74544E6FC578;  pname=%u6F6E%u9E23%u5C0F%u533A");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36");
        Document document = iDownLoadPage.downLoadPageByPost(buildinfoUrl, params,headers);
        String buildInfo = document.select("body").text();
        JSONArray objects = JSON.parseArray(buildInfo);
        JSONObject jsonObject = objects.getJSONObject(0);
        String bnum = jsonObject.getString("bnum");
        String btype = jsonObject.getString("btype");
        String dongid = jsonObject.getString("dongid");
        System.out.println(bnum+"---"+btype+"---"+dongid);
    }

    @Test
    public void test1(){
        String buildinfoUrl="http://www.xfpg.com.cn/House.do?method=getPgHouseList";
        Map<String, String> params = new HashMap<>();
        params.put("dongId","building_28901693_33_516");
        params.put("validate","rUbZsuX1Va-D4_Rf.Jf41G6J0BT0Twv1UaA7cMxif6.JSbgiQ.-aM22QnmXY_IsS7EP8zjtH-fi6r1llUBm2X1_QubuofZsqzOTh8q7qyvvVXdIYMmIGxAwY8l1dEjyKPxRFpJ.t8W2fmshgOV5om8XTPtBfMtaRCigcSS.fyhfdfWbeRFnh0OsbPccQqmu.jOQp8hU4TOmHp4FWPxnlynuOu-t858wJUYGDwj9mDXgQ.huBUaKXhrs-AHNQTzSEpsRSTqugPDrnHtDa6kvJNmHENVhCLeU0Bx6N0VDMZK_u_VWBK0lXAYYrZzofqXX5y.veV-F.pNVvegopt8.QDr7sJFDkQ1EjTqS6GnzfT6J8-lxi5SJ2-yx_Poiza_gDP5raGAOaMhDpoqzbipkO5wDf-ev8CI_bfuDBok9nMsbxsX4Ss.weAFadFmdZUrc9pTSsJlBqmyHnLlofa8xXvP-vWtJJwsqWth0gDmgz7l9c5KwbtXJSaSzP1vF3");
        Map<String,String> headers =new HashMap<>();
        headers.put("Cookie","xfpgCity=%E6%9D%AD%E5%B7%9E%E5%B8%82; _9755xjdesxxd_=32; JSESSIONID=38EE2D888BF61DED44BF74544E6FC578; Hm_lvt_92e911e1c49474a0e7efd3bf125479ac=1544002478,1544086735; pname=%u6F6E%u9E23%u5C0F%u533A; gdxidpyhxdE=zuo6YATMhovN9hvo4k4ScVpOb%5CqBqmxGdUzn9gcVGv7UqM5M2uUUwHQ%5COHgs4cjGZ%2FPqS2EQMJMRhlvaU255yT%5CupzAEfETMD3CmItj%5CgARxYQQORLGk5bgJvKyVbJM2cL%5CzCYGT%5CBiO5gtx%5Cot9J%2FfY2dnchyvCa5GqJ9IMuRx8yuMG%3A1544093160626; Hm_lpvt_92e911e1c49474a0e7efd3bf125479ac=1544092858");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36");
        Document document = iDownLoadPage.downLoadPageByPost(buildinfoUrl, params,headers);
        System.out.println(document);
    }

    @Test
    public void test(){
        HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
        //获取Driver对象
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtils.openChrome(iPoolProxy);
            String indexUrl="http://www.xfpg.com.cn/evaluate_0803.jsp";
            //请求页面
            webDriver.get(indexUrl);

            String pageSource = webDriver.getPageSource();
            System.out.println(pageSource);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退出
            //webDriver.quit();
        }
    }


    
}
