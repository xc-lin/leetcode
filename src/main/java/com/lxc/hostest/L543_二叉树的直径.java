package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L543_二叉树的直径 {
    int result = 0;

    public int diameterOfBinaryTreeBetter(TreeNode root) {
        dfs2(root);
        return result - 1;
    }

    public int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs2(root.left);
        int right = dfs2(root.right);
        int temp = Math.max(left, right) + 1;
        result = Math.max(result,left+right+1);
        return temp;

    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root, 0);
        return result - 1;
    }

    public int dfs(TreeNode root, int length) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, length);

        int right = dfs(root.right, left + 1);
        int temp = Math.max(left, right) + 1;
        result = Math.max(result, temp + length);
        return temp;

    }
}
