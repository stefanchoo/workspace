package javamultithread.WorkerThread;

/**
 * Channel
 * 接收传递 工作请求， 保存工人线程
 * Created by stefan on 2016/2/22.
 */
public class Channel {
    private static final int MAX_REQUESTS = 100;
    private Request[] requestQueue;                          // 请求组数

    private int tail;                                        // 下一个putRequestd的地方
    private int head;                                        // 下一个takeRequest的地方
    private int count;                                       // request的数量

    private WorkerThread[] threadPool;                       // 存放工人线程的 线程池

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUESTS];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        this.threadPool = new WorkerThread[threads];

        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public void stopWorkers(){
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].stopThread();
        }
    }
    public synchronized void putRequest(Request request) throws InterruptedException {
        while(count >= requestQueue.length) {
            wait();
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() throws InterruptedException {
        while(count <= 0) {
            wait();
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
