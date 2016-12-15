package com.africa.study.annotation;

import java.lang.annotation.*;

/**
 * @author zhuhusheng
 * @date 2016/6/8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnimalName {
    String value() default "";
}
