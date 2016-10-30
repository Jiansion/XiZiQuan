package com.conch.xiziquan.presenter;

import android.content.Context;

/**
 * Created by conch on 2016/10/22.
 */

public interface IndexPresenter {

    void startLoadFirstMessage(Context context);

    void startLoadMoreMessage(Context context);

    void viewDestroy();
}
