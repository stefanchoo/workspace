package com.shmingjiang.netty_learning.Test;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by stefan on 2016/1/8.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    public static String SLA = "SLA|";
    public static String ECHO_REQ = "JDA|model=185TMFG|description=黑金|weight=56/46kg|\r";

    public EchoClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("===== 已连接 =====");
//        System.out.println("发送：" + string2Unicode(ECHO_REQ));
//        ctx.writeAndFlush(Unpooled.copiedBuffer(string2Unicode(ECHO_REQ).getBytes()));
        System.out.println(Arrays.toString(ECHO_REQ.getBytes(Charset.forName("UTF-16LE"))));
//        ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes(Charset.forName("UTF-16LE"))));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("==== ASK ====");
        System.out.println(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 字符串转换unicode
     */
    private static String string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }
}
