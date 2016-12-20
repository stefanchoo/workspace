package com.africa.study.Java8.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author zhuhusheng
 * @date 2016/12/20
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface Hints {
    Hint[] value();
}

