package com.leo.algorithm.work;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Search {

    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.get(target) == null ? 0 : map.get(target);
    }

    //因为是有序数组 二分得到比目标大的位置和小的位置 其差为目标个数
    public int search2(int[] nums, int target) {
        return searchCore(nums, target + 0.5) - searchCore(nums, target - 0.5);
    }

    public int searchCore(int[] nums, double target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
