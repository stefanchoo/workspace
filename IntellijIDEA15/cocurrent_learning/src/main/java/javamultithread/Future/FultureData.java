package javamultithread.Future;

/**
 * FutureData
 * 将来会获取到的数据对象，持有RealData的对象
 * Created by stefan on 2016/2/22.
 */
public class FultureData implements Data {
    private RealData realData;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if(ready) {
            return;             // balk
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while(!ready) {
            try{
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.getContent();
    }
}
