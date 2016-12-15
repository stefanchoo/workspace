package javamultithread.ProducerConsumer;

/**
 * 测试 ProducerConsumer Pattern
 * Created by stefan on 2016/2/18.
 */
public class Main {
    public static void main(String[] args) {

        Table table = new Table(3);

        Thread[] threads = {
                new MakerThread("MakerThread-1", table, 325466),
                new MakerThread("MakerThread-2", table, 125466),
                new MakerThread("MakerThread-3", table, 334466),
                new EaterThread("EaterThread-1", table, 237878),
                new EaterThread("EaterThread-2", table, 337878),
                new EaterThread("EaterThread-3", table, 437878),
                new LazyThread("LazyThread-1", table),
                new LazyThread("LazyThread-2", table),
                new LazyThread("LazyThread-3", table),
                new LazyThread("LazyThread-4", table),
                new LazyThread("LazyThread-5", table)
//                new ClearThread("ClearThread-0", table)
        };

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        /*
        // 休息 10s
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止
        System.err.println("=======>" + " interrupts " + "<=======");

        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
        */
    }
}
