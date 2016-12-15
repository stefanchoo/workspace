package javamultithread.Future;

/**
 * 真实数据
 * Created by stefan on 2016/2/22.
 */
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println("    making(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
        }
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        this.content = new String(buffer);
        System.out.println("    making(" + count + ", " + c + ") END");
    }

    @Override
    public String getContent() {
        return content;
    }
}
