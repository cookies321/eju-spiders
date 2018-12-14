package beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.common.utils.ValidateUtil;
import com.tt.service.JedisClientService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ke_loginCookie {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

    static JedisClientService jedisClientService = (JedisClientService)applicationContext.getBean("jedisClientServiceImpl");

    public static List<String> getLoginCookie() {
        List<String> cookies = new ArrayList<>();

        //账户和密码信息
        Map<String, String> userMap = new HashMap<>();
        userMap.put("18516262188", "ni55275730");
        userMap.put("15800380039", "a12345678");
        userMap.put("18116212736", "123QWEasd");
        userMap.put("15618660226", "ejucy2018");
        userMap.put("18717955209", "ej890iop");
        userMap.put("15221801885", "ejucy19920826");
        userMap.put("18721174109", "ejucy2018");
        userMap.put("18017679712", "EJLJxian0917");

        for (Map.Entry entry : userMap.entrySet()) {
            //post请求
            String url = "https://upassport.ke.com/login";
            Map<String, String> ticket = getTicket(entry.getKey().toString());

            if (ticket != null && !ticket.isEmpty()) {  //ticket不为空
                String lt = ticket.get("lt");
                String execution = ticket.get("execution");
                String cookieStr = ticket.get("cookie");
                if (StringUtils.isNotEmpty(lt) && StringUtils.isNotEmpty(execution) && StringUtils.isNotBlank(cookieStr)) {  //当都不为空的时候
                    Map<String, String> params = new HashMap<>();
                    params.put("username", entry.getKey().toString());
                    params.put("password", entry.getValue().toString());
                    params.put("code", "");
                    params.put("service", "https://ajax.api.ke.com/login/login/getuserinfo");
                    params.put("isajax", "true");
                    params.put("_eventId", "submit");
                    params.put("remember", "1");
                    params.put("lt", lt);
                    params.put("execution", execution);
                    Map<String, String> headersMap = new HashMap<>();
                    headersMap.put("Cookie",cookieStr);
                    String cookie = null;
                    try {
                        HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyPost(url, params, headersMap);

                        HttpEntity entity = httpResponse.getEntity();
                        String rel = EntityUtils.toString(entity);
                        if(!ValidateUtil.valid(rel)){
                            cookie = PageDownLoadUtil.getResponseCookie(httpResponse);
                        }else{
                            for (int i = 0; i < 10; i++) {
                                httpResponse = PageDownLoadUtil.httpMoguproxyPost(url, params, headersMap);
                                entity = httpResponse.getEntity();
                                rel = EntityUtils.toString(entity);
                                if(!ValidateUtil.valid(rel)){
                                    cookie = PageDownLoadUtil.getResponseCookie(httpResponse);
                                    break;
                                }else {
                                    continue;
                                }
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNotEmpty(cookie) && cookie.contains("token")) {
                        jedisClientService.addObjectToList("cookieList",cookie);
                        cookies.add(cookie);
                    }
                    }
                }
            }
        return cookies;
    }

    /**
     * 获取ticket
     * @param mobileNum
     * @return
     */
    public static Map<String, String> getTicket(String mobileNum) {
        Map<String, String> result = new HashMap<>();
        if (StringUtils.isEmpty(mobileNum)) {
            return null;
        }
        String ticketUrl = "https://upassport.ke.com/login";

        Map<String, String> params = new HashMap<>();
        params.put("service", "https://ajax.api.ke.com/login/login/getuserinfo");
        params.put("type", "1");
        params.put("get-lt", "true");
        params.put("isajax", "true");
        params.put("from", "lianjiaweb");
        params.put("username", mobileNum);

        HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyPost(ticketUrl, params, new HashMap<>());
        String responseCookie = PageDownLoadUtil.getResponseCookie(httpResponse);
        if (httpResponse==null) {
            return null;
        }
        try {
            HttpEntity entity = httpResponse.getEntity();
            String rel = EntityUtils.toString(entity);
            Document document = Jsoup.parse(rel);
            String data = document.select("body").text();
            JSONObject jsonObject = JSON.parseObject(data);
            if (StringUtils.isNotEmpty(jsonObject.getString("code"))) {
                if (jsonObject.getString("code").equals("1")) {  //请求成功
                    result.put("lt", jsonObject.getString("data"));
                    result.put("execution", jsonObject.getString("execution"));
                    result.put("cookie",responseCookie);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        /*Map<String, String> ticket = getTicket("18516262188");
        for (String s : ticket.keySet()) {
            System.out.println(s+ticket.get(s));
        }*/

        List<String> loginCookie = getLoginCookie();
        for (String s : loginCookie) {
            System.out.println(s+"--------------");
        }

        /*List<Object> lrange = jedisClientService.lrange("cookieList", 0, -1);
        for (Object o : lrange) {
            String cookie=(String) o;
            System.out.println(cookie);
        }*/

       /* String url="https://upassport.ke.com/login?service=https%3A%2F%2Fajax.api.ke.com%2Flogin%2Flogin%2Fgetuserinfo&type=1&get-lt=true&isajax=true&from=lianjiaweb&username=18516262188";
        HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyGet(url);
        HttpEntity entity = httpResponse.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);*/

    }
}
