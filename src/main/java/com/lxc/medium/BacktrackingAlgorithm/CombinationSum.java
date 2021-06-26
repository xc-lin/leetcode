package com.lxc.medium.BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(result, combine, candidates, target, 0);
        return result;

    }

    public void dfs(List<List<Integer>> result, List<Integer> combine, int[] candidates, int target, int i) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combine));
            return;
        }
        if (i > candidates.length - 1) {
            return;
        }
        if (target - candidates[i] >= 0) {
            int tempTarget = target - candidates[i];
            combine.add(candidates[i]);
            dfs(result, combine, candidates, tempTarget, i);
            combine.remove(combine.size()-1);
        }
        //搜索下一个数组位置
        dfs(result, combine, candidates, target, i + 1);

    }
}
