package com.example.administrator.projectstructs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2016/11/17.具有宽高比例的控件
 */
public class RatioLayout extends FrameLayout {
    private float ratio = 2.43f;

    public RatioLayout(Context context) {
        super(context);

    }

    public RatioLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RatioLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测量大小
        //获取宽高的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode =MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY&&heightMode!=MeasureSpec.EXACTLY){
            height = (int) (width*ratio);
        }else if (widthMode!=MeasureSpec.EXACTLY&&heightMode == MeasureSpec.EXACTLY){
            width = (int) (height*ratio);
        }
        //拼自己的尺子
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,widthMode);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,heightMode);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
