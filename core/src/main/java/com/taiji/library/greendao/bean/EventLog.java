package com.taiji.library.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Map;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 描述：通用日志，记录用户操作行为
 * 创建人： panho
 * 创建时间： 2016-12-14
 */
@Entity
public class EventLog {

    @Id(autoincrement = true)
    private Long id;
    /**
     * 客户端类型
     */
    private String client;
    /**
     * 应用版本
     */
    private String version;
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 行为id
     */
    private String eventId;
    /**
     * 所在页面名称
     */
    private String pageName;
    /**
     * 操作时间
     */
    private String time;
    /**
     * 操作用户
     */
    private String user;
    @Generated(hash = 1996880576)
    public EventLog(Long id, String client, String version, String deviceId,
            String eventId, String pageName, String time, String user) {
        this.id = id;
        this.client = client;
        this.version = version;
        this.deviceId = deviceId;
        this.eventId = eventId;
        this.pageName = pageName;
        this.time = time;
        this.user = user;
    }
    @Generated(hash = 915828638)
    public EventLog() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClient() {
        return this.client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public String getVersion() {
        return this.version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getDeviceId() {
        return this.deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getEventId() {
        return this.eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getPageName() {
        return this.pageName;
    }
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getUser() {
        return this.user;
    }
    public void setUser(String user) {
        this.user = user;
    }


}
