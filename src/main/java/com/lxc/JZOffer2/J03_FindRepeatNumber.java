package com.lxc.JZOffer2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class J03_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int num:nums){
            if (map.containsKey(num)){
                return num;
            }
            map.put(num,num);
        }
        return 0;
    }
    public int findRepeatNumberBetter(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for (int num:nums){
            if (!set.add(num)){
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumberBest(int[] nums) {
        int i=0;
        while (i<nums.length){
            if (nums[i]==i){
                i++;
                continue;
            }
            // 此时nums[i]一定不等于i所以nums[i]还没有在正确的位置上
            // 若此时nums[nums[i]] 这个代表正确位置上的值
            // 这个值如果等于nums[i] 那么就说明这个值重复了
            if (nums[nums[i]]==nums[i]){
                return nums[i];
            }
            int temp=nums[nums[i]];
            nums[nums[i]]=nums[i];
            nums[i]=temp;
        }
        return -1;
    }
}
