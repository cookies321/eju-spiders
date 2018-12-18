import android.util.Base64;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/14 15:04
 * @Description:
 */
public class fangApp {

    //final String source = "https://app.api.lianjia.com/house/ershoufang/searchv4?city_id=310000&priceRequest&limit_offset=60&shequIdRequest=&moreRequest=&communityRequset=&has_recommend=1&is_suggestion=0&limit_count=20&sugQueryStr=&houseHotTagsRequest=&comunityIdRequest=&areaRequest=&is_history=0&schoolRequest&condition&roomRequest=&isFromMap=false&ad_recommend=1";
    final String source="https://app.api.lianjia.com/yezhu/publish/getBuildings?community_id=5011000014422";
    @Test
    public void test(){
        String encripty = encripty(source, null);
        System.out.println(encripty);
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String encripty = encripty(source, null);

    }*/

    public String encripty(String str, Map<String, String> map) {
        Map parmars = getParmars(str);

        HashMap hashMap = new HashMap();
        if (parmars != null) {
            hashMap.putAll(parmars);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        List arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object obj, Object obj2) {
                return a((Map.Entry) obj, (Map.Entry) obj2);
            }

            public int a(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                return ((String) entry.getKey()).compareTo((String) entry2.getKey());
            }
        });
        //9264fc28f157c514fe2bcedcea50fd96877c1623
        String GetAppSecret = "93273ef46a0b880faf4466c48f74878f";
        String GetAppId = "20170324_android";
        StringBuilder stringBuilder = new StringBuilder(GetAppSecret);
        for (int i = 0; i < arrayList.size(); i++) {
            Map.Entry entry = (Map.Entry) arrayList.get(i);
            stringBuilder.append(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        System.out.println("ssssStringBuilder:"+stringBuilder.toString());
        System.out.println("ssssSHA1:"+Digest_SHA1(stringBuilder.toString()));
        System.out.println("ssss"+GetAppId + ":" + Digest_SHA1(stringBuilder.toString())+"---"+Digest_SHA1(stringBuilder.toString()).length());
        GetAppSecret = Base64.encodeToString((GetAppId + ":" + Digest_SHA1(stringBuilder.toString())).getBytes(), 2);

        System.out.println("sssss"+GetAppSecret+"----"+GetAppSecret.length());
        return new String("helloworld");


    }

    public static String Digest_SHA1(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*private Map<String, String> getParmars(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Uri parse = Uri.parse(str);

        for (String str2 : parse.getQueryParameterNames()) {
            String str22 = str2.toString();

            hashMap.put(str22, parse.getQueryParameter(str22));
        }
        return hashMap;
    }*/
    public Map<String, String> getParmars(String url) {
        Map<String, String> resMap = new HashMap<>();
        String[] split = url.split("\\?");
        if(split.length==2){
            String paramStr=split[1];
            String[] params = paramStr.split("&");
            for (int i = 0; i < params.length; i++) {
                String[] param = params[i].split("=");
                if(param.length ==1){
                    String key = param[0];
                    String value = null;
                    resMap.put(key, "");
                }
                if (param.length >= 2) {
                    String key = param[0];
                    String value = param[1];
                    for (int j = 2; j < param.length; j++) {
                        value += "=" + param[j];
                    }
                    resMap.put(key, value);
                }
            }
        }
        return resMap;
    }

}
