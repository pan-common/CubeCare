package com.taiji.library.mvp.schedulers;

import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-12-1
 */

public class SchedulerProvider implements BaseSchedulerProvider{

    @NonNull
    private static SchedulerProvider INSTANCE;

    private SchedulerProvider(){};

    public static synchronized SchedulerProvider getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
