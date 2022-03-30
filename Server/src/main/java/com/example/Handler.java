package com.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends SimpleChannelInboundHandler <String>{
    private static final List<Channel> channel = new ArrayList<>();
    private String clientName;
    private static int count = 0;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        count++;
        System.out.println("Client connected" + ctx);
        channel.add(ctx.channel());
        clientName = "Client # " + count;
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println("Got message : " + s);
        String out = String.format("[%s]: %s\n", clientName, s);
        for (Channel c :
                channel) {
            c.writeAndFlush(out);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
