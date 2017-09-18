package com.taiji.library.http.service;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 描述：基础服务
 * 创建人： panho
 * 创建时间： 2016-11-21
 */

public interface BaseService {
    /**
     * 获取服务器时间
     * @return
     */
    @GET("common/getServerTime")
    Observable<String> getServerTime();

}
