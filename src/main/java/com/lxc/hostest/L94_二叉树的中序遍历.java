package com.lxc.hostest;

import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L94_二叉树的中序遍历 {
    List<Integer>  result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return result;
    }
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        recur(root.left);
        result.add(root.val);
        recur(root.right);
    }
}
