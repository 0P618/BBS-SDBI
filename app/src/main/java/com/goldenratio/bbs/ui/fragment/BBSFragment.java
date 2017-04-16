package com.goldenratio.bbs.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.goldenratio.bbs.R;
import com.goldenratio.bbs.adapter.BbsGVAdapter;
import com.goldenratio.bbs.adapter.BbsItemAdapter;
import com.goldenratio.bbs.domain.PostBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBSFragment extends Fragment implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private GridView mGvTitle;
    private RecyclerView mLvShow;
    private int[] img;
    private String[] imgName;
    private List<Map<String, Object>> mapList;
    private List<PostBean> mBeanList;
    private SwipeRefreshLayout mSwPosts;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bbs, container, false);

        mGvTitle = (GridView) view.findViewById(R.id.gv_title);
        mLvShow = (RecyclerView) view.findViewById(R.id.lv_show);
        mSwPosts = (SwipeRefreshLayout) view.findViewById(R.id.sw_posts);

        initData();
        mGvTitle.setAdapter(new BbsGVAdapter(mapList, getContext()));
        mGvTitle.setOnItemClickListener(this);

        // 指定布局方式，Linear 的话默认就是类似 ListView 了
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mLvShow.setLayoutManager(layoutManager);
        mLvShow.setAdapter(new BbsItemAdapter(mBeanList));
        mSwPosts.setOnRefreshListener(this);

        return view;
    }

    private void initData() {
        mapList = new ArrayList<>();
        mBeanList = new ArrayList<>();
        // 图片
        img = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        // 对应的文字
        imgName = new String[]{"conan", "death_note", "naruto", "one_piece", "loli", "lolicon"};

        for (int i = 0; i < img.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", img[i]);
            map.put("text", imgName[i]);
            mapList.add(map);
        }

        for (int i = 0; i < 5; i++) {
            PostBean postBean=new PostBean();
            postBean.setTitle("标题"+(i+1));
            postBean.setContent("副标题"+(i+1));
            postBean.setImgUrl("http://of8vzatuv.bkt.clouddn.com/bbs03.jpg");
            mBeanList.add(postBean);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "点击的是：" + mapList.get(position).get("text"), Toast.LENGTH_SHORT).show();
    }

    // 下拉刷新
    @Override
    public void onRefresh() {
        // 测试代码
        mSwPosts.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                // 通过setRefreshing(false)使动画停止
                mSwPosts.setRefreshing(false);
            }
        }, 3000);
    }
}
