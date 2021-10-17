package com.lxc.Job.xiecheng;

import java.util.*;

public class test2 {
    int result=Integer.MAX_VALUE;
    int nums[];
    int opt[][];
    int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k=scanner.nextInt();
        scanner.nextLine();
        int nums[]=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        int[][] opt=new int[n][n];
        for (int i = 0; i < n; i++) {
            int min=nums[i];
            int max=nums[i];
            for (int j = i; j < n; j++) {
                if (nums[j]<min){
                    min=nums[j];
                }
                if (nums[j]>max){
                    max=nums[j];
                }
                opt[i][j]=max-min;
            }
        }
        test2 t=new test2();
        t.nums=nums;
        t.n=n;
        t.opt=opt;
        t.dfs(0,1,k,0);
        System.out.println(t.result);

    }
    public  void dfs(int temp,int depth,int k,int i){
        if (depth==k){
            temp=Math.max(temp,opt[i][n-1]);
            result= Math.min(temp,result);
            return;
        }
        for (int j = i; j <=n-k+depth-1; j++) {
            dfs(Math.max(temp,opt[i][j]),depth+1,k,j+1);
        }

    }

}
