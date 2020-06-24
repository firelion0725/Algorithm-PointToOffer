package com.leo.algorithm.work;

import java.util.Stack;

public class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        switchStack(stack1, stack2);
        stack1.add(value);
        switchStack(stack2, stack1);
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        int d = stack1.pop();
        size--;
        return d;
    }

    private void switchStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (stack1.size() != 0) {
            int val = stack1.pop();
            stack2.add(val);
        }
    }
}
