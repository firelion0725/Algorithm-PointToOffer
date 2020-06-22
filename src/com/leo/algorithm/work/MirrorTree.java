package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class MirrorTree {

    //就是翻转二叉树 标准 递归写法 0ms
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        return helper(root);
    }

    private TreeNode helper(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null) {
            helper(node.left);
        }
        if (node.right != null) {
            helper(node.right);
        }
        return node;
    }
}
