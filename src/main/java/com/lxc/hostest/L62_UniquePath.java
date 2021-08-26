package com.lxc.hostest;

public class L62_UniquePath {
    int m,n,count=0;
    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
        dfs(0,0);
        return count;
    }
    public void dfs(int i,int j){
        if (i<0||i>=m||j<0||j>=n){
            return;
        }
        if (i==m-1&&j==n-1){
            count++;
            return;
        }
        dfs(i+1,j);
        dfs(i,j+1);
    }
    
    public int uniquePaths2(int m, int n) {
        int opt[][]=new int[m][n];
        for (int i = 0; i < n; i++) {
            opt[0][i]=1;
        }
        for (int i = 0; i < m; i++) {
            opt[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j]= opt[i-1][j]+opt[i][j-1];
            }
        }
        return opt[m-1][n-1];
    }
}
