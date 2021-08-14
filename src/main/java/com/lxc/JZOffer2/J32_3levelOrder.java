package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

import java.util.*;

public class J32_3levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {

                if (result.size() % 2 == 0) {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }

                }


            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }

            }

            result.add(list);
            list = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.pollLast();
                list.add(node.val);
                if (node.right != null) {
                    queue.addFirst(node.right);
                }
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
            }

            if(list.size()!=0){
                result.add(list);
            }
        }
        return result;
    }
}
