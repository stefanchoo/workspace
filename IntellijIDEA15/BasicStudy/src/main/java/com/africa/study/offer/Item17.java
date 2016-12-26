package com.africa.study.offer;

/**
 * 合并两个排序的链表
 *
 * @author zhuhusheng
 * @date 2016/12/26
 */
public class Item17 {

    public static void main(String[] args) {
        // 构建链表1
        ListNode node_7 = new ListNode(7);
        ListNode node_5 = new ListNode(5, node_7);
        ListNode node_3 = new ListNode(3, node_5);
        ListNode head1 = new ListNode(1, node_3);

        // 构建链表2
        ListNode node_8 = new ListNode(8);
        ListNode node_6 = new ListNode(6, node_8);
        ListNode node_4 = new ListNode(4, node_6);
        ListNode head2 = new ListNode(2, node_4);

        System.out.println("链表1：");
        printList(head1);
        System.out.println("-------------");

        System.out.println("链表2：");
        printList(head2);
        System.out.println("-------------");

        System.out.println("合并后的链表：");
        ListNode head = mergeList(head1, head2);
        printList(head);
        System.out.println("--------------");
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode head = null;
        if(head1 == null) {
            head = head2;
        } else if (head2 == null) {
            head = head1;
        }
        if(head1 != null && head2 != null) {
            ListNode node_1 = head1;
            ListNode node_2 = head2;
            if(node_1.getValue() < node_2.getValue()) {
                head = node_1;
                head.setNext(mergeList(node_1.getNext(), node_2));
            } else {
                head = node_2;
                head.setNext(mergeList(node_1, node_2.getNext()));
            }
        }
        return head;
    }
}
