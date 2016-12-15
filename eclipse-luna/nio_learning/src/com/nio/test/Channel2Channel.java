package com.nio.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author stefan
 * 通道之间的数据传输
 * 
 * position：开始写的位置
 * count：表示写多少个
 * 默认情况下被写入的会被覆盖
 * transform(fromChannel, position, count)
 * transTo(position, count, toChannel)
 *
 */
public class Channel2Channel {
	public static void main(String[] args) throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("file/fromFile.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("file/toFile.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		// transfrom
		/*
		long position = 0;
		long count = fromChannel.size();
		
		toChannel.transferFrom(fromChannel, position, count);
		System.out.println("transFrom completed");
		*/
		long position = 0;
		long count = fromChannel.size();
//		System.out.println("count=" + count);
		// position 指的是开始写的位置
		fromChannel.transferTo(position, count, toChannel);
		System.out.println("transTo completed");
	}
	
}
