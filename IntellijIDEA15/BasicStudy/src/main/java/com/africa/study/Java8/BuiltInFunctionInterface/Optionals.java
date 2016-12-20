package com.africa.study.Java8.BuiltInFunctionInterface;

import java.util.Optional;

/**
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class Optionals {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();         // true
        optional.get();               // "bam"
        optional.orElse("fallback");  // "bam"

        optional.ifPresent(o -> System.out.println(o.charAt(0)));
    }
}
