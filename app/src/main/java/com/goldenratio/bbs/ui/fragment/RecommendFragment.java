package com.goldenratio.bbs.ui.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.goldenratio.bbs.R;
import com.goldenratio.bbs.adapter.RecommendListAdapter;
import com.goldenratio.bbs.domain.RecommendBean;
import com.goldenratio.bbs.tools.GlideImageLoader;
import com.goldenratio.bbs.ui.customView.ScrollListView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面
 */
public class RecommendFragment extends Fragment {
    Banner mRecommendBanner;
    List<String> imgUrlList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    SwipeRefreshLayout mSwipeRefreshLayout;
    ScrollListView recommendListView;
    List<RecommendBean> listDate=new ArrayList<>();
    RecommendListAdapter mRecommendListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        mRecommendBanner = (Banner) view.findViewById(R.id.recommend_banner);
        mSwipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.recommend_swipe);
        recommendListView= (ScrollListView) view.findViewById(R.id.recommend_list);
        listDateLoader();
        mRecommendListAdapter = new RecommendListAdapter(listDate,getActivity());
        recommendListView.setAdapter(mRecommendListAdapter);


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
                Toast.makeText(getActivity(), "加载完。。", Toast.LENGTH_SHORT).show();
            }
        });

        initList();
        startBanner();
        return view;
    }

    //获取date
    private void listDateLoader() {
        for (int i = 0; i < 5; i++) {
            RecommendBean recommendBean=new RecommendBean();
            recommendBean.setTitle("标题"+(i+1));
            recommendBean.setContent("副标题"+(i+1));
            recommendBean.setImgUrl("http://of8vzatuv.bkt.clouddn.com/bbs03.jpg");
            listDate.add(recommendBean);
        }

    }

    private void refreshContent(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);//通知刷新停止
            }
        },1000);
    }

    private void startBanner(){
        mRecommendBanner.setImageLoader(new GlideImageLoader());
        mRecommendBanner.setImages(imgUrlList);
        mRecommendBanner.setBannerTitles(titleList);
        mRecommendBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);//图片样式
        mRecommendBanner.setIndicatorGravity(BannerConfig.RIGHT);

        mRecommendBanner.start();
    }
    private void initList(){
        imgUrlList.add("http://of8vzatuv.bkt.clouddn.com/bbs01.jpg");
        imgUrlList.add("http://of8vzatuv.bkt.clouddn.com/bbs02.jpg");
        imgUrlList.add("http://of8vzatuv.bkt.clouddn.com/bbs03.jpg");
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
        mRecommendBanner.update(imgUrlList,titleList);
    }

}
