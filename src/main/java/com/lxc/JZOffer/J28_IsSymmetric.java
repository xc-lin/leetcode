package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J28_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode left, TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return recur(left.left,right.right)&&recur(left.right,right.left);

    }
}
