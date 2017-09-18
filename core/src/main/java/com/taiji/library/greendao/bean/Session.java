package com.taiji.library.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 描述：事件对应属性
 * 创建人： panho
 * 创建时间： 2016-12-14
 */
@Entity
public class Session {
    @Id(autoincrement = true)
    private Long id;
    /**
     * 事件id
     */
    private String eventId;
    /**
     * 属性名
     */
    private String key;
    /**
     * 属性值
     */
    private String value;
    @Generated(hash = 668592864)
    public Session(Long id, String eventId, String key, String value) {
        this.id = id;
        this.eventId = eventId;
        this.key = key;
        this.value = value;
    }
    @Generated(hash = 1317889643)
    public Session() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEventId() {
        return this.eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
