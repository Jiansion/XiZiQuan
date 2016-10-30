package com.conch.xiziquan.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.conch.xiziquan.R;
import com.conch.xiziquan.adapter.IndexAdapter;
import com.conch.xiziquan.adapter.IndexRollViewAdapter;
import com.conch.xiziquan.base.BaseFragment;
import com.conch.xiziquan.bean.IndexNews;
import com.conch.xiziquan.presenter.IndexPresenter;
import com.conch.xiziquan.presenter.impl.IndexPersenterImpl;
import com.conch.xiziquan.ui.view.IndexView;
import com.conch.xiziquan.utils.LogUtil;
import com.conch.xiziquan.utils.ToastUtil;
import com.conch.xiziquan.widget.RecycScrollListener;
import com.jude.rollviewpager.RollPagerView;
import com.lzy.okhttputils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by conch on 2016/10/22.
 * 首页
 */

public class IndexFragment extends BaseFragment implements IndexView {

    @BindView(R.id.btnSelectType)
    Button btnSelectType;

    @BindView(R.id.btnReport)
    Button btnReport;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.mSwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private View headView;

    private RollPagerView mRollPagerView;

    private TextView tvHeadlines;

    private IndexPresenter indexPresenter;

    private IndexAdapter itemAdapter;

    private IndexRollViewAdapter rollViewAdapter;

    private List<IndexNews.PushdataBean> list;

    private final static String TAG = IndexFragment.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initViews(View container, Bundle savedInstanceState) {
        initHeadView();
        initSwipeLayout();
        initRecyclerView();

    }

    private void initHeadView() {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        headView = inflater.inflate(R.layout.fragment_indext_header_view, null, false);
        mRollPagerView = (RollPagerView) headView.findViewById(R.id.mRollPagerView);
        tvHeadlines = ((TextView) headView.findViewById(R.id.tvHeadlines));
    }

    @Override
    protected void initData() {
        indexPresenter = new IndexPersenterImpl(this);
        indexPresenter.startLoadFirstMessage(mActivity);
        list = new ArrayList<>();
        itemAdapter = new IndexAdapter(mActivity, list);
        itemAdapter.setHeaderView(headView);
        mRecyclerView.setAdapter(itemAdapter);

    }

    private void initSwipeLayout() {
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GRAY, Color.BLACK);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        //下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                indexPresenter.startLoadFirstMessage(mActivity);
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.addOnScrollListener(new RecycScrollListener() {
            @Override
            public void onBottom() {//滑动到到地步，加载下一页数据
                indexPresenter.startLoadMoreMessage(mActivity);
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hintProgress() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void downFirstSuccess(IndexNews indexNews) {
        LogUtil.e(TAG, indexNews.getHeadline().get(0).getSubject());
        if (rollViewAdapter == null) {
            rollViewAdapter = new IndexRollViewAdapter(mActivity, indexNews.getHotimage());
            mRollPagerView.setAdapter(rollViewAdapter);
        } else {
            rollViewAdapter.notifyDataSetChanged();
        }
        tvHeadlines.setText(indexNews.getHeadline().get(0).getSubject());
        list.clear();
        list.addAll(indexNews.getPushdata());
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void downMoreSuccess(List<IndexNews.PushdataBean> list) {
        this.list.addAll(list);
//        itemAdapter.notifyItemRangeChanged(itemAdapter.getItemCount() - 1, list.size());
        itemAdapter.notifyDataSetChanged();

    }

    @Override
    public void downError() {
        ToastUtil.showToast(mActivity, "不能连接到服务器！");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mRollPagerView.isPlaying()) {
            mRollPagerView.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRollPagerView.isPlaying()) {
            mRollPagerView.pause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        OkHttpUtils.getInstance().cancelTag(mActivity);
        indexPresenter.viewDestroy();
    }
}
