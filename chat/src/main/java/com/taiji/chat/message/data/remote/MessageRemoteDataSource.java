package com.taiji.chat.message.data.remote;

import android.content.Context;

import com.taiji.chat.message.data.MessageDataSource;
import com.taiji.chat.message.data.entity.MessageList;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;
import com.taiji.library.http.methods.HttpMethod;

import rx.Observable;

/**
 * Created by panho on 2017-9-18.
 */

public class MessageRemoteDataSource implements MessageDataSource{

    private static MessageRemoteDataSource mInstance;

    private Context mContext;

    private MessageService mMessageService;

    private MessageRemoteDataSource(Context context){
        this.mContext = context;

        try {
            mMessageService = HttpMethod.getInstance().getRetrofit(context)
                    .create(MessageService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MessageRemoteDataSource getmInstance(Context context){
        if(mInstance == null){
            synchronized (MessageRemoteDataSource.class){
                mInstance = new MessageRemoteDataSource(context);
            }
        }
        return mInstance;
    }

    @Override
    public Observable<Response<PageInfo<MessageList>>> getMessageLists(String userId, int pageNum, int pageSize) {
        return mMessageService.getMessageList(userId,pageNum,pageSize);
    }
}
