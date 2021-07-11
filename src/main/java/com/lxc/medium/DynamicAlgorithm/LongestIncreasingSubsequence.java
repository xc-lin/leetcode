package com.lxc.medium.DynamicAlgorithm;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int opt[] = new int[nums.length];
        opt[0] = 1;
        int prev[] = new int[nums.length];
        prev[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            prev[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (opt[j] > max) {
                        max = opt[j];
                        prev[i] = j;
                    }
                }
            }
            opt[i] = max + 1;
        }
        int result = 0;
        int pos = 0;
        for (int i = 0; i < opt.length; i++) {
            if (opt[i] > result) {
                pos = i;
                result = opt[i];
            }
        }
        while (true) {
            System.out.println(nums[pos]);
            if(pos==prev[pos]){
                break;
            }
            pos=prev[pos];

        }
        return result;
    }
}
