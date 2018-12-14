package com.tt.tmsf;

import com.tt.common.utils.ProxyUtils;
import com.tt.common.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/7 17:19
 * @Description:
 */
@Service
public abstract class BaseChromeWebDriver {

    protected String url;
    protected int time;
    protected int rnt;

    public abstract void init();

    public abstract Map<String,String> doWebPrase(WebDriver webDriver,Map<String,String> map);

    public abstract void callBackDriverServies();

    public WebDriver openUrl(String url, int time, int rnt) {
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
                System.out.println("webDriver打开异常："+e.getMessage()+url);
                closeWebDriver(webDriver);
            }finally {
                cnt++;
            }
        }while (webDriver!=null && webDriver.toString().contains("null")  && cnt < rnt);

        return  webDriver;
    }

    /**
     *
     * 功能描述 异常关闭webdriver
     *
     * @param:
     * @return:
     * @auther: 赵乐
     * @date: 2018/12/11 10:03
     */
    protected void closeWebDriver(WebDriver webDriver) {
        try {
            if(webDriver !=null && !webDriver.toString().contains("null")){
                //关闭所有句柄
                Set<String> windowHandles2 = webDriver.getWindowHandles();
                if(windowHandles2!=null && windowHandles2.size()!=0){
                    for (String handle : windowHandles2) {
                        webDriver.switchTo().window(handle);
                        webDriver.close();
                    }
                }
                webDriver.quit();
            }
        } catch (Exception e1) {
            try {
                if(!webDriver.toString().contains("null")){
                    webDriver.quit();
                }
            } catch (Exception e) {
                e.printStackTrace();
                webDriver.quit();
                webDriver=null;
            }
            e1.printStackTrace();
        } finally {
            webDriver=null;
        }
    }


}
