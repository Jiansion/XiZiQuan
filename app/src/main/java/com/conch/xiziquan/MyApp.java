package com.conch.xiziquan;

import android.app.Application;

import com.lzy.okhttputils.OkHttpUtils;

/**
 * Created by jiansion on 2016/5/25.
 * 自定义Applcation
 */
public class MyApp extends Application {

    //全局上下文
    private static MyApp applicationContext;

    //通过 getInstance()得到全局上下文
    public static MyApp getInstance() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        OkHttpUtils.init(applicationContext);
        //以下都不是必须的，根据需要自行选择
        OkHttpUtils.getInstance()
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS);               //全局的写入超时时间
    }
}
