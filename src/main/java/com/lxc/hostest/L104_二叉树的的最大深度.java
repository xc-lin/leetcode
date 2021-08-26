package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L104_二叉树的的最大深度 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left,right)+1;
    }

}
