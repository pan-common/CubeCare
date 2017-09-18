package com.taiji.library.http.entity;

/**
 * 作者：panho on 2017-2-27 16:23
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class Request<T>{

    private Header header;

    private RequestBody<T> requestBody;

    public Request() {
        super();
    }

    public Request(Header header, RequestBody<T> requestBody) {
        super();
        this.header = header;
        this.requestBody = requestBody;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public RequestBody<T> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody<T> requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "Request [header=" + header + ", requestBody=" + requestBody
                + "]";
    }
}
