package com.africa.study.offer;

import java.util.List;
import java.util.Stack;

/**
 * 从微到头打印链表
 *
 * @author zhuhusheng
 * @date 2016/12/22
 */
public class Item05 {
    public static void main(String[] args) {
        ListNode node_four = new ListNode(4);
        ListNode node_three = new ListNode(3, node_four);
        ListNode node_two = new ListNode(2, node_three);
        ListNode node_one = new ListNode(1, node_two);
        ListNode head = new ListNode(0, node_one);

        printRecursiveListReverse(head);
        printStackListReverse(head);
    }

    public static void printRecursiveListReverse(ListNode head) {
        System.out.println("枚举法：");
        if(head.getNext() != null) {
            printRecursiveListReverse(head.getNext());
        }
        System.out.println(head.getValue());
    }

    public static void printStackListReverse(ListNode head) {
        System.out.println("堆栈法：");
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        // push in stack
        while(p!= null) {
            stack.push(p);
            p = p.getNext();
        }
        // pop out stack
        while(!stack.isEmpty()) {
            ListNode node = stack.pop();
            System.out.println(node.getValue());
        }
    }
}
