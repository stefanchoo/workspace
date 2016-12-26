package com.africa.study.offer;

/**
 * @author zhuhusheng
 * @date 2016/12/26
 */
public class Item16 {
    public static void main(String[] args) {
        ListNode node_7 = new ListNode(7);
        ListNode node_6 = new ListNode(6, node_7);
        ListNode node_5 = new ListNode(5, node_6);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);

        ListNode reservedHead = reverseList(head);
        printList(reservedHead);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode reservedHead = null;             // 新链表的头
        ListNode pNode = head;
        ListNode pPrev = null;                    // 慢指针
        while (pNode != null) {
            ListNode nextNode = pNode.getNext();  // 快指针
            if (nextNode == null) {
                reservedHead = pNode;             // 得到新链表的头
            }
            pNode.setNext(pPrev);
            pPrev = pNode;
            pNode = nextNode;
        }
        return reservedHead;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
