package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class J34_PathSum {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode node, int target) {
        if (node == null) {

            return;
        }
        path.offer(node.val);

        int newTarget = target - node.val;
        if (newTarget == 0 && node.left == null && node.right == null) {
            ret.add(new LinkedList<Integer>(path));
            path.pollLast();
            return;
        }
        dfs(node.right, newTarget);
        dfs(node.left, newTarget);
        path.pollLast();

    }
}
