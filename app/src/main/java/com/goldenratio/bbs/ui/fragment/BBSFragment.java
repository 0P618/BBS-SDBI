package com.goldenratio.bbs.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.goldenratio.bbs.R;
import com.goldenratio.bbs.adapter.BbsGVAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBSFragment extends Fragment implements AdapterView.OnItemClickListener {
    private GridView mGvTitle;
    private ListView mLvShow;
    private int[] img;
    private String[] imgName;
    private List<Map<String, Object>> mapList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bbs, container, false);

        mGvTitle = (GridView) view.findViewById(R.id.gv_title);
        mLvShow = (ListView) view.findViewById(R.id.lv_show);

        initData();
        mGvTitle.setAdapter(new BbsGVAdapter(mapList, getContext()));
        mGvTitle.setOnItemClickListener(this);

        return view;
    }

    private void initData() {
        mapList = new ArrayList<>();
        // 图片
        img = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        // 对应的文字
        imgName = new String[]{"conan", "death_note", "naruto", "one_piece"};

        for (int i = 0; i < img.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", img[i]);
            map.put("text", imgName[i]);
            mapList.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "点击的是：" + mapList.get(position).get("text"), Toast.LENGTH_SHORT).show();
    }

}
