package com.lxc.hostest;

import java.util.ArrayList;
import java.util.List;

public class L78_子集 {
    int length;
    int nums[];
    boolean visited[];
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        length = nums.length;
        this.nums = nums;
        visited = new boolean[length];
        result.add(new ArrayList<>());
        dfs(0,-1);
        return result;
    }

    public void dfs(int depth,int index) {
        if (depth==length){
            return;
        }
        // 排除这个这个数字之前的数字
        for (int i = index+1; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                result.add(new ArrayList<>(list));
                visited[i]=true;
                dfs(depth+1,i);
                visited[i]=false;
                list.remove(list.size()-1);

            }
        }
    }
}
