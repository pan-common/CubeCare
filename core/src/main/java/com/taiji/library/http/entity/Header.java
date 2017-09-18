package com.taiji.library.http.entity;

/**
 * 作者：panho on 2017-3-12 23:45
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class Header{

    private String sourceSystem;//消息来源

    private String messageId;//消息ID

    private String deviceId;//设备ID

    public Header(String sourceSystem, String messageId, String deviceId) {
        this.sourceSystem = sourceSystem;
        this.messageId = messageId;
        this.deviceId = deviceId;
    }

    public Header() {
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Header{" +
                "sourceSystem='" + sourceSystem + '\'' +
                ", messageId='" + messageId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
