package com.goldenratio.bbs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.goldenratio.bbs.R;
import com.goldenratio.bbs.domain.PostBean;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/4/15 0015.
 * 论坛界面的 RecycleView 的适配器
 */

public class BbsItemAdapter extends RecyclerView.Adapter<BbsItemAdapter.ViewHolder> {
    private List<PostBean> mList;
    private Context mContext;

    public BbsItemAdapter(List<PostBean> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_posts,null);

        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewHolder.getAdapterPosition();
                Toast.makeText(mContext, "click " + mList.get(pos).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mList.get(position).getTitle());
        holder.content.setText(mList.get(position).getContent());
        Glide.with(mContext).load(mList.get(position).getImgUrl()).into(holder.imgs);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    // 自定义我们的 ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView content;
        private ImageView imgs;
        private LinearLayout mLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            title= (TextView) itemView.findViewById(R.id.title_item_recommend);
            content= (TextView) itemView.findViewById(R.id.small_title_item_recommend);
            imgs= (ImageView) itemView.findViewById(R.id.image_item_recommend);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_post);
        }
    }
}
