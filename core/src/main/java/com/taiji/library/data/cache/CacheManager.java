package com.taiji.library.data.cache;

import android.content.Context;

import com.blankj.utilcode.utils.ConstUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.taiji.library.greendao.db.CacheDao;
import com.taiji.library.greendao.db.DaoSession;
import com.taiji.library.greendao.manager.BaseDBManager;
import com.taiji.library.greendao.manager.EventManager;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * 作者：panho on 2016-12-27 14:33
 * 邮箱: panhongzhi02@163.com
 * 功能描述：缓存管理器
 */

public class CacheManager extends BaseDBManager{

    private static CacheManager INSTANCE;

    protected CacheManager(Context context) {
        super(context);
    }

    public static CacheManager getInstance(Context context){
        if(INSTANCE== null){
            synchronized (EventManager.class) {
                INSTANCE = new CacheManager(context);
            }
        }
        return INSTANCE;
    }

    public void insertReplace(Cache cache){
        DaoSession session = getWritableSession();
        CacheDao cacheDao = session.getCacheDao();
        cacheDao.insertOrReplace(cache);
    }

    /**
     * 缓存是否有效
     * @param cacheName 缓存名称
     * @return true有效 false无效
     */
    public boolean isValid(String cacheName){
        Cache cache = queryCache(cacheName);
        if(cache==null){
            return false;
        }else {
            long interval = TimeUtils.getIntervalByNow(cache.getLastTime(), ConstUtils.TimeUnit.SEC);
            if(interval<Long.valueOf(cache.getValidity())){
                return true;
            }else {
                return false;
            }
        }
    }

    public Cache queryCache(String cacheName){
        DaoSession session = getReadableSession();
        CacheDao cacheDao = session.getCacheDao();
        QueryBuilder<Cache> qb = cacheDao.queryBuilder();
        Cache cache = qb.where(CacheDao.Properties.CacheName.eq(cacheName)).unique();
        return cache;
    }


}
