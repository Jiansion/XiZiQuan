package com.conch.xiziquan.presenter.impl;

import android.content.Context;

import com.conch.xiziquan.bean.IndexNews;
import com.conch.xiziquan.model.IndexModel;
import com.conch.xiziquan.model.impl.IndexModelImpl;
import com.conch.xiziquan.presenter.IndexPresenter;
import com.conch.xiziquan.ui.view.IndexView;

import java.util.List;

/**
 * Created by conch on 2016/10/22.
 */

public class IndexPersenterImpl implements IndexPresenter,
        IndexModel.OnIndexLoadFirstFinishListener,
        IndexModel.OnIndexLoadMoreFinishListener {

    private IndexView indexView;

    private IndexModel indexModel;

    public IndexPersenterImpl(IndexView indexView) {
        this.indexView = indexView;
        indexModel = new IndexModelImpl();
    }

    @Override
    public void onFirstError() {
        if (indexView != null) {
            indexView.downError();
            indexView.hintProgress();
        }

    }

    @Override
    public void onMoreError() {
        if (indexView != null) {
            indexView.downError();
            indexView.hintProgress();
        }
    }

    @Override
    public void onMoreSuccess(List<IndexNews.PushdataBean> list) {
        if (indexView != null) {
            indexView.downMoreSuccess(list);
            indexView.hintProgress();
        }
    }

    @Override
    public void onFirstSuccess(IndexNews indexNews) {
        if (indexView != null) {
            indexView.downFirstSuccess(indexNews);
            indexView.hintProgress();
        }
    }

    @Override
    public void startLoadFirstMessage(Context context) {
        if (indexView != null) {
            indexModel.loadFirstMessage(context, this);
        }

    }

    @Override
    public void startLoadMoreMessage(Context context) {
        if (indexView != null) {
            indexView.showProgress();
            indexModel.loadMoreMessage(context, this);
        }

    }

    @Override
    public void viewDestroy() {

        indexView = null;
    }
}
