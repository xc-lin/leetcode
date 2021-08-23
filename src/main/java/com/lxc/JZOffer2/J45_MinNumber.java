package com.lxc.JZOffer2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class J45_MinNumber {
    public String minNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            // 如果o1 小于 o2 那么 (o1 + o2)小于(o2 + o1);
            // 比如 30 和3 303< 330
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }

        });
        for (int num : nums) {
            priorityQueue.offer(String.valueOf(num));
        }
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 10; i >=0 ; i--) {
            priorityQueue.add(i);
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
