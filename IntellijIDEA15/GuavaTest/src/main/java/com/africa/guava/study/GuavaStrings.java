package com.africa.guava.study;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

/**
 * @author zhuhusheng
 * @date 2016/6/2
 */
public class GuavaStrings {
    public static void main(String[] args) {
        // check empty
        checkEmpty("");
        checkEmpty(null);
        checkEmpty("I am not null!");

        //Strings.isNullOrEmpty(input) demo
        String a = "com.jd.coo.Hello";
        String b = "com.jd.coo.Hi";

        //Strings.commonSuffix(a,b) demo
        String c = "com.google.Hello";
        String d = "com.jd.Hello";

        // test padEnd: 不足这个数量时才会补全！
        // 12    4 0    ->    1200
        // 123   4 0    ->    1230
        // 1234  4 0    ->    1234
        // 12345 4 0    ->    12345
        padEnd("12", 4, '0');

        // test padStart: 不足这个数量时才会补全！
        // 12    4 0    ->    0012
        // 123   4 0    ->    0123
        // 1234  4 0    ->    1234
        // 12345 4 0    ->    12345
        padStart("12", 4, '0');
        split("hello,word,,世界，水平", "[,，]{1,}");

        getPrefix("abcdefgh", "abcwwee");

        getSuffix("abcdefgh", "cdfrrfdedgh");
    }

    public static boolean checkEmpty(String input) {

        boolean isNullOrEmpty = Strings.isNullOrEmpty(input);
        System.out.println("input " + (isNullOrEmpty ? "is" : "is not") + " null or empty.");
        return isNullOrEmpty;
    }

    public static void getPrefix(String a, String b) {
        String ourCommonPrefix = Strings.commonPrefix(a, b);
        System.out.println("a,b common prefix is " + ourCommonPrefix);
    }

    public static void getSuffix(String c, String d) {
        String ourSuffix = Strings.commonSuffix(c, d);
        System.out.println("c,d common suffix is " + ourSuffix);
    }

    public static void padEnd(String str, int minLength, char padChar) {
        String padEndResult = Strings.padEnd(str, minLength, padChar);
        System.out.println("padEndResult is " + padEndResult);
    }

    public static void padStart(String str, int minLength, char padChar) {
        String padStartResult = Strings.padStart(str, minLength, padChar);
        System.out.println("padStartResult is " + padStartResult);
    }

    /**
     *
     * @param str   : 原字串
     * @param regix ：正则表达式
     */
    public static void split(String str, String regix) {
        Iterable<String> splitResults = Splitter.onPattern(regix)
                .trimResults()
                .omitEmptyStrings()
                .split(str);

        for (String item : splitResults) {
            System.out.println(item);
        }
    }
}
