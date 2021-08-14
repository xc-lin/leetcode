package com.lxc.JZOffer2;

/**
 * 首先题目说是二叉搜索树
 * 因此根节点的左边小于根节点
 * 根节点的右边大于根节点
 * 对于树来说最重要的就是找到根节点
 * 这道题来说根节点在最右边
 */
public class J33_VerifyPostorder {
    int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        int left = 0;
        int right = postorder.length - 1;
        this.postorder = postorder;
        return recur(left, right);
    }

    /**
     * 递归对每一个子树都递归
     * 主要是判断 从右向左遍历（根节点开始） 是否有左子树中的值是否有大于根节点的情况
     * 左子树的判断就是找到第一个小于根节点的值的位置
     * 因此在这个值的左边所有的值都应该小于根节点
     * 因此在这个左边都是左子树
     *
     * @param left  此子树的左边界
     * @param right 此子树的右边界
     * @return
     */
    public boolean recur(int left, int right) {
        // 当左节点等于右节点的时候就说明 只有一个值 没有可比性 自己就是自己的根节点
        if (left >= right) {
            return true;
        }
        // temp就是第一个小于根节点的值的位置
        // 初始化全部都是左子树
        int temp = right - 1;
        // flag代表是否找到第一个小于根节点的值m
        boolean flag = false;
        // 遍历数组 从左往右 找到第一个小于根节点值的位置
        for (int i = right - 1; i >= left; i--) {
            // 如果没有找到 就寻找第一个小于根节点值的位置
            // 如果找到了就 不进入这个判断语句了
            if (!flag && postorder[i] < postorder[right]) {
                temp = i;
                flag = true;
            }
            // 如果找到了第一个比根节点值小的位置 那么说明在这个位置的左边都是左子树
            // 因此如果有一个树大于了根节点 那么直接return false
            if (flag && postorder[i] > postorder[right]) {
                return false;
            }
        }
        // temp代表左子树的起点
        // 因此将左子树和右子树分别带进递归中判断
        // 右子树的范围是 左子树的起点+1～根节点-1
        // 左子树的起点是 左边界到左起树的起点
        return recur(temp + 1, right - 1) && recur(left, temp);

    }

}
