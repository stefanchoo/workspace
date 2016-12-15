package com.africa.study.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event + "| sequence: " + sequence);
    }
}
