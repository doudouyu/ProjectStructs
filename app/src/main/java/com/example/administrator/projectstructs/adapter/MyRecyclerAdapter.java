package com.example.administrator.projectstructs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.projectstructs.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/8.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    //    List<Integer> list = new ArrayList<>();
    private int[] list;
    Context context;
    private OnRecyclerItemClickListener recyclerItemClickListener;

    public MyRecyclerAdapter(int[] list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recyclerview, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.iv.setImageResource(list[position]);
        if (recyclerItemClickListener!=null){
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    recyclerItemClickListener.OnMyItemClick(holder.itemView, pos);
                }
            });
            holder.iv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    recyclerItemClickListener.OnMyItemLongClick(holder.itemView,pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
//        return list.size();
        return list.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        private MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_girl);
        }
    }
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener recyclerItemClickListener ){
        this.recyclerItemClickListener=recyclerItemClickListener;
    }

    public interface OnRecyclerItemClickListener {
        void OnMyItemClick(View view,int position);
        void OnMyItemLongClick( View view,int position);
    }
}
