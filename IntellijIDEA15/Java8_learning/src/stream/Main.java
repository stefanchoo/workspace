package stream;

import java.util.ArrayList;

/**
 * TODO
 * Created by stefan on 2016/1/15.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();  // Java 7 规范

        for (int i = 0; i < 10 ; i++) {
            arrayList.add(i);
        }
        System.out.println("\n--- foreach ---");
        for (Integer i : arrayList) {
            System.out.print(i);
        }

        System.out.println("\n--- lambda 1 ---");
        arrayList.forEach(System.out::print);

        System.out.println("\n--- lambda 2 ---");
        arrayList.forEach(i -> System.out.print(i));
    }
}
