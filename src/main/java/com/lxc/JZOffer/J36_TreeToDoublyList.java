package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

public class J36_TreeToDoublyList {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        // 特殊处理
        if (root == null) {
            return null;
        }
        pre = null;
        dfs(root);
        // 将第一个和最后一个相连
        // pre是最后一个，head是第一个
        // 因此pre的right是第一个，第一个的left是最后一个
        pre.right = head;
        head.left = pre;
        return head;


    }
    // 利用中序遍历 可以得到二叉搜索树的按升序排列输出
    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 进入第一层遍历，直到他的左子树为空弹出
        dfs(node.left);
        // 当pre为null的时候，说明此时是最小的节点也就是遍历碰到空的那个节点，也就是最小的节点，我们将他设位置head

        if (pre == null) {
            head = node;
        } else {
            //pre是之前的节点也就是上一个最小节点
            // 这个节点是左子树为空也就是一个小的值
            pre.right = node;
            node.left = pre;
        }
        // 这个节点我们将它设置为pre 接下来要么右子树有节点，右子树节点就比当前节点大，我们因此将当前节点设置为pre
        // 这个节点我们接下来将它连接上下一个节点
        pre = node;
        // 当前节点的右节点如果有子树，那么在接下来的遍历中将对到达右子树的左子树，此时pre还是当前节点，
        dfs(node.right);
    }
}
