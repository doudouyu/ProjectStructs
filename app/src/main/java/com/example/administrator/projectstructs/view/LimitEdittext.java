package com.example.administrator.projectstructs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/12/15.
 */
public class LimitEdittext extends EditText {
    public LimitEdittext(Context context) {
        super(context);
    }

    public LimitEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LimitEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return new mInputConnecttion(super.onCreateInputConnection(outAttrs),
                false);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
