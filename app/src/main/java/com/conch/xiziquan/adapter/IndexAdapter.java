package com.conch.xiziquan.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.conch.xiziquan.R;
import com.conch.xiziquan.bean.IndexNews;
import com.conch.xiziquan.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by conch on 2016/10/23.
 * 增加头布局
 */

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.ViewHolder> {

    //有头布局
    public static final int TYPE_HEADER = 0;

    //正常布局
    public static final int TYPE_NORMAL = 1;

    private View mHeaderView;

    private List<IndexNews.PushdataBean> list;

    private Context context;
    private LayoutInflater infalter;

    public IndexAdapter(Context context, List<IndexNews.PushdataBean> list) {
        this.context = context;
        this.list = list;
        infalter = LayoutInflater.from(context);
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) {
            return TYPE_NORMAL;
        }
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }
        View view = infalter.inflate(R.layout.item_index, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            return;
        }
        final int pos = getRealPosition(holder);
        IndexNews.PushdataBean pushdataBean = list.get(pos);
        holder.tvTitle.setText(pushdataBean.getSubject());
        holder.tvAuthor.setText(pushdataBean.getAuthor());
        holder.tvAddress.setText(pushdataBean.getForumtwoname());
        holder.tvTime.setText(pushdataBean.getPostdate());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(context, "点击了我");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? list.size() : list.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        TextView tvAddress;

        TextView tvAuthor;

        TextView tvTime;

        CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            mCardView = (CardView) itemView.findViewById(R.id.mCardView);
        }
    }
}
