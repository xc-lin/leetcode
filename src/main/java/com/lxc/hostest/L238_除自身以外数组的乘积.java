package com.lxc.hostest;

public class L238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i-1];
        }
        int[] right = new int[length];
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i+1];
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i-1];
        }
        int right=1;
        for (int i = length-1; i >=0; i--) {
            result[i] = result[i]*right;
            right*=nums[i];
        }
        return result;
    }
}
