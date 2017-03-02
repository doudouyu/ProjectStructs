package com.example.administrator.projectstructs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.projectstructs.activity.BaseActivity;

/**
 * Created by Administrator on 2016/12/16.
 */
public class HomeWatcherReceiver  extends BroadcastReceiver {
    private static final String LOG_TAG = "HomeWatcherReceiver";
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_REASON_LOCK = "lock";
    private static final String SYSTEM_DIALOG_REASON_ASSIST = "assist";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i(LOG_TAG, "onReceive: action: " + action);
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
            // android.intent.action.CLOSE_SYSTEM_DIALOGS
            String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
            Log.i(LOG_TAG, "reason: " + reason);
            if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                // 短按Home键
                Log.i(LOG_TAG, "homekey");
                Toast.makeText(context, "homekey: " + reason,Toast.LENGTH_SHORT).show();
                BaseActivity.ActivityManger.killAll();
            }
            else if (SYSTEM_DIALOG_REASON_RECENT_APPS.equals(reason)) {
                // 长按Home键 或者 activity切换键
                Log.i(LOG_TAG, "long press home key or activity switch");
                Toast.makeText(context, "long press home key or activity switch: " + reason,Toast.LENGTH_SHORT).show();
                BaseActivity.ActivityManger.killAll();
            }
            else if (SYSTEM_DIALOG_REASON_LOCK.equals(reason)) {
                // 锁屏
                Log.i(LOG_TAG, "lock");
                Toast.makeText(context, "lock " + reason,Toast.LENGTH_SHORT).show();
                BaseActivity.ActivityManger.killAll();
            }
            else if (SYSTEM_DIALOG_REASON_ASSIST.equals(reason)) {
                // samsung 长按Home键
                Log.i(LOG_TAG, "assist");
                Toast.makeText(context, "assist " + reason,Toast.LENGTH_SHORT).show();
                BaseActivity.ActivityManger.killAll();
            }

        }
    }

}




