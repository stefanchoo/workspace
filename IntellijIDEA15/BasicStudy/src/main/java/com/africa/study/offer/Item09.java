package com.africa.study.offer;

/**
 * 斐波那契数列数列
 *
 * @author zhuhusheng
 * @date 2016/12/23
 */
public class Item09 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if(n == 1 || n == 2) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
