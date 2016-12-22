package com.africa.study.offer;

/**
 * @author zhuhusheng
 * @date 2016/12/22
 */
public class Item07 {
    public static void main(String[] args) {
        // 在队列中增加元素  
        CQueue<Integer> cq = new CQueue<>();
        for (int i = 0; i < 5; i++) {
            cq.appendTail(i);
        }
        // 依次取出
        for (int i = 0; i < 5; i++) {
            System.out.print(cq.deleteHead() + "、");
        }
        System.out.println();
        // 此时为空，再取一次，看会不会报错
        cq.deleteHead();
    }
}
