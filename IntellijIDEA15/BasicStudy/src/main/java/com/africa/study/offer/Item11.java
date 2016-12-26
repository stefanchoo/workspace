package com.africa.study.offer;

/**
 * 数值的整数次方
 * 偶数：指数折半，奇数-1，再折半
 *
 * @author zhuhusheng
 * @date 2016/12/26
 */
public class Item11 {
    public static void main(String[] args) {
        int base = 2;
        int exponent_1 = 9;
        int exponent_2 = 10;
        System.out.println("当exponent为奇数时：" + power(base, exponent_1));
        System.out.println("当exponent为偶数时：" + power(base, exponent_2));
    }

    public static double power(int base, int exponent){
        if(exponent == 0) {
            return 1;
        } else if(exponent == 1) {
            return base;
        }
        if(exponent >> 1 == 0) {
            int halfExponent = exponent >> 1;
            double result = power(base, halfExponent);
            return result * result;
        } else {
            int halfExponent = exponent - 1;
            double result = power(base, halfExponent);
            return result * base;
        }
    }
}
