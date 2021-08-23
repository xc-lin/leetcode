package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

public class J55_MaxDepth {
    int count = 0;
    int result = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recur(root);
        return result;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            if (count > result) {
                result = count;
            }
            return;
        }
        count++;
        recur(root.left);
        recur(root.right);
        count--;

    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recur2(root,0);

    }

    public int recur2(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int leftDepth = recur2(root.left, depth);
        int rightDepth = recur2(root.right, depth);
        return Math.max(leftDepth,rightDepth);
    }


}
