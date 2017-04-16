package com.goldenratio.bbs.ui.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 冰封承諾Andy on 2017/4/15 0015.
 * 自定义 GridView
 * 解决和
 */

public class ScrollGridView extends GridView {

    public ScrollGridView(Context context) {
        super(context);
    }

    public ScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
