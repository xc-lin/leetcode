package com.lxc.hostest;

public class L198_打家劫舍 {
    public int rob(int[] nums) {
        int length = nums.length;
        int opt[] = new int[length];
        opt[0] = nums[0];
        int result = opt[0];
        for (int i = 1; i < length; i++) {
            if (i == 1) {
                opt[i] = Math.max(opt[i - 1], nums[i]);
            } else {
                opt[i] = Math.max(opt[i - 1], opt[i - 2] + nums[i]);
            }
            result=Math.max(opt[i],result);
        }
        return result;

    }
}
