package com.africa.study.offer;

/**
 * 二叉树的深度
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item39 {
    public static void main(String[] args) {
        BinaryTreeNode node_7 = new BinaryTreeNode(7);
        BinaryTreeNode node_6 = new BinaryTreeNode(6);
        BinaryTreeNode node_5 = new BinaryTreeNode(5);
        BinaryTreeNode node_4 = new BinaryTreeNode(4);
        BinaryTreeNode node_3 = new BinaryTreeNode(3, null, node_6);
        BinaryTreeNode node_2 = new BinaryTreeNode(2, node_4, node_5);
        BinaryTreeNode root = new BinaryTreeNode(1, node_2, node_3);

        // 计算深度
        System.out.println("二叉树的深度为：" + treeDepth(root));
    }

    /**
     * 计算二叉树的深度
     *
     * @param root
     * @return 深度
     */
    private static int treeDepth(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        // 递归实现左右子树的深度
        int leftDepth = treeDepth(root.getLeft());
        int rightDepth = treeDepth(root.getRight());

        // 找到最大值
        return (leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1);
    }

}
