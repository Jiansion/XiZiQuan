package com.conch.xiziquan.utils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiansion on 2016/4/14.
 * 工具类
 */
public class Utils {


    /**
     * 将毫秒转换成日期,
     *
     * @param date Date 对象
     * @return 日期
     */
    public static String timeMethod(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * 替换字符串
     *
     * @param url    拼接地址
     * @param format 表示占位符
     * @param page   表示 替换的内容
     * @return 拼接好的字符串
     */
    public static String getReplaceFormat(String url, String format, String page) {
        String urls = url.replace(format, page);
        return urls;
    }

    /**
     * 将 px 转为 dp 保持尺寸大小不变
     *
     * @param context 上下文
     * @param pxValue 像素单位
     * @return dp
     */
    public static int pxToDp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * dp值转换为px值，保证尺寸大小不变
     *
     * @param context context
     * @param dpValue dp单位
     * @return px
     */
    public static int dpToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * sp 转换为 px
     *
     * @param context context
     * @param spValue sp
     * @return px
     */
    public static int spToPx(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px 转换为 sp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int pxToSp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


}
