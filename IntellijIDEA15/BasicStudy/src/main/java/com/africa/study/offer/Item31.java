package com.africa.study.offer;

/**
 * 连续字数组的最大和
 *
 * @author zhuhusheng
 * @date 2016/12/28
 */
public class Item31 {
    public static void main(String[] args) {
        int array[] = {1, -2, 3, 10, -4, 7, 2, -5};
        int result = findGreatSumOfSubArray(array);
        System.out.println("子树组的最大和为：" + result);
    }

    public static int findGreatSumOfSubArray(int array[]) {
        // 用currentSum记录当前的和
        int currentsSum = 0;
        // 用finalGreatSum 记录历史最佳值
        int finalGreatSum = 0;
        for (int i = 0; i < array.length; i++) {
            currentsSum += array[i];
            if(currentsSum > 0) {
                if(currentsSum > finalGreatSum) {
                    finalGreatSum = currentsSum;
                }
            } else {
                currentsSum = 0;
            }
        }
        return finalGreatSum;
    }
}
