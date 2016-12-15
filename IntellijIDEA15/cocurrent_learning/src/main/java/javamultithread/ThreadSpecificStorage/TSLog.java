package javamultithread.ThreadSpecificStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TSLog
 * 每个线程自己的log信息
 * Created by stefan on 2016/2/23.
 */
public class TSLog {
    private PrintWriter writer;

    public TSLog(String filename) {
        try{
            this.writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 加入一条log
    public void println(String s) {
        writer.println(s);
    }

    // 关闭
    public void close() {
        System.out.println("======== End of Log");
        writer.close();
    }

}
