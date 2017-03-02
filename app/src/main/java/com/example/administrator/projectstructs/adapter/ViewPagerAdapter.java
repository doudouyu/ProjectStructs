package com.example.administrator.projectstructs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.projectstructs.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
private List<BaseFragment> fragments = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm,List<BaseFragment>fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
