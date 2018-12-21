package com.tt.common.utils;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/18 17:39
 * @Description:
 */
public class LianjiaAppUtil {

    /**
     *
     * 功能描述: 获取头部Authorization的信息
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/18 17:44
     */
    public static String getAuthorization(String str) {
        Map<String, String> parmars = getParmars(str);
        if(parmars!=null){
            List arrayList = new ArrayList(parmars.entrySet());
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
            GetAppSecret = Base64.encodeToString((GetAppId + ":" + Digest_SHA1(stringBuilder.toString())).getBytes(), 2);
            return GetAppSecret;
        }
        return null;
    }

    
    /**
     *
     * 功能描述: sha-1加密
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/18 17:40
     */
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
    
    /**
     *
     * 功能描述: 获取url中的参数
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/18 17:40
     */
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
