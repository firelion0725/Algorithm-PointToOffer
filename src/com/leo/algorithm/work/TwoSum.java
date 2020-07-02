package com.leo.algorithm.work;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class TwoSum {

    //hash计数作为缓存方式 是一种通用方式
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashSet<Integer> datas = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            int sub = target - data;
            if (datas.contains(sub)) {
                res[0] = sub;
                res[1] = data;
                return res;
            }
            datas.add(data);
        }
        return res;
    }

    //首位指针向中间移动，因为本题中声明 数组为递增
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null) {
            return new int[2];
        }
        int start = 0;
        int end = nums.length - 1;
        int[] res = new int[2];
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                res[0] = nums[start];
                res[1] = nums[end];
                break;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }
}
