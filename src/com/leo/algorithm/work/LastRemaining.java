package com.leo.algorithm.work;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int c = (m - 1) % list.size();
        while (list.size() != 1) {
            list.remove(c);
            c = (c + m - 1) % list.size();
        }

        return list.get(0);
    }


}
