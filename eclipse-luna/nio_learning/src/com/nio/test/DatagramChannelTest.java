package com.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author stefan Datagram通道 ： UDP连接，发送和接受的只有数据包
 * 
 * 
 * 
 */
public class DatagramChannelTest {
	public static void main(String[] args) throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(9999)); 
		
		// 接收数据
		/*
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		channel.receive(buf);           // 多余的数据将会被丢弃
		*/
		
		// 发送数据
		/*
		String newData = "New String to write to file..." + System.currentTimeMillis();

		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		buf.flip();

		int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
		*/
		
		// 连接到特定地址，锁住DatagramChannel: 连接后也可以读写，不过数据没有保证性
		/*
		channel.connect(new InetSocketAddress("jenkov.com", 80));
		int bytesRead = channel.read(buf);
		int bytesWritten = channel.write(buf);
		*/
	}
}
