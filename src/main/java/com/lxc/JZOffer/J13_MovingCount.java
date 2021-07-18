package com.lxc.JZOffer;

public class J13_MovingCount {
    int m, n, k;
    boolean visited[][];

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited=new boolean[m][n];
        return dfs(0, 0);

    }

    public int dfs(int i, int j) {
        if (i >= m || j >= n || visited[i][j] == true || sum(i) + sum(j) > k) {
            return 0;
        }

        visited[i][j]=true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    int sum(int x) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }
}
