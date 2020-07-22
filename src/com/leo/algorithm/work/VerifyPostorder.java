package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] nums, int left, int right) {
        if (left == right) {
            return true;
        }

        int right_count = 0;
        int left_count = 0;
        int root = nums[right];
        for (int i = right - 1; i >= left; i--) {
            if (nums[i] > root) {
                right_count++;
            } else {
                break;
            }
        }
        left_count = right - 1 - right_count;
        if (!check(nums, 0, left_count, root)) {
            return false;
        }
        return helper(nums, 0, left_count) && helper(nums, left_count + 1, right - 1);
    }

    private boolean check(int[] nums, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (nums[i] > target) {
                return false;
            }
        }
        return true;
    }

    //==============================================================

    public boolean verifyPostorder2(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
