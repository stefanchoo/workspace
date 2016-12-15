package javamultithread.Deadlock;

/**
 * Created by stefan on 2016/1/15.
 *  测试 死锁情况的发生
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread ...");

        Tool spoon = new Tool("spoon");
        Tool fork = new Tool("fork");

       /******* 1. 不同的顺序拿，出现死锁现象 ********/
        /**** 原因： 两个线程会同时持有对某个对象的锁，都没来得及释放 ****/
        new EaterThread("Alice", spoon, fork).start();
        // 这里让第二个线程启动的慢一点，让第一个线程执行一段时间
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        new EaterThread("Bob", fork, spoon).start();


        /****** 2. 同样的顺序拿，不会发生死锁 ********/
        /*** 同时拿的对象永远不会一致, A拿的时候，B必须等 ****/
        /*
        new EaterThread("Alice", fork, spoon).start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        new EaterThread("Bob", fork, spoon).start();
        */



        /**** 3. 可以将工具组成一个配对对象，让线程锁住这个配对对象就不会发生死锁了 ****/
    }

}
