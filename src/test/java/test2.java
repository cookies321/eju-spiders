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
    public static void main(String[] args) throws Exception {
       String html="<div class=\"xf_box_02\">\n" +
               "\t\t<p>\n" +
               "\t\t\t\t<span>楼盘名称：</span>浙富亲亲园\n" +
               "\t\t</p>\n" +
               "\t\t\t<p class=\"a\">\n" +
               "\t\t\t\t<span>近月成交：</span>\n" +
               "\t\t\t\t\t近月暂无成交\n" +
               "\t\t\t</p>\n" +
               "\t\t<p>\n" +
               "\t\t\t<span>所属城区：</span>县城\n" +
               "\t\t</p>\n" +
               "\t\t\t<p>\n" +
               "\t\t\t\t<span>物业地址：</span>\n" +
               "\t\t\t\t\t县城瑶琳路与下杭路交汇处\n" +
               "\t\t\t</p>\n" +
               "\t\t<p>\n" +
               "\t\t\t<span>物业类型：</span>商住\n" +
               "\t\t\t<span>主力户型：</span>90-130㎡\n" +
               "\t\t</p>\n" +
               "\t\t<p>\n" +
               "\t\t\t<span>建筑形式：</span>高层、多层\n" +
               "\t\t\t<span>装修状况：</span>毛坯\n" +
               "\t\t</p>\n" +
               "\t\t<p>\n" +
               "\t\t\t<span>项目公司：</span>桐庐浙富置业有限公司\n" +
               "\t\t</p>\n" +
               "\t\t<p>\n" +
               "\t\t\t<span>集团公司：</span>\n" +
               "\t\t\t\t\t\t桐庐浙富置业有限公司\n" +
               "\t\t</p>\n" +
               "\t\t\t<p>\n" +
               "\t\t\t\t<span>售楼处地址：</span>县城瑶琳路与下杭路交汇处\n" +
               "\t\t\t</p>\n" +
               "\t\t<ul>\n" +
               "\t\t\t<p class=\"bold\" style=\"margin-top: 15px;\">\n" +
               "\t\t\t\t\t浙富亲亲园售楼电话\n" +
               "\t\t\t</p>\n" +
               "\t\t\t<p>\n" +
               "\t\t\t\t<span class=\"telred\">0571-69966998</span>\n" +
               "\t\t\t</p>\n" +
               "\t\t</ul>\n" +
               "\t</div>";
        Document document = Jsoup.parse(html);
        Elements select = document.select("div.xf_box_02>p");
        if(!select.isEmpty()){
            for (Element element : select) {
                Elements select1 = element.select("span");
                if(!select1.isEmpty()){
                    for (int i=0; i< select1.size();i++) {
                        String tag = null;
                        String value=null;
                        try {
                            tag = select1.get(i).text();
                            String[] split = element.ownText().split(" ");
                            value=split[i];
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        switch (tag){
                            case "物业地址：":
                                System.out.println("物业地址："+value);
                                break;
                                default:
                                    break;



                        }
                    }
                }
            }
        }


    }

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
