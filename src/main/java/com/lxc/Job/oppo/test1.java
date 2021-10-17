package com.lxc.Job.oppo;

import com.lxc.test;

public class test1 {
    int m;
    int n;
    long count = 0;

    long countRoutes(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        long opt[][] = new long[m][n];
        opt[0][0] = 1;
        for (int i = 1; i < m; i++) {
            opt[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            opt[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j]=opt[i][j-1]+opt[i-1][j];
            }
        }
        return opt[m-1][n-1];
    }

    public void dfs(long i, long j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            count++;
        }
        dfs(i + 1, j);
        dfs(i, j + 1);

    }

    public static void main(String[] args) {
        System.out.println(new test1().countRoutes(0, 0));
    }

}
