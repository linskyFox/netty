package com.muke.netty.chat.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @Auther: lhl
 * @Date: 2020/03/16/10:11
 * @Description:
 */
public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
         ChannelPipeline channelPipeline = ch.pipeline();
         channelPipeline.addLast(new DelimiterBasedFrameDecoder(4096,Delimiters.lineDelimiter()));
         channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
         channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
         channelPipeline.addLast(new ChatServerHandler());
    }
}
