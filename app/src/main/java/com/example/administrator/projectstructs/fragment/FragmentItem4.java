package com.example.administrator.projectstructs.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;

/**
 * Created by Administrator on 2016/11/3.
 */
public class FragmentItem4 extends BaseFragment {

    private TextView textView;

    @Override
    protected void initView(View view) {
        textView = (TextView) view.findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        textView.setText("我是fragment4");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment4;
    }
}
