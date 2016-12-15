package com.nio.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author stefan
 * 
 * 1. FileChannel 无法设置非阻塞模式
 * 
 * - wirte()
 * - read()
 * - close()
 * - position()
 * - size()
 * - truncate()
 * - force()
 */
public class FileChannelTest {
	public static void main(String[] args) throws IOException {
		FileChannelTest fTest = new FileChannelTest();

		RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		fTest.readFile(inChannel);

	}

	/**
	 * 将channel中的数据写入buf,并读出
	 * 
	 * @param inChannel
	 * @throws IOException
	 */
	public void readFile(FileChannel inChannel) throws IOException {
		ByteBuffer buf = ByteBuffer.allocate(48);
		int byteRead = inChannel.read(buf);

		while (byteRead != -1) {
			System.out.println("Read " + byteRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.println((char) buf.get());
			}
		}
	}

	/**
	 * 将数据写入buf,然后写入channel
	 * 
	 * @param inChannel
	 * @param data
	 * @throws IOException
	 */
	public void writeFile(FileChannel inChannel, String data)
			throws IOException {
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(data.getBytes());

		buf.flip();

		while (buf.hasRemaining()) {
			inChannel.write(buf);
		}
	}

	/**
	 * 获取position
	 * 
	 * @param inChannel
	 * @return
	 * @throws IOException
	 */
	public long getPosition(FileChannel inChannel) throws IOException {
		return inChannel.position();

	}
	
	/**
	 * 获取size
	 * 
	 * @param inChannel
	 * @return
	 * @throws IOException
	 */
	public long getSize(FileChannel inChannel) throws IOException {
		return inChannel.size();
	}
	
	/**
	 * 按照指定长度截取一个文件，文件后面的部分将会被删除
	 * @param size
	 * @param incChannel
	 * @throws IOException
	 */
	public void truncate(long size, FileChannel inChannel) throws IOException {
		inChannel.truncate(size);
	}
	
	/**
	 * 强制将写入到FileChannel中的数据即时写到磁盘上
	 * @param inChannel
	 * @param metaData ： 是否将元数据（权限信息等）写在磁盘上
	 * @throws IOException
	 */
	public void force(FileChannel inChannel, boolean metaData) throws IOException {
		inChannel.force(metaData);
	}
	
	/**
	 * 关闭channel
	 * 
	 * @param inChannel
	 * @throws IOException
	 */
	public void close(FileChannel inChannel) throws IOException {
		inChannel.close();
	}
}