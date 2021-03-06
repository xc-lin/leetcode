package com.lxc.hostest;

public class L70_ClimbStairs {
    public int climbStairs(int n) {
        int opt[] = new int[n + 1];
        opt[0] = 1;
        opt[1] = 1;
        for (int i = 2; i <= n; i++) {
            opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[n];
    }
}
