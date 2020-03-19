package com.muke.netty.http.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Auther: lhl
 * @Date: 2020/03/13/11:57
 * @Description:
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast("HttpServerCodec",new HttpServerCodec());
        channelPipeline.addLast("HttpServerHandler",new HttpServerHandler());
    }
}
