package com.lxc.JZOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class J45_MinNumber {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
    }

    public static String minNumber(int[] nums) {
        // 最巧妙的是通过o1+o2>o2+o1=>o1>o2
        // 然后通过最小堆对他排序
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }
        String result = "";
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;

    }
}
