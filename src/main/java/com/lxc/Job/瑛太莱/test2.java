package com.lxc.Job.瑛太莱;

public class test2 {
    public static int climbStairs(int n) {
        int[] opt = new int[n + 1];
        opt[1] = 1;
        opt[2] = 2;
        for (int i = 3; i <= n; i++) {
            opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
