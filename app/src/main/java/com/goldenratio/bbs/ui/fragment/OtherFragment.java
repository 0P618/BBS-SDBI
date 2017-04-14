package com.goldenratio.bbs.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goldenratio.bbs.R;

/**
 * 其他页面，暂时未定
 */
public class OtherFragment extends Fragment {


    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false);
    }

}
