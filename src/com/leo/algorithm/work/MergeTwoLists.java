package com.leo.algorithm.work;

import com.leo.algorithm.model.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if (l1 == null) {
            res.next = l2;
        }

        if (l2 == null) {
            res.next = l1;
        }

        return temp.next;
    }
}
