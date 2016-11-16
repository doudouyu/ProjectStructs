package com.example.administrator.projectstructs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;


/**
 * Created by Administrator on 2016/11/3.
 */
public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//    private static final int TYPE_COUNT = 1;
//    private
    public MyListViewAdapter(Context context) {
        this.context = context;
    }

    //返回listView的类型的个数
    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    //返回listview对应的样式
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //在这里判断类型
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_listview, null);
            holder.tv = (TextView) convertView.findViewById(R.id.text_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list[position]);
        return convertView;
    }

    private class ViewHolder {
        public TextView tv;
    }
}
