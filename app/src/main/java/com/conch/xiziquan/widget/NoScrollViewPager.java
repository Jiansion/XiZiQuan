package com.conch.xiziquan.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by conch on 2016/10/22.
 * 禁止左右滑动
 */

public class NoScrollViewPager extends ViewPager {


    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //返回false是表示不拦截事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    //拦截点击事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
