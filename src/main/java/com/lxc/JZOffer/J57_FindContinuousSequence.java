package com.lxc.JZOffer;

import java.util.ArrayList;
import java.util.List;

public class J57_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        // 双指针 滑动窗口
        // 让窗口不断变大
        int left = 1;
        // 右边界是开
        int right = 1;
        int sum = 0;
        // 跳出循环条件是如果左边界大于了target的一半 就不可能有两个数加起来大于target了
        // 因为如果left等于target/2 第二个数一定大于target/2 这样加起来一定大于target了 因此如果left>target/2 则已经遍历结束
        while (left <= target/2) {
            // 如果sum小于target说明 sum太小，左边界已经是最小了
            // 只能让右边界往右移， 这样才能增大
            if (sum < target) {
                sum += right;
                right++;
                continue;
            }
            // 如果太大了， 需要让左边界往右移，因为右边界因为sum太小才右移，如果让右边界往左移，必定会太小
            // 因此， 让左边界往右移让sum减小
            if (sum > target) {
                sum -= left;
                left++;
                continue;
            }
            // 如果相等我们需要将这之间的值生成数组加入到lists里面
            if (sum == target) {
                int temp[] = new int[right - left];
                int count = 0;
                for (int i = left; i < right; i++) {
                    temp[count++] = i;
                }
                // 此时还需要继续寻找，让左边界向右或者让有边界向右都是可以的 目的是破坏掉等于的条件
                lists.add(temp);
                sum += right;
                right++;
            }

        }
        return lists.toArray(new int[lists.size()][]);
    }
}
