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
        for (int i = 0; i <= k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
