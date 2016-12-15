package com.africa.study.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author zhuhusheng
 * @date 2016/10/7
 */
public class MyPoint {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // method is modifying x and y, needs exclusive lock
    public void moveTo(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x = deltaX;
            y = deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    // 有条件的改变值，需要将读锁转化为写锁 【悲观锁】
    public void moveIfAt(double oldX, double oldY, double newX, double newY) {
        long stamp = sl.readLock();           // 读悲观锁
        try {
            while (x == oldX && y == oldY) {
                long writeStamp = sl.tryConvertToWriteLock(stamp);  // 转化为写锁
                if (writeStamp != 0L) {     // 判断是否转化成功， '0' 表示没有写锁被授权访问
                    stamp = writeStamp;     // 替换票据
                    System.out.println("ready to move");
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);   // 显式的释放读锁
                    stamp = sl.writeLock(); // 显式的拿到读锁，再进行循环重试
                }
            }
        } finally {
            sl.unlock(stamp);  // 释放读锁或者写锁
        }
    }

    // 【乐观锁】乐观的认为，读的操作很多，而写的操作很少的情况下
    public double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        if (!sl.validate(stamp)) {    // 判断一下是否有其他写操作发生，stamp 的值是否发生后改变
            stamp = sl.readLock();    // 如果有，则重新获得一个悲观锁，将新值重新读入
            try{
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
