package com.tt.common;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/19 20:22
 * @Description:
 */
public  class JnaLianjia {

    static {
        System.load("/home/libSouFunSec.so");
    }

    public interface CLibrary extends Library {
        //调用系统自带的动态链接库
        /*CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
        void printf(String format);*/

       CLibrary INSTANCE = (CLibrary) Native.loadLibrary("SouFunSec", CLibrary.class);

        String getSec(String str);

    }

    public static String getSec(String str){
        return CLibrary.INSTANCE.getSec(str);
    }

    public static void main(String[] args) {
        String sec = getSec("city=%25E4%25B8%258A%25E6%25B5%25B7&gettype=android&isJiajuAD=1&isspecialpricefour=1&jkVersion=2&maptype=baidu&messagename=esflist&page=1&pagesize=20&purpose=%25E4%25BD%258F%25E5%25AE%2585");
        System.out.println(sec);
    }
}
