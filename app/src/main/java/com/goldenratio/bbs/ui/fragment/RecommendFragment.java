package com.goldenratio.bbs.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goldenratio.bbs.R;
import com.goldenratio.bbs.tools.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面
 */
public class RecommendFragment extends Fragment {
    Banner recommendBanner;
    List<String> imgUrlList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        recommendBanner = (Banner) view.findViewById(R.id.recommend_banner);
        initList();
        startBanner();

        return view;
    }

    private void startBanner(){
        recommendBanner.setImageLoader(new GlideImageLoader());
        recommendBanner.setImages(imgUrlList);
        recommendBanner.setBannerTitles(titleList);
        recommendBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);//图片样式
        recommendBanner.setIndicatorGravity(BannerConfig.RIGHT);

        recommendBanner.start();
    }
    private void initList(){
        imgUrlList.add("http://of8vzatuv.bkt.clouddn.com/bbs01.jpg");
        imgUrlList.add("http://of8vzatuv.bkt.clouddn.com/bbs02.jpg");
        imgUrlList.add("http://of8vzatuv.bkt.clouddn.com/bbs03.jpg");
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
        recommendBanner.update(imgUrlList,titleList);
    }

}
