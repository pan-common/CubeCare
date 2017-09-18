package com.taiji.library.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.taiji.library.data.constant.C;

/**
 * 描述：公共数据预设类，利用android的sharePreferences将数据预设到xml文件中
 * 创建人： panho
 * 创建时间： 2016-11-21
 */

public class DataPreferences {

    private SharedPreferences mPreferences;

    private Context mContext;

    private static DataPreferences mInstance;

    private DataPreferences(Context context){
        this.mContext = context;
        mPreferences = context.getSharedPreferences(C.BASE.BASE_INFO,Context.MODE_PRIVATE);
    }

    public static DataPreferences getInstance(Context context){
        if(mInstance==null){
            synchronized (DataPreferences.class){
                mInstance = new DataPreferences(context);
            }
        }
        return mInstance;
    }

    /**
     * 根据key从预设文件中获取value
     * @param key
     * @return
     */
    public String getData(String key){
        String value = mPreferences.getString(key,"");
        return value;
    }

    /**
     * 修改预设文件中的数据
     * @param key
     * @param value
     */
    public void updateDate(String key,String value){
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

}
