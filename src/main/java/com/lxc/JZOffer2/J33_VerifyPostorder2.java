package com.lxc.JZOffer2;

/**
 * 首先题目说是二叉搜索树
 * 因此根节点的左边小于根节点
 * 根节点的右边大于根节点
 * 对于树来说最重要的就是找到根节点
 * 这道题来说根节点在最右边
 */
public class J33_VerifyPostorder2 {
    int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return recur(0, postorder.length - 1);
    }

    public boolean recur(int left, int right) {
        if (left >= right) {
            return true;
        }
        int leftSubtree = right - 1;
        boolean flag = false;
        for (int i = right - 1; i >= 0; i--) {
            if (!flag && postorder[i] < postorder[right]) {
                flag = true;
                leftSubtree = i;
            }
            if (flag && postorder[i] > postorder[right]) {
                return false;
            }
        }
        return recur(left, leftSubtree) && recur(leftSubtree, right - 1);
    }
}
