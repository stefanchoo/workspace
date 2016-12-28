package com.africa.study.offer;

/**
 * @author zhuhusheng
 * @date 2016/12/28
 */
public class Item37 {
    public static void main(String[] args) {
        // 构建链表
        ListNode node_7 = new ListNode(7);
        ListNode node_6 = new ListNode(6, node_7);
        ListNode node_5 = new ListNode(5, node_6);
        ListNode head2 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_6);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head1 = new ListNode(1, node_2);

        ListNode result = findFirst(head1, head2);
        System.out.println("第一个公共结点：" + result.getValue());
    }

    /**
     * 查找第一个公共的结点
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode findFirst(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        int list_1_len = 0;
        int list_2_len = 0;
        // 分别计算两个链表的长度
        while(p1 != null) {
            list_1_len++;
            p1 = p1.getNext();
        }
        while(p2 != null) {
            list_2_len++;
            p2 = p2.getNext();
        }
        int nLength = list_1_len - list_2_len;
        ListNode pLong = head1;
        ListNode pShort = head2;
        if(list_1_len < list_2_len) {
            pLong = head2;
            pShort = head1;
            nLength = list_2_len - list_1_len;
        }

        // 长的先走nLength步
        for (int i = 0; i < nLength; i++) {
            pLong = pLong.getNext();
        }

        // 此时长度相等
        while(pLong != null && pShort != null && pLong != pShort){
            pLong = pLong.getNext();
            pShort = pShort.getNext();
        }

        return pLong;
    }
}
