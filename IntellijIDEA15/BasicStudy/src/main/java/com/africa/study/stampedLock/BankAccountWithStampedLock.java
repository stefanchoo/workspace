package com.africa.study.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author zhuhusheng
 * @date 2016/10/7
 */
public class BankAccountWithStampedLock {

    private final StampedLock sl = new StampedLock();
    private double balance;

    public void deposit(double amount) {
        long stamp = sl.writeLock();
        try {
            balance += amount;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public double getBalance() {
        long stamp = sl.readLock();
        try {
            return balance;
        } finally {
            sl.unlockRead(stamp);
        }
    }
}
