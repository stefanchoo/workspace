package com.africa.study.offer;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * 和为 s 的两个数字和为s的连续正数序列
 * 头指针 和 尾指针
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item41 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 13, 14, 15};
        int s = 15;
        int[] result = new int[2];  // 存储两个解
        boolean flag = findNumWithSum(array, result, s);

        if(flag) {
            System.out.println("一组解为：" + result[0] + " " + result[1]);
        } else {
            System.out.println("不存在");
        }

        List<Result> results = Lists.newArrayList();
        boolean flag2 = findNumWithSum(array, results, s);
        if(flag2) {
            System.out.println("合为 " + s + " 共有 " + results.size() + " 组解：");
            results.forEach(r -> System.out.println(r.getT1() + "和" + r.getT2()));
        }
    }

    private static boolean findNumWithSum(int[] array, List<Result> results, int s) {
        int length = array.length;
        boolean flag = false;

        // 头指针 和 尾指针
        int low = 0;
        int high = length - 1;

        while(low < high) {
            // 如果相等
            if(array[low] + array[high] == s) {
                Result result = new Result(array[low], array[high]);
                results.add(result);
                flag = true;
                high--;
                low++;
            } else if(array[low] + array[high] > s) {
                high--;
            } else {
                low++;
            }
        }
        return flag;
    }

    private static boolean findNumWithSum(int[] array, int[] result, int s) {
        int length = array.length;
        boolean flag = false;

        // 头指针 和 尾指针
        int low = 0;
        int high = length - 1;

        while(low < high) {
            // 如果相等
            if(array[low] + array[high] == s) {
                result[0] = array[low];
                result[1] = array[high];
                flag = true;
                break;
            } else if(array[low] + array[high] > s) {
                high--;
            } else {
                low++;
            }
        }
        return flag;
    }

    @Data
    public static class Result {
        private int t1;
        private int t2;

        public Result(int t1, int t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }
}
