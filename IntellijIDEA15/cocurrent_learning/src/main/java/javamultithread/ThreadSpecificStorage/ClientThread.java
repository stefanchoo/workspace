package javamultithread.ThreadSpecificStorage;

/**
 * ClientThread
 * desc
 * Created by stefan on 2016/2/23.
 */
public class ClientThread extends Thread {

    public ClientThread(String name) {
        super(name);
//        Log.println("Constructor is called!");
// 不会保存到log中，原因是执行该构造器的为主线程，所以要会新建一个main-log,
// 但是没有执行close(), 所以信息可能不会被保存
    }

    @Override
    public void run() {
        System.out.println(getName() + "Begin");
        for (int i = 0; i < 10 ; i++) {
            Log.println("i = " + i);
            try{
                sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Log.close();
        System.out.println(getName() + "End");
    }
}
