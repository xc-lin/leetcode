package com.lxc.JZOffer;

public class J53_MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;


        while (left<=right) {
            if (nums[mid] == mid) {
                left = mid + 1;
            }
            if (nums[mid] > mid) {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return left;
    }
}
