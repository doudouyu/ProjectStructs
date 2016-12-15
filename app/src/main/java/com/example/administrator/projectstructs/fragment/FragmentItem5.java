package com.example.administrator.projectstructs.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.adapter.MyRecyclerAdapter5;
import com.example.administrator.projectstructs.bean.CheckedBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public class FragmentItem5 extends BaseFragment {

    private ListView recyclerView;
    private List<CheckedBean> list = new ArrayList();
    private TextView tv;
    private boolean isBianji = true;
    private MyRecyclerAdapter5 adapter5;
    private TextView textView;
    private Button btn;

    @Override
    protected void initView(View view) {
        recyclerView = (ListView) view.findViewById(R.id.recycle_view);
        tv = (TextView) view.findViewById(R.id.bianji);
        textView = (TextView) view.findViewById(R.id.quxiao);
        btn = (Button) view.findViewById(R.id.delete);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new CheckedBean(false, "我是条目" + i));
        }
        //默认状态下是非编辑状态
        list.get(0).setBianji(false);
        adapter5 = new MyRecyclerAdapter5( list, _context);
        recyclerView.setAdapter(adapter5);

    }

    @Override
    protected void initListener() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(0).setBianji(false);
                adapter5.notifyDataSetChanged();
                btn.setVisibility(View.GONE);
                tv.setText("编辑");
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当编辑状态下，应该显示所有的checkBox

                if (list.get(0).getBianji() == false) {
                    list.get(0).setBianji(true);

                    if (list.size() > 0) {

                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).isChecked = false;
                        }
                    }
                   adapter5.notifyDataSetChanged();
                    isBianji = false;
                    tv.setText("全选");
                    return;
                } else {
                    if (isBianji) {
                        if (list.size() > 0) {

                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).isChecked = false;
                            }
                        }
                        adapter5.notifyDataSetChanged();
                        isBianji = false;
                        btn.setVisibility(View.GONE);
                        tv.setText("全选");
                    } else {
                        if (list.size() > 0) {

                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).isChecked = true;
                            }
                        }
                        adapter5.notifyDataSetChanged();
                        isBianji = true;
                        btn.setVisibility(View.VISIBLE);
                        tv.setText("全不选");
                    }
//                    list.get(0).setBianji(false);
                }
            }
        });
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment5;
    }
}
