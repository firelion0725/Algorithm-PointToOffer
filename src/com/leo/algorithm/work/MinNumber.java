package com.leo.algorithm.work;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class MinNumber {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

}
