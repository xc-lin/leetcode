package com.lxc.JZOffer2;

import java.util.Arrays;

public class J61_IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min=0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]!=0&&min==0){
                min=nums[i];

            }
            if(nums[i]!=0&&nums[i]==nums[i+1]){
                return false;
            }
        }
        if (nums[nums.length-1]-min>=5){
            return false;
        }
        return true;
    }
}
