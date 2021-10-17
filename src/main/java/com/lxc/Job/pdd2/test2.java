package com.lxc.Job.pdd2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class test2 {
    int[][] matrix;
    int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int l = 0; l < T; l++) {
            scanner.nextLine();
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            test2 t = new test2();
            t.matrix = matrix;
            t.count=0;
            t.dfs(0,0,n,m,new HashSet<>());
            System.out.println(t.count);
        }
    }

    public void dfs(int i, int j, int n, int m, HashSet<Integer> set) {

        if (i < 0 || i >= m || j < 0 || j >= n || set.contains(matrix[i][j])) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }
        set.add(matrix[i][j]);
        dfs(i + 1, j, n, m, set);
        dfs(i, j + 1, n, m, set);
        set.remove(matrix[i][j]);
    }
}
