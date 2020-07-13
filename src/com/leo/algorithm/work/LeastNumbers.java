package com.leo.algorithm.work;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class LeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length <= k) {
            return arr;
        }

        int[] res = new int[k];

        Arrays.sort(arr);
        if (k + 1 >= 0) System.arraycopy(arr, 0, res, 0, k + 1);
        return res;
    }
}
