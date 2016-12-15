package com.shmingjiang.netty_learning.example.POJO;

import java.util.Date;

/**
 * Created by stefan on 2016/1/4.
 *
 */
public class UnixTime {
    private final long value;

    public UnixTime() {
        this.value = System.currentTimeMillis() / 1000L + 2208988800L;
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L)).toString();
    }
}
