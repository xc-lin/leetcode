package com.lxc.hostest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L581_最短无序连续子数组 {
    public int findUnsortedSubarrayBest(int[] nums) {
        int start = -1;
        int end = -1;
        int max = nums[0];
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[nums.length-i-1]<min){
                min=nums[nums.length-i-1];
            }else {
                start=nums.length-i-1;
            }
            // 记录最后一个破坏升序的记录
            // 如果后面都是升序的那么nums[i]>=max 所以end一定是要排序的最后一个
            if (nums[i] < max) {
                end = i;
            }
            max = Math.max(max, nums[i]);

        }
        return start==-1?0:end-start+1;

    }

    public int findUnsortedSubarray(int[] nums) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        int start = 0;
        int end = nums.length - 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums2[i] != nums[i]) {
                start = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return 0;
        }
        for (int i = nums.length - 1; i >= start; i--) {
            if (nums2[i] != nums[i]) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(new L581_最短无序连续子数组().findUnsortedSubarrayBest(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
