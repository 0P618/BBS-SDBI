package com.goldenratio.bbs.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.goldenratio.bbs.R;
import com.goldenratio.bbs.adapter.MainPagerAdapter;
import com.goldenratio.bbs.ui.fragment.BBSFragment;
import com.goldenratio.bbs.ui.fragment.OtherFragment;
import com.goldenratio.bbs.ui.fragment.RecommendFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<String> mDataList;
    private List<Fragment> mFragmentList;
    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),mFragmentList));

        initMagicIndicator();
    }

    // 初始化数据，标题与 VP 关联的 Fragment
    private void initData() {
        lastTime = 0;
        mDataList = new ArrayList<>();
        mDataList.add("推荐");
        mDataList.add("论坛");
        mDataList.add("待定");
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new RecommendFragment());
        mFragmentList.add(new BBSFragment());
        mFragmentList.add(new OtherFragment());
    }

    // 初始化顶部 Tab
    private void initMagicIndicator() {
        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(this, 15));
        // 是否需要分割线，自行定义
        // titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    // 按两次退出
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime >= 2000){
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            lastTime = System.currentTimeMillis();
        }else {
            finish();
            System.exit(0);
        }
    }
}
