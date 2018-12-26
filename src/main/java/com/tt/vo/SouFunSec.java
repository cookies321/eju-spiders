package com.tt.vo;


/**
 * @Auther: 赵乐
 * @Date: 2018/12/18 14:46
 * @Description:
 */
public class SouFunSec {
    public static native String getDBSec();

    public static native String getSec(String str);

    public static native void setMessage(Context context);

    static {
        System.loadLibrary("SouFunSec");
    }


}
