package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J55_IsBalanced {


    public boolean isBalanced(TreeNode root) {
        if (recur(root) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int recur(TreeNode root) {
        // 如果此时root为null
        // 说明此节点的深度为0
        if (root == null) {
            return 0;
        }
        // 先对左子树遍历
        int left = recur(root.left);
        // 如果返回是-1 说明左子树的左子树和右子树的深度差大于1
        // 可以直接返回结果
        // 如果不是1 就是他的深度
        if (left == -1) {
            return -1;
        }

        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        // 得到左子树和右子树的深度差值
        // 如果差值小于2
        // 说明目前满足平衡二叉树的要求
        if (Math.abs(left - right) < 2) {
            // 向上返回一层 此时需要返回的是左右子树最大的深度+自己的深度
            return Math.max(left, right) + 1;
        } else {
            // 反之如果两子树大小相差超过1
            // 返回-1表示已经不满足平衡二叉树要求逐级返回
            return -1;
        }
    }

    public boolean isBalanced2(TreeNode root) {

        if (root==null){
            return true;
        }
        int left = recur2(root.left);
        int right = recur2(root.right);
        // 如果左右子树深度相差大于1，那么就说明已经不足以满足平衡二叉树
        // 向上返回false，因为使用的是&& 如果有一个是false那么其他都不用检查了直接返回false 返回至顶层
        if (Math.abs(left-right)>1){
            return false;
        }else {
            return isBalanced2(root.left)&&isBalanced2(root.right);
        }

    }
    // 这个函数用来判断子树的深度
    public int recur2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur2(root.left);
        int right = recur2(root.right);
        // 如果左右子树返回为0；
        // 那么往上返回0+1；
        return Math.max(left, right) + 1;

    }
}
