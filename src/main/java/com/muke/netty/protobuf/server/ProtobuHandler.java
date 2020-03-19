package com.muke.netty.protobuf.server;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: lhl
 * @Date: 2020/03/19/10:43
 * @Description:
 */
public class ProtobuHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println(msg.getName());
        System.out.println(msg.getAge());
        System.out.println(msg.getAddress());
    }
}
