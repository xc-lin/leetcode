package com.lxc.hostest;

import java.util.HashSet;

public class L28_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        int result=0;
        for (int num:set) {
            int count=1;
            if (!set.contains(num-1)){
                while (set.contains(++num)){
                    count++;
                }
                result=Math.max(result,count);
            }
        }
        return result;
    }
}
