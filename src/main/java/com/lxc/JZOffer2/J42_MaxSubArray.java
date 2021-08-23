package com.lxc.JZOffer2;

import org.apache.commons.lang.enums.Enum;

public class J42_MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
