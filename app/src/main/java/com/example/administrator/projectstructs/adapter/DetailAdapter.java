package com.example.administrator.projectstructs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;


/**
 * Created by Administrator on 2016/12/12.
 */
public class DetailAdapter extends BaseAdapter {
    private Context context;
    private String[][] rightStr;
    private int i = 0;
    public DetailAdapter(String[][] rightStr, Context lgActivity,int i) {
        this.context = lgActivity;
        this.rightStr = rightStr;
        this.i = i;
    }
    @Override
    public int getCount() {
        return rightStr[i].length;
    }

    @Override
    public Object getItem(int position) {
        return rightStr[i][position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyGVViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_gridview,null);
            holder = new MyGVViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image333);
            holder.textView = (TextView) convertView.findViewById(R.id.item_gv_detail);
            convertView.setTag(holder);
        }else {
            holder = (MyGVViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(R.drawable.girl1);
        holder.textView.setText(rightStr[i][position]);
        return convertView;
    }


    private class MyGVViewHolder {

        public ImageView imageView;
        public TextView textView;
    }
}
