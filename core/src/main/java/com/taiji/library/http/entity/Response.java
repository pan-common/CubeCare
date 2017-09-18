package com.taiji.library.http.entity;

/**
 * 作者：panho on 2017-2-27 16:30
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class Response<T> {

    private Header header;

    private ResponseBody<T> body;

    public Response() {
        super();
    }

    public Response(Header header, ResponseBody<T> body) {
        super();
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ResponseBody<T> getBody() {
        return body;
    }

    public void setBody(ResponseBody<T> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response [header=" + header + ", body=" + body + "]";
    }

}
