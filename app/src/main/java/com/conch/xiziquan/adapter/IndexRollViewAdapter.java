package com.conch.xiziquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.conch.xiziquan.R;
import com.conch.xiziquan.bean.IndexNews;
import com.conch.xiziquan.ui.fragment.IndexFragment;
import com.conch.xiziquan.utils.LogUtil;
import com.conch.xiziquan.utils.PicassoUtil;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.List;

/**
 * Created by conch on 2016/10/23.
 */

public class IndexRollViewAdapter extends StaticPagerAdapter {

    private static final String TAG = IndexFragment.class.getName();
    private List<IndexNews.HotimageBean> list;

    private Context context;

    private LayoutInflater inflater;

    public IndexRollViewAdapter(Context context, List<IndexNews.HotimageBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item_rollview, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView tvImTitle = (TextView) view.findViewById(R.id.tvImTitle);
        IndexNews.HotimageBean hotimageBean = list.get(position);
        LogUtil.e(TAG, hotimageBean.getUrl());
        PicassoUtil.downLoadImage(context, hotimageBean.getImage(), imageView);
        tvImTitle.setText(hotimageBean.getTitle());
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
