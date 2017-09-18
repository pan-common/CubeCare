package com.taiji.library.http.entity;

import java.util.Map;

/**
 * 作者：panho on 2017-3-12 23:45
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class RequestBody<T>{

    private T params;

    public RequestBody() {
        super();
    }

    public RequestBody(T params) {
        this.params = params;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }


    @Override
    public String toString() {
        return "RequestBody{" +
                "params=" + params +
                '}';
    }
}
