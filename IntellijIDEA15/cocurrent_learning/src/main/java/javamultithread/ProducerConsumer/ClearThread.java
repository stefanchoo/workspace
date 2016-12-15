package javamultithread.ProducerConsumer;

/**
 * 每隔 1s 清空 蛋糕的数量
 * Created by stefan on 2016/2/19.
 */
public class ClearThread extends Thread {
    private final Table table;

    public ClearThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try{
            while(true) {
                sleep(1000);
                System.err.println("=======>" + getName() + " clear " + "<=======");
                table.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
