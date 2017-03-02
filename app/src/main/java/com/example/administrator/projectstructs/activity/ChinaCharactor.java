package com.example.administrator.projectstructs.activity;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.view.LimitEdittext;
import com.example.administrator.projectstructs.view.view;

/**
 * Created by Administrator on 2016/12/15.
 */
public class ChinaCharactor extends BaseActivity {

    private LimitEdittext text;

    @Override
    public int getLayoutId() {
        return R.layout.activity_chanacharactor;
    }

    @Override
    public void initView() {
        text = (LimitEdittext) findViewById(R.id.edit_text);
        Button view  = (Button) findViewById(R.id.edit);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("view的事件传递", "onClick");
            }
        });
       view.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               switch (event.getAction()){
                   case MotionEvent.ACTION_DOWN:
                       Log.i("view的事件传递", "ACTION_DOWN");
                       break;
                   case MotionEvent.ACTION_MOVE:
                       Log.i("view的事件传递", "ACTION_MOVE");
                       break;
                   case MotionEvent.ACTION_UP:
                       Log.i("view的事件传递", "ACTION_UP");
                       break;
                   case MotionEvent.ACTION_CANCEL:
                       Log.i("view的事件传递", "ACTION_CANCEL");
                       break;
               }
               Log.i("view的事件传递", "onTouch");
               return false;
           }
       });
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("view的事件传递","dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("view的事件传递","onTouchEvent");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("view的事件传递", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("view的事件传递", "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("view的事件传递", "ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("view的事件传递", "ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(event);
    }
    @Override
    public void initData() {
//

    }
}
