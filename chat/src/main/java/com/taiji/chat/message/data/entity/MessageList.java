package com.taiji.chat.message.data.entity;

/**
 * Created by panho on 2017-9-18.
 */

public class MessageList {

    private String userId;//用户ID
    private String imageUrl;//头像
    private String name;//名称
    private String newMessage;//最新消息
    private String time;//消息时间

    public MessageList(String userId, String imageUrl, String name, String newMessage, String time) {
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.name = name;
        this.newMessage = newMessage;
        this.time = time;
    }

    public MessageList() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageList{" +
                "userId='" + userId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", newMessage='" + newMessage + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
