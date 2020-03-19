package com.muke.netty.chat.server;

import com.muke.netty.socket.server.SocketServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Auther: lhl
 * @Date: 2020/03/16/10:10
 * @Description:
 */
public class ChatServer {
    public static void main(String[] args) throws InterruptedException {
         EventLoopGroup bossGroup = new NioEventLoopGroup();
         EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap =new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new ChatServerInitializer());
            ChannelFuture channelFuture = bootstrap.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
