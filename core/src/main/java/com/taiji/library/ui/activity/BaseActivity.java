package com.taiji.library.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.taiji.library.R;
import com.taiji.library.ui.helper.ToolBarHelper;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * 描述：封装了toolbar，loadingView的基础activity
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public abstract class BaseActivity  extends SupportActivity{

    private ToolBarHelper mToolBarHelper;

    public Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mToolBarHelper = new ToolBarHelper(this,layoutResID);
        mToolbar = mToolBarHelper.getToolbar();
        setContentView(mToolBarHelper.getContentView());
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        onCreateCustomToolBar(mToolbar);
        mToolBarHelper.setOnTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTitleClick();
            }
        });
    }

    public void onCreateCustomToolBar(Toolbar toolbar){
        toolbar.setContentInsetsRelative(0,0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setTitle(String title){
        mToolBarHelper.setTitle(title);
    }

    public void onTitleClick(){

    }

    /**
     * 显示进度条
     */
    public void showProgress(){
        mToolBarHelper.getLoadView().show();
    }

    /**
     * 隐藏进度条
     */
    public void hideProgress(){
        mToolBarHelper.getLoadView().hide();
    }


}
