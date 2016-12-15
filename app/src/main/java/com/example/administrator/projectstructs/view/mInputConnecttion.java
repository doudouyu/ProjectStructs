package com.example.administrator.projectstructs.view;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

/**
 * Created by Administrator on 2016/12/15.
 */
public class mInputConnecttion extends InputConnectionWrapper implements InputConnection {
    public mInputConnecttion(InputConnection target, boolean mutable) {
        super(target, mutable);
    }

    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        if (!text.toString().matches("[\u4e00-\u9fa5]+")) {
            return false;
        }
        // 只能输入汉字或者英文
//        if (!text.toString().matches("[\u4e00-\u9fa5]+") && !text.toString().matches("[a-zA-Z /]+")) {
//            return false;
//        }
        return super.commitText(text, newCursorPosition);
    }

    @Override
    public boolean sendKeyEvent(KeyEvent event) {
        return super.sendKeyEvent(event);
    }

    @Override
    public boolean setSelection(int start, int end) {
        return super.setSelection(start, end);
    }
}
