package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)) {
            return true;
        }
        return false;

    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
