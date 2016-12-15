package com.africa.study.interesting;

import java.util.Random;

/**
 * @author zhuhusheng
 * @date 2016/9/7
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);   //    8, 5, 12, 12, 15, 0
                                       //    23, 15, 18, 12, 4, 0
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }

        return sb.toString();
    }
}
