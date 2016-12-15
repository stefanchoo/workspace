package com.nio.test;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author stefan 1. 为什么要使用Selector? 使用单线程管理多通道
 * 
 *         2. Selector的创建 Selector selector = Selector.open();
 * 
 *         3. 向Selector注册通道 channel.configureBlocking(false); SelectionKey key =
 *         channel.register(selector, SelectionKey.OP_READ);
 *         注意要想与Selector一起使用，必须保证Channel是非阻塞模式，者意味着不能
 *         将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式
 *         register()方法的第二个参数是一个Interrest集合，意思是通过Selector监听
 *         Channel时对什么事件感兴趣。主要有四类 - Connect -> SelectionKey.OP_CONNECT - Accept
 *         -> SelectionKey.OP_ACCEPT - Read -> SelectionKey.OP_READ - Wirte ->
 *         SelectionKey.OP_WRITE
 * 
 *         通道触发了一个事件意思是该事件已经就绪。所以，某个channel成功连接到另一个 服务器称为“连接就绪”。一个server socket
 *         channel准备好接收新进入的连接 称为“接收就绪”。一个有数据可读的通道可以说是“读就绪”。等待写数据的通道可 以说是“写就绪”。
 *         可以通过'|'来指定多个感兴趣的事件
 * 
 *         4. SelectionKey - interest 集合 - ready 集合 - channel - Selector -
 *         附加的对象（可选）
 * 
 *         5. 通过Selector选择通道 重载后的select()方法会返回你感兴趣的事件已经准备就绪的通道，返回的是就绪的通道数 - int
 *         select() - 阻塞至少有一个在你注册的事件上就绪了 - int select(long timeout) - 阻塞
 *         timeout这么长时间 ms - int selectNow() - 不阻塞，直接返回，若没有就绪的，则返回0
 * 
 *         6. selectedKeys 7. wakeUp() 和 close()
 *         某个线程调用select()方法后阻塞了，即使没有通道已经就绪，也有办法让其从select()方法返回。
 *         只要让其它线程在第一个线程调用select()方法的那个对象上调用Selector.wakeup()方法即可。
 *         阻塞在select()方法上的线程会立马返回。
 *         如果有其它线程调用了wakeup()方法，但当前没有线程阻塞在select()方法上，下个调用select()
 *         方法的线程会立即“醒来（wake up）”。
 * 
 *         用完Selector后调用其close()方法会关闭该Selector，且使注册到该Selector上的所有SelectionKey
 *         实例无效。通道本身并不会关闭。
 */
public class SelectorTest {
	public static void main(String[] args) throws IOException {
		
		Selector selector = Selector.open();
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		SelectionKey selectionKey = channel.register(selector,
				SelectionKey.OP_READ);
		int interestSet = selectionKey.interestOps();

		boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
		boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
		boolean isInterestedInRead = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
		boolean isInterestedInWrite = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;

		int readySet = selectionKey.readyOps();
		selectionKey.isAcceptable();
		selectionKey.isConnectable();
		selectionKey.isReadable();
		selectionKey.isWritable();

		// 从selectionKey访问Channel和Selector
		Channel channel1 = selectionKey.channel();
		Selector selector2 = selectionKey.selector();

		// 可以将一个对象或者更多信息附着到SelectionKey上，
		// 这样就能方便的识别某个给定的通道。例如，可以附加 与通道一起使用的Buffer，
		// 或是包含聚集数据的某个对象。
		ByteBuffer buffer = ByteBuffer.allocate(50);
		selectionKey.attach(buffer); // 也可以在注册channel的时候就添加上去
		Buffer attachBuf = (Buffer) selectionKey.attachment();

		// select()
		while (true) {
			int readyChannels = selector.select();
			if(readyChannels == 0) continue;
			Set selectedKeys = selector.selectedKeys();
			Iterator keyIterator = selectedKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key = (SelectionKey) keyIterator.next();
				if (key.isAcceptable()) {
					// a connection was accepted by a ServerSocketChannel.
				} else if (key.isConnectable()) {
					// a connection was established with a remote server.
				} else if (key.isReadable()) {
					// a channel is ready for reading
				} else if (key.isWritable()) {
					// a channel is ready for writing
				}
			}
			keyIterator.remove(); // 必须手动移除
		}

	}
}
