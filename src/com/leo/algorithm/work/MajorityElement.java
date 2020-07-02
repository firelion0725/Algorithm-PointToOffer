package com.leo.algorithm.work;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {

    //hash 计数法
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int data : nums) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        for (Integer a : map.keySet()) {
            if (map.get(a) > nums.length / 2) {
                return a;
            }
        }
        return 0;
    }

    //因为众数数量一定超过一半所以排序后 中位数一定为众数
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }

}
