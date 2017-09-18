package com.taiji.library.ui.view;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.taiji.library.R;

/**
 * Created by panho on 2017-9-12.
 */

public class BottomTab extends LinearLayout{

    private int mIcon;
    private int mStr;

    public BottomTab(Context context, @DrawableRes int icon, @StringRes int str) {
        this(context, null, icon);
        this.mIcon = icon;
        this.mStr = str;
    }

    public BottomTab(Context context,AttributeSet attrs,int icon){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_bottom_tab,this,true);

    }

}
