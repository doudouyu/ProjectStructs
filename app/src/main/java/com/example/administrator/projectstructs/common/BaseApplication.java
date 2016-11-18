package com.example.administrator.projectstructs.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/11/17.
 */
public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = BaseApplication.this;
    }

    public static Context getInstance() {
        return context;
    }
}
