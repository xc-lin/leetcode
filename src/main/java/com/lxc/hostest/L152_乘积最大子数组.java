package com.lxc.hostest;

public class L152_乘积最大子数组 {
    static public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int opt[][] = new int[length][2];
        opt[0][0] = nums[0];
        opt[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            opt[i][0] = Math.max(opt[i - 1][0] * nums[i], Math.max(opt[i - 1][1] * nums[i], nums[i]));
            opt[i][1] = Math.min(opt[i - 1][0] * nums[i], Math.min(opt[i - 1][1] * nums[i], nums[i]));
        }
        int result = opt[0][0];
        for (int i = 1; i < length; i++) {
            if (result < opt[i][0]) {
                result = opt[i][0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-3,-2,4}));
    }
}
