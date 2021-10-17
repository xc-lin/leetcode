package com.lxc.Job.金山云;

import java.util.Scanner;

public class test2 {
    int[] nums;
    int n,result=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        test2 t=new test2();
        t.n=n;
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        t.nums=nums;
        t.dfs(0,0,0,-1);
        System.out.println(t.result);

    }
    public void dfs(int index,int sum,int count,int pre){
        if (index>=n){
            return;
        }
        if (count==3){
            if (sum>result){
                result=sum;
            }
            return;
        }
        for (int i = index; i < n; i++) {
            if (nums[i]>pre) {
                dfs(i + 1, sum + nums[i], count + 1,nums[i]);
            }
        }

    }
}
