package com.africa.study.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 *
 * @author zhuhusheng
 * @date 2016/12/27
 */
public class Item23 {
    public static void main(String[] args) {
        // 构建二叉树
        BinaryTreeNode t6 = new BinaryTreeNode(11);
        BinaryTreeNode t5 = new BinaryTreeNode(9);
        BinaryTreeNode t4 = new BinaryTreeNode(7);
        BinaryTreeNode t3 = new BinaryTreeNode(5);
        BinaryTreeNode t2 = new BinaryTreeNode(10, t5, t6);
        BinaryTreeNode t1 = new BinaryTreeNode(6, t3, t4);
        BinaryTreeNode root = new BinaryTreeNode(8, t1, t2);

        // 层次遍历
        System.out.println("层次遍历序列：");
        printFromTopToBottom(root);
    }

    /**
     * 层次遍历
     */
    private static void printFromTopToBottom(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode treeNode = queue.poll();
            System.out.print(treeNode.getValue() + " ");
            if(treeNode.getLeft() != null) {
                queue.add(treeNode.getLeft());
            }
            if(treeNode.getRight() != null) {
                queue.add(treeNode.getRight());
            }
        }
    }


}
