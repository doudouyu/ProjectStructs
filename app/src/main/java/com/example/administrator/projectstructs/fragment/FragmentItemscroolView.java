package com.example.administrator.projectstructs.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;

/**
 * Created by Administrator on 2016/12/12.
 */
public class FragmentItemscroolView extends BaseFragment {

    private TextView textView;

    @Override
    protected void initView(View view) {
        textView = (TextView) view.findViewById(R.id.tv_text);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 1000; i++) {
            textView.append("i have a dream!");
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment6;
    }
}
