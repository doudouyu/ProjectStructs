package com.example.administrator.projectstructs.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.activity.PictureActivity;
import com.example.administrator.projectstructs.adapter.MyItemPagerAdapter;
import com.example.administrator.projectstructs.adapter.MyListViewAdapter;
import com.example.administrator.projectstructs.view.CycleViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */
public class FragmentItem1 extends BaseFragment {

    private CycleViewPager pager;
    private List<Integer> list = new ArrayList<>();
    private int[] ll_contains = {R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10};
    private LinearLayout ll;
    private View view1;
    private ListView lv;

    @Override
    protected void initView(View view) {
        pager = (CycleViewPager) view.findViewById(R.id.banner);
        ll = (LinearLayout) view.findViewById(R.id.ll_container);
        for (int i = 0; i < ll_contains.length; i++) {
            view1 = View.inflate(_context, R.layout.item_image, null);
            ImageView iv = (ImageView) view1.findViewById(R.id.image);
//            TextView tv = (TextView) view1.findViewById(R.id.text);
            iv.setImageResource(ll_contains[i]);
//            tv.setText("我是美眉" + i);
            ll.addView(view1);
        }

        lv = (ListView) view.findViewById(R.id.lv);
        lv.setAdapter(new MyListViewAdapter(_context));
    }

    @Override
    protected void initData() {
        list.add(R.drawable.picture1);
        list.add(R.drawable.picture2);
        list.add(R.drawable.picture3);
        list.add(R.drawable.picture4);
        pager.setAdapter(new MyItemPagerAdapter(_context, list));

    }

    @Override
    protected void initListener() {
        pager.setOnItemClickListener(new CycleViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(_context,PictureActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("list",ll_contains);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment1;
    }
}
