package com.muke.netty.keepalive;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lhl
 * @Date: 2020/03/17/15:10
 * @Description:
 */
public class KeepAliveInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));
        channelPipeline.addLast(new KeepAliveHandler());

    }
}
