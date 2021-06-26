package com.lxc.medium;
import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        boolean reverse = false;
        for (int i = nums.length - 1; i > 0; i--) {

            if (nums[i] > nums[i - 1]) {
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] < nums[min]) {
                        min = j;
                    }
                }
                swap(nums, i - 1, min);
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }

        reverse(nums);
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums) {
        int left= 0;
        int right= nums.length-1;
        while(left<=right){
            swap(nums,left,right);
            right--;
            left++;
        }
    }
}
