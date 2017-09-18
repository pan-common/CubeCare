package com.taiji.chat.message.data;

import com.taiji.chat.message.data.entity.MessageList;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;

import rx.Observable;

/**
 * Created by panho on 2017-9-18.
 */

public interface MessageDataSource {

    /**
     * 获取用户全部消息列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    Observable<Response<PageInfo<MessageList>>> getMessageLists(String userId,
                                                                int pageNum,
                                                                int pageSize);

}
