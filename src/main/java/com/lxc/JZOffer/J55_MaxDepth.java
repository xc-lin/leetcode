package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

import java.util.*;

public class J55_MaxDepth {
    int depth = 0, result = 0;

    public int maxDepth(TreeNode root) {
        recur(root);
        return depth;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }

        if (++result > depth) {
            depth = result;
        }
        recur(root.left);
        recur(root.right);
        result--;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> tmp ;
        queue.add(root);
        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node=queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;

    }




}
