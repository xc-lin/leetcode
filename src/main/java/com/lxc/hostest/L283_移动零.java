package com.lxc.hostest;

public class L283_移动零 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int length = nums.length;
        int right=0;
        while (right<length){
            while (left<length&&nums[left]!=0){
                left++;
            }
            if (left>=length){
                break;
            }
            right=left+1;
            while (right<length&&nums[right]==0){
                right++;
            }
            if (right>=length){
                break;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right++;
        }

    }

    public void moveZeroesBest(int[] nums) {
        int left = 0;
        int length = nums.length;
        int right=0;
        while (right<length) {
            if (nums[right]!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }
            right++;
        }

    }

    public static void main(String[] args) {
        new L283_移动零().moveZeroes(new int[]{1,0,0,1});
    }
}
