package com.example.administrator.projectstructs.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.adapter.DetailAdapter;
import com.example.administrator.projectstructs.adapter.MenuAdapter;

/**
 * Created by Administrator on 2016/12/12.
 */
public class LGActivity extends BaseActivity {

    private ListView lv;
    private GridView gv;
    private String[] leftStr = new String[]{"面食类", "盖饭", "寿司", "烧烤", "酒水", "凉菜", "小吃", "粥", "休闲"};
    private String[][] rightStr = new String[][]{{"热干面", "臊子面", "烩面"},
            {"番茄鸡蛋", "红烧排骨", "农家小炒肉"},
            {"芝士", "丑小丫", "金枪鱼"}, {"羊肉串", "烤鸡翅", "烤羊排"}, {"长城干红", "燕京鲜啤", "青岛鲜啤"},
            {"拌粉丝", "大拌菜", "菠菜花生"}, {"小食组", "紫薯"},
            {"小米粥", "大米粥", "南瓜粥", "玉米粥", "紫米粥"}, {"儿童小汽车", "悠悠球", "熊大", " 熊二", "光头强"}
    };
    private TextView tv_title_name;

    @Override
    public int getLayoutId() {
        return R.layout.activity_lg;
    }

    @Override
    public void initView() {
        lv = (ListView) findViewById(R.id.lv_menu);
        gv = (GridView) findViewById(R.id.gv_detail);
        tv_title_name = (TextView) findViewById(R.id.tv_title_name);
    }

    @Override
    public void initData() {
        tv_title_name.setText(leftStr[0]);
        lv.setAdapter(new MenuAdapter(leftStr,this));
        gv.setAdapter(new DetailAdapter(rightStr,this,0));
    }

    @Override
    public void initListener() {
        super.initListener();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gv.setAdapter(new DetailAdapter(rightStr,LGActivity.this,position));
                tv_title_name.setText(leftStr[position]);
            }
        });
    }
}
