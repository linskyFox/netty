package com.muke.netty.keepalive;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Auther: lhl
 * @Date: 2020/03/17/15:19
 * @Description:
 */
public class KeepAliveHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                default:
                    eventType="读写空闲";
                    break;


            }
            System.out.println(ctx.channel().remoteAddress()+"超时时间:" +eventType);
            ctx.channel().close();

        }
    }
}
