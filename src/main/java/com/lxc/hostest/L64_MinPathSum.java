package com.lxc.hostest;

public class L64_MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int opt[][]=new int[m][n];
        opt[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            opt[i][0] = opt[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            opt[0][i] = opt[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j]= Math.min(opt[i-1][j],opt[i][j-1])+grid[i][j];
            }
        }
        return opt[m-1][n-1];
    }

    public static void main(String[] args) {
        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

}
