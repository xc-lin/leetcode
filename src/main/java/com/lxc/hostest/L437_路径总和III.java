package com.lxc.hostest;

import com.lxc.util.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class L437_路径总和III {
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,0,targetSum,true);
        return count;
    }
    public void dfs(TreeNode root,int sum,int targetSum,boolean flag){
        if (root==null){
            return;
        }
        sum+=root.val;
        if (sum==targetSum){

            count++;
            return;
        }

        dfs(root.left,sum,targetSum,flag);
        dfs(root.right,sum,targetSum,flag);
        if (flag) {
            dfs(root.left, 0, targetSum,false);
            dfs(root.right, 0, targetSum,false);
        }

    }
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int targetSum = Integer.parseInt(line);

            int ret = new L437_路径总和III().pathSum(root, targetSum);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
