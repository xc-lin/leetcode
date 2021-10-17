package com.lxc.Job.meituan;

import java.util.*;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int opt = scanner.nextInt();
            int x = scanner.nextInt();
            if (opt == 1) {
                int y = scanner.nextInt();
                if (!map.containsKey(x)) {
                    map.put(x, new LinkedList<>());
                }
                map.get(x).addLast(y);

            } else {
                if (!map.containsKey(x) || map.get(x).isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(map.get(x).removeFirst());
                }
            }
        }
    }
}
