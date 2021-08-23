package com.lxc.Tencent;

import java.util.Arrays;
import java.util.Scanner;


public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            scanner.nextLine();
            long a[] = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextLong();

            }
            test(a,n);
        }
    }

    public static void test(long a[], int n) {

    }
}
