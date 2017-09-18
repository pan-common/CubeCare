package com.taiji.library.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.taiji.library.ui.helper.TabPageHelper;

/**
 * 描述：TabLayout的通用适配器
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public class SimplePageAdapter extends PagerAdapter{

    private TabPageHelper mHelper;

    public SimplePageAdapter(TabPageHelper helper){
        this.mHelper = helper;
    }

    @Override
    public int getCount() {
        return mHelper.getCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mHelper.getView(position));
        return mHelper.getView(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mHelper.getView(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mHelper.getTitle(position);
    }
}
