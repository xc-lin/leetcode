package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

import java.util.*;

public class J32_1LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {

            result[i] = list.get(i);
        }
        return result;

    }
}
