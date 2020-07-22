package com.leo.algorithm.work;

public class TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    //==========================================


    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
     */
    Node pre, head;

    // 中序递增
    public Node treeToDoublyList(Node node) {
        if (node == null) return null;
        dfs(node);
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 中序遍历
    void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        //因为上一步会不断往左侧（小侧）递归 可以得到最小值 pre为null意味着没有记录过 所以此时可以得到head
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        //通过不断递归之后pre为最后一个节点
        dfs(node.right);
    }
}
