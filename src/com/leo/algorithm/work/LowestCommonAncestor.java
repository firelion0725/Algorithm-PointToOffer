package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class LowestCommonAncestor {

    //二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

    private TreeNode helperToSearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        //根据搜索二叉树特性进行剪枝
        if (p.val < root.val && q.val < root.val) {
            return helperToSearchTree(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return helperToSearchTree(root.right, p, q);
        }
        return root;
    }
}
