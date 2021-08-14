package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J28_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }

        if (leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val) {
            return false;
        }

        return recur(leftRoot.right, rightRoot.left) && recur(leftRoot.left, rightRoot.right);

    }
}
