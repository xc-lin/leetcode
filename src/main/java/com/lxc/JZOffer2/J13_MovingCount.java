package com.lxc.JZOffer2;

/**
 * 这道题最精华的地方就是要结合数位运算
 * 还要用到dfs
 */
public class J13_MovingCount {
    boolean visited[][];
    int count = 0, m, n, k;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        dfs(0, 0, 0, 0);
        return count;
    }

    public void dfs(int i, int j, int sumi, int sumj) {
        // 跳出的条件
        if (sumi + sumj > k || i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j]) {
            return;
        }
        // 如果访问过了 就不再计数了
        visited[i][j] = true;
        count++;
        // i-1 当此时末尾是0 的情况 比如20 然后20-1=19 19的数位之和为20的数位之和+8
        dfs(i - 1, j, i % 10 == 0 ? sumi + 8 : sumi - 1, sumj);
        // 当i+1的末尾是0的时候比如 i+1=20 20的数位之和就是19-8
        dfs(i + 1, j, (i + 1) % 10 == 0 ? sumi - 8 : sumi + 1, sumj);
        dfs(i, j - 1, sumi, j % 10 == 0 ? sumj + 8 : sumj - 1);
        dfs(i, j + 1, sumi, (j + 1) % 10 == 0 ? sumj - 8 : sumj + 1);
        return;
    }

    public static void main(String[] args) {
        System.out.println(new J13_MovingCount().movingCount(11, 8, 16));
    }
}
