package javamultithread.ReadWriteLock;

/**
 * 读写锁
 * 1. 读取与读取 没有冲突
 * 2. 读取与写入 有冲突  read-write conflict
 * 3. 写入与写入 有冲突  write-write conflict
 *
 * Created by stefan on 2016/2/19.
 */
public final class ReadWriteLock {
    private int readingReaders = 0;   // A. 实际正在读的线程数量
    private int waitingWriters = 0;   // B. 正在等待写的线程数量
    private int writingWriters = 0;   // C. 实际正在写的线程数量

    private boolean preferWriter = true; // 写优先的话，值为true

    public synchronized void readLock() throws InterruptedException {
        // 有线程在写 或者 有等待写的线程（写优先），这时不能获得读锁定
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;       // A.实际正在读取的线程 +1
    }

    public synchronized void readUnlock() {
        readingReaders--;      // A. 实际正在读取的线程 -1
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;    // B. 正在等待写的线程数量 +1
        try{
            while(readingReaders > 0 || writingWriters > 0){
                wait();
            }
        } finally {
            waitingWriters--;    // B. 正在等待的写线程数量 - 1
        }
        writingWriters++;        // C. 实际正在写的线程数量 + 1
    }

    public synchronized void writeUnlock() {
        writingWriters--;       // C. 实际正在写的线程数量 - 1
        preferWriter = false;
        notifyAll();
    }
}
