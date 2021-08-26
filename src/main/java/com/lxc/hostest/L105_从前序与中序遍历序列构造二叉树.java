package com.lxc.hostest;

import com.lxc.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L105_从前序与中序遍历序列构造二叉树 {
    int[] preorder;
    int[] inorder;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        TreeNode root=new TreeNode();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return recur(0,preorder.length-1,0);
    }
    public TreeNode recur(int left,int right,int preIndex){
        if (left>right){
            return null;
        }
        TreeNode node=new TreeNode(preorder[preIndex]);
        int inIndex=map.get(preorder[preIndex]);
        node.left=recur(left,inIndex-1,preIndex+1);
        node.right=recur(inIndex+1,right,preIndex+inIndex-left+1);
        return node;
    }

}
