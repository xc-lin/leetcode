package com.lxc.Job.leyuansu;

public class test3 {
    int result=Integer.MAX_VALUE;
    int[][] mapData;
    int length1=0;
    int length2=0;
    boolean visited[][];
    public int getMinimumSteps (int[][] mapData, int k, int r, int c) {
        this.mapData=mapData;
        length1=mapData.length;
        length2=mapData[0].length;
        visited=new boolean[length1][length2];
        dfs(r,c,k,0);
        if (result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
    public void dfs(int i,int j,int k,int sum){

        if(i==0&&j==0){
            result=Math.min(result,sum);
            return;
        }
        if(k==0||i<0||i>=length1||j<0||j>=length2||visited[i][j]){
            return;
        }
        if(mapData[i][j]==1){
            k-=1;
        }
        visited[i][j]=true;
        dfs(i,j+1,k,sum+1);
        dfs(i,j-1,k,sum+1);
        dfs(i+1,j,k,sum+1);
        dfs(i-1,j,k,sum+1);

    }

    public static void main(String[] args) {
        System.out.println(new test3().getMinimumSteps(new int[][]{{0,1},{0,0}},1,1,1));
    }
}
