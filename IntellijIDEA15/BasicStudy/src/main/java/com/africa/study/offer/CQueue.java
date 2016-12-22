package com.africa.study.offer;

import java.util.Stack;

/**
 * 队列
 *
 * @author zhuhusheng
 * @date 2016/12/22
 */
public class CQueue<T> {
    // 两个栈
    private Stack<T> stack1;   // 负责添加
    private Stack<T> stack2;   // 负责删除

    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * 模拟在队列末尾插入
     */
    public void appendTail(T node) {
        stack1.push(node);
    }

    /**
     * 模拟删除队列的头
     */
    public T deleteHead() {
        if (stack2.size() == 0) {
            if (stack1.size() == 0) {
                try {
                    throw new Exception("队列为空");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // stack1 不为空，将stack1中的元素放入stack2中
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
