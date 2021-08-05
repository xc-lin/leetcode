package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J54_KthLargest {
    int count = 0, k = 0, result = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        return result;
    }

    public void recur(TreeNode root) {
        if (count < k||root == null) {
            return;
        }
        recur(root.right);
        if (++count == k) {
            result = root.val;
            return;
        }
        recur(root.left);

    }
}
