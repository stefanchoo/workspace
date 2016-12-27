package com.africa.study.offer;

/**
 * 二叉树的镜像
 *
 * @author zhuhusheng
 * @date 2016/12/27
 */
public class Item18 {
    public static void main(String[] args) {
        // 构建二叉树
        BinaryTreeNode t6 = new BinaryTreeNode(11);
        BinaryTreeNode t5 = new BinaryTreeNode(9);
        BinaryTreeNode t4 = new BinaryTreeNode(7);
        BinaryTreeNode t3 = new BinaryTreeNode(5);
        BinaryTreeNode t2 = new BinaryTreeNode(10, t5, t6);
        BinaryTreeNode t1 = new BinaryTreeNode(6, t3, t4);
        BinaryTreeNode root = new BinaryTreeNode(8, t1, t2);

        System.out.println("原始二叉树：");
        printPreOrder(root);

        // 求镜像
        mirrorRecursively(root);
        System.out.println();
        System.out.println("镜像二叉树：");
        // 前序遍历输出
        printPreOrder(root);
    }

    public static void mirrorRecursively(BinaryTreeNode root) {
        // 树为空
        if(root == null) return;
        // 只有一个根节点
        if(root.getLeft() == null && root.getRight() == null) return;
        BinaryTreeNode treeTmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(treeTmp);

        // 递归求解左右子树
        if(root.getLeft() != null) {
            mirrorRecursively(root.getLeft());
        }
        if(root.getRight() != null) {
            mirrorRecursively(root.getRight());
        }

    }

    /**
     * 递归方式实现前序遍历输出
     * @param root
     */
    public static void printPreOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }
}
