package com.taiji.library.ui.helper;

import com.taiji.library.http.entity.PageInfo;

/**
 * Created by panho on 2017-9-12.
 */

public class PageHelp<T extends PageInfo> {

    private int pageNum;
    private int pageSize;

    private OnPageListener mListener;

    public PageHelp(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageHelp() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void startPage(T pageInfo,OnPageListener listener,boolean isRefresh){
        boolean isHasNextPage = pageInfo.isHasNextPage();
        if(listener!=null) {
            if(isRefresh){
                if(isHasNextPage){
                    pageNum = pageInfo.getNextPage();
                }
                listener.refresh();
            }else {
                if (isHasNextPage) {
                    pageNum = pageInfo.getNextPage();
                    listener.loadMoreComplate();
                }else {
                    listener.loadMoreEnd();
                }
            }
        }
    }

    public interface OnPageListener{

        void refresh();

        void loadMoreComplate();

        void loadMoreEnd();

    }


}
