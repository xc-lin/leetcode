package com.lxc.Job.博乐科技;

import java.util.Arrays;
import java.util.HashSet;

public class test4 {
    int count = 0;


    public int queens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> dig1 = new HashSet<>();
        HashSet<Integer> dig2 = new HashSet<>();
        recur(n, 0, col, dig1, dig2);
        return count;

    }

    public void recur(int n, int r, HashSet<Integer> col, HashSet<Integer> dig1, HashSet<Integer> dig2) {
        if (r == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            int d1 = r - i;
            if (dig1.contains(d1)) {
                continue;
            }
            int d2 = r + i;
            if (dig2.contains(d2)) {
                continue;
            }

            col.add(i);
            dig1.add(d1);
            dig2.add(d2);
            recur(n, r + 1, col, dig1, dig2);

            col.remove(i);
            dig1.remove(d1);
            dig2.remove(d2);
        }


    }

    public static void main(String[] args) {
        System.out.println(new test4().queens(4));
    }
}
