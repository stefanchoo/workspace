package javamultithread.Deadlock;

/**
 * Created by stefan on 2016/1/15.
 * 定义工具类，指定是叉子亦或是调羹
 */
public class Tool {

    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ " + name + " ]";
    }
}
