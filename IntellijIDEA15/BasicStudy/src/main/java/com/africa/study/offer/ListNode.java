package com.africa.study.offer;

import lombok.Data;

/**
 * @author zhuhusheng
 * @date 2016/12/22
 */
@Data
public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
