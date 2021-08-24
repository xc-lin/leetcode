package com.lxc.hostest;

import java.util.ArrayList;
import java.util.List;

public class L39_CombinationSum {
    int[] candidates;
    int sum = 0, target;

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0,list);
        return result;

    }

    public void dfs(int begin,List<Integer> list) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
        }
        // 难点是这里 因为上一轮的for循环的dfs里面已经考虑了包含i这个变量的各种情况下一层你只需要考虑不包含他的各种情况
        for (int i = begin; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum+=candidates[i];
            dfs(i,list);
            sum-=candidates[i];
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new L39_CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
