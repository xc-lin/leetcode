package com.lxc.JZOffer;

import java.util.HashMap;

public class J57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                return new int[]{num, target - num};
            } else {
                map.put(num, num);
            }
        }
        return null;
    }

    // 对于排序数组双指针有的时候很有效
    public int[] twoSumBest(int[] nums, int target) {
        // 使用双指针的思想一个在数组头，一个在数组尾
        int left = 0, right = nums.length - 1;
        // 当left==right的时候就已经说明只有一个数了，与题目不符
        while (left < right) {
            // 如果最左边加最右边大于我们的值
            // 最小值加最大值大于target
            // 说明最大值太大了 因为已经不能让左边的值更小了
            // 因此需要让右边的网左移，使得当前最大值减小
            if (nums[left] + nums[right] > target) {
                right--;
                continue;
            }
            // 如果最左边的值加上最右边的值小于我们的值
            // 最小值加上最大值小于target
            // 说明最小值太小了，需要增大，最大值已经无法再增加了
            // 因此需要让左边的右移，让最小值增大
            // 在后面的轮次中因为在前面已经论证最右边的右边已经不符合了 所以我们可以理解为我们需要搜索的范围减小了，left的左边和right的右边
            // 已经不符合我们要找的条件了，将它放在移除范围
            if (nums[left] + nums[right] < target) {
                left++;
                continue;
            }
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;

    }

}
