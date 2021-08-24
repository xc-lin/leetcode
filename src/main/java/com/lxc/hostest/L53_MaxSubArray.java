package com.lxc.hostest;

public class L53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre=0;
        pre = nums[0];
        int result=pre;

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre, 0) + nums[i];
            result=Math.max(result,pre);
        }
        return result;
    }
}
