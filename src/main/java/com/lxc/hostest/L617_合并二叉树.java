package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);

    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newRoot;
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            newRoot = new TreeNode(root1.val + root2.val);
        }
        newRoot.left = dfs(root1.left, root2.left);
        newRoot.right = dfs(root1.right, root2.right);
        return newRoot;

    }

}
