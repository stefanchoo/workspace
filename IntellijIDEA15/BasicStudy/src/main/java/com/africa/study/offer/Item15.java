package com.africa.study.offer;

/**
 * 双指针法： 链表中倒数第 K 个节点
 *
 * @author zhuhusheng
 * @date 2016/12/26
 */
public class Item15 {
    public static void main(String[] args) {
        ListNode node_7 = new ListNode(7);
        ListNode node_6 = new ListNode(6, node_7);
        ListNode node_5 = new ListNode(5, node_6);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);

        // 查找倒数第k个
        ListNode node = findKth2Tail(head, 2);
        System.out.println(node.getValue());
    }

    public static ListNode findKth2Tail(ListNode head, int k) {
        // 首先判断链表是否存在
        if (head == null || k <= 0) {
            return null;
        }
        ListNode prePoint = head;
        ListNode postPoint = head;

        for (int i = 0; i < k - 1; i++) {
            if(prePoint.getNext() != null) {
                prePoint = prePoint.getNext();
            } else {
                return null;
            }
        }
        while(prePoint.getNext() != null) {
            prePoint = prePoint.getNext();
            postPoint = postPoint.getNext();
        }
        return postPoint;
    }
}
