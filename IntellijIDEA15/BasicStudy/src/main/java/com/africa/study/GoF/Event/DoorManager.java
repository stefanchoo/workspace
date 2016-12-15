package com.africa.study.GoF.Event;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public class DoorManager {

    private Collection<DoorListener> listeners;

    /**
     * 添加事件
     *
     * @param listener
     *            DoorListener
     */
    public void addDoorListener(DoorListener listener) {
        if (listeners == null) {
            listeners = new HashSet<>();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     *
     * @param listener
     *            DoorListener
     */
    public void removeDoorListener(DoorListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event) {
        for (DoorListener listener : listeners) {
            listener.doorEvent(event);
        }
    }

}
