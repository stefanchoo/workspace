package com.africa.study.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb) {
        long sequence = ringBuffer.next();    // 请求下一个事件序号
        try{
            LongEvent event = ringBuffer.get(sequence);  // 获取该序号对应的事件对象
            event.setValue(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

