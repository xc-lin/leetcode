package com.lxc.Job.jd;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] a = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            int temp = map.getOrDefault(a[i], 0) + 1;
            if (temp > max) {
                max = temp;
            }
            map.put(a[i], temp);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int start = 1,end = n;
        int start2 = 0,end2 = 0;
        for (int j = 0; j < list.size(); j++) {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (map.getOrDefault(a[i],-1) == max) {
                    k = a[i];
                    start2 = i + 1;
                    map.remove(a[i]);
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] == k) {
                    end2 = i + 1;
                    break;
                }
            }
            if (end2 - start2 < end - start) {
                end = end2;
                start = start2;
            }
        }
        System.out.println(start+" "+end);
    }
}
/*
7
3 2 1 2 2 3 3
*/