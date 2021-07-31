package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // B为空说明子树为空 返回false
        // A为空说明 A已经遍历到叶子节点了
        if (A==null||B==null){
            return false;
        }
        if (recur(A,B)||isSubStructure(A.right,B)||isSubStructure(A.left,B)){
            return true;
        }
        return false;
    }

    /**
     * 用来判断两个子树是否相等
     * @param A
     * @param B
     * @return
     */
    public boolean recur(TreeNode A, TreeNode B){
        // 若子树遍历到空了 就说明之前的都是值相等
        if(B==null){
            return true;
        }
        // 若A到空了说明没匹配上，或有一个值不同就返回false
        if (A==null||A.val!=B.val){
            return false;
        }

        //要左右子树都为true才可以
        return recur(A.left, B.left)&&recur(A.right, B.right);
    }
}
