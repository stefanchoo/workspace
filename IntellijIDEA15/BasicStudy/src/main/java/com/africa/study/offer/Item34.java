package com.africa.study.offer;

/**
 * 丑数：只包含因子2， 3， 5的数，求从小到大顺序的第1500个丑数。
 * 约定：1当做第一个丑数
 *
 * @author zhuhusheng
 * @date 2016/12/28
 */
public class Item34 {
    public static void main(String[] args) {
        int index = 1500;
        System.out.println("第" + index + "个丑数为：" + getUglyNum(index));
    }

    private static int getUglyNum(int index) {
        // 为了便于存储，可以建立数组保存的中间结果
        int tmp[] = new int[index];
        // 保存第一个
        tmp[0] = 1;
        // 记录三组数的位置
        int multi2 = 0;
        int multi3 = 0;
        int multi5 = 0;

        int nextUglyNum = 1;
        while (nextUglyNum < index) {
            int min = findMin(tmp[multi2] * 2, tmp[multi3] * 3, tmp[multi5] * 5);
            tmp[nextUglyNum] = min;

            // 重新计算
            while (tmp[multi2] * 2 <= min) {
                multi2++;
            }
            while (tmp[multi3] * 3 <= min) {
                multi3++;
            }
            while (tmp[multi5] * 5 <= min) {
                multi5++;
            }
            nextUglyNum++;
        }
        return tmp[index - 1];
    }

    private static int findMin(int t1, int t2, int t3) {
        return t1 < t2 ? (t1 < t3 ? t1 : t3) : (t2 < t3 ? t2 : t3);
    }

}
