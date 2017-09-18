
package com.taiji.library.ui.helper;

import android.support.design.widget.TabLayout;

import com.taiji.library.ui.view.BasePageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public class TabPageHelper {

    private List<String> mTitleList = new ArrayList<>();

    private List<BasePageView> mViewList = new ArrayList<>();

    public void add(String title,BasePageView view){
        mTitleList.add(title);
        mViewList.add(view);
    }

    public TabPageHelper(){

    }

    public int getCount(){
        return mTitleList.size();
    }

    public void initTab(TabLayout tabLayout){
        for (int i = 0; i < mTitleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(i)));
        }
    }

    /**
     * 获取标题
     * @param position
     * @return
     */
    public String getTitle(int position){
        return mTitleList.get(position);
    }

    /**
     * 获取控件
     * @param position
     * @return
     */
    public BasePageView getView(int position){
        return mViewList.get(position);
    }

}
