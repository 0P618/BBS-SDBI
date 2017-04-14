package com.goldenratio.bbs.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.goldenratio.bbs.R;


public class BBSFragment extends Fragment {
    private GridView mGvTitle;
    private ListView mLvShow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        mGvTitle = (GridView) view.findViewById(R.id.gv_title);
        mLvShow = (ListView) view.findViewById(R.id.lv_show);
        return view;
    }



}
