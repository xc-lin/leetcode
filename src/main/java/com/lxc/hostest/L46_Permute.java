package com.lxc.hostest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L46_Permute {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    boolean visit[];
    int length=0;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        length=nums.length;
        this.nums=nums;
        visit=new boolean[length];
        dfs(0);
        return result;
    }
    public void dfs(int depth){
        if (depth==length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                visit[i]=true;
                list.add(nums[i]);
                dfs(depth + 1);
                list.remove(list.size() - 1);
                visit[i]=false;
            }
        }
    }
}
