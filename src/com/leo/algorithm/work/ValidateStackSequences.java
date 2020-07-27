package com.leo.algorithm.work;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};

        ValidateStackSequences s = new ValidateStackSequences();
        s.validateStackSequences(push, pop);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0, len = pushed.length; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < len && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();

    }
}
