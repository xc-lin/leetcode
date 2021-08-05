package com.lxc.JZOffer;

public class J53_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        int count = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (result == -1) {
            return 0;
        }
        int a = result;
        while (++a >= 0 && a < nums.length && nums[a] == target) {

            count++;
        }
        a = result;
        while (--a >= 0 && a < nums.length && nums[a] == target) {

            count++;
        }
        return count;
    }
    // 两次二分查找
    public int search2(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int result=0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        result=right;
        if (right>=0&&nums[right] != target) {
            return 0;
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        System.out.println(left);
        System.out.println(result);

        return result-left+1;
    }
}

