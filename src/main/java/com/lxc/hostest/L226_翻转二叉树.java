package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        recur(root);
        return root;
    }
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        recur(root.left);
        recur(root.right);


    }
}
