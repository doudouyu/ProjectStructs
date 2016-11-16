package com.example.administrator.projectstructs.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.projectstructs.R;
import com.example.administrator.projectstructs.adapter.DividerGridItemDecoration;
import com.example.administrator.projectstructs.adapter.MyRecyclerAdapter;
import com.example.administrator.projectstructs.utils.MyUtils;

/**
 * Created by Administrator on 2016/11/3.
 */
public class FragmentItem2 extends BaseFragment implements View.OnClickListener {

    private TextView textView;
    private ImageView iv_home;
    private ImageView iv_search;
    private ImageView iv_youku;
    private ImageView iv_menu;
    private ImageView iv_music;
    private static RelativeLayout rl1;
    private static RelativeLayout rl2;
    private static RelativeLayout rl3;
    private boolean isLevel1Show = true;
    private boolean isLevel2Show = true;
    private boolean isLevel3Show = true;
    private int offset = 200;
    //    private List <Integer> list = new ArrayList<>();
    private int[] list = {R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10
            , R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10, R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4, R.drawable.girl5, R.drawable.girl6, R.drawable.girl7, R.drawable.girl8, R.drawable.girl9, R.drawable.girl10};
    private Button button;
    private StaggeredGridLayoutManager st;
    private RecyclerView rl;
    private boolean flag = false;

    @Override
    protected void initView(View view) {
//        textView = (TextView) view.findViewById(R.id.tv_title);
        rl1 = (RelativeLayout) view.findViewById(R.id.level_1);
        rl2 = (RelativeLayout) view.findViewById(R.id.level_2);
        rl3 = (RelativeLayout) view.findViewById(R.id.level_3);
        iv_home = (ImageView) view.findViewById(R.id.icon_home);
        //找到切换按钮
        button = (Button) view.findViewById(R.id.btn_change);

//        for (int i = 0;i<30;i++){
//            list.add(R.drawable.ic_launcher);
//        }

//        iv_search = (ImageView) view.findViewById(R.id.img_search);
//        iv_youku = (ImageView) view.findViewById(R.id.img_youku);
        iv_menu = (ImageView) view.findViewById(R.id.icon_menu);
//        iv_music = (ImageView) view.findViewById(R.id.img_music);
        rl = (RecyclerView) view.findViewById(R.id.recycler);
        //设置recycleView的样式，竖排还是横排。。
        st = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rl.setLayoutManager(st);
//        rl.setLayoutManager(new LinearLayoutManager(_context,LinearLayoutManager.HORIZONTAL,true));
//        rl.setLayoutManager(new GridLayoutManager(_context,3));
        //设置分割线
//        rl.addItemDecoration(new DividerItemDecoration(_context,DividerItemDecoration.VERTICAL_LIST));
//        rl.addItemDecoration(new DividerItemDecoration(_context,DividerItemDecoration.HORIZONTAL_LIST));
        rl.addItemDecoration(new DividerGridItemDecoration(_context));
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list,_context);
        rl.setAdapter(adapter);
        adapter.setOnRecyclerItemClickListener(new MyRecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void OnMyItemClick(View view, int position) {
                Toast.makeText(_context,"点我干嘛",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnMyItemLongClick(View view, int position) {
                Toast.makeText(_context,"点我肯定是喜欢我喽！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
//        textView.setText("我是fragment2");
    }

    @Override
    protected void initListener() {
        iv_home.setOnClickListener(this);
        iv_menu.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment2;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_home:
                //当home键被点击的时候，先隐藏二级菜单，同时判断三级菜单是否显示，如果显示也隐藏
                if (isLevel2Show) {
                    // 隐藏二级菜单，同时，判断三级菜单的显示状态，如果是显示的，也隐藏
                    MyUtils.hideMenu(rl2);
                    isLevel2Show = false;
                    if (isLevel3Show) {
                        MyUtils.hideMenu(rl3, 200);
                        isLevel3Show = false;
                        if (isLevel1Show) {
                            MyUtils.hideMenu(rl1, 400);
                            isLevel1Show = false;
                        }
                    }

                } else {
                    // 显示二级菜单
                    MyUtils.showMenu(rl2);
                    isLevel2Show = true;
                }

                break;
            case R.id.icon_menu:
                if (isLevel3Show) {
                    // 隐藏三级菜单
                    MyUtils.hideMenu(rl3);
                    isLevel3Show = false;
                } else {
                    // 显示三级菜单
                    MyUtils.showMenu(rl3);
                    isLevel3Show = true;
                }
                break;
            case R.id.btn_change:
                if (flag) {
                    st = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
                    rl.setLayoutManager(st);
                    rl.setAdapter(new MyRecyclerAdapter(list, _context));
                    flag = false;
                } else {
                    st = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                    rl.setLayoutManager(st);
                    rl.setAdapter(new MyRecyclerAdapter(list, _context));
                    flag = true;
                }

                break;
            default:
                break;
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            //当点击的是menu的时候，显示整个菜单
            //如果菜单1不存在，就显示菜单
            MyUtils.showMenu(rl1);
            isLevel1Show = false;
            MyUtils.showMenu(rl2);
            isLevel2Show = false;
            MyUtils.hideMenu(rl3);
            isLevel3Show = false;
            return true;
        }
        return false;
    }


}
