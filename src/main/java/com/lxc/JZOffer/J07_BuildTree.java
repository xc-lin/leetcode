package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

import java.util.HashMap;

public class J07_BuildTree {
    int[] preorder;
    HashMap<Integer,Integer> mapIn= new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        if( preorder.length==0){
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            mapIn.put(inorder[i],i);
        }

        return recur(0,0, inorder.length-1);
    }

    /**
     *
     * @param root 在先序遍历的index
     * @param left 在中序遍历的index
     * @param right 在中序遍历的index
     * @return
     */
    public TreeNode recur(int root, int left, int right){
        if (left>right){
            return null;
        }
        TreeNode node= new TreeNode(preorder[root]);
        int i = mapIn.get(preorder[root]);
        // left 不变， right是在中序遍历中的root左边一个
        node.left= recur(root+1,left,i-1);
        // root: 原来root+ 左子树长度
        node.right=recur(root+(i-left)+1,i+1,right);
        return node;
    }
}
