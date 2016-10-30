package com.conch.xiziquan.model;

import android.content.Context;

import com.conch.xiziquan.bean.IndexNews;

import java.util.List;

/**
 * Created by conch on 2016/10/22.
 */

public interface IndexModel {

    interface OnIndexLoadFirstFinishListener {
        void onFirstError();//请求失败

        void onFirstSuccess(IndexNews indexNews);//数据请求成功
    }

    interface OnIndexLoadMoreFinishListener {
        void onMoreError();//请求失败

        void onMoreSuccess(List<IndexNews.PushdataBean> list);//数据请求成功
    }


    void loadFirstMessage(Context context, OnIndexLoadFirstFinishListener listener);

    void loadMoreMessage(Context context, OnIndexLoadMoreFinishListener listener);
}
