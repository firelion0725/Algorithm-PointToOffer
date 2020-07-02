package com.leo.algorithm.work;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        MaxSlidingWindow m = new MaxSlidingWindow();
        m.maxSlidingWindow(nums, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int end = k - 1;
        int start = 0;

        for (int i = 0; i < res.length; i++) {
            res[i] = getMax(nums, start, end);
            start++;
            end++;
        }
        return res;
    }

    private int getMax(int[] nums, int start, int end) {
        int res = nums[start];
        for (int i = start; i <= end; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
