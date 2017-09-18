package com.taiji.chat.message.data.local;

import com.taiji.chat.message.data.MessageDataSource;
import com.taiji.chat.message.data.entity.MessageList;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;

import rx.Observable;

/**
 * Created by panho on 2017-9-18.
 */

public class MessageLocalDataSource implements MessageDataSource {
    @Override
    public Observable<Response<PageInfo<MessageList>>> getMessageLists(String userId, int pageNum, int pageSize) {
        return null;
    }
}
