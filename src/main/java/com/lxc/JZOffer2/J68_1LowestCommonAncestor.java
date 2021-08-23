package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J68_1LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }

    public TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return recur(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return recur(root.left, p, q);
        }
        return root;
    }
}
