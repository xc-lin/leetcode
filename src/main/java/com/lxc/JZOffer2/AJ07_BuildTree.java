package com.lxc.JZOffer2;

import com.lxc.util.TreeNode;
import sun.font.TextRecord;
import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.HashMap;

public class AJ07_BuildTree {
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 首先要将inorder放入map以value为key 这样可以通过preorder 找到的root来找到 inorder的位置 可以分出左子树和右子树
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode head = recur(0, 0, inorder.length - 1);
        return head;
    }

    public TreeNode recur(int rootIndex, int left, int right) {
        if (left > right) {
            return null;
        }
        // 首先有了rootindex 就得到这个当前子树的root节点然后返回即可
        TreeNode node = new TreeNode(preorder[rootIndex]);
        int inorderRootIndex = map.get(preorder[rootIndex]);
        // 得到root的左子树和右子树
        // 根据preorder的特性下一个就是左子树的root节点 然后进入遍历
        // 如果此时left已经和right相等那么说明此时节点只有一个值
        // 此时递归则会返回null
        node.left = recur(rootIndex + 1, left, inorderRootIndex - 1);
        // root+左子树的长度+1 就是新的右子树的root节点  新的left的开始就是inorder的root的右边一个 right不需要改变

        node.right = recur(rootIndex + inorderRootIndex - left + 1, inorderRootIndex + 1, right);
        return node;
    }
}