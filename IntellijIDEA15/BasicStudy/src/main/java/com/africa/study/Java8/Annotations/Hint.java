package com.africa.study.Java8.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @author zhuhusheng
 * @date 2016/12/20
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Repeatable(Hints.class)
@interface Hint {
    String value();
}
