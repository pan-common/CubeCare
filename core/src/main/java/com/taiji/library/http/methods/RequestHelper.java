package com.taiji.library.http.methods;

import android.content.Context;

import com.taiji.library.http.entity.Header;
import com.taiji.library.http.entity.Request;
import com.taiji.library.http.entity.RequestBody;
import com.taiji.library.util.SystemUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：panho on 2017-3-16 00:23
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class RequestHelper<T> {

    private Context mContext;

    public RequestHelper(Context context){
        this.mContext = context;
    }

    public Request<T> getRequest(T t) {
        Header header = new Header("android", SystemUtil.getGUID(), "---");
        RequestBody<T> requestBody = new RequestBody(t);
        Request<T> mRequest = new Request<T>(header,requestBody);
        return mRequest;
    }

}
