package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J55_2IsBalanced {
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        recur(root,0);
        return result;
    }

    public int recur(TreeNode root,int depth) {
        if (root == null||!result) {
            return depth;
        }
        depth++;
        int leftDepth=recur(root.left,depth);
        int rightDepth=recur(root.right,depth);
        if (Math.abs(leftDepth-rightDepth)>1){
            result=false;
            return 0;
        }
        return Math.max(leftDepth,rightDepth);




    }

}
