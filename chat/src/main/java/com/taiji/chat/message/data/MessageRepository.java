package com.taiji.chat.message.data;

import android.content.Context;

import com.taiji.chat.message.data.entity.MessageList;
import com.taiji.chat.message.data.remote.MessageRemoteDataSource;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;

import rx.Observable;

/**
 * Created by panho on 2017-9-18.
 */

public class MessageRepository implements MessageDataSource{

    private static MessageRepository mInstance;

    private MessageRemoteDataSource mMessageRemoteDataSource;

    private MessageRepository(Context context){
        mMessageRemoteDataSource = MessageRemoteDataSource.getmInstance(context);
    };

    public static MessageRepository getmInstance(Context context){
        if(mInstance==null){
            synchronized (MessageRepository.class){
                mInstance = new MessageRepository(context);
            }
        }
        return mInstance;
    }

    @Override
    public Observable<Response<PageInfo<MessageList>>> getMessageLists(String userId, int pageNum, int pageSize) {
        return mMessageRemoteDataSource.getMessageLists(userId, pageNum, pageSize);
    }
}
