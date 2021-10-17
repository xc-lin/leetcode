package com.lxc.Job.乐信;

import java.util.Arrays;

public class test2 {
    public static int[] searchRange (int[] nums, int target) {
        if (nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int length=nums.length;
        int left=0;
        int right=length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        int resultRight=right;
        if (nums[right]!=target){
            return new int[]{-1,-1};
        }
//        System.out.println(left+" "+right);
        left=0;
        right=length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]>=target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
//        System.out.println(left+" "+right);
        return new int[]{left,resultRight};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{}, 9)));
    }
}
