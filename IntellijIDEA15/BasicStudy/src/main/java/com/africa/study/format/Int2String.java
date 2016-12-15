package com.africa.study.format;

/**
 * @author zhuhusheng
 * @date 2016/12/5
 */
public class Int2String {

    public static void main(String[] args) {
        int num = 1090;
        System.out.println(int2String(4, num));
    }

    public static String int2String(int length, int num) {
        return String.format("%0" + length + "d", num);
    }
}
