package javamultithread.GuardSuspensionPattern;

/**
 * TODO
 * Created by stefan on 2016/1/19.
 */
public class Request {
    private final String name;

    public Request(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
