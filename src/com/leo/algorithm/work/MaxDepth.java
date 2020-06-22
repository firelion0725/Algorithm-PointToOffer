package com.leo.algorithm.work;


import com.leo.algorithm.model.TreeNode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        int leftDepth = node.left != null ? getDepth(node.left) : 0;
        int rightDepth = node.right != null ? getDepth(node.right) : 0;

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
