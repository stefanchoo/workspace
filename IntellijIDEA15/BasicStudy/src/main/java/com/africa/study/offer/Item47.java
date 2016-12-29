package com.africa.study.offer;

/**
 * 不用加减乘除做加法
 *
 * 异或值 + 进位值（与操作后移位）
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item47 {
    public static void main(String[] args) {
        int a = 100;
        int b = 15;
        System.out.println(addWithoutOpr(a, b));
    }

    private static int addWithoutOpr(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;                       // 异或
            carry = (num1 & num2) << 1;              // 进位
            // 相加
            num1 = sum;
            num2 = carry;
        } while(num2 != 0);

        return num1;
    }


}
