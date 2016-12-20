package com.africa.study.Java8.lambda;

import com.africa.study.Java8.defaultInterface.Formula;

/**
 * the scope of lambda
 * <p>final local variable</p>
 * <p>field variable</p>
 * <p>static variable</p>
 *
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class LambdaScope {
    public static void main(String[] args) {

        // final variable
        final int num = 1;
        Converter<Integer, String> stringConverter1 = from -> String.valueOf(from + num);
        System.out.println(stringConverter1.convert(2));

//        int num = 1;
//        Converter<Integer, String> stringConverter1 = from -> String.valueOf(from + num);
//        System.out.println(stringConverter1.convert(2));
////        num = 4;             // Error because num has been compiled as final variable.

        // field variable & static variable
        Lambda4 lambda4 = new Lambda4();
        lambda4.testScope(209);

//        Formula formula = (a) -> sqrt(a * 100); // default method in interface couldn't be accessed in lambda.
    }

    public static final class Lambda4 {
        static int outStaticNum;
        int outerNum;

        void testScope(int a) {
            Converter<Integer, String> stringConverter1 = from -> {
                outerNum = 23;
                return String.valueOf(from + outerNum);
            };
            System.out.println(stringConverter1.convert(a));

            Converter<Integer, String> stringConverter2 = from -> {
                outStaticNum = 72;
                return String.valueOf(from + outStaticNum);
            };
            System.out.println(stringConverter2.convert(a));
        }

    }
}
