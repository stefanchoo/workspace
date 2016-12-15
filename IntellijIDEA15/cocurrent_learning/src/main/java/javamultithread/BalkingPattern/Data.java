package javamultithread.BalkingPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 可保存，可修改的数据类
 * Created by stefan on 2016/2/18.
 */
public class Data {
    private final String filename;   // 文件名称
    private String content;          // 数据内容
    private boolean changed;         // 修改后的内容还没有保存的时候 为 true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // 修改数据内容
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    // 若数据有修改，则保存到文件中
    public synchronized void save() throws IOException {
        if (!changed) {
            System.out.println("nothing changed!");
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
