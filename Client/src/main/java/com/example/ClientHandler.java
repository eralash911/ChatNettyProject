package com.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<String> {
    private Callback onMsgReceivedCallback;

    public ClientHandler(Callback pnMsgReceivedCallback) {
        this.onMsgReceivedCallback = pnMsgReceivedCallback;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        if (onMsgReceivedCallback != null){
            onMsgReceivedCallback.callback(s);
        }
    }
}
