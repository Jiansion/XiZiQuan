package com.conch.xiziquan.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lzy.okhttputils.OkHttpUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jiansion on 2016/5/6.
 * 基类Activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    public BaseActivity mActivity;

    protected Unbinder bind;


    protected abstract int initLayoutId();

    protected abstract void initView();

    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        mActivity = this;
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        OkHttpUtils.getInstance().cancelTag(this);

    }
}
