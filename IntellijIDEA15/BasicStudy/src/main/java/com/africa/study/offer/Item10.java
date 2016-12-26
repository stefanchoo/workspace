package com.africa.study.offer;

/**
 * 二进制中1的个数
 *
 * @author zhuhusheng
 * @date 2016/12/25
 */
public class Item10 {
    public static void main(String[] args) {
        int n = 2354;
        int number = Integer.bitCount(n);
        System.out.println(number);
        System.out.println(numberOf1(n));
        System.out.println(bitCount(n));
    }

    public static int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     *  思想是平行算法： 先转化为二进制，然后相邻位相加，在递归调用，最后得出1的个数
     *  其中 00 -> 00, 01 / 10 -> 01, 11 -> 10
     *            157
     *     1 0 0 1 1 1 0 1
     *     \/  \/  \/  \/
     *     1   1   2   1
     *      \/      \/
     *      2       3
     *      \      /
     *         5
     */
    public static int bitCount(int n) {
        n = (n & 0x55555555) + (n >> 1 & 0x55555555);    // 以 1 为单位，判断奇偶
        n = (n & 0x33333333) + (n >> 2 & 0x33333333);    // 以 2 为单位，判断奇偶
        n = (n & 0x0f0f0f0f) + (n >> 4 & 0x0f0f0f0f);    // 以 4 为单位，判断奇偶
        n = (n & 0x00ff00ff) + (n >> 8 & 0x00ff00ff);    // 以 8 为单位，判断奇偶
        n = (n & 0x0000ffff) + (n >> 16 & 0x0000ffff);   // 以 16为单位，判断奇偶
        return n;
    }
}
