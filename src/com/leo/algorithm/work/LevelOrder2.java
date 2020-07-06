package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.model.Utils;

import java.util.*;

/**
 * 要求之字形 进行层序遍历
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class LevelOrder2 {

    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode tn = Utils.intToTree(nums);

        LevelOrder2 lo2 = new LevelOrder2();
        lo2.levelOrder(tn);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        boolean fromLeft = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode tn = queue.poll();
                if (fromLeft) {
                    list.addLast(tn.val);
                } else {
                    list.addFirst(tn.val);
                }

                if (tn.left != null) {
                    queue.add(tn.left);
                }
                if (tn.right != null) {
                    queue.add(tn.right);
                }
            }
            fromLeft = !fromLeft;
            res.add(list);
        }

        return res;
    }
}
