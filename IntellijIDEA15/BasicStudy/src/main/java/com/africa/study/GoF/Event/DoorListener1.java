package com.africa.study.GoF.Event;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public class DoorListener1 implements DoorListener {

    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getDoorState() != null && event.getDoorState().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }
}
