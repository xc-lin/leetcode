package com.lxc.Job.j58同城;

import java.util.Arrays;

public class test3 {
    int m, n;
    int[][] matrix;
    boolean[] result;
    boolean[][] visited;

    public boolean[] pathAvailable(int[][] matrix, int[][] starts, int[][] ends) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        result = new boolean[starts.length];
        for (int i = 0; i < starts.length; i++) {
            visited = new boolean[matrix.length][matrix[0].length];
            dfs(starts[i][0], starts[i][1], ends[i][0], ends[i][1], i);
        }
        return result;

    }

    public void dfs(int i, int j, int endI, int endJ, int index) {
        if (i >= m || i < 0 || j >= n || j < 0 || matrix[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (i == endI && j == endJ) {
            result[index] = true;
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, endI, endJ, index);
        dfs(i - 1, j, endI, endJ, index);
        dfs(i, j + 1, endI, endJ, index);
        dfs(i, j - 1, endI, endJ, index);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new test3().pathAvailable(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 0, 1}},
                new int[][]{{0, 0},{0,1},{2,0}},
                new int[][]{{0, 3},{2,2},{3,3}})));
    }
}
