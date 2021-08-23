package com.lxc.JZOffer2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class J49_NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n < 6) {
            return n;
        }
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        priorityQueue.add(1L);
        priorityQueue.add(2L);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = priorityQueue.poll();
            if (set.add(2L * result)) {
                priorityQueue.add(2L * result);
            }
            if (set.add(3L * result)) {
                priorityQueue.add(3L * result);
            }
            if (set.add(5L * i)) {
                priorityQueue.add(5L * result);
            }
        }
        return (int) result;
    }

    public int nthUglyNumberBest(int n) {
        int a = 0, b = 0, c = 0;
        int opt[] = new int[n];
        opt[0] = 1;
        int k = 1;
        for (int i = 1; i < n; i++) {
            opt[i] = Math.min(Math.min(opt[a] * 2, opt[b] * 3), opt[c] * 5);
            if (opt[i] == opt[a] * 2) {
                a++;
            }
            if (opt[i] == opt[b] * 3) {
                b++;
            }
            if (opt[i] == opt[c] * 5) {
                c++;
            }
        }
        return opt[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new J49_NthUglyNumber().nthUglyNumber(3));
    }
}
