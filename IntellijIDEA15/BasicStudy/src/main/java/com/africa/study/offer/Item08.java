package com.africa.study.offer;

/**
 * 旋转数组的最小数字
 *
 * @author zhuhusheng
 * @date 2016/12/23
 */
public class Item08 {
    public static void main(String[] args) {
        int[] A = { 3, 4, 5, 1, 2};    // 旋转数组
        System.out.println(findMin(A));
    }

    /**
     *  思路： 旋转之后的数组，部分是有序的，数组依然可以二分法来查询
     */
    public static int findMin(int array[]) {
        int low = 0;
        int high = array.length - 1;
        int middle = low;
        while(array[low] >= array[high]) {
            // 数组中只有两个数时，最小的是后者
            if(high - low == 1) {
                middle = high;
                break;
            }
            // 查找中间位置
            middle = (high + low) / 2;
            if(array[middle] >= array[low]) {
                low = middle;
            } else if(array[middle] <= array[high]) {
                high = middle;
            }
        }
        return array[middle];
    }
}
