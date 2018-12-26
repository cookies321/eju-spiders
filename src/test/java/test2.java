import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/8 18:31
 * @Description:
 */
public class test2 {




    public static String a(String string) {
        String str="";
        if (string != null) {
            for (int i = string.length(); i < 16; ++i) {
                string += "0";
            }
            str = string.substring(0, 16);
        }
        return str;
    }



    public static byte[] a(byte[] array) throws Exception {
        final int n = 0;
        String a = a("24839553");
        System.out.println(a);
        if (a == null || array == null) {
            array = null;
        } else {
            final StringBuffer sb = new StringBuffer();
            for (int length = array.length, i = 0; i < length; ++i) {
                sb.append(array[i] + " ");
            }
            final SecretKeySpec secretKeySpec = new SecretKeySpec(a.getBytes(), "AES");
            final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //
            instance.init(128, secretKeySpec, new IvParameterSpec(a.getBytes()));
            final byte[] doFinal = instance.doFinal(array);
            final StringBuffer sb2 = new StringBuffer();
            final int length2 = doFinal.length;
            int n2 = n;
            while (true) {
                array = doFinal;
                if (n2 >= length2) {
                    break;
                }
                sb2.append(doFinal[n2] + " ");
                ++n2;
            }
        }
        return array;
    }



    public static byte[] b(byte[] doFinal) throws Exception {
        String a="";
        if (a== null || doFinal == null) {
            doFinal = null;
        }
        else {
            final Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(a.getBytes("UTF-8"))), new IvParameterSpec(a.getBytes("UTF-8")));
            doFinal = instance.doFinal(doFinal);
        }
        return doFinal;
    }


}
