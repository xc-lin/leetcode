package com.lxc.JZOffer2;

public class J57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null){
            return new int[]{};
        }
        int left=0;
        int right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]<target){
                left++;
            }else if (nums[left]+nums[right]>target){
                right--;
            }else if (nums[left]+nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[]{};
    }
}
