package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J27_MirrorTree {
    TreeNode root=null;
    public TreeNode mirrorTree(TreeNode root) {
        recur(root);
        return root;
    }
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        recur(root.right);
        recur(root.left);

    }
}
