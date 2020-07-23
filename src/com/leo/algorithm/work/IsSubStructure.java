package com.leo.algorithm.work;

import com.leo.algorithm.model.TreeNode;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && (helper(A.left, B.left) && helper(A.right, B.right))) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val == B.val) {
            return helper(A.left, B.left) && helper(A.right, B.right);
        } else {
            return false;
        }
    }
}
