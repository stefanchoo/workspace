package com.africa.study.format;

/**
 * @author zhuhusheng
 * @date 2016/12/5
 */
public class BitUtils {

    /**
     * 读方法
     *
     * @param target 目标值
     * @param index  位置索引
     */
    public static boolean read(int target, int index) {
        return ((target >>> index) & 1) == 1;
    }

    /**
     * 写方法
     *
     * @param target 目标值
     * @param index  位置索引
     * @param value  置位
     */
    public static int write(int target, int index, boolean value) {
        if (value) return target | (1 << index);
        else return target & (~(1 << index));
    }

    public static void main(String[] args) {
        int target = -32768;
        System.out.println(read(target, 15));
        System.out.println(Integer.toBinaryString(write(target, 2, false)));
    }
}
