package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        recur(newRoot,root);
        return newRoot;
    }

    public void recur(TreeNode newRoot, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right!=null){
            newRoot.left = new TreeNode(root.right.val);
        }
        if (root.left!=null){
            newRoot.right = new TreeNode(root.left.val);
        }
        recur(newRoot.left,root.right);
        recur(newRoot.right,root.left);
    }
}
