package com.africa.study.GoF.Event;

import java.util.EventListener;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public interface DoorListener extends EventListener {
    void doorEvent(DoorEvent event);
}
