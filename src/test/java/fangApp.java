import com.tt.vo.Hack;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;


public class fangApp {

    public static void main(String[] args) throws Exception {
        String wirelessCheckCode = getWirelessCheckCode("008796761777320" + ";" + "MuMu");
        System.out.println(wirelessCheckCode);
        //wirelessCheckCode    983920f277805b065951a717ec92aae6bb8f61d11f6d7174

        String wirelesscode111="0593F97D1FAE983C83DAFC9EADB3C37D";
        String url="https://soufunapp.3g.fang.com/http/sfpgservice.jsp?X1=116.403699&Y1=39.914938&city=北京&distance=5&gettype=android&jkVersion=2&maptype=baidu&messagename=lplist&page=4&pagesize=20&tongji=2";


        Map<String, String> parmars = getParmars(url);
        String wirelesscode = getWirelesscode(parmars);
        System.out.println(wirelesscode);
        parmars.put("wirelesscode", wirelesscode);
    }


    //008796761777320MuMu
    public static String getWirelessCheckCode(String str) throws Exception {
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("r0ei8euo".getBytes("GB2312"))), new IvParameterSpec("a966g0g4".getBytes("GB2312")));
        return getHexString(instance.doFinal(str.getBytes("GB2312")));
    }

    public static String getHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                toHexString = "0" + toHexString;
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }

    public static String getWirelesscode(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (map.size() > 0) {
                stringBuilder.append("?");
                List<Map.Entry<String, String>> arrayList = new ArrayList(map.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() {
                     //renamed from: a
                    public int compare(Map.Entry<String, String> entry, Entry<String, String> entry2) {
                        return ((String) entry.getKey()).compareTo((String) entry2.getKey());
                    }
                });
                for (Entry entry : arrayList) {
                    String str = "";
                    str = (String) entry.getValue();
                    if (StringUtils.isNotBlank(str)) {
                        if ("NULL".equals(str)) {
                            str = URLEncoder.encode("", "UTF-8");
                        } else {
                            str = URLEncoder.encode(str, "UTF-8");
                        }
                        stringBuilder.append((String) entry.getKey()).append("=").append(str).append("&");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(stringBuilder.toString()) || stringBuilder.toString().length() > 0) {
            return getSec(stringBuilder.toString().substring(1, stringBuilder.toString().length()));
        }
        return null;
    }



    public static String getSec(String str){
        String soufunhttp = md5(new StringBuilder(str).append("soufunhttp").toString());
        //String soufunhttp = md5(str);
        return soufunhttp;
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

}