package com.leo.algorithm.work;

import com.leo.algorithm.model.ListNode;

import java.util.Stack;

public class ReversePrint {


    //利用栈的特性 先进后出
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        if (stack.size() == 0) {
            return res;
        }
        int index = 0;
        while (stack.size() != 0) {
            ListNode node = stack.pop();
            res[index] = node.val;
            index++;
        }

        return res;
    }

    //也是二次循环
    public int[] reversePrintOffice(ListNode head) {
        int len = 0;
        ListNode tail = head;
        while(tail != null){
            tail = tail.next;
            len++;
        }
        int[] arr = new int[len];
        int j = len - 1;
        while(head != null){
            arr[j] = head.val;
            head = head.next;
            j--;
        }
        return arr;
    }

}
