package com.taiji.library.mvp.schedulers;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * 描述：调度器构建
 * 创建人： panho
 * 创建时间： 2016-12-1
 */

public interface BaseSchedulerProvider {

    /**
     * 创建并返回一个调度程序用于计算工作
     * @return
     */
    @NonNull
    Scheduler computation();

    /**
     * 创建并返回一个调度程序用于执行异步阻塞任务
     * @return
     */
    @NonNull
    Scheduler io();

    /**
     * 创建并返回一个调度程序用于执行Android UI任务
     * @return
     */
    @NonNull
    Scheduler ui();

}
