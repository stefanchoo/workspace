package com.africa.study.offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author zhuhusheng
 * @date 2016/12/27
 */
public class Item21 {
    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(3);
        s.push(4);
        s.push(2);
        System.out.println(s.min());
        s.push(1);
        System.out.println(s.min());
    }

    public static final class StackWithMin {
        private Stack<Integer> stack;
        private Stack<Integer> stackHelp;    // 一个辅助的栈

        public StackWithMin() {
            stack = new Stack<>();
            stackHelp = new Stack<>();
        }

        public void push(int t) {
            stack.push(t);
            // 插入辅助的栈
            if(stackHelp.size() == 0 || t < stackHelp.peek()) {
                stackHelp.push(t);
            } else {
                stackHelp.push(stackHelp.peek());
            }
        }

        public int pop() {
            assert (stack.size() > 0 && stackHelp.size() > 0);
            stackHelp.pop();
            return stack.pop();
        }

        public int min() {
            assert (stack.size() > 0 && stackHelp.size() > 0);
            return stackHelp.peek();
        }
    }
}
