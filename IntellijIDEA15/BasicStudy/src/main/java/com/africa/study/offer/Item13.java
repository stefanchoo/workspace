package com.africa.study.offer;

/**
 * 在 O(1)时间删除链表的节点
 *
 * @author zhuhusheng
 * @date 2016/12/26
 */
public class Item13 {
    public static void main(String[] args) {
        ListNode node_7 = new ListNode(7);
        ListNode node_6 = new ListNode(6, node_7);
        ListNode node_5 = new ListNode(5, node_6);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);

        // 输出原始链表
        System.out.println("原始链表：");
        printList(head);
        System.out.println("--------------");

        // 删除节点 node_3
        deleteNode(head, node_3);
        System.out.println("删除node_3后的链表：");
        printList(head);
        System.out.println("--------------");

        // 删除head
        deleteNode(head, head);
        System.out.println("删除head后链表：");
        printList(head);
        System.out.println("--------------");
    }

    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if(head == null || toBeDeleted == null) {
            return;
        }
        if(toBeDeleted.getNext() != null) {
            ListNode p = toBeDeleted.getNext();
            toBeDeleted.setValue(p.getValue());
            // 删除节点
            toBeDeleted.setNext(p.getNext());
        } else if(head == toBeDeleted) {
            head = null;
        } else {
            // 删除尾节点
            ListNode currentNode = head;      // 用于遍历链表
            while(currentNode.getNext() != toBeDeleted) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
