package com.lxc.hostest;

import com.lxc.JZOffer.J34_PathSum;

public class L34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean found = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                found = true;
                right = mid - 1;
            }
        }
        if (!found) {
            return new int[]{-1, -1};
        }
        int tempLeft = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return new int[]{tempLeft, right};
    }

    public static void main(String[] args) {
        System.out.println(new L34_searchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
