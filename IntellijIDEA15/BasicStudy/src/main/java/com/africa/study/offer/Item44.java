package com.africa.study.offer;

import java.util.Arrays;

/**
 * 扑克牌的顺序
 * A - 1, 大小王 - 0, 相当于 癞子
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item44 {
    public static void main(String[] args) {
        // 用例1：正好填补
        int array_1[] = {0, 0, 1, 4, 5};
        System.out.println(isContinuous(array_1));

        // 用例2：不能填补
        int array_2[] = {0, 1, 4, 5, 6};
        System.out.println(isContinuous(array_2));

        // 用例3：有相同元素
        int array_3[] = {0, 1, 3, 3, 4};
        System.out.println(isContinuous(array_3));
    }

    public static boolean isContinuous(int array[]) {
        Arrays.sort(array);

        int numOfZero = 0;       // 统计 0 的个数
        int sumOfError = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] == 0) {
                numOfZero++;
            } else {
                if(array[i + 1] == array[i]) {   // 有相同元素
                    return false;
                } else {
                    sumOfError += array[i + 1] - array[i] - 1;   // 相邻元素差值大于1，记一个错误
                }
            }
        }
        return numOfZero >= sumOfError;
    }
}
