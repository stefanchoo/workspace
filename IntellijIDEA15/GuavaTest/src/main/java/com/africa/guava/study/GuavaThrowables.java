package com.africa.guava.study;

import com.google.common.base.Throwables;

import java.sql.SQLException;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaThrowables {

    public static void main(String[] args) {

    }

    public void doSomething() throws Throwable {
        //ignore method body
    }

    public void doSomethingElse() throws Exception {
        //ignore method body
    }

    public void doIt() throws SQLException {
        try {
            doSomething();
        } catch (Throwable throwable) {
            // 表示如果抛出的异常是 SQLException， 则输出
            Throwables.propagateIfInstanceOf(throwable, SQLException.class);
            // 表示如果异常是Error类型，那么抛出这个类型，否则将抛出RuntimeException
            Throwables.propagateIfPossible(throwable);
        }
    }
}
