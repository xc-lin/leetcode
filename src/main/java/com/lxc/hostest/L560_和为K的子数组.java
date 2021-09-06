package com.lxc.hostest;

import java.util.HashMap;
import java.util.Map;

public class L560_和为K的子数组 {
    public int subarraySumBest(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
//        int opt[][] = new int[len][len];
//        for (int i = 0; i < len; i++) {
//            opt[i][i]=nums[i];
//            if (nums[i]==k){
//                count++;
//            }
//        }
        for (int i = 0; i < len; i++) {
            int pre = nums[i];
            if (pre == k) {
                count++;
            }
            for (int j = i + 1; j < len; j++) {
                pre = pre + nums[j];
                if (pre == k) {
                    count++;
                }
            }

        }
        return count;
    }
}
