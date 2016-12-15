package com.example.administrator.projectstructs.activity;
import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.view.LimitEdittext;

/**
 * Created by Administrator on 2016/12/15.
 */
public class ChinaCharactor extends BaseActivity{

    private LimitEdittext text;

    @Override
    public int getLayoutId() {
        return R.layout.activity_chanacharactor;
    }

    @Override
    public void initView() {
        text = (LimitEdittext) findViewById(R.id.edit_text);
    }
    @Override
    public void initData() {

    }
}
