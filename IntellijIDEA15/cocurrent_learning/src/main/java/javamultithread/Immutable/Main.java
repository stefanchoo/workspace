package javamultithread.Immutable;

/**
 * Created by stefan on 2016/1/15.
 *  测试 Immutable 不可变对象
 *  不管有多少个线程访问都是安全的
 *
 */
public class Main {
    public static void main (String[] args) {
        Person p1 = new Person("Alice", "Alagon");

        new PrintPersonThread(p1).start();
        new PrintPersonThread(p1).start();
        new PrintPersonThread(p1).start();
        new PrintPersonThread(p1).start();
    }
}
