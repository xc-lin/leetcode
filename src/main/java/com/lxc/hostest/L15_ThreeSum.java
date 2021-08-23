package com.lxc.hostest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int length=nums.length;
        if (length<3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (nums[i]>0){
                break;
            }
            if (i>0&& nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=length-1;
            int curr=nums[i];
            while (left<right){
                int temp=curr+nums[left]+nums[right];
                if (temp==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(curr);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left<right&&nums[left+1]==nums[left]) left++;
                    while (left<right&&nums[right-1]==nums[right]) right--;

                    left++;
                }else if (temp>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
