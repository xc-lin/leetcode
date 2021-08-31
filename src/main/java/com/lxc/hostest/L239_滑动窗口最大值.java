package com.lxc.hostest;

import java.util.Deque;
import java.util.LinkedList;

public class L239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[length];
        int right = -1;
        int left = -k;
        while (right < length - 1) {
            if (left >= 0 && nums[left] == deque.getFirst()) {
                deque.removeFirst();
            }
            left++;
            right++;
            while (!deque.isEmpty() && deque.getLast() < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(nums[right]);
            if (left >= 0) {
                result[left] = deque.getFirst();
            }
        }
        return result;
    }
}
