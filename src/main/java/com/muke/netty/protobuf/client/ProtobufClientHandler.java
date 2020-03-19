package com.muke.netty.protobuf.client;

import com.muke.netty.protobuf.server.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: lhl
 * @Date: 2020/03/19/10:51
 * @Description:
 */
public class ProtobufClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(32).setAddress("柳州").build();
        ctx.channel().writeAndFlush(student);
    }
}
