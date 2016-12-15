package com.africa.study.annotation;

import java.lang.annotation.*;

/**
 * @author zhuhusheng
 * @date 2016/6/8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Zoo {
    int id() default -1;         // 编号
    String name() default "";    // 名称
    String address() default ""; // 地址
}
