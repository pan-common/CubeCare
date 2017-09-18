package com.taiji.library.greendao.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.taiji.library.greendao.db.DaoMaster;
import com.taiji.library.greendao.db.DaoSession;


/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-11-18
 */

public abstract class BaseDBManager {

    protected final static String dbName = "app_db";

    protected Context mContext;

    protected DaoMaster.DevOpenHelper mOpenHelper;

    protected BaseDBManager(Context context){
        this.mContext = context;
        mOpenHelper = new DaoMaster.DevOpenHelper(context,dbName,null);
    }

    /**
     * 获取可读数据库
     * @return db 可读数据库
     */
    protected SQLiteDatabase getReadableDatabase(){
        if(mOpenHelper==null){
            mOpenHelper = new DaoMaster.DevOpenHelper(mContext,dbName,null);
        }
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     * @return db 可写数据库
     */
    protected SQLiteDatabase getWritableDatabase(){
        if(mOpenHelper==null){
            mOpenHelper = new DaoMaster.DevOpenHelper(mContext,dbName,null);
        }
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        return db;
    }

    protected DaoSession getReadableSession(){
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        return daoMaster.newSession();
    }

    protected DaoSession getWritableSession(){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        return daoMaster.newSession();
    }

}
