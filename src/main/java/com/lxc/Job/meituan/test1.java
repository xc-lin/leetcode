package com.lxc.Job.meituan;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        scanner.nextLine();
        for (int i = 0; i < n - 1; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.nextLine();
        M[] m = new M[n - 1];
        for (int i = 0; i < n - 1; i++) {
            b[i] = scanner.nextInt();
            m[i] = new M(i + 2, a[i], b[i]);
        }
        Arrays.sort(m, new Comparator<M>() {
            @Override
            public int compare(M o1, M o2) {
                return o1.b - o2.b;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        System.out.print(1 + " ");
        map.put(1, 1);
        for (int i = 0; i < n - 1; i++) {
            int num = m[i].a * map.get(m[i].b);
//            System.out.print(num+" ");
            map.put(i + 2, num);
            result.put(m[i].index, num);
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(result.get(i+2)+" ");
        }
    }


}

class M {
    int index;
    int a;
    int b;

    public M(int index, int a, int b) {
        this.index = index;
        this.a = a;
        this.b = b;
    }
}
