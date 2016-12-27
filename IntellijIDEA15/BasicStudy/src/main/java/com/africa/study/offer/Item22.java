package com.africa.study.offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 序列长度是否相等，若相等且大于0，则直接利于辅助栈模拟入栈和出栈
 * 如果栈为空，则入栈，此时若栈顶元素与出栈序列的第一个元素相等，则出栈，最后判断栈是否空且出栈序列的所有元素都遍历完
 *
 * @author zhuhusheng
 * @date 2016/12/27
 */
public class Item22 {
    public static void main(String[] args) {
        // 测试用例
        // 第一组
        int pushArray_1[] = {1, 2, 3, 4, 5};
        int popArray_1[] = {4, 5, 3, 2, 1};
        System.out.println("第一组：" + isEqualPopOrder(pushArray_1, popArray_1));

        // 第二组
        int pushArray_2[] = {1, 2, 3, 4, 5};
        int popArray_2[] = {4, 3, 5, 1, 2};
        System.out.println("第二组：" + isEqualPopOrder(pushArray_2, popArray_2));

        // 第三组
        int pushArray_3[] = {1, 2, 3, 4, 5};
        int popArray_3[] = {4, 5, 3};
        System.out.println("第三组：" + isSubPopOrder(pushArray_3, popArray_3));
    }

    private static boolean isEqualPopOrder(int[] pushArray, int[] popArray) {
        boolean flag = false;
        // 能够执行的条件是这样的序列不为空，而且这两个序列的长度是相等的
        if(pushArray.length > 0 && pushArray.length == popArray.length) {
            // 构造一个辅助栈
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int j = 0;
            while(i < pushArray.length) {
                // 当栈非空时，若栈顶元素与出栈序列中的元素相同，则出栈
                if(stack.size() > 0 && stack.peek() == popArray[j]) {
                    stack.pop();
                    j++;
                } else {  // 若不相等或者栈为空，则在入栈序列中继续增加
                    stack.push(pushArray[i]);
                    i++;
                }
            }
            // 此时栈中还有元素需要与出栈序列对比
            while(stack.size() > 0) {
                // 若结果相等就出栈
                if(stack.peek() == popArray[j]) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }
            // 最终如果栈是空的，而且popArray中所有的数都遍历了，则是出栈序列
            if(stack.isEmpty() && j == popArray.length) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isSubPopOrder(int[] pushArray, int[] popArray) {
        boolean flag = false;
        // 能够执行的条件是这样的序列不为空
        if(pushArray.length > 0) {
            // 构造一个辅助栈
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int j = 0;
            while(i < pushArray.length) {
                // 当栈非空时，若栈顶元素与出栈序列中的元素相同，则出栈
                if(stack.size() > 0 && stack.peek() == popArray[j]) {
                    stack.pop();
                    j++;
                } else {  // 若不相等或者栈为空，则在入栈序列中继续增加
                    stack.push(pushArray[i]);
                    i++;
                }
            }
            // 此时栈中还有元素需要与出栈序列对比
            while(stack.size() > 0 && j < popArray.length) {
                // 若结果相等就出栈
                if(stack.peek() == popArray[j]) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }
            // popArray中所有的数都遍历了，则是出栈序列
            if(j == popArray.length) {
                flag = true;
            }
        }
        return flag;
    }
}
