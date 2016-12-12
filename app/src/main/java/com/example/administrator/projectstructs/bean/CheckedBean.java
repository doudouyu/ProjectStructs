package com.example.administrator.projectstructs.bean;

/**
 * Created by Administrator on 2016/12/12.
 */
public class CheckedBean {
    /**
     * 当前的checkBox是否被选中
     */
    public boolean isChecked;

    public String name;
    /**
     *这个字段用来记录当前是否为编辑状态
     */

    private boolean isBianji;

    public boolean getBianji() {
        return isBianji;
    }

    public void setBianji(boolean isBianji) {
        this.isBianji = isBianji;
    }

    public CheckedBean(boolean b, String s) {
        this.isChecked = b;
        this.name = s;
    }
}
