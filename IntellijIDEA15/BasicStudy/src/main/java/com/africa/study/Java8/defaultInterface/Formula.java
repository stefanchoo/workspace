package com.africa.study.Java8.defaultInterface;

/**
 * 使用 default 关键字， 扩展方法
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
public interface Formula {
    double calculate(int a);

    // couldn't be accessed in lambda
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
