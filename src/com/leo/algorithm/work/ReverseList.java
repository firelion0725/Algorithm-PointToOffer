package com.leo.algorithm.work;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.model.Utils;

import java.util.Stack;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode node = Utils.intToListNode(nums);

        ReverseList r = new ReverseList();
        r.reverseList(node);
    }

    //用栈结构进行翻转
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        if (stack.size() == 0) {
            return null;
        }

        ListNode newHead = stack.pop();
        ListNode res = newHead;
        while (stack.size() != 0) {
            newHead.next = stack.pop();
            newHead = newHead.next;
        }
        newHead.next = null;
        return res;
    }

    //双指针平移翻转 官方最优
    public ListNode reverseListOffice(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存cur下一个
            ListNode curNext = cur.next;
            // 当前node指向前一个 进行翻转
            cur.next = pre;
            // 前一个变成现在的 等价于 一次平移 pre平移完成
            pre = cur;
            // 现在的变成下一个 等价于 一次平移 cur平移完成 两个指针都完成平移 工作结束
            cur = curNext;
        }
        return pre;
    }
}
