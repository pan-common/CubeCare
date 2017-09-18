package com.taiji.chat.message.data.remote;

import com.taiji.chat.message.data.entity.MessageList;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by panho on 2017-9-18.
 */

public interface MessageService {

    @GET("message/getMessageList")
    Observable<Response<PageInfo<MessageList>>> getMessageList(
            @Query("userId")String userId,
            @Query("pageNum")int pageNum,
            @Query("pageSize")int pageSize
    );

}
