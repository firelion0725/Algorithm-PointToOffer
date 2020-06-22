package com.leo.algorithm.work;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.model.Utils;

import java.util.HashMap;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class KthFromEnd {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = Utils.intToListNode(nums);

        KthFromEnd k = new KthFromEnd();
        k.getKthFromEnd(listNode, 2);
    }

    //单次遍历记录长度 二次遍历 拿出结果 0ms
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curNode = head;

        int length = 0;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }

        int position = length - k;
        curNode = head;
        while (position > 0) {
            curNode = curNode.next;
            position--;
        }
        return curNode;
    }

    //单次遍历 hash存储 1ms
    //不过为啥二次遍历 能比 hash快呢？ 不解
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(index, head);
            index++;
            head = head.next;
        }

        int key = index - k;
        return map.get(key);
    }
}
