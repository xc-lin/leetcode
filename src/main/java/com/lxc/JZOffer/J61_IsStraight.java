package com.lxc.JZOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class J61_IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int gap = 0;
        int count0 = 0;
        if (nums[0] == 0) {
            count0++;
        }
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == 0) {
                count0++;
                continue;
            }
            if (nums[i - 1] == 0) {
                continue;
            }
            int temp = nums[i] - nums[i - 1] - 1;
            if (temp == -1) {
                return false;
            }
            gap += temp;
        }
        if (count0 >= gap) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStraightBest(int[] nums) {
        Arrays.sort(nums);
        int count0 = 0, min = -1, max = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count0++;
                continue;
            } else if (nums[i] == nums[i + 1]) {
                //如果重复就不可能是顺子=
                return false;
            }

        }
        // 这个条件是最妙的
        // 因为不管是否有王
        // 如果最大减最小<5 一定是顺子（无重复的牌）
        // 因为这这个min和max之间的牌如果构不成顺子
        // 那么说明min和max之间一定缺牌了
        // 而max-min<5 且一共有五张牌
        // 不在min和max之间的一定是0
        return nums[nums.length - 1] - nums[count0] < 5;

    }

    public boolean isStraightHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 14, max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);


        }
        // 这个条件是最妙的
        // 因为不管是否有王
        // 如果最大减最小<5 一定是顺子（无重复的牌）
        // 因为这这个min和max之间的牌如果构不成顺子
        // 那么说明min和max之间一定缺牌了
        // 而max-min<5 且一共有五张牌
        // 不在min和max之间的一定是0
        return max - min < 5;

    }

    public static void main(String[] args) {
        new J61_IsStraight().isStraightHashSet(new int[]{10,11,0,12,6});
    }
}
