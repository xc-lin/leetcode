package com.lxc.freeWheel;

import com.lxc.util.TreeNode;
import org.apache.commons.lang.enums.Enum;

import java.sql.Struct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class test2 {

    public int GetMinTimeCost (TreeNode root, int failId, int[] timeCost) {
        if (root==null){
            return 0;
        }
        int result=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean flag=false;

        while (!queue.isEmpty()){
            boolean flag2=false;
            int min=0;
            for (int i = queue.size()-1; i >=0 ; i--) {
                if (flag2){
                    queue.poll();
                    continue;
                }
                TreeNode temp=queue.poll();
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                if (temp.val==failId){
                    flag2=true;
                    flag= true;
                }
                if (flag&&(temp.right!=null||temp.left!=null)){
                    if (min==0){
                        min=timeCost[temp.val];
                    }else {
                        min = Math.min(timeCost[temp.val], min);
                    }
                }

            }

            result+=min;
        }
        return result;
    }
    public void recur(TreeNode root, int failedId){
        if (root==null){
            return;
        }
        if (root.val==failedId){

        }
    }
}
