package com.africa.study.offer;

/**
 * 计算数组中超过一半的数字
 *
 * @author zhuhusheng
 * @date 2016/12/27
 */
public class Item29 {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 3, 5, 3, 4, 0};
        System.out.println("超过一半的数字为：" + moreThanHalfNum(array));
    }

    /**
     * 出现超过一半的数字减去其他的数的出现次数始终是要大于 0 的
     */
    private static int moreThanHalfNum(int[] array) {
        // 一种巧妙的解法
        int result = array[0];
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if(times > 0) return result;             // 出现超过一半的数字减去其他的数的出现次数始终是要大于 0 的
        else return -100;                        // 不存在
    }

}
