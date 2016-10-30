package com.conch.xiziquan.ui.activity;

import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.conch.xiziquan.R;
import com.conch.xiziquan.base.BaseActivity;
import com.conch.xiziquan.ui.fragment.IndexFragment;
import com.conch.xiziquan.widget.NoScrollViewPager;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mFrameLayout)
    FrameLayout mFrameLayout;

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @BindView(R.id.mDrawerLayout)
    DrawerLayout mDrawerLayout;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //默认选中第一个
        radioGroup.check(R.id.rbIndex);
        IndexFragment indexFragment = new IndexFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mFrameLayout, indexFragment)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbIndex:
                        break;
                    case R.id.rbForum:
                        break;
                    case R.id.rbActivity:
                        break;
                    case R.id.rbUser:
                        break;
                }
            }
        });

    }


}
