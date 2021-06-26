package com.lxc.easy.tree;

import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        recurse(result,root);
        return result;
    }

    public void recurse(List<Integer> result,TreeNode node) {
        if (node==null){
            return;
        }
        recurse(result,node.left);
        recurse(result,node.right);
        result.add(node.val);
    }
}
