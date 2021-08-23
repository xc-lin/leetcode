package com.lxc.JZOffer2;

public class J53_2missingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid]==mid){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}
