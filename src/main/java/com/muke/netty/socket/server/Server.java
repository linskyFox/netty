package com.muke.netty.socket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * @Auther: lhl
 * @Date: 2020/03/13/16:48
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap =new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new SocketServerInitializer<AbstractSelectableChannel>());
            ChannelFuture channelFuture = bootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
           bossGroup.shutdownGracefully();
           workGroup.shutdownGracefully();
        }
    }
}
