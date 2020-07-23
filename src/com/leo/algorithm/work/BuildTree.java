package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class BuildTree {
    Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTree b = new BuildTree();
        b.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start == pre_end) {
            return new TreeNode(preorder[pre_start]);
        }
        if (pre_start > pre_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_start]);
//        int index = getIndex(inorder, preorder[pre_start]);
        int index = map.get(preorder[pre_start]);
        int i_s_l = in_start;
        int i_e_l = index - 1;
        int count = i_e_l - i_s_l + 1;
        int p_s_l = pre_start + 1;
        int p_e_l = pre_start + count;

        int i_s_r = index + 1;
        int i_e_r = in_end;
        int p_s_r = p_e_l + 1;
        int p_e_r = pre_end;


        TreeNode left = helper(preorder, inorder, p_s_l, p_e_l, i_s_l, i_e_l);
        TreeNode right = helper(preorder, inorder, p_s_r, p_e_r, i_s_r, i_e_r);
        root.left = left;
        root.right = right;
        return root;
    }


    private int getIndex(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
