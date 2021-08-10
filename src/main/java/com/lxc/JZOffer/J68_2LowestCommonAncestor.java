package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J68_2LowestCommonAncestor {
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
        // 如果这个节点是p和q其中一个那么curr置为true
        // 1、有可能这个节点就是根节点
        // 2、这个节点是一个子节点
        if (root.val == p.val || root.val == q.val) {
            curr = true;
        }
        // 继续遍历左子树和右子树 等待返回左右子树是否有对应的节点
        boolean left = dfs(root.left);
        if (result != null) {
            return true;
        }
        boolean right = dfs(root.right);
        // 如果左子树和右子树都为true说明p q分别在左右子树中 返回true
        // 或者这个节点就是等于p或q 看他的左右子树是否有一个返回为true
        if ((left && right) || (curr && (right || left))) {
            result = root;
        }
        return left || right || curr;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 当root为空的时候返回null
        if (root==null){
            return null;
        }
        // 当root和p或q相等时 直接返回 因为如果他的左子树或者右子树中有另一个pq时也无所谓了
        // 因为root一定是最大祖先节点了
        // 但是如果他的左右没有另一个 那另一个一定在他的父节点的另一侧
        if (root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);

        // 如果左侧节点是空的那么那么说明p和q都不在这个节点的左子树中那么可以直接返回右子树
        // 因为 要么就在左子树中要么在右子树中
        if (leftNode==null){
            return rightNode;
        }
        if (rightNode==null){
            return leftNode;
        }
        // 如果左子树和右子树返回来的值都不为空那么
        // 说明最大祖先节点就是这个节点
        // 如果左子树或右子树持续为空 那么就说明最大祖先节点已经找到就是 在不为空的那个子树中
        // 因此看到最上面 就算在更深的地方我们假设 那个节点是祖先节点 在返回的过程中我们也会发现
        // 另一子树可能不为空此时就说明还有一个目标节点在另一侧，此时最大祖先就变成父节点
        return root;
    }


}
