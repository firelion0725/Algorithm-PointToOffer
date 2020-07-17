package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i < nums[i]) {
                return i;
            }
        }
        return nums[nums.length - 1] + 1;
    }

}
