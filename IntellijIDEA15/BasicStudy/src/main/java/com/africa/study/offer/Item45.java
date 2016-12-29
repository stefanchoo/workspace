package com.africa.study.offer;

/**
 * 圆圈中最后剩下的数字
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item45 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    /**
     * 圆圈中最后剩下的数字
     *
     * @param n n个数字
     * @param m 删除第m个数字
     * @return 最后剩下的数字
     */
    private static int lastRemaining(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
