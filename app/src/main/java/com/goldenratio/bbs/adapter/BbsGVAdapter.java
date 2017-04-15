package com.goldenratio.bbs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldenratio.bbs.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2017/4/14 0014.
 * 论坛界面的板块 GV 的适配器
 * 目前来说，布局比较简单，使用简单适配器也可以
 */

public class BbsGVAdapter extends BaseAdapter {
    private List<Map<String, Object>> mMapList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public BbsGVAdapter(List<Map<String, Object>> mapList, Context context) {
        mMapList = mapList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMapList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMapList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.grid_item, parent,false);
            viewHolder.initView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 填充数据
        viewHolder.mImageView.setImageResource((Integer) mMapList.get(position).get("img"));
        viewHolder.mTextView.setText((CharSequence) mMapList.get(position).get("text"));
        return convertView;
    }

    static class ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        private void initView(View view) {
            mImageView = (ImageView) view.findViewById(R.id.img_item);
            mTextView = (TextView) view.findViewById(R.id.txt_item);
        }

    }
}
