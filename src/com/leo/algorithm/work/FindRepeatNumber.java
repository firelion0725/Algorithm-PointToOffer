package com.leo.algorithm.work;

import java.util.HashMap;
import java.util.HashSet;

public class FindRepeatNumber {

    //hash 查重
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer data : nums) {
            if (set.contains(data)) {
                return data;
            }
            set.add(data);
        }
        return -1;
    }

}
