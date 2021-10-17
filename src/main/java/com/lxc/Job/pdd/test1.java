package com.lxc.Job.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            int red[] = new int[n];
            int blue[] = new int[m];
            for (int j = 0; j < n; j++) {
                red[j] = scanner.nextInt();
            }
            scanner.nextLine();
            for (int j = 0; j < m; j++) {
                blue[j] = scanner.nextInt();
            }
            test1(n, m, k, red, blue);
        }
    }

    public static void test1(int n, int m, int k, int[] red, int[] blue) {
        Arrays.sort(red);
        Arrays.sort(blue);
        int opt[][] = new int[m + 1][n + 1];
        opt[0][1] = 0;
        opt[1][0] = 0;
        opt[0][0] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (Math.abs(blue[i - 1] - red[j - 1]) <= k) {
                    opt[i][j] = opt[i - 1][j - 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]);
                }
            }

        }
        System.out.println(opt[m][n]);
    }
}
//1
//3 4 1
//5 2 3
//1 2 9 7