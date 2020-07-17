package com.leo.algorithm.work;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinArray {

    //最传统解 先排序取第一个
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
    
}
