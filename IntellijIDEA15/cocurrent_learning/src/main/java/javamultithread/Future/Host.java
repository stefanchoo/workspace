package javamultithread.Future;

/**
 * 发送请求的主机
 * Immutable class 的特殊形式
 * 没有共享的实例，状态不会更新
 * Created by stefan on 2016/2/22.
 */
public class Host {
   public Data request(final int count, final char c) {
       System.out.println("  request(" + count + ", " + c + ") BEGIN" );

       // 1. 建立futureData
       FultureData future = new FultureData();

       // 2. 建立realData
       new Thread(()->{
           RealData realData = new RealData(count, c);
           future.setRealData(realData);
       }).start();

       System.out.println("  request(" + count + ", " + c + ") END" );
       return future;
   }
}
