package javamultithread.ThreadSpecificStorage;

/**
 * Log
 * 持有 保存各个线程 log 信息的保险箱
 * 模拟 log4j 的实现
 * Created by stefan on 2016/2/23.
 */
public class Log {
    private static final ThreadLocal<TSLog> tsCollectionLog = new ThreadLocal<>(); // 保存各个log信息的保险箱

    // 加入一条Log
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 关闭
    public static void close() {
        getTSLog().close();
    }

    // 取得各个线程的Log对象
    private static TSLog getTSLog() {
        TSLog tsLog = tsCollectionLog.get();
        if(tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsCollectionLog.set(tsLog);
        }
        return tsLog;
    }
}
