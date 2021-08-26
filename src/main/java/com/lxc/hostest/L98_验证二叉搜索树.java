package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L98_验证二叉搜索树 {
    long pre= Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return recur(root);
    }

    public boolean recur(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = recur(root.left);
        if (!left||pre >= root.val) {
            return false;
        }
        pre=root.val;
        boolean right = recur(root.right);

        return left&&right;

    }
}
