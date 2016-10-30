package com.conch.xiziquan.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;


import com.conch.xiziquan.R;
import com.conch.xiziquan.utils.transform.CircleTransform;
import com.conch.xiziquan.utils.transform.RoundedTransform;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by jiansion on 2016/5/25.
 * 图片加载工具类
 */
public class PicassoUtil {


    //查看图片加载的来源，右上角为绿色的表示从本地加载，红色为网路加载，蓝色的为内存加载
    // Picasso.with(context).setIndicatorsEnabled(true);
    private static final boolean idDebug = true;

    /**
     * 加载普通图片/加载资产目录图片
     * 加载资产目录图片
     * Picasso.with(this).load("file:///android_asset/heart.png").into(iv_picasso);
     *
     * @param context   上下文
     * @param url       图片链接
     * @param imageView ImageView
     */
    public static void downLoadImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(url)
                .config(Bitmap.Config.RGB_565)
                .placeholder(R.mipmap.ic_launcher)//图片加载占位符
                .error(R.mipmap.ic_launcher)//加载失败的图片
                .into(imageView);
    }

    /**
     * 加载资源文件
     * // Picasso.with(this).load(R.drawable.alipay).into(iv_picasso);
     *
     * @param context   上下文
     * @param resources 图片资源
     * @param imageView ImageView
     */
    public static void downLoadImage(Context context, int resources, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(resources)
                .into(imageView);
    }

    /**
     * 加载文件图片如SD卡中的图片
     * Picasso.with(this).load(new File("XXX")).into(iv_picasso);
     *
     * @param context   上下文
     * @param file      文件
     * @param imageView ImageView
     */
    public static void downLoadImage(Context context, File file, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(file)
                .config(Bitmap.Config.RGB_565)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param context   上下文
     * @param url       图片链接
     * @param imageView ImageView
     */
    public static void downCircleImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)  //图片占位符
                .error(R.mipmap.ic_launcher)    //图片加载失败是加载的图片
                .config(Bitmap.Config.ARGB_8888)
                .transform(new CircleTransform())
                .into(imageView);
    }

    /**
     * 加载圆角图片
     *
     * @param context   上下文
     * @param url       图片资源地址
     * @param imageView imageView
     * @param rodius    圆角的弧度，单位dp ,radius is corner radii in dp
     * @param margin    圆角的宽度，单位dp,margin is the board in dp
     */
    public static void downRoundImage(Context context, String url, ImageView imageView, int rodius, int margin) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)  //图片占位符
                .error(R.mipmap.ic_launcher)    //图片加载失败是加载的图片
                .config(Bitmap.Config.ARGB_8888)
                .transform(new RoundedTransform(rodius, margin))
                .into(imageView);
    }


    /**
     * 设置tag，下载图片,可以通过标记暂停或恢复图片的下载
     * Picasso.with(context).resumeTag("tag");
     * Picasso.with(context).pauseTag("tag");
     * 例如在RrecyclerView滑动中暂停或恢复图片下载
     *
     * @param context   上下文
     * @param url       url
     * @param tag       Tag
     * @param imageView ImageView
     *                  <p/>例如滑动列表是不加载中图片
     *                  //                 new RecyclerView(context).addOnScrollListener(new RecyclerView.OnScrollListener() {
     *                  //                      public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
     *                  //                              super.onScrollStateChanged(recyclerView, newState);
     *                  //                                  if (newState == RecyclerView.SCROLL_STATE_IDLE) {   //滑动暂停时恢复加载图片
     *                  //                                       Picasso.with(context).resumeTag(tag);
     *                  //                                   } else {
     *                  //                                              Picasso.with(context).pauseTag(tag);       //列表滑动时暂停加载图片
     *                  //                                           }
     *                  //                                   }
     *                  //                                 });
     *                  //
     */
    public static void downLoadImage(Context context, String url, Object tag, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(url)
                .config(Bitmap.Config.RGB_565)
                .placeholder(R.mipmap.ic_launcher)  //图片占位符
                .error(R.mipmap.ic_launcher)    //图片加载失败是加载的图片
                .tag(tag)
                .into(imageView);
    }

    /**
     * 加载高清大图是不需要缓存时使用该方法不缓存改，
     * 减少对内存的消耗，可以加快对内存的回收，防止内存溢出
     *
     * @param context   context
     * @param url       url
     * @param imageView ImageView
     */
    public static void downBigImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(url)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .placeholder(R.mipmap.ic_launcher)  //图片占位符
                .error(R.mipmap.ic_launcher)    //图片加载失败是加载的图片
                .into(imageView);
    }


    /**
     * 裁剪图片
     *
     * @param context
     * @param url
     * @param width
     * @param height
     * @param imageView
     */
    public static void downCutImage(Context context, String url, int width, int height, ImageView imageView) {
        Picasso.with(context).setIndicatorsEnabled(idDebug);
        Picasso.with(context)
                .load(url)
                .resize(Utils.dpToPx(context, width), Utils.dpToPx(context, height))
                .placeholder(R.mipmap.ic_launcher)  //图片占位符
                .error(R.mipmap.ic_launcher)    //图片加载失败是加载的图片
                .config(Bitmap.Config.RGB_565)
                .into(imageView);
    }

}
