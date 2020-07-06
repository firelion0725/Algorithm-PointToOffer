package com.leo.algorithm.work;

import com.leo.algorithm.model.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode root = head;
        while (root.next != null) {
            if (root.next.val == val) {
                root.next = root.next.next;
                return head;
            }
            root = root.next;
        }

        return head;
    }
}
