package com.taiji.library.mvp.view;

import java.util.List;

/**
 * 作者：panho on 2017-1-5 13:39
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */
public interface CommonListView<T,P> extends BaseView<P>{
    /**
     * 显示列表数据
     * @param data
     */
    void showDataList(List<T> data);

    /**
     * 显示加载视图
     * @param isShow
     */
    void showLoadView(boolean isShow);

    /**
     * 显示错误信息
     * @param errorMessage
     */
    void showError(String errorMessage);

    /**
     * 显示空数据
     */
    void showNoData();

    /**
     * 加载完成
     */
    void loadComplate();

}
