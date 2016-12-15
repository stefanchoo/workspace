package com.africa.study.GoF.Event;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 *
 * Java 事件机制的模拟实现
 */
public class Main {
    public static void main(String[] args) {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());
        manager.addDoorListener(new DoorListener2());

        // 开门
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了！");
        // 关门
        manager.fireWorkspaceClosed();
    }
}
