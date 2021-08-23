package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J68_2LowestCommonAncestor {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root, p, q);
        return result;
    }

    public boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || result != null) {
            return false;
        }
        boolean flag = false;
        if (root.val == p.val || root.val == q.val) {
            flag = true;
        }
        boolean left = recur(root.left, p, q);
        boolean right = recur(root.right, p, q);

        if ((flag &&left) || (flag &&left)|| (left&&right)){
            result = root;
            return true;
        }
        return flag||left||right;

    }
}
