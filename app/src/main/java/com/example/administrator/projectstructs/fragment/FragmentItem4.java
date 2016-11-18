package com.example.administrator.projectstructs.fragment;

import android.graphics.Color;
import android.support.v7.graphics.drawable.DrawableUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.view.RatioFrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/3.
 */
public class FragmentItem4 extends BaseFragment {

    private TextView textView;
    private String[] s = {"北国风光", "千里冰封", "万里雪飘", "望长城内外", "惟余莽莽", "大河上下", "顿失滔滔", "山舞银蛇","原驰蜡象", "欲与天公试比高",  "须晴日", "看红装素裹", "分外妖娆", "江山如此多娇", "引无数英雄竞折腰", "惜秦皇汉武", "略输文采", "唐宗宋祖稍逊风骚", "一代天骄", "成吉思汗", "只识弯弓射大雕", "俱往矣", "数风流人物", "还看今朝"};
    private Integer[] colors = {Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE,Color.BLUE,Color.GRAY,Color.MAGENTA,Color.TRANSPARENT};
    private RatioFrameLayout layout;
    private List<TextView> list = new ArrayList<>();
    ;

    @Override
    protected void initView(View view) {
//        textView = (TextView) view.findViewById(R.id.tv_title);
        layout = (RatioFrameLayout) view.findViewById(R.id.ll_ratio);
    }

    @Override
    protected void initData() {
        int padding = 13;
        layout.setPadding(padding, padding, padding, padding);
        TextView textView;
        String text;
        int textPaddingV = 4;
        int textPaddingH = 7;
        for (int i = 0; i < s.length; i++) {
            text = s[i];
            textView = new TextView(_context);
            textView.setText(text);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(colors[new Random().nextInt(colors.length)]);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);//14dp
            textView.setPadding(textPaddingH, textPaddingV, textPaddingH, textPaddingV);
            layout.addView(textView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
//            layout.addView(textView);
            final String temp = text;
            //设置点击事件
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(_context,temp,Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment4;
    }
}
