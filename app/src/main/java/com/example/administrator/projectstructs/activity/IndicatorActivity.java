package com.example.administrator.projectstructs.activity;

import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.adapter.ViewPagerAdapter;
import com.example.administrator.projectstructs.fragment.BaseFragment;
import com.example.administrator.projectstructs.fragment.FragmentIndicator1;
import com.example.administrator.projectstructs.fragment.FragmentIndicator2;
import com.example.administrator.projectstructs.fragment.FragmentIndicator3;
import com.example.administrator.projectstructs.fragment.FragmentItem1;
import com.example.administrator.projectstructs.fragment.FragmentItem2;
import com.example.administrator.projectstructs.fragment.FragmentItem5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public class IndicatorActivity extends BaseActivity {

    private ViewPager viewPager;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private View view;
    private List<BaseFragment> fragments = new ArrayList<>();
    private int linesWidth;
    private ViewPagerAdapter viewHelper;

    @Override
    public int getLayoutId() {
        return R.layout.activity_indicator;
    }

    @Override
    public void initView() {
        //找到三个textView做动画
        textView1 = (TextView) findViewById(R.id.tv1);
        textView2 = (TextView) findViewById(R.id.tv2);
        textView3 = (TextView) findViewById(R.id.tv3);
        //找到指示线移动
        view = findViewById(R.id.line);
        //找到ViewPager切换fragment
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void initData() {
        fragments.add(new FragmentIndicator1());
        fragments.add(new FragmentIndicator2());
        fragments.add(new FragmentIndicator3());
        getLinesWidth();
        //给三个textView设置点击事件
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new OnMyPagerChangeListener());
        //给ViewPager设置adapter
        viewHelper = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(viewHelper);
    }

    /**
     * 测量指示线的宽度
     */
    private void getLinesWidth() {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        linesWidth = screenWidth / fragments.size();
        view.getLayoutParams().width = linesWidth;

    }

    private class OnMyPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // 偏移距离 = 位移距离百分比 * 指示线宽度
            float disX = positionOffset * linesWidth;
            float startX = position * linesWidth;
            float endX = startX + disX;
            // Todo 指示线设置平移动画
            ObjectAnimator//
                    .ofFloat(view, "translationX", startX, endX)//
                    .setDuration(100)//
                    .start();
        }

        //
        @Override
        public void onPageSelected(int position) {
            //当页面被选中的时候，切换viewPager的Fragment，改变字体的颜色
            int green = getResources().getColor(R.color.green);
            int halfWhite = getResources().getColor(R.color.red);
            textView1.setTextColor(position == 0 ? green : halfWhite);
            textView2.setTextColor(position == 1 ? green : halfWhite);
            textView3.setTextColor(position == 2 ? green : halfWhite);
            if (position == 0){
                scaleX1(textView1);
                scaleX2(textView2);
                scaleX2(textView3);
            }else if (position == 1){
                scaleX1(textView2);
                scaleX2(textView1);
                scaleX2(textView3);
            }else if (position == 2){
                scaleX1(textView3);
                scaleX2(textView1);
                scaleX2(textView2);
            }
        }

        @Override
        public    void onPageScrollStateChanged(int state) {

    }
}

    private void scaleX1(View view) {
        ObjectAnimator//
                .ofFloat(view, "ScaleX", 1.0f, 1.8f)//
                .setDuration(10)//
                .start();
    }

    private void scaleX2(View view) {
        ObjectAnimator//
                .ofFloat(view, "ScaleX", 1.8f, 1.0f)//
                .setDuration(10)//
                .start();
    }

    @Override
    public void onInnerClickListener(View view) {
        super.onInnerClickListener(view);
        switch (view.getId()) {
            case R.id.tv1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv2:
                viewPager.setCurrentItem(1);

                break;
            case R.id.tv3:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
