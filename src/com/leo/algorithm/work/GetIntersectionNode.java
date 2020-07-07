package com.leo.algorithm.work;

import com.leo.algorithm.model.ListNode;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        int al = getLength(headA);
        int bl = getLength(headB);
        int diff = Math.abs(al - bl);

        if (al - bl > 0) {
            for (int i = 0; i < diff; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                b = b.next;
            }
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    private int getLength(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
