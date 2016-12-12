package com.example.administrator.projectstructs.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.fragment.FragmentItem5;
import com.example.administrator.projectstructs.fragment.FragmentItemscroolView;

/**
 * Created by Administrator on 2016/12/12.
 */
public class MyButtonActivity extends BaseActivity {

    private Button btnScroolTextView;
    private Button btnRattingBar;
    private Button btnMessageUi;
    private Button btnIndicator;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_button;
    }

    @Override
    public void initView() {
        btnScroolTextView = (Button) findViewById(R.id.btn_1);
        btnRattingBar = (Button) findViewById(R.id.btn_2);
        btnMessageUi = (Button) findViewById(R.id.btn_3);
        btnIndicator = (Button) findViewById(R.id.btn_4);
//        btnScroolTextView = (Button) findViewById(R.id.btn_5);
//        btnScroolTextView = (Button) findViewById(R.id.btn_6);
//        btnScroolTextView = (Button) findViewById(R.id.btn_7);
//        btnScroolTextView = (Button) findViewById(R.id.btn_8);
//        btnScroolTextView = (Button) findViewById(R.id.btn_9);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onInnerClickListener(View view) {
        super.onInnerClickListener(view);
        switch (view.getId()){
            case R.id.btn_1:
                //滚动文本
                getSupportFragmentManager().beginTransaction().replace(R.id.ll_containers,new FragmentItemscroolView()).commit();
                break;
            case R.id.btn_2:
                Intent intent = new Intent(this,PictureActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_3:
                //短信界面
                getSupportFragmentManager().beginTransaction().replace(R.id.ll_containers,new FragmentItem5()).commit();
                break;
            case  R.id.btn_4:
                //指示器
                Intent intent1 = new Intent(this,IndicatorActivity.class);
                startActivity(intent1);
                break;
        }

    }

    @Override
    public void initListener() {
        super.initListener();
        btnScroolTextView.setOnClickListener(this);
        btnRattingBar.setOnClickListener(this);
        btnMessageUi.setOnClickListener(this);
        btnIndicator.setOnClickListener(this);

    }
}
