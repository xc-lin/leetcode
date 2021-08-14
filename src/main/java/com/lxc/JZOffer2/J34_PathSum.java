package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J34_PathSum {
    List<Integer> num = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return result;
    }

    public void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        num.add(root.val);


        if (sum == target&&root.right==null&&root.left==null) {
            result.add(new ArrayList<>(num));
        }

        recur(root.left, target);
        recur(root.right, target);
        sum-=root.val;
        num.remove(num.size()-1);
    }
}