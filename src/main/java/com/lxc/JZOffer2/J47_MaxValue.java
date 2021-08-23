package com.lxc.JZOffer2;

public class J47_MaxValue {
    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int opt[][] = new int[row][column];
        opt[0][0] = grid[0][0];
        for (int i = 1; i < column; i++) {
            opt[0][i] = opt[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            opt[i][0] = opt[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]) + grid[i][j];
            }
        }
        return opt[row - 1][column - 1];
    }
}
