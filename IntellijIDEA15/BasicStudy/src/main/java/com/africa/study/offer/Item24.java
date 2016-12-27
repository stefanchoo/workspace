package com.africa.study.offer;

import java.util.Arrays;

/**
 * 二叉搜索树的后续遍历序列
 *
 * @author zhuhusheng
 * @date 2016/12/27
 */
public class Item24 {
    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySequenceOfBST(array));
    }

    public static boolean verifySequenceOfBST(int[] sequence) {
        int length = sequence.length;
        // 序列的最后一个数是二叉搜索树的根节点
        int root = sequence[length - 1];
        int i;
        for (i = 0; i < length; i++) {
            if(sequence[i] >= root) {
                break;
            }
        }

        // 判断右子树是否满足要求
        for (int j = i; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 左子树节点的个数
        int leftNum = i;
        // 构建左子树的序列
        int left[] = Arrays.copyOfRange(sequence, 0, leftNum);
        // 构造右子树的序列
        int right[] = Arrays.copyOfRange(sequence, leftNum, length - 1);
        boolean leftBool = true;
        boolean rightBool = true;
        // 当左子树的序列存在时
        if(left.length > 0) {
            leftBool = verifySequenceOfBST(left);
        }
        // 当右子树存在时
        if(right.length > 0) {
            rightBool = verifySequenceOfBST(right);
        }
        return (leftBool & rightBool);
    }
}
