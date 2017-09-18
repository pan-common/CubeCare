package com.taiji.library.statistics;

import android.content.Context;

import com.blankj.utilcode.utils.TimeUtils;
import com.taiji.library.greendao.bean.EventLog;
import com.taiji.library.util.SystemUtil;

import java.util.Map;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-12-14
 */

public class TaiJiEventAgent {

    private Context mContext;

    private static TaiJiEventAgent mInstance;

    private TaiJiEventAgent(Context context){
        this.mContext = context;
    }

    public static TaiJiEventAgent getmInstance(Context context){
        if(mInstance==null){
            synchronized (TaiJiEventAgent.class){
                mInstance = new TaiJiEventAgent(context);
                firstStart();
            }
        }
        return mInstance;
    }

    /**
     * 首次启动
     */
    private static void firstStart(){
        
    }

    public void onPageStart(){

    }

    public void onPageEnd(){

    }

    public void onEvent(String eventId){

    }

    public void onEvent(String eventId, Map<String,String> map){
        EventLog eventLog = getEventLog();
    }

    private EventLog getEventLog(){
        EventLog eventLog = new EventLog();
        eventLog.setClient("Android");
        eventLog.setDeviceId(SystemUtil.getDeviceId(mContext));
        eventLog.setTime(TimeUtils.getCurTimeString());
        return eventLog;
    }

}
