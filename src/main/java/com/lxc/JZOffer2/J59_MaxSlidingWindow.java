package com.lxc.JZOffer2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class J59_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return new int[0];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int right = 0;
        int left = -k + 1;
        int result[] = new int[nums.length - k + 1];
        int count = 0;
        while (right < nums.length) {

            while (!queue.isEmpty()) {
                if (queue.getLast() < nums[right]) {
                    queue.removeLast();
                }else {
                    break;
                }
            }
            queue.addLast(nums[right]);

            if (left > -1) {
                result[count++] = queue.getFirst();
                if (queue.getFirst() == nums[left]) {
                    queue.removeFirst();
                }
            }
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new J59_MaxSlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
}
