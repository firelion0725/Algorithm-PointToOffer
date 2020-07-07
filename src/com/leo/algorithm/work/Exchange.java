package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int fastIndex = 0;
        int slowIndex = 0;

        while (fastIndex < nums.length) {
            if (nums[fastIndex] % 2 != 0) {
                if (fastIndex != slowIndex) {
                    reverse(nums, fastIndex, slowIndex);
                }
                slowIndex++;
            }
            fastIndex++;
        }
        return nums;
    }

    private void reverse(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
