package fangdaohang;

import com.tt.common.utils.HttpClientUtils;
import com.tt.common.utils.ProxyUtils;
import org.apache.http.HttpHost;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/7 16:51
 * @Description:
 */
public class ParseIndex {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
           /* String url="http://shangfengyihao.fang.com/office/";
            HttpHost iPoolProxy = ProxyUtils.getIPoolProxy();
            String html = HttpClientUtils.get(url,"gbk",iPoolProxy);
            System.out.println(html);*/
        System.out.println(startTime);
        String url="http://androidapi.realtynavi.com/v2/android/Deal/getbargainnewdisklist";
        Map<String,String> headers=new HashMap<>();
        headers.put("Authorization","Basic QzNjSEpJMVpXOUVxOGpRQTpGZzZvQmczd05tTjJwc1JO");

        headers.put("Date","Wed, 07 Nov 2018 08:39:12 GMT+00:00");
        headers.put("Accept","application/json; charset=UTF-8");
        headers.put("Content-Type","application/x-www-form-urlencoded");
        headers.put("X-Ca-Signature-Headers","X-Ca-Timestamp,X-Ca-Key");
        headers.put("X-Ca-Key","24839553");
        headers.put("X-Ca-Signature","AxszzlLhk46AqO0S1wbITnRY98ADzlETLvjxUiN32Ng=");
        //时间戳
        headers.put("X-Ca-Timestamp","1541579952988");

        headers.put("User-Agent","okhttp/3.9.0");
        headers.put("Accept-Encoding","gzip");

        HttpHost mouGuProxy = ProxyUtils.getMouGuProxy();

        Map<String,String> params=new HashMap<>();
        params.put("lng","121.456777");
        params.put("lat","31.278339");
        params.put("pricerange","0");
        params.put("daterange","0");
        params.put("pageindex","1");
        params.put("pagesize","15");
        params.put("livablestar","0");
        params.put("greeningrate","0");
        params.put("plotratio","0");

        String html2 = HttpClientUtils.post(url,params,headers,mouGuProxy);
        System.out.println(html2);

    }
}
