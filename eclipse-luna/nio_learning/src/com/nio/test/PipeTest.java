package com.nio.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author stefan
 *
 * 管道（Pipe）
 * Java NIO 管道是2个线程之间的单向数据连接。
 * Pipe有一个source通道和一个sink通道。
 * 数据会被写到sink通道，从source通道读取。
 * 
 *  Pipe写满之后会阻塞，直到有一个线程过来读取了
 *
 */
public class PipeTest {
	public static void main(String[] args) throws IOException {
		Pipe pipe = Pipe.open();
		
		// 向管道中写东西
		Pipe.SinkChannel sinkChannel = pipe.sink();
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());

		buf.flip();

		while(buf.hasRemaining()) {
		    sinkChannel.write(buf);
		}
		
		// 从管道中读取数据
		Pipe.SourceChannel sourceChannel = pipe.source();
		int byteRead = sourceChannel.read(buf);
	}
}
