package com.lxc.hostest;

public class L31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int left = -1;
        for (int i = nums.length-1; i > 0; i--) {
            // 从后往前找
            // 找到第一个非升序的数组
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                for (int j = nums.length-1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                break;
            }
        }
        int right = nums.length - 1;
        left++;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return;
    }

    public static void main(String[] args) {
        new L31_NextPermutation().nextPermutation(new int[]{3,2,1});
    }
}
