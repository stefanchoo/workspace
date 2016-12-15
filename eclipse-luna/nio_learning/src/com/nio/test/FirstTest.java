package com.nio.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author stefan
 *
 * JavaNIO 与  IO 之间的差别
 * JavaNIO : Buffer oriented / Non Blocking IO / Selectors
 * JavaIO : Streaming oriented / Blocking IO
 * 
 * 一、IO面向流与NIO面向缓存
 * 1. JavaIO 面向流意味着每次从流中读取一个或多个字节，直到读取所有字节，没有缓存到任何地方，流中的数据不能前后移动
 * 2. JavaNIO的缓冲导向方法是建立多个缓存区，可以选择性地读入，增加里灵活性
 * 
 * 二、 阻塞与非阻塞IO
 * 1. JavaIO是阻塞的，read&write，线程都会阻塞，直到有有一次读取或者数据完全写入
 * 2. JavaNIO是非阻塞的， read某通道数据，没有数据可以做其他事情，write某通道，不需要等待完全写入，线程可以继续做
 * 其他事情，将空闲时间用来执行其他IO操作，所以一个单独的线程现在可以管理多个输入和输出通道（channel）
 * 
 * 三、 选择器（selectors)
 * JavaNIO 使用selectors来管理多个channel,可以将多个输入通道注册到一个选择器，使用单线程来选择通道
 * 
 * 四、 NIO和IO如何影响应用程序的设计
 * - 对NIO或IO类的API调用
 * - 数据处理
 * - 用来处理数据的线程数
 * 
 * 五、API调用与数据处理
 * NIO必须将数据写入缓冲区才能进行处理
 * 
 * etc.
 * Name: Anna
 * Age: 25
 * Email: anna@mailserver.com
 * Phone: 1234567890
 * 
 * == JavaIO ==
 * InputStream input = … ; // get the InputStream from the client socket
 * BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 * 
 * String nameLine   = reader.readLine();
 * String ageLine    = reader.readLine();
 * String emailLine  = reader.readLine();
 * String phoneLine  = reader.readLine();
 * 
 * 处理数据直到数据的具体内容，但是在线程运行过程中，不容易直到stream中当前的值，容易发生阻塞
 * ==================================================
 * == Java NIO ==
 * ByteBuffer buffer = ByteBuffer.allocate(48);
 * int bytesRead = inChannel.read(buffer);
 * 不知道buffer中是否有足够数据，而且不清楚具体内容
 * 所以NIO可以允许你使用一个或几个单线程管理多个通道（网络连接或文件），但付出的代价就是数据解析的复杂性
 * ===============================================
 * 
 * 六、通道（channel）
 * Java NIO的通道类似流，区别如下：
 * 1. 可以对通道进行读写数据，而流通常都是单向的
 * 2. 通道可以异步的读写
 * 3. 通道中的数据总是要先读到一个buffer，或者从一个buffer写入
 * 
 * == 通道实现 ==
 * FileChannel : 从文件中读写数据
 * DatagramChannel: 能通过UDP读写网络中的数据
 * SocketChannel: 能通过TCP读写网络中的数据
 * ServerSocketChannel: 可以监听一个新进来的TCP连接，像Web服务器那样。对每一个新进来的连接，都会
 * 创建一个socketChannel
 * 
 */
public class FirstTest {
	public static void main(String[] args) throws IOException{
//		System.out.println("hello nio");
		RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(50);
		
		int bytesRead = inChannel.read(buf);
		while(bytesRead != -1){
			
			System.out.println("Read " + bytesRead);
			buf.flip();
			
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
