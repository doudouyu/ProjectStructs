package com.example.administrator.projectstructs.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.activity.IndicatorActivity;
import com.example.administrator.projectstructs.activity.MyButtonActivity;
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
    private LinearLayout ll_point;
    private List<ImageView> list1;

    @Override
    protected void initView(View view) {
        pager = (CycleViewPager) view.findViewById(R.id.banner);
        ll = (LinearLayout) view.findViewById(R.id.ll_container);
        ll_point = (LinearLayout) view.findViewById(R.id.ll_points);


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
    public void onStart() {
        super.onStart();
        pager.startScroll();
    }

    @Override
    public void onStop() {
        super.onStop();
        pager.stopScroll();
    }

    @Override
    protected void initData() {
        if (list.size() == 0) {
            list.add(R.drawable.picture1);
            list.add(R.drawable.picture2);
            list.add(R.drawable.picture3);
            list.add(R.drawable.picture4);
        }
        addPoint();
        pager.setAdapter(new MyItemPagerAdapter(_context, list));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("页面改变了", position + "");
                //当页面改变的时候，改变圆点的样式
                for (int i = 0; i < list1.size(); i++) {
                    if (i == position - 1) {
                        list1.get(i).setImageResource(R.drawable.selected_point);
                    } else {
                        list1.get(i).setImageResource(R.drawable.default_point);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(_context,IndicatorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void addPoint() {
        //存放imageView
        list1 = new ArrayList();
        list1.clear();
        ll_point.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(_context);
            if (i == 0) {
                imageView.setImageResource(R.drawable.selected_point);
            } else {
                imageView.setImageResource(R.drawable.default_point);
            }
            //给指示点添加一个间隔
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 10;
            list1.add(imageView);
            ll_point.addView(imageView, params);
        }
    }

    @Override
    protected void initListener() {
        pager.setOnItemClickListener(new CycleViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(_context, MyButtonActivity.class);
//                intent.putExtra("position", position);
//                intent.putExtra("list", ll_contains);
                startActivity(intent);
            }
        });

    }
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment1;
    }
}
