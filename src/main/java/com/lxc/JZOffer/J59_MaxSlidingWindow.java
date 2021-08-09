package com.lxc.JZOffer;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class J59_MaxSlidingWindow {
    public int[] maxSlidingWindowBest(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[nums.length];
        }
        int right = k ;
        int[] result = new int[nums.length - k + 1];
        // 建立一个双端队列
        Deque<Integer> queue = new LinkedList<>();
        // 当窗口还无法建立的时候，先插入一部分
        for (int i = 0; i < k; i++) {
            // 在插入的过程保持队头一直是最大值 且递减
            while (!queue.isEmpty() && nums[i]> queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);

        }
        int count=0;
        result[count++]=queue.getFirst();

        while (right < nums.length) {

            // 在插入的过程保持队头一直是最大值 且递减
            while (!queue.isEmpty() && nums[right] > queue.getLast()) {
                queue.removeLast();
            }
            // 如果队列的最大值和左边边界的值相同，那么删除这个最大值
            if (!queue.isEmpty()&&queue.getFirst() == nums[right - k]) {
                queue.removeFirst();
            }

            // 然后将这个值加入到队尾，可以保持队伍里有至少一个值
            queue.addLast(nums[right]);
            // 将队伍的最大值加入到result
            result[count++]=queue.getFirst();
            right++;
        }
        return result;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[nums.length];
        }
        int right = k - 1;
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        int count = 0;
        while (right < nums.length) {
            queue.offer(nums[right]);
            result[count++] = queue.peek();
            right++;

            queue.remove(nums[right - k]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new J59_MaxSlidingWindow().maxSlidingWindowBest(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
