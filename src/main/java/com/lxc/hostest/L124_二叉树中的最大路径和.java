package com.lxc.hostest;

import com.lxc.util.TreeNode;

public class L124_二叉树中的最大路径和 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recur(root);
        return result;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(recur(root.left),0);
        int right = Math.max(recur(root.right),0);
        // 经过当前跟节点的最大值是 左节点的最大值+右节点最大值+自己的值
        int res=left+right+ root.val;
        result=Math.max(res,result);
        // 但是返回的时候不可以返回res 因为不能重复走
        return Math.max(left,right)+root.val;
    }
}
