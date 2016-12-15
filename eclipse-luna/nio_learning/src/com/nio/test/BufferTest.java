package com.nio.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * @author stefan
 *
 * buffer的基本用法
 * 1. 写入数据到buffer
 * 2. 调用filp()方法   --> 将写模式切换到读模式
 * 3. 从buffer中读取数据
 * 4. 调用clear()方法或者compact()方法： clear()清除整个buf, compact()清除已经读过的数据
 * =================================================
 * Buffer的属性
 * capacity，position和limit
 *  capcaity ： buffer的容量
 *  position: writemode -> 写到的位置， max = capacity - 1, default = 0
 *            readmode -> 从某个特定位置开始，当writemode -> readmode,position reset 0
 *  limit : writemode -> 最多能往buf里写多少数据 
 *          readmode -> 已写的数据量，当从写模式切换到读模式时，limit被设置成写模式的position值
 *  =================================================        
 *  buffer的类型
 *  - ByteBuffer
 *  - MappedByteBuffer
 *  - CharBuffer
 *  - DoubleBuffer
 *  - FloatBuffer
 *  - IntBuffer
 *  - LongBuffer
 *  - ShortBuffer
 *  
 *  buffer分配函数 ： allocate(n)
 *  buffer写函数 : 
 *  1. channel -> buffer          etc. bytesRead = inChannel.read(buf)
 *  2. Buffer的put()方法写入Buffer  ect. buf.put(124)
 *  
 *  flip()方法
 *  功能： 将Buffer从写模式切换到度模式，调用后会将position设为0，并将limit设置为position的值
 *  
 *  从buffer中读取数据：
 *  1. buffer -> channel           etc. bytesWritten = inChannel.write(buf);
 *  2. 使用get方法从buffer中读取数据      etc. aByte = buf.get()
 *  
 *  rewind() : position reset to 0, 重读Buffer中所有数据
 *  
 *  clear()与compact()方法
 *  clear(),position 将被设为0， limit被设置为capacity的值，但是请注意，buffer中的数据并未被清除
 *  只是这些标记告诉我们可以从哪里开始往Buffer里写数据。如果buffer中还有未读的数据，但是没有了这些标记，
 *  我们就无法读出。
 *  针对上述情况的话，我们可以采用compact()方法，将所有未读数据拷贝到buffer的起始处，然后将position设到最后一个未读
 *  元素的正后面，这样，buffer准备写数据的时候也不会覆盖未读的数据
 *  
 *  mark()与reset()方法
 *  通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。之后可以通过调用Buffer.reset()方法恢复到原先的postion
 *  buffer.mark();
 *  //call buffer.get() a couple of times, e.g. during parsing.
 *  buffer.reset();  //set position back to mark.
 *  
 *  equals() 与 compareTo() 方法
 *  比较两个buffer
 *  equals()比较剩余元素，compareTo() 按照ASII码比较
 *  
 **/ 
public class BufferTest {
	public static void main(String[] args) throws IOException {
		BufferTest fileBufferTest = new BufferTest();
		fileBufferTest.testFileBuffer();
		
		
	}
	
	
	
	

	/**
	 * FileBuffer 测试
	 * @throws IOException
	 */
	public void testFileBuffer() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("file/buffer.txt", "rw");
		FileChannel fc = raf.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(100);
		int bytesCount = fc.read(buf);       // 目前buf是写状态
		
		while(bytesCount != -1){
			System.out.println("buf中字节数为：" + bytesCount);
			buf.flip();                     // 翻转一下，变成读状态 
			
			while(buf.hasRemaining()){      // read
				System.out.print((char)buf.get());
			}
			buf.compact();                 // clear
			bytesCount = fc.read(buf);
		}
		raf.close();
	}


}
