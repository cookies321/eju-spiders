package com.tt.common.utils;

import java.security.MessageDigest;

/**
 * @author Created by zcm on 2018/5/7.
 * @version v0.1.0
 * @see <font color="#0000FF">anal</font>
 */
public class Md5Utils {

    /**
     * @Description:加密-32位小写
     */
    public static final String encrypt32(String encryptStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("Md5");
            byte[] md5Bytes = md5.digest(encryptStr.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            encryptStr = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptStr;
    }

    /**
     * @Description:加密-16位小写
     */
    public static final String encrypt16(String encryptStr) {
        return encrypt32(encryptStr).substring(8, 24);
    }

    public static void main(String[] args) {
        String encryptStr = "22222222222,./.,./.,./!@#$%^&*()";
        System.out.println(Md5Utils.encrypt32(encryptStr));
        System.out.println(Md5Utils.encrypt16(encryptStr));
    }
}