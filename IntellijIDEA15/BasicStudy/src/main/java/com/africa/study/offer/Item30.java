package com.africa.study.offer;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 最小的k个数
 *
 * @author zhuhusheng
 * @date 2016/12/28
 */
public class Item30 {
    public static void main(String[] args) {
        // 测试的例子
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        final int k = 4;
        TreeSet<Integer> set = getLastNumbers(array, k);
        Iterator<Integer> it = set.iterator();
        System.out.println("最小的" + k + "个数为：");
        while (it.hasNext()) {
            System.out.print(it.next() + "  ");
        }
    }

    /**
     * 搜索二叉树的思想
     */
    public static TreeSet<Integer> getLastNumbers(int[] array, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        // 判断k和array的合法性
        if(array == null || k <= 0) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            if(set.size() < k) {
                set.add(array[i]);
            } else {
                if(set.last() > array[i]) {
                    set.pollLast();                // 移除
                    set.add(array[i]);             // 加入新的
                }
            }
        }
        return set;
    }
}
