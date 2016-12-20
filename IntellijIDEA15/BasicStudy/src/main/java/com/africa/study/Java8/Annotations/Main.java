package com.africa.study.Java8.Annotations;

/**
 * @author zhuhusheng
 * @date 2016/12/20
 */
public class Main {
    public static void main(String[] args) {

        // TODO: 2016/12/20 有问题的
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);

        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);
    }
}
