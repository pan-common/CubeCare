package com.taiji.library.ui.helper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public class PageHelper<T> {

    private int total;//总行数

    private int page_size;//每页行数

    private int mCurrentCounter = 1;//当前行数

    private Context mContext;

    private List<T> mData;

    private OnPageChangeListener mListener;

    public PageHelper(Context context,int page_size){
        this.page_size = page_size;
        this.mContext = context;
        mData = new ArrayList<>();
    }

    /**
     * 初始化分页组件
     */
    public void init(){
        mCurrentCounter = 1;
        mData.clear();
        if(mListener!=null){
            mListener.onInit();
        }
    }

    /**
     * 初始化下拉刷新
     * @param total 总行数
     */
    public void onRefresh(int total,List<T> data){
        mData.addAll(data);
        this.total = total;
        if(total>0){
            mCurrentCounter = mData.size()+1;
            mListener.onRefresh(data);
            if(mCurrentCounter>=total){
                mListener.onAllComplete();
            }
        }
    }

    /**
     * 加载更多
     * @param total
     * @param data
     */
    public void loadMore(int total,List<T> data){
        mData.addAll(data);
        this.total = total;
        if(total>0){
            if(mCurrentCounter<total){
                mCurrentCounter = mData.size()+1;
                mListener.loadMore(data);
                if(mCurrentCounter>=total){
                    mListener.onAllComplete();
                }
            }
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener listener){
        this.mListener = listener;
    }

    public interface OnPageChangeListener<T>{
        /**
         * 分页初始化  (初始化时调用,下拉刷新时调用,移除底部控件)
         */
        void onInit();
        /**
         * 刷新数据（下拉刷新时回调）
         */
        void onRefresh(List<T> data);
        /**
         * 加载更多（滑动加载更多时回调）
         */
        void loadMore(List<T> data);
        /**
         * 加载完成（全部数据加载完成回调）
         */
        void onAllComplete();

    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    /**
     * @return
     */
    public String getStart(){
        return String.valueOf(mCurrentCounter);
    }

    public int getCurrentPage(){
        return mCurrentCounter/page_size;
    }
}
