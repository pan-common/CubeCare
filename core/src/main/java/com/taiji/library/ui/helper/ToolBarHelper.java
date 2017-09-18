package com.taiji.library.ui.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.taiji.library.R;
import com.taiji.library.ui.loadview.AVLoadingIndicatorView;


/**
 * 作者：panho on 2016-08-02 15:37
 * 邮箱：panhongzhi02@163.com
 */
public class ToolBarHelper {
    /**
     * 上下文，创建view的时候需要用到
     */
    private Context mContext;
    /**
     * base view
     */
    private FrameLayout mContentView;
    /**
     * 用户定义view
     */
    private View mUserView;

    private View view;

    private Toolbar mToolbar;

    private TextView title_tv;
    /**
     * 视图构造器
     */
    private LayoutInflater mInflater;
    /**
     * 俩个属性
     * 1、toolbar是否悬浮在窗口之上
     * 2、toolbar的高度获取
     */
    private static int[] ATTRS ={
            R.attr.windowActionBarOverlay,
            R.attr.actionBarSize
    };

    private AVLoadingIndicatorView mLoadView;

    public ToolBarHelper(Context context, int layoutId){
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        initContentView();
        initUserView(layoutId);
        initToolBar();
    }

    private void initContentView(){
        mContentView = new FrameLayout(mContext);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView.setLayoutParams(params);
    }

    private void initToolBar(){
        view = mInflater.inflate(R.layout.toolbar,mContentView);
        mToolbar = (Toolbar) view.findViewById(R.id.tool_bar);
        mToolbar.setTitle("");
        title_tv = (TextView) view.findViewById(R.id.toolbar_title);
        mLoadView = (AVLoadingIndicatorView) view.findViewById(R.id.loading_view);
    }

    public void removeToolbar(){
        ((ViewGroup)view).removeView(mToolbar);
    }

    @SuppressWarnings("ResourceType")
    private void initUserView(int id){
        mUserView = mInflater.inflate(id,null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0,false);
        /*获取主题中定义的toobar高度*/
        int toolBarSize = (int) typedArray.getDimension(1,(int) mContext.getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        /*如果是悬浮状态，则不需要设置间距*/
        params.topMargin = overly?0:toolBarSize;
        mContentView.addView(mUserView,params);
    }

    public void setTitle(String title){
        title_tv.setText(title);
    }

    public FrameLayout getContentView(){
        return mContentView;
    }

    public AVLoadingIndicatorView getLoadView(){
        return mLoadView;
    }

    public Toolbar getToolbar(){
        return mToolbar;
    }

    public void setOnTitleClickListener(View.OnClickListener listener){
        if(listener!=null){
            title_tv.setOnClickListener(listener);
        }
    }

}
