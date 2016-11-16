package com.example.administrator.projectstructs.fragment;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.adapter.MyListViewAdapter;
import com.example.administrator.projectstructs.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */
public class FragmentItem3 extends BaseFragment {

    private TextView textView;
    private List <String>list = new ArrayList();
    private int[] list1 = {R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10
            , R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10, R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10};

    @Override
    protected void initView(View view) {
        textView = (TextView) view.findViewById(R.id.tv_title);
        ListView lv = (ListView) view.findViewById(R.id.lv_rl);
       for (int i = 0;i<50;i++){
            list.add("条目"+i);
        }
        lv.setAdapter(new MyViewAdapter(_context,list));

    }

    @Override
    protected void initData() {
        textView.setText("我是fragment3");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment3;
    }

    private class MyViewAdapter extends BaseAdapter {
        public MyViewAdapter(Context context, List list) {
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
            TestHolder viewHolder ;
            if (convertView == null){
                viewHolder = new TestHolder();
                convertView = View.inflate(_context,R.layout.test,null);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.test);
                viewHolder.recycler = (RecyclerView) convertView.findViewById(R.id.rl_lv);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (TestHolder) convertView.getTag();
            }
            viewHolder.textView.setText(list.get(position));
            //第三个boolean类型的参数标示默呈现的图片是哪一个，true标示显示最后一个图片，false标示默认显示最后一个图片
//            viewHolder.recycler.setLayoutManager(new LinearLayoutManager(_context,LinearLayoutManager.HORIZONTAL,true));
            viewHolder.recycler.setLayoutManager(new LinearLayoutManager(_context,LinearLayoutManager.HORIZONTAL,false));
            viewHolder.recycler.setAdapter(new MyItemRecyclerAdapter(list1));
            return convertView;
        }

        public class MyItemRecyclerAdapter extends RecyclerView.Adapter<MyItemRecyclerAdapter.MyItemHolder> {
            int[] l;
            public MyItemRecyclerAdapter(int [] i) {
                this.l = i;
            }

            @Override
            public MyItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                View view = View.inflate(_context,R.layout.testitem,null);
                Log.i("填充布局","onCreateViewHolder");
                View view = LayoutInflater.from(_context).inflate(R.layout.testitem,parent,false);
                return new MyItemHolder(view);
            }

            @Override
            public void onBindViewHolder(MyItemHolder holder, int position) {
                //这里用来设置数据
                Log.i("绑定数据","onBindViewHolder");
                holder.tv.setImageResource(l[position]);

            }

            @Override
            public int getItemCount() {
                Log.i("集合长度",list.size()+"");
                return l.length;
            }

            public class MyItemHolder extends RecyclerView.ViewHolder {
                ImageView tv;
                public MyItemHolder(View view) {
                    super(view);
                    tv = (ImageView) view.findViewById(R.id.tvtvtv);
                }
            }
        }
    }

    private class TestHolder {

        public TextView textView;
        public RecyclerView recycler;
    }

}
