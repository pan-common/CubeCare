package com.taiji.library.data.cache;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 作者：panho on 2016-12-27 14:41
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */
@Entity
public class Cache {
    @Id
    private Long id;//
    @Unique
    private String cacheName;//缓存名称

    private int validity;//有效期限

    private String lastTime;//上次修改时间

    @Generated(hash = 1584422427)
    public Cache(Long id, String cacheName, int validity, String lastTime) {
        this.id = id;
        this.cacheName = cacheName;
        this.validity = validity;
        this.lastTime = lastTime;
    }

    @Generated(hash = 1305017356)
    public Cache() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCacheName() {
        return this.cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public int getValidity() {
        return this.validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public String getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }


}
