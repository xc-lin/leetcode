package com.lxc.JZOffer2;

public class J53_Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        int tempLeft= left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return right-tempLeft+1;

    }
}
