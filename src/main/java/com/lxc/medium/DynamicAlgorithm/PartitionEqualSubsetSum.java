package com.lxc.medium.DynamicAlgorithm;

public class PartitionEqualSubsetSum {
    /*
    * 因为要分成两个子集有相同的值，我们可以将容量看为一半的sum
    * weight就是num[i]的值
    * 与01背包不同的是，在01背包问题中要的是小于或等于背包容量最多的item数量
    * 但在这题中我们要的是一定相等才可以
    * 01 表中存的是最大的item个数，在这题中我们只需存是否可以相等
    *
    * */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2!=0){
            return false;
        }
        sum = sum / 2;

        boolean opt[][] = new boolean[nums.length][sum+1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>sum){
                return false;
            }
            opt[i][nums[i]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == nums[i]) {
                    continue;
                }
                boolean second;
                if (j - nums[i] < 0) {
                    second = false;
                } else {
                    second = opt[i - 1][j - nums[i]];
                }
                opt[i][j] = opt[i - 1][j] || second;
            }

        }
        return opt[nums.length-1][sum];
    }
}
