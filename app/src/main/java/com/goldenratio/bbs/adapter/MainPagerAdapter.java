package com.goldenratio.bbs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/4/14 0014.
 * 主界面的 VP 适配器
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
