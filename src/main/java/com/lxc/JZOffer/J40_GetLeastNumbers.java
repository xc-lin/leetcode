package com.lxc.JZOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class J40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int []result= new int[k];
        if (k == 0) {
            return result;
        }
        // 升序是o1-o2，降序是o2-o1
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        // 优先队列的添加是offer 虽然也可以用add
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        //
        for (int i = k; i < arr.length; i++) {
            if (arr[i]<queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i]= queue.poll();

        }
        return result;
    }
}
