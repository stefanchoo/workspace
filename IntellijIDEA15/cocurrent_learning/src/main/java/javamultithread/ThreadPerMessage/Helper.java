package javamultithread.ThreadPerMessage;

/**
 * 模拟对请求的处理
 * Created by stefan on 2016/2/22.
 */
public class Helper {

    public void handle(final int count, final char c) {
        System.out.println(" ==> handle(" + count + ", " + c + ") BEGIN");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println("");
        System.out.println(" ==> handle(" + count + ", " + c + ") END");
    }

    private void slowly() {
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
