package com.lxc.JZOffer;

import java.util.HashMap;
import java.util.PriorityQueue;

public class J49_NthUglyNumber {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashMap<Long, Long> map = new HashMap();
        int[] factors = {2, 3, 5};
        queue.offer(1L);
        map.put(1L, 1L);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = queue.poll();
            for (int factor : factors) {
                long temp = factor * result;
                if (!map.containsKey(temp)) {
                    map.put(temp, temp);
                    queue.offer(temp);
                }
            }
        }
        return (int) result;

    }

    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;
        int[] opt = new int[n];
        opt[0] = 1;
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
}
