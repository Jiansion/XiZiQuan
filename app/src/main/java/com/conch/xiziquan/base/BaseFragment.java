package com.conch.xiziquan.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.okhttputils.OkHttpUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiansion on 2016/5/25.
 * 基类Fragment
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected Unbinder bind;
    private View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
    }

    // 处理fragment的布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(mActivity).inflate(getLayoutId(), container, false);
            bind = ButterKnife.bind(this, view);
            initViews(view, savedInstanceState);
        }
        return view;
    }


    // 依附的activity创建完成
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
        OkHttpUtils.getInstance().cancelTag(this);
    }

    /**
     * 该抽象方法就是 onCreateView中需要的layoutID
     *
     * @return Fragment的布局
     */
    protected abstract int getLayoutId();

    /**
     * 该抽象方法就是 初始化view
     *
     * @param container          布局容器
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void initViews(View container, Bundle savedInstanceState);

    /**
     * 初始化数据
     * 可直接在此加载数据
     */
    protected void initData() {

    }


}
