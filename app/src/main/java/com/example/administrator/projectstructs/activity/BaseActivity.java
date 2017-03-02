package com.example.administrator.projectstructs.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.administrator.projectstructs.HomeWatcherReceiver;
import com.example.administrator.projectstructs.R;

import java.util.Stack;

/**
 * Created by Administrator on 2016/11/3.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG ="===========================" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManger.add(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
    }
    private static HomeWatcherReceiver mHomeKeyReceiver = null;

    private static void registerHomeKeyReceiver(Context context) {
        Log.i(LOG_TAG, "registerHomeKeyReceiver");
        mHomeKeyReceiver = new HomeWatcherReceiver();
        final IntentFilter homeFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

        context.registerReceiver(mHomeKeyReceiver, homeFilter);
    }

    private static void unregisterHomeKeyReceiver(Context context) {
        Log.i(LOG_TAG, "unregisterHomeKeyReceiver");
        if (null != mHomeKeyReceiver) {
            context.unregisterReceiver(mHomeKeyReceiver);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        registerHomeKeyReceiver(this);
    }

    @Override
    protected void onPause() {

        unregisterHomeKeyReceiver(this);
        super.onPause();
    }
    public static class ActivityManger {
        private static Stack<Activity> activities = new Stack<>();

        public static void add(Activity activity) {
            activities.add(activity);
        }

        public static void remove(Activity activity) {
            activities.remove(activity);
        }

        public static void clear() {
            activities.clear();
        }

        public static void killAll() {
            for (Activity activity : activities) {
                activity.finish();
            }
        }
    }
    /**
     * 初始化布局
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化监听
     */
    public  void initListener(){
        View view = findViewById(R.id.back);
        if (view!=null){
            view.setOnClickListener(this);
        }
    };

    /**
     * 处理点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            default:
                //处理其他事件的点击事件
                onInnerClickListener(v);
                break;
        }
    }

    public void onInnerClickListener(View view) {

    }
    public   void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
