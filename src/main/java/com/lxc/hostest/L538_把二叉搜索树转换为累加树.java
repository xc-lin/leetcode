package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L538_把二叉搜索树转换为累加树 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
