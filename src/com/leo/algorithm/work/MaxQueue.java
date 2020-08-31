package com.leo.algorithm.work;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class MaxQueue {

    private Queue<Integer> queue;
    private int max;

    public MaxQueue() {
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (queue == null || queue.size() == 0) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        queue.add(value);
        max = Math.max(max, value);
    }

    public int pop_front() {
        if (queue == null || queue.size() == 0) {
            return -1;
        }
        int v = queue.poll();
        if (v == max) {
            getMax();
        }
        return v;
    }

    private void getMax() {
        max = Integer.MIN_VALUE;
        for (Integer v : queue) {
            max = Math.max(v, max);
        }
    }
}
