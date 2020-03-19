package com.muke.netty.socket.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * @Auther: lhl
 * @Date: 2020/03/13/16:54
 * @Description:
 */
public class SocketServerInitializer<S extends AbstractSelectableChannel> extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
          ChannelPipeline pipeline =  ch.pipeline();
          pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
          pipeline.addLast(new LengthFieldPrepender(4));
          pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
          pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
          pipeline.addLast(new SocketServerHandler());

    }
}
