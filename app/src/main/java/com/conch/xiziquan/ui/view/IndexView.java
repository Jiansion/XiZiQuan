package com.conch.xiziquan.ui.view;

import com.conch.xiziquan.bean.IndexNews;

import java.util.List;

/**
 * Created by conch on 2016/10/22.
 */

public interface IndexView {

    void showProgress();

    void hintProgress();

    void downFirstSuccess(IndexNews indexNews);

    void downMoreSuccess(List<IndexNews.PushdataBean> list);

    void downError();
}
