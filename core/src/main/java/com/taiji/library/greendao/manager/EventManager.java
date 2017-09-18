package com.taiji.library.greendao.manager;

import android.content.Context;

import com.taiji.library.greendao.bean.EventLog;
import com.taiji.library.greendao.db.DaoSession;
import com.taiji.library.greendao.db.EventLogDao;

/**
 * 描述：将操作日志保存到本地
 * 创建人： panho
 * 创建时间： 2016-12-14
 */

public class EventManager extends BaseDBManager{

    private static EventManager mInstance;

    protected EventManager(Context context) {
        super(context);
    }

    public static EventManager getmInstance(Context context){
        if(mInstance==null){
            synchronized (EventManager.class){
                mInstance = new EventManager(context);
            }
        }
        return mInstance;
    }

    /**
     * 插入操作日志
     * @param eventLog
     */
    public void insert(EventLog eventLog){
        DaoSession session = getWritableSession();
        EventLogDao dao = session.getEventLogDao();
        dao.insert(eventLog);
    }

}
