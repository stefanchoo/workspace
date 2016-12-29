package com.africa.study.offer;

/**
 * 数字在排序数组中出现的次数
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item38 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 4 , 4, 5};
        int k = 1;
        System.out.println("数字 " + k + " 在数组中出现的次数为 " + getNumOfK(array, k));
    }

    public static int getNumOfK(int[] array, int k) {
        int num = 0;
        if (array != null) {
            int index_start = getFirstK(array, k, 0, array.length - 1);         // 初始位置
            int index_end = getLastK(array, k, 0, array.length - 1);            // 结束位置
            if (index_start > -1 && index_end > -1) {
                num = index_end - index_start + 1;
            }
        }
        return num;
    }

    private static int getFirstK(int[] array, int k, int low, int high) {
        if (low > high) return -1;
        int middle = (low + high) / 2;
        if (array[middle] == k) {
            // 判断是不是第一个
            // 是第一个
            if ((middle > 0 && array[middle - 1] != k) || middle == 0) {
                return middle;
            } else {         // 不是第一个
                high = middle - 1;
            }
        } else if (array[middle] < k) {  // 在右侧
            low = middle + 1;
        } else {
            high = middle - 1;          // 在左侧
        }
        return getFirstK(array, k, low, high);
    }

    private static int getLastK(int[] array, int k, int low, int high) {
        if (low > high) return -1;
        int middle = (low + high) / 2;
        if(array[middle] == k) {
            // 判断是不是最后一个
            if(middle > 0 && array[middle + 1] != k) {
                return middle;
            } else {
                low = middle + 1;
            }
        } else if(array[middle] < k) {  // 在右侧
            low = middle + 1;
        } else {                        // 在左侧
            high = middle - 1;
        }
        return getLastK(array, k, low, high);
    }

}
