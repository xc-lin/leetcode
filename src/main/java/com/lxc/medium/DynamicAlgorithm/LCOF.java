package com.lxc.medium.DynamicAlgorithm;

import java.util.List;

public class LCOF {
    public int fib(int n) {

        int opt[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i<2){
                opt[i] = i;
            }else {
                opt[i] = (opt[i - 1] + opt[i - 2]) % 1000000007;
            }

        }
        return opt[n];
    }
}
