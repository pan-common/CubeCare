package com.taiji.cubecare.common.netty;

import com.taiji.cubecare.common.netty.bean.BookOuterClass;
import com.taiji.library.util.L;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by panho on 2017-9-5.
 */

public class NettyClient {

    private String host;
    private int port;

    public NettyClient(String host,int port) throws InterruptedException{
        this.port = port;
        this.host = host;
        new Thread(){
            public void run(){
                try {
                    NettyClient.this.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }

    private void start() throws InterruptedException{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.TCP_NODELAY,true);
            bootstrap.group(eventLoopGroup);
            bootstrap.remoteAddress(host,port);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline cp = ch.pipeline();
                    cp.addLast(new ProtobufVarint32FrameDecoder());
                    cp.addLast(new ProtobufDecoder(BookOuterClass.Book.getDefaultInstance()));
                    cp.addLast(new ProtobufVarint32LengthFieldPrepender());
                    cp.addLast(new ProtobufEncoder());
                    cp.addLast(new NettyClientHandler());
                }
            });
            ChannelFuture future = bootstrap.connect(host,port).sync();
            if(future.isSuccess()){
                SocketChannel socketChannel = (SocketChannel) future.channel();
                L.d("=====================服务连接成功=========================");
            }
            future.channel().closeFuture().sync();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
