package com.africa.study.disruptor;

import com.lmax.disruptor.EventFactory;


/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
