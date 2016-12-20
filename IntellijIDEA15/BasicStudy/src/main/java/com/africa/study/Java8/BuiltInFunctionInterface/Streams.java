package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuhusheng
 * @date 2016/12/19
 */
public class Streams {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        test(stringCollection);

        // parallel streams : 多线程执行
        int max = 1000000;

        List<String> values = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        // 顺序排序
        orderSort(values);
        // 并行排序, 速度上快了2倍以上
        parallelSort(values);

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));                 // val33

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));         // false

        map.computeIfAbsent(23, num -> "val" + num);    // if get(key) not exists, map.put(key, value) else do nothing;
        System.out.println(map.containsKey(23));

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));

        map.remove(3, "val3");
        System.out.println(map.get(3));

        map.remove(3, "val33");
        System.out.println(map.get(3));

        map.getOrDefault(42, "not found"); // not found

        System.out.println(map.get(9));   // null

        System.out.println(map.merge(9, "val9", String::concat));   // val9
        System.out.println(map.merge(9, "concat", String::concat)); // val9concat
    }

    /**
     * test method
     */
    public static void test(List<String> stringCollection) {
        stringCollection
                .stream()
                .sorted()                       // aaa2, aaa1 -> aaa1, aaa2 || sorted 不会改变原来集合元素顺序
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);           // DDD2, DDD1, CCC, BBB3, BBB2, BBB1, AAA2, AAA1

        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA);               // true

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA);              // false

        boolean nonStartsWithZ = stringCollection
                .stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println(nonStartsWithZ);              // true


        long startWithB = stringCollection
                .stream()
                .filter(s -> s.startsWith("b"))
                .count();
        System.out.println(startWithB);

        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);    // 3

        // reduce 削减 归一操作
        Optional<String> reduced = stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);


    }

    public static void orderSort(List<String> values) {
        long start = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long stop = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(stop - start);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void parallelSort(List<String> values) {
        long start = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long stop = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(stop - start);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
