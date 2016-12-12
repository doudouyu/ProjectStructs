package com.example.administrator.projectstructs.activity;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;

/**
 * Created by Administrator on 2016/11/3.
 */
public class PictureActivity extends BaseActivity{

    private RatingBar rb;

    @Override
    public int getLayoutId() {
        return R.layout.activity_picture;
    }

    @Override
    public void initView() {
        ImageView iv = (ImageView) findViewById(R.id.image1);
        iv.setImageResource(R.drawable.girl1);

        final TextView tvScore = (TextView) findViewById(R.id.tv_score);
        rb = (RatingBar) findViewById(R.id.rating);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //当星星个数变化的时候，记录下此刻的分数
                tvScore.setText(rating+"");
            }
        });
//        rb.setStepSize(0.5f);
    }

    @Override
    public void initData() {

    }
}
