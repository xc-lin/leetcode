package com.lxc.hostest;

public class L300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int length=nums.length;
        int opt[]=new int[length];
        opt[0]=1;
        int result=1;
        for (int i = 1; i < length; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    max=Math.max(max,opt[j]);
                }
            }
            opt[i]=max+1;
            result=Math.max(opt[i],max);
        }
        return result;
    }
}
