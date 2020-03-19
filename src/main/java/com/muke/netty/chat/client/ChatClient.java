package com.muke.netty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: lhl
 * @Date: 2020/03/16/10:49
 * @Description:
 */
public class ChatClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChatClientInitializer());
            Channel channel = bootstrap.connect("localhost",9999).sync().channel();
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
                channel.writeAndFlush(bf.readLine()+"\n");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
