package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class KthLargest {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        if (k > list.size()) {
            return 0;
        }
        int index = list.size() - k;
        return list.get(index);
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            helper(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            helper(node.right, list);
        }
    }
}
