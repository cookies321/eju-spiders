package com.tt.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author Created by zcm on 2018/12/24.
 * @version v0.1.0
 * @see <font color="#0000FF">ip-proxy-pool</font>
 */
public class FangSouFunSec {

    public static void main(String [] args) {
        String wirelesscode="0593F97D1FAE983C83DAFC9EADB3C37D";
        String url="https://soufunapp.3g.fang.com/http/sfpgservice.jsp?X1=116.403699&Y1=39.914938&city=北京&distance=5&gettype=android&jkVersion=2&maptype=baidu&messagename=lplist&page=4&pagesize=20&tongji=2";


        /*Map<String, String> parmars = getParmars(url);*/

         Map<String,String> map = new HashMap<>();
         map.put("X1","116.403699");
         map.put("Y1","39.914938");
         map.put("city","%E5%8C%97%E4%BA%AC");
         map.put("distance","5");
         map.put("gettype","android");
         map.put("jkVersion","2");
         map.put("maptype","baidu");
         map.put("messagename","lplist");
         map.put("page","4");
         map.put("pagesize","20");
         map.put("tongji","2");

        System.out.println(wirelesscode(map));

    }


    public static String wirelesscode(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (map.size() > 0) {
                stringBuilder.append("?");
                List<Map.Entry> arrayList = new ArrayList(map.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry>() {
                            @Override
                            public int compare(Map.Entry o1, Map.Entry o2) {
                                return ((String) o1.getKey()).compareTo((String) o2.getKey());
                            }
                        }
                );
                for (Map.Entry entry : arrayList) {
                    String str = "";
                    str = (String) entry.getValue();
                    if (!isNull(str)) {
                        stringBuilder.append((String) entry.getKey()).append("=").append(URLEncoder.encode(str, "UTF-8")).append("&");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (!isNull(stringBuilder.toString()) || stringBuilder.toString().length() > 0) {
            stringBuilder.append("&wirelesscode=" + md5(new StringBuilder(String.valueOf(stringBuilder.toString().substring(1, stringBuilder.toString().length()))).append("soufunhttp").toString()));
        }
        return stringBuilder.toString();
    }

    public static boolean isNull(String str) {
        if (str == null || "".equals(str.trim()) || str.trim().length() == 0 || "null".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static String md5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(digest[i] & 255).length() == 1) {
                stringBuffer.append("0").append(Integer.toHexString(digest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            }
        }
        return stringBuffer.toString().toUpperCase();
    }

    private static Map<String, String> getParmars(String url) {
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
