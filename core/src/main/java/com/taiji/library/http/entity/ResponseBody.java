package com.taiji.library.http.entity;

/**
 * 作者：panho on 2017-3-12 23:46
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class ResponseBody<T>{

    public static final String SUCCESS = "0";

    public static final String FAILED = "1";

    private String resultCode;

    private String resultContent;

    private T entity;

    public ResponseBody() {
        super();
    }

    public ResponseBody(String resultCode, String resultContent, T entity) {
        super();
        this.resultCode = resultCode;
        this.resultContent = resultContent;
        this.entity = entity;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "Body{" +
                "resultCode='" + resultCode + '\'' +
                ", resultContent='" + resultContent + '\'' +
                '}';
    }

}
