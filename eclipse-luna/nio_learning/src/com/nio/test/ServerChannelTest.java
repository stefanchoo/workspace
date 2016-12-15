package com.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author stefan
 * ServerSocket通道
 */
public class ServerChannelTest {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		// 配置非阻塞模式
		serverSocketChannel.configureBlocking(false);  
		// 监听新进来的连接
		while(true){
		    SocketChannel socketChannel =
		            serverSocketChannel.accept();

		    //do something with socketChannel...
		    if(socketChannel != null) {
		    	// do something
		    }
		}
		// close
		//serverSocketChannel.close();
	}
	
}
