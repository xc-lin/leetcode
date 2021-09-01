package com.lxc.hostest;

import com.lxc.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L337_打家劫舍III {
    Map<TreeNode, Integer> include=new HashMap<>();
    Map<TreeNode, Integer> exclude=new HashMap<>();
    public int rob(TreeNode root) {
        recur(root);
        return Math.max(include.getOrDefault(root,0),exclude.getOrDefault(root,0));
    }
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        recur(root.left);
        recur(root.right);
        int exLeft=exclude.getOrDefault(root.left,0);
        int exRight=exclude.getOrDefault(root.right,0);
        int inLeft=include.getOrDefault(root.left,0);
        int inRight=include.getOrDefault(root.right,0);

        include.put(root,root.val+exLeft+exRight);
        exclude.put(root,Math.max(exLeft,inLeft)+Math.max(exRight,inRight));
    }
}
