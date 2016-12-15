package com.example.administrator.projectstructs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.administrator.projectstructs.activity.BaseActivity;
import com.example.administrator.projectstructs.activity.LGActivity;

/**
 * Created by Administrator on 2016/12/12.
 */
public class MenuAdapter extends BaseAdapter {
    private String[] leftstr;
    private Context context;
    public MenuAdapter(String[] leftStr, Context lgActivity) {
        this.leftstr = leftStr;
        this.context = lgActivity;
    }

    @Override
    public int getCount() {
        return leftstr.length;
    }

    @Override
    public Object getItem(int position) {
        return leftstr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setTextSize(20);
        tv.setHeight(50);
        tv.setText(leftstr[position]);
        return tv;
    }
}
