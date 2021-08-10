package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J68_1LowestCommonAncestor {
    TreeNode p;
    TreeNode q;
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return result;
    }

    public boolean dfs(TreeNode root) {
        if (root == null || result != null) {
            return false;
        }
        boolean curr = false;
        if (root.val == p.val || root.val == q.val) {
            curr = true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if ((left && right) || (curr && right) || (curr && left)) {
            result = root;
        }
        return left || right || curr;
    }

    public TreeNode lowestCommonAncestorBest(TreeNode root, TreeNode p, TreeNode q) {
        //这个方法发挥了二叉搜索树的作用
        while (true) {
            if (root == null) {
                return null;
            }
            // 如果这个我的两个目标值都比我的root大或者是小 就说明两个值一定在我的root的左边或者右边不是这个点
            // 但是如果这个点恰好和一个p或者q相等此时也不会继续往下延伸， 因为这个值已经和我的root相同了
            // 如果在找到最大公共祖先之前 有一个节点和我的跟节点相同那么可以直接返回这个root
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
                continue;
            }
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
                continue;
            }
            return root;
        }
    }
    public TreeNode lowestCommonAncestorBest2(TreeNode root, TreeNode p, TreeNode q) {
        //这个方法发挥了二叉搜索树的作用
        // 递归
        // 和上面的想法是相同的
        // 如果这个我的两个目标值都比我的root大或者是小 就说明两个值一定在我的root的左边或者右边不是这个点
        // 递归到右边或者左边子树
        // 当进入了一个if 就可以直接return了因为已经不可能是其他子树
        // 当p和q分布在root的左右两边 那么就返回
        // 或p和q其中一个等于root
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;

    }


}
