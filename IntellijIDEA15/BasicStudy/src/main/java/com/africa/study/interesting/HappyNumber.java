package com.africa.study.interesting;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Test two digits number is happy number or not.
 *
 * 19 is a happy number
 *
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author zhuhusheng
 * @date 2016/9/12
 */
public class HappyNumber {
    public static void main(String[] args) throws IOException {
        System.out.println("please input two digits number:");
        while(true) {
            Integer n = new Scanner(System.in).nextInt();
            System.out.println(n + " is" + (isHappy(n) ? " " : " not ") + "a happy number!");
        }
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            n = getSum(n);
            if(n == 1) {
                return true;
            }
        }
        return false;
    }

    private static int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n = n/10;
        }
        return sum;
    }
}
