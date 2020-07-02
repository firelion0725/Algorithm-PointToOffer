package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class IsBalancedTree {

    //这套双重递归写法确实是极好的 平衡递归 + 深度递归
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(getDepth(root.left, 0) - getDepth(root.right, 0)) < 2);
    }

    private int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int leftDepth = getDepth(node.left, depth + 1);
        int rightDepth = getDepth(node.right, depth + 1);

        return Math.max(rightDepth, leftDepth);
    }

}
