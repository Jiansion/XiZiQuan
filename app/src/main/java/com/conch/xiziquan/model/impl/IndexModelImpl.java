package com.conch.xiziquan.model.impl;

import android.content.Context;

import com.conch.xiziquan.bean.IndexNews;
import com.conch.xiziquan.model.IndexModel;
import com.conch.xiziquan.utils.Urls;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.callback.StringCallback;

import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by conch on 2016/10/22.
 * IndexFragment数据
 */

public class IndexModelImpl implements IndexModel {

    private Gson gson;

    public IndexModelImpl() {
        gson = new Gson();
    }

    @Override
    public void loadFirstMessage(Context context, final OnIndexLoadFirstFinishListener listener) {
        OkHttpUtils
                .get(Urls.INDEX_NEWS)
                .cacheKey("IndexMessage")
                .tag(context)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        JsonReader reader = new JsonReader(new StringReader(s));
                        reader.setLenient(true);
                        IndexNews indexNews = gson.fromJson(reader, IndexNews.class);
                        listener.onFirstSuccess(indexNews);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        listener.onFirstError();
                    }
                });
    }


    @Override
    public void loadMoreMessage(Context context, final OnIndexLoadMoreFinishListener listener) {
        OkHttpUtils.get(Urls.INDEXLAST)
                .tag(context)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        JsonReader reader = new JsonReader(new StringReader(s));
                        reader.setLenient(true);
                        IndexNews indexNews = gson.fromJson(reader, IndexNews.class);
                        listener.onMoreSuccess(indexNews.getPushdata());
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        listener.onMoreError();
                    }
                });

    }
}
