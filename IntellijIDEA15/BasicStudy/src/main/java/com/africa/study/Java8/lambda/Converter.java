package com.africa.study.Java8.lambda;

/**
 * FunctionalInterface identified that interface can only include one method
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
