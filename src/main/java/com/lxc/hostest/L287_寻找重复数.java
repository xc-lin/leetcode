package com.lxc.hostest;

public class L287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int ptr = 0;
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }
        return slow;

    }

    public static void main(String[] args) {
        System.out.println(new L287_寻找重复数().findDuplicate2(new int[]{1, 3, 4, 5, 2, 2}));
    }
}