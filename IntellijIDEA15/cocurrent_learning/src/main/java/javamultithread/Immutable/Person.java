package javamultithread.Immutable;

/**
 * Created by stefan on 2016/1/15.
 * 构造一个线程安全的immutable类
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
