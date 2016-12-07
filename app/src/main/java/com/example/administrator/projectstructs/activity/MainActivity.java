package com.example.administrator.projectstructs.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.adapter.MyPagerAdapter;
import com.example.administrator.projectstructs.fragment.BaseFragment;
import com.example.administrator.projectstructs.fragment.FragmentItem1;
import com.example.administrator.projectstructs.fragment.FragmentItem2;
import com.example.administrator.projectstructs.fragment.FragmentItem3;
import com.example.administrator.projectstructs.fragment.FragmentItem4;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private ViewPager viewPager;
    private List<BaseFragment> fragments = new ArrayList<BaseFragment>();
    private BaseFragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rb1 = (RadioButton) findViewById(R.id.rb_1);
        rb2 = (RadioButton) findViewById(R.id.rb_2);
        rb3 = (RadioButton) findViewById(R.id.rb_3);
        rb4 = (RadioButton) findViewById(R.id.rb_4);
        viewPager = (ViewPager) findViewById(R.id.ll);
    }

    @Override
    public void initData() {
        fragments.add(new FragmentItem1());
        fragments.add(new FragmentItem2());
        fragments.add(new FragmentItem3());
        fragments.add(new FragmentItem4());
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments));
    }

    @Override
    public void initListener() {
        super.initListener();
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
//        viewPager.setOnItemClickListener();
    }

    @Override
    public void onInnerClickListener(View view) {
        super.onInnerClickListener(view);
        switch (view.getId()) {
            case R.id.rb_1:
                showToast("rb_1");
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_2:
                showToast("rb_2");
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_3:
                showToast("rb_3");
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb_4:
                showToast("rb_4");
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU){
            new FragmentItem2().onKeyDown(keyCode,event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
