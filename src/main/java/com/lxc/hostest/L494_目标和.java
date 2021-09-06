package com.lxc.hostest;

public class L494_目标和 {
    public int findTargetSumWaysBest(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i]);
        }
        if (Math.abs(target)>sum){
            return 0;
        }
        int t = sum * 2 + 1;
        int opt[][]=new int[nums.length][sum*2+1];
        int len=nums.length;
        if (nums[0]==0){
            opt[0][sum]=2;
        }else {
            opt[0][sum+nums[0]]=1;
            opt[0][sum-nums[0]]=1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                int a1,a2;
                if (j-nums[i]<0){
                    a1=0;
                }else {
                    a1=opt[i-1][j-nums[i]];
                }
                if (j+nums[i]>=t){
                    a2=0;
                }else {
                    a2=opt[i-1][j+nums[i]];
                }
                opt[i][j]=a1+a2;
            }
        }
        return opt[len - 1][sum + target];
    }
    int length;
    int sum = 0;
    int target = 0;
    int result = 0;
    int[] nums;

    public int findTargetSumWays(int[] nums, int target) {
        length = nums.length;
        this.target = target;
        this.nums = nums;
        dfs(0,0);
        return result;
    }

    public void dfs(int depth, int sum) {
        if (depth == length) {
            if (sum == target) {
                result++;
            }
            return;
        }

        dfs(depth + 1, sum+nums[depth] );
        dfs(depth + 1,sum-nums[depth] );
    }
}
