package com.lxc.JZOffer;

import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class J32_LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 运用队列来存放每一层的Treenode
        Queue<TreeNode> queue =new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 如果root为空直接没了，到最后return
        // 不为空先初始化， 把真正的root放到队列里，这样第一层的就已经在队列中了
        if (root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            // 这是每一层的list
            List<Integer> list=new ArrayList<>();
            // 这一步是最巧妙的，因为i只有在for循环刚开始的时候才会初始化，所以即使queue在for循环中增大，或减小都不会影响我已知这一层有几个node的数量
            for (int i = queue.size(); i >0; i--) {
                // 对queue poll出来，队列中的node就被删除了
                TreeNode node=queue.poll();
                // 向这一层添加node的值
                list.add(node.val);
                // 等于是在向下一层的queue添加新的node 因为这一个for循环结束，上一层的node一定都会被poll完
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            // for循环结束说明这一层在queue中的node都已经被取出 因此直接放进result
            result.add(list);
        }
        return result;
    }

}
