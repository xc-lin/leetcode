package com.lxc.Job.烽火通信;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    long n,k,count=0;
    StringBuffer sb=new StringBuffer();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long n = scanner.nextLong();
        long k=scanner.nextLong();
        scanner.nextLine();
        long[] nums=new long[(int) n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextLong();
        }
        test2 t=new test2();
        t.k=k;
        t.n=n;
        t.dfs(0,0,nums);
        System.out.println(t.count);

    }


    public void dfs(int index,long sum,long[] nums){
        if (sum==k&&index!=0){
            count++;
        }
        if (index>=n){
            return;
        }

        for (int i = index; i < n; i++) {
            dfs(i+1,sum+nums[i],nums);
        }
    }
}
