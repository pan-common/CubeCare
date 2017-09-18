package com.taiji.cubecare.common.netty;

import com.muduo.proto.ChatProtos;
import com.taiji.cubecare.common.netty.bean.BookOuterClass;
import com.taiji.library.util.L;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by panho on 2017-9-5.
 */

public class NettyClientHandler extends ChannelHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        BookOuterClass.Book book = BookOuterClass.Book.newBuilder()
                .setId(12)
                .setName("")
                .setDesc("").build();
        ctx.write(book);
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        BookOuterClass.Book book = (BookOuterClass.Book) msg;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        L.d("连接异常断开");
        ctx.close();
    }
}
