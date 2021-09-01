package com.lxc.hostest;

import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L297_二叉树的序列化与反序列化 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer result = new StringBuffer();
        recur(root, result);
        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
        return result.toString();
    }

    public void recur(TreeNode root, StringBuffer result) {
        if (root == null) {
            result.append("null,");
            return;
        }
        result.append(String.valueOf(root.val) + ",");
        recur(root.left, result);
        recur(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String strings[] = data.split(",");
        return recur2(strings,0);

    }

    public TreeNode recur2(String strings[], int index) {
        System.out.println(strings[index]);
        if (index>=strings.length||strings[index].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strings[index]));
        node.left = recur2(strings, ++index);
        node.right = recur2(strings, ++index);
        return node;
    }
}
