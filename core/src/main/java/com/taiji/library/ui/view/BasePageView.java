package com.taiji.library.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.taiji.library.ui.activity.BaseActivity;

/**
 * 描述：TabLayout内的自定义控件基类
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public abstract class BasePageView extends LinearLayout{

    protected Activity mActivity;

    public BasePageView(Activity context) {
        this(context,null);
    }

    public BasePageView(Activity context, AttributeSet attrs) {
        super(context, attrs);
        this.mActivity = context;
    }

    public abstract void onResume();

    public abstract void onPause();

    public abstract void onDestory();

    public abstract void onStop();

    public abstract void onRestart();

    public void onActivityResult(int requestCode, int resultCode, Intent data){

    }

    /**
     * 传递参数
     * @param param
     */
    public abstract void onRefreshData(String...param);

}
