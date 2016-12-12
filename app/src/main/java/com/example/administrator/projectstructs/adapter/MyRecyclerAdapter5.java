package com.example.administrator.projectstructs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.bean.CheckedBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
public class MyRecyclerAdapter5 extends BaseAdapter {
    private List<CheckedBean> list = new ArrayList<>();
    private Context context;


    public MyRecyclerAdapter5( List<CheckedBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyRecycleViewHolder holder = null;
        if (convertView == null) {
            holder = new MyRecycleViewHolder();
            convertView = View.inflate(context, R.layout.layout_item_recycler, null);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_content);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image_icon);
            convertView.setTag(holder);
        } else {
            holder = (MyRecycleViewHolder) convertView.getTag();
        }
        if (list.get(0).getBianji() == true){
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(list.get(position).isChecked);
        }else{
            holder.checkBox.setVisibility(View.GONE);
        }
        holder.textView.setText(list.get(position).name);
        holder.imageView.setImageResource(R.drawable.girl1);
        return convertView;
    }

    public class MyRecycleViewHolder {
        public CheckBox checkBox;
        public TextView textView;
        public ImageView imageView;
    }
}
