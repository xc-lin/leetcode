package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L236_二叉树的最近公共祖先 {
    TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root, p, q);
        return result;
    }

    public boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null||result!=null) {
            return false;
        }
        boolean flag=false;
        if (root.val == p.val || root.val == q.val) {
            flag=true;
        }
        if (flag==true){
            System.out.println(root.val);
        }
        boolean left=recur(root.left,p,q);
        boolean right=recur(root.right,p,q);
        if ((flag&&left)||(left&&right)||(right&&flag)){
            result=root;
            return true;
        }
        return false;
    }
}
