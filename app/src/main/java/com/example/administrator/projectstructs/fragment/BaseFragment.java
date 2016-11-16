package com.example.administrator.projectstructs.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/3.
 */
public abstract class BaseFragment extends Fragment {
    public   Context _context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _context = getActivity();
        View view = View.inflate(_context,getLayoutResId(),null);
        initView(view);
        initData();
        initListener();
        return view;
    }
    /**
     * 初始化fragment控件
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 初始化fragment数据
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 初始化fragment
     * @return
     */
    protected abstract int getLayoutResId();

    public  void showToast(String s){
        Toast.makeText(_context,s,Toast.LENGTH_SHORT).show();
    }

}
