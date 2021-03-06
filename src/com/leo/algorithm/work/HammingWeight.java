package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;

        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
