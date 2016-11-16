package com.example.administrator.projectstructs.utils;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/11/7.
 */
public class MyUtils {

    public static void showMenu(RelativeLayout rl) {
        showMenu(rl, 0);

    }

    public static void hideMenu(RelativeLayout rl) {
        hideMenu(rl, 0);
    }

    public static void hideMenu(RelativeLayout rl, int i) {
        RotateAnimation ra = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1);
        ra.setDuration(200);
        ra.setStartOffset(i);
        ra.setFillAfter(true);
        rl.startAnimation(ra);
        for (int j = 0; j < rl.getChildCount(); j++) {
            rl.getChildAt(j).setEnabled(false);
            rl.getChildAt(j).setClickable(false);
        }
    }

    public static void showMenu(RelativeLayout rl, int j) {
        RotateAnimation ra = new RotateAnimation(180, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1);
        ra.setFillAfter(true);//设置动画结束后的位置
        ra.setDuration(200);//设置动画播放的时间
        ra.setStartOffset(j);
        rl.startAnimation(ra);
        //获取自布局的格式
        int count = rl.getChildCount();
        for (int i = 0; i < count; i++) {
            rl.getChildAt(i).setEnabled(true);
            rl.getChildAt(i).setClickable(true);
        }
    }
}
