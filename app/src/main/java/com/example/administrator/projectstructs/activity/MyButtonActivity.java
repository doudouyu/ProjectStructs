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
    private Button btnShuangLianDong;
    private Button btnCharsetSort;
    private Button btnCamera;
    private Button btnChineseCharactor;

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
        btnShuangLianDong = (Button) findViewById(R.id.btn_5);
        btnCharsetSort = (Button) findViewById(R.id.btn_6);
        btnCamera = (Button) findViewById(R.id.btn_7);
        btnChineseCharactor = (Button) findViewById(R.id.btn_8);
//        btnChineseCharactor = (Button) findViewById(R.id.btn_9);
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
            case R.id.btn_5:
                //双联动列表
                Intent intent2 = new Intent(this,LGActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_6:
                //字母排序
                Intent intent3 = new Intent(this,CharsetSortActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_7:
                //自定义相机
                Intent intent4 = new Intent(this,CameraActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_8:
                //只能输入汉字的edittext
                Intent intent5 = new Intent(this,ChinaCharactor.class);
                startActivity(intent5);
                break;
            case R.id.btn_9:
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
        btnShuangLianDong.setOnClickListener(this);
        btnCharsetSort.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
        btnChineseCharactor.setOnClickListener(this);

    }
}
