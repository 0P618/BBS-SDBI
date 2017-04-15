package com.goldenratio.bbs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.goldenratio.bbs.R;
import com.goldenratio.bbs.domain.RecommendBean;

import java.util.List;

/**
 * Created by qiuyi on 2017/4/15.
 */

public class RecommendListAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater; // 布局加载器
    private List<RecommendBean> mList;
    private Context mContext;

    public RecommendListAdapter(List<RecommendBean> list, Context context){
        this.mList=list;
        this.mContext=context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder;
        if (view == null) {
            viewHoder = new ViewHoder();
            view = mLayoutInflater.inflate(R.layout.item_recommend, null);
            viewHoder.title= (TextView) view.findViewById(R.id.title_item_recommend);
            viewHoder.content= (TextView) view.findViewById(R.id.small_title_item_recommend);
            viewHoder.imgs= (ImageView) view.findViewById(R.id.image_item_recommend);

            view.setTag(viewHoder);

        } else {
            viewHoder = (ViewHoder) view.getTag();
        }
        viewHoder.title.setText(mList.get(i).getTitle());
        viewHoder.content.setText(mList.get(i).getContent());
        Glide.with(mContext).load(mList.get(i).getImgUrl()).into(viewHoder.imgs);

        return view;
    }

    private class ViewHoder {
        private TextView title;
        private TextView content;
        private ImageView imgs;
    }
}
