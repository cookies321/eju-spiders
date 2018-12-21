package com.tt.common.utils;

import android.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/19 21:10
 * @Description:
 */
public class BeikeAppUtils {

    public static void main(String[] args) {
//        //gateway.lj-web-21.lianjia.com ateway.lianjia.com
//        String post = createAuthorizationStr("POST", "netstat/neteye/sample/api", "gateway.lj-web-21.lianjia.com", null);
//        System.out.println(post);
        String source="https://app.api.ke.com/yezhu/publish/getBuildings?community_id=1811043642571";
        String b = getAuthorization(source);
        System.out.println(b);

    }
    public static String getAuthorization(String str) {
        Map hashMap = getParmars(str);
        List arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
            public int compare(Entry<String, String> entry, Entry<String, String> entry2) {
                return ((String) entry.getKey()).compareTo((String) entry2.getKey());
            }
        });
        String GetAppSecret = "d5e343d453aecca8b14b2dc687c381ca";//JniClient.GetAppSecret(APPConfigHelper.c());
        String GetAppId = "20180111_android";//JniClient.GetAppId(APPConfigHelper.c());
        StringBuilder stringBuilder = new StringBuilder(GetAppSecret);
        for (int i = 0; i < arrayList.size(); i++) {
            Entry entry = (Entry) arrayList.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String) entry.getKey());
            stringBuilder2.append("=");
            stringBuilder2.append((String) entry.getValue());
            stringBuilder.append(stringBuilder2.toString());
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("sign origin=");

        stringBuilder3.append(stringBuilder);
        str = Digest_SHA1(stringBuilder.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(GetAppId);
        stringBuilder3.append(":");
        stringBuilder3.append(str);
        str = Base64.encodeToString(stringBuilder3.toString().getBytes(), 2);
        return str;
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


    public static Map<String, String> getParmars(String url) {
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


    private static String sign(String str, String str2) {
        Exception e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stringToSign: ");
        stringBuilder.append(str);
        System.out.println(stringBuilder.toString());
        String str3 = "";
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            str = Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
            try {
                return str.replaceAll("\n", "");
            } catch (Exception e2) {
                e = e2;
                str3 = str;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("HmacSHA256 signature error: ");
            stringBuilder2.append(e.getMessage());
            System.out.println(stringBuilder2.toString());
            return str3;
        }
        return null;
    }

}
