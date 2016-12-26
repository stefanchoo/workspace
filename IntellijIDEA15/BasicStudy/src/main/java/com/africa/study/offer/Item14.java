package com.africa.study.offer;

import java.util.Arrays;

/**
 * 双指针法: 调整数组顺序
 *
 * @author zhuhusheng
 * @date 2016/12/26
 */
public class Item14 {
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        rejustArray(A);
        System.out.println(Arrays.toString(A));
    }

    public static void rejustArray(int[] array) {
        // 两个位置，头和尾
        int low = 0;
        int high = array.length - 1;

        // 两个位置直到相遇
        while (low < high) {
            // 如果low位置上的为偶数，high位置上为奇数，则交换
            if (array[low] % 2 == 0 && array[high] % 2 == 1) {
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
                low++;
                high--;
            } else if (array[low] % 2 == 1) { // low 位置为奇数，low 后移
                low++;
            } else {                          // high 位置上为偶数，high 前移
                high--;
            }
        }
    }
}