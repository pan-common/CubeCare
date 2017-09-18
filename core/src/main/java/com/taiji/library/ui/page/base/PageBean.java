package com.taiji.library.ui.page.base;

import java.util.List;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public class PageBean<T>{

    protected int total;

    protected List<T> mTList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getTList() {
        return mTList;
    }

    public void setTList(List<T> TList) {
        mTList = TList;
    }

    public PageBean(int total, List<T> TList) {
        this.total = total;
        mTList = TList;
    }



    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", mTList=" + mTList +
                '}';
    }
}
