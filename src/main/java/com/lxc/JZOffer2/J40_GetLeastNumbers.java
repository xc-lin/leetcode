package com.lxc.JZOffer2;

import java.util.PriorityQueue;

public class J40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int result[]=new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num:arr){
            queue.add(num);
        }
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()){
                break;
            }
            result[i]=queue.poll();
        }
        return result;
    }
}
