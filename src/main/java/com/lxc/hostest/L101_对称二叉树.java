package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }

}
