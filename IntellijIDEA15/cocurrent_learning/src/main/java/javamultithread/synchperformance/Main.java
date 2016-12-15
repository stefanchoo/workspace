package javamultithread.synchperformance;

/**
 * Created by stefan on 2016/1/15.
 * 测试一下 Synchronized 的性能有多低下
 */
public class Main {
    private static final Long CALL_COUNT = 1000000000L;
    public static void main(String[] args) {
        trial("NotSynch", CALL_COUNT, new NotSynch());
        trial("Synch", CALL_COUNT, new Synch());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + ": BEGIN");
        long start_time = System.currentTimeMillis();
        for(long i = 0; i< count; i++) {
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start_time) + "msec.");

    }
}

class Synch {
    private final String name = "Synch";
    public synchronized String toString() {
        return "[ " + name + " ]";
    }
}

class NotSynch {
    private final String name = "NotSynch";
    public String toString() {
        return "[ " + name + " ]";
    }
}