package com.leo.algorithm.work;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口入门题 必会 不然滑动窗口都没法做
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int left = 1;
        int right = 2;
        int sum = 3;

        while (left <= target / 2) {
            if (sum == target) {
                //加入结果集
                res.add(getArray(left, right));
                //左指针右移
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return listToArray(res);
    }

    private int[] getArray(int left, int right) {
        int[] res = new int[right - left + 1];
        for (int i = 0; i <= right - left; i++) {
            res[i] = left + i;
        }
        return res;
    }

    private int[][] listToArray(List<int[]> list) {
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
