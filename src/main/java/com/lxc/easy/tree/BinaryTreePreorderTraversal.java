package com.lxc.easy.tree;

import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();
        recurse(root,result);
        return result;
    }
    public void recurse(TreeNode root, List<Integer> result){
        if (root==null){
           return ;
        }
        result.add(root.val);
        recurse(root.left,result);
        recurse(root.right,result);


    }
}
