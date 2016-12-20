package com.africa.study.Java8.defaultInterface;

/**
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Main {
    public static void main(String[] args) {
        Formula formula = new Formula() {

            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));

    }
}
