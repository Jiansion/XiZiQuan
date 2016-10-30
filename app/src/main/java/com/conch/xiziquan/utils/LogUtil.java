package com.conch.xiziquan.utils;

/**
 * Created by Jiansion on 2016/3/21.
 * 日志工具类,当项目完成是不需要打印 Log 时改变 LEVEL 的值为NOTHING 即可
 */

import android.util.Log;

import com.conch.xiziquan.BuildConfig;


public class LogUtil {

    private static final boolean DEBUG = BuildConfig.LOG_DEBUG;

    public static void v(String tag, String msg) {
        if (DEBUG)
            Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (DEBUG)
            Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (DEBUG)
            Log.i(tag, msg);

    }

    public static void w(String tag, String msg) {
        if (DEBUG)
            Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG)
            Log.e(tag, msg);
    }


}
