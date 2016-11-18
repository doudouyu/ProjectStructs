package com.example.administrator.projectstructs.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/11/17.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration{
    private int space ;
    public SpaceItemDecoration(int i) {
        this.space = i;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = space;
        outRect.right = space;

        outRect.bottom = space;
        outRect.top = space;
    }
}
