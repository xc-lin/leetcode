package com.lxc.hostest;

public class L33_Search {
    public int search(int[] nums, int target) {

        int rightMost = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid]>nums[right]) {
                left = mid + 1;
            }else if (nums[mid]<nums[right]) {
                right=mid;

            }
        }
        int point=left;
        if (target>rightMost){
            left=0;
            right=point-1;
        }else {
            left=point;
            right=nums.length-1;
        }
        while (left<=right){
            int mid = (right + left) / 2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid]>target){
                right=mid-1;
            }
            if (nums[mid]<target) {
                left=mid+1;

            }
        }
        return -1;

    }
}
