package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J54_KthLargest {
    int count = 0;
    int k;
    int result=0;
    boolean flag=false;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recur(root);
        return result;
    }

    public void recur(TreeNode root) {
        if (root == null||flag) {
            return ;
        }
        recur(root.right);
        if (++count == k){
            result = root.val;
            flag=true;
            return;
        }
        recur(root.left);
    }
}
