package com.lxc.Job.Tencent;

import java.util.Arrays;
import java.util.Scanner;


public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            long a[] = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextLong();

            }
            test(a,n);
        }
    }

    public static void test(long a[], int n) {
        Arrays.sort(a);
        long energy = 0;
        long temp = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            long curr=(a[i] +temp);
            energy +=curr;
            temp += curr;
//            temp%=1000000007;
        }
        System.out.println(energy% 1000000007);
    }
}
