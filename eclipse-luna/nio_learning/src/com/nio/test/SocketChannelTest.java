package com.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author stefan
 *
 * Socket通道 : 创建的是TCP连接
 * 1. 创建
 * - 打开一个SocketChannel并连接到互联网上的某台服务器
 * - 一个新连接到达ServerSocketChannel时，会创建一个SocketChannel
 * 
 * 
 */
public class SocketChannelTest {
	public static void main(String[] args) throws IOException {
		// 打开
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("http://baidu.com", 80));
		
		
		// 从SocketChannel 中读数据
		/*
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = socketChannel.read(buf);
		*/
		// 写入到SocketChannel
		/*
		String newData = "New String to write to file..." + System.currentTimeMillis();

		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());

		buf.flip();

		while(buf.hasRemaining()) {
			socketChannel.write(buf);
		}
		*/
		
		// 设置非阻塞模式
		/*
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("http://baidu.com", 80));
		while(!socketChannel.finishConnect()){
			// wait, or do something else
			
		}
		*/
		// 关闭
		socketChannel.close();
	}
}
