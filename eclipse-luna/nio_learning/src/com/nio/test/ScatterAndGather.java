package com.nio.test;


/**
 * @author stefan
 * 分散（Scatter）和聚集（Gather）针对channel说的
 * Scatter : channel Data -> different bufs
 * Gather : different bufs -> the same channel
 * 
 * Scattering Reads:将数据从一个channel读取到多个buffer中
 * Scatter 分散，将一个channel中的数据读入到多个buf,且是按照buf的顺序，
 * 写满之后再写下一个，不能处理动态消息
 * 
 * Gathering Writes：将多个buf中数据写到同一个channel中
 * Gather 聚集，将多个buf写入到channel中，并按照buf数组的顺序依次读取，
 * 只有position和limit之间的数据才会被写入，如一个buf为128byte,但是仅
 * 仅包含50byte的数据，则只会写入50Byte,所以Gather Writes能较好地处理
 * 动态消息
 *
 *
 *
 */
public class ScatterAndGather {
	public static void main(String[] args) {
		/*
		 * Scatter 分散，将一个channel中的数据读入到多个buf,且是按照buf的顺序，
		 * 写满之后再写下一个，不能处理动态消息
		 * Gather 聚集，将多个buf写入到channel中，并按照buf数组的顺序依次读取，
		 * 只有position和limit之间的数据才会被写入，如一个buf为128byte,但是仅
		 * 仅包含50byte的数据，则只会写入50Byte,所以Gather Writes能较好地处理
		 * 动态消息
		ByteBuffer header = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(1024);
		
		ByteBuffer[] byteArray = {header, body};
		
		channel.read(byteArray);
		channel.write(byteArray);
		*/	
	}
}
