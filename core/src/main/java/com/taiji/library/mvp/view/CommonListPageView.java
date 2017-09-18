package com.taiji.library.mvp.view;

import java.util.List;

/**
 * 作者：panho on 2017-1-5 13:51
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public interface CommonListPageView<T,P> extends CommonListView<T,P> {
    /**
     *  分页加载更多数据
     * @param data
     */
    void loadMoreList(List<T> data);

    /**
     *  分页加载完成
     */
    void loadMoreComplate();

    /**
     *  分页加载结束
     */
    void loadMoreEnd();

    /**
     *  分页加载初始化
     */
    void loadMoreinit();

}
