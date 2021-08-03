package com.lxc.JZOffer;

public class J47_MaxValue {
    public int maxValue(int[][] grid) {
        if (grid==null){
            return 0;
        }
        int rowLength = grid.length;
        if (rowLength==0){
            return 0;
        }
        int columnLength = grid[0].length;
        if (columnLength==0){
            return 0;
        }
        int opt[][] = new int[rowLength][columnLength];
        opt[0][0] = grid[0][0];
        for (int i = 1; i < rowLength; i++) {
            opt[i][0] = grid[i][0]+opt[i-1][0];
        }
        for (int j = 1; j < columnLength; j++) {
            opt[0][j] = grid[0][j]+opt[0][j-1];
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]) + grid[i][j];
            }

        }
        return opt[rowLength-1][columnLength-1];
    }
}
