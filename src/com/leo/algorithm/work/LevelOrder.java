package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.model.Utils;

import java.util.*;

/**
 * 二叉树层序遍历 基础BFS题 必会
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class LevelOrder {

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = Utils.intToTree(nums);
        LevelOrder l = new LevelOrder();
        l.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pop();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
